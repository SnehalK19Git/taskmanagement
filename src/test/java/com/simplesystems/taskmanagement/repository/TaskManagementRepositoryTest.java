package com.simplesystems.taskmanagement.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.simplesystems.taskmanagement.dto.TaskStatus;
import com.simplesystems.taskmanagement.entity.Task;

@DataJpaTest
public class TaskManagementRepositoryTest {
	
	@Autowired
	private TaskRepository taskRepo;
	
	private Task reqObj;
	
	@BeforeEach
    public void setup(){
		reqObj = createNewTaskObj();
    }
	
	private Task createNewTaskObj() {
		Task task = new Task();

		task.setTaskDueDate(LocalDate.now());
		task.setTaskTitle("Test Task Title");
		task.setTaskDescription("Test Junits");
		task.setTaskStatus(TaskStatus.NOT_DONE.getStringValue());
		return task;
	}
	
	@Test
	void givenTaskDetails_save_thenReturnSavedTask() {
		reqObj = taskRepo.save(reqObj);
		assertThat(reqObj.getTaskId()).isNotNull();
	}
	
	@Test
	void givenAnyDate_findPastDueDateTasks_thenUpdateDueDateTask() {
		reqObj = taskRepo.save(reqObj);
		taskRepo.updateTaskStatusToPastDueDate(LocalDate.now().plusDays(2), TaskStatus.NOT_DONE.getStringValue(), TaskStatus.PAST_DUE.getStringValue());
		String status =  taskRepo.findById(reqObj.getTaskId()).get().getTaskStatus();
		assertEquals(status, TaskStatus.PAST_DUE.getStringValue());
	}

}
