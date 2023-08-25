package com.simplesystems.taskmanagement.mapper;

import org.springframework.stereotype.Component;

import com.simplesystems.taskmanagement.dto.TaskDTO;
import com.simplesystems.taskmanagement.dto.TaskStatus;
import com.simplesystems.taskmanagement.entity.Task;



@Component
public class TaskDTOMapper {


   public TaskDTO mapToTaskDTO(Task task) {
	   TaskDTO taskDTO = new TaskDTO ();
	   taskDTO.setTaskId(task.getTaskId());
	   taskDTO.setTaskTitle(task.getTaskTitle());
	   taskDTO.setTaskStatus(task.getTaskStatus());
	   taskDTO.setTaskDueDate(task.getTaskDueDate());
	   taskDTO.setTaskDescription(task.getTaskDescription());
	   return taskDTO;
   }

//public Task mapUpdateRequestToTask(TaskDTO taskUpdateRequestDto) {
//	Task task = new Task();
//	task.setTaskId(taskUpdateRequestDto.getTaskId());
//	task.setTaskTitle(taskUpdateRequestDto.getTaskTitle());
//	task.setTaskDescription(taskUpdateRequestDto.getTaskDescription());
//	task.setTaskStatus(TaskStatus.getValue(taskUpdateRequestDto.getTaskStatus()));
//	task.setTaskDueDate(taskUpdateRequestDto.getTaskDueDate());
//	return task;
//}

public void updateRequestToTask(TaskDTO taskUpdateRequestDTO, Task task) {
	task.setTaskId(taskUpdateRequestDTO.getTaskId());
	task.setTaskTitle(taskUpdateRequestDTO.getTaskTitle());
	task.setTaskDescription(taskUpdateRequestDTO.getTaskDescription());
	task.setTaskStatus(taskUpdateRequestDTO.getTaskStatus());
	task.setTaskDueDate(taskUpdateRequestDTO.getTaskDueDate());
	
}

}

