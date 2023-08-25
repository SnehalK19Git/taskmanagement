package com.simplesystems.taskmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.simplesystems.taskmanagement.dto.CreateTaskDTO;
import com.simplesystems.taskmanagement.dto.TaskDTO;
import com.simplesystems.taskmanagement.dto.TaskStatus;
import com.simplesystems.taskmanagement.entity.Task;
import com.simplesystems.taskmanagement.exception.InvalidTaskException;
import com.simplesystems.taskmanagement.mapper.TaskDTOMapper;
import com.simplesystems.taskmanagement.repository.TaskRepository;


@Service
public class TaskManagementService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskDTOMapper mapper;

	@Transactional(readOnly=true)
	public List<TaskDTO> getAllTasks() {
		List<TaskDTO> taskList = new ArrayList<>();
		taskRepository.findAll().forEach(task -> taskList.add(mapper.mapToTaskDTO(task)));
		return taskList;
	}

	@Transactional
	public TaskDTO createTask(
			CreateTaskDTO taskReqDTO) {
		Task task = new Task();
		task.setTaskTitle(taskReqDTO.getTaskTitle());
		task.setTaskDescription(taskReqDTO.getTaskDescription());
		task.setTaskDueDate(taskReqDTO.getTaskDueDate());
		task.setTaskStatus(TaskStatus.NOT_DONE.getStringValue());
		return mapper.mapToTaskDTO(taskRepository.save(task));
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public TaskDTO updateTask(
			TaskDTO taskUpdateRequestDTO) {
		
		Task task = taskRepository.findById(taskUpdateRequestDTO.getTaskId()).get();
		mapper.updateRequestToTask(taskUpdateRequestDTO, task);
		return mapper.mapToTaskDTO(taskRepository.save(task));
	}

	@Transactional(readOnly=true)
	public TaskDTO getTask(Long taskId) {
		return mapper.mapToTaskDTO(taskRepository.findById(taskId).orElseThrow(() -> new InvalidTaskException()));
	}

	@Transactional
	public void updateTasksToPastDueDate() {
		taskRepository.updateTaskStatusToPastDueDate(LocalDate.now(),TaskStatus.NOT_DONE.getStringValue(),TaskStatus.PAST_DUE.getStringValue() );
	}

}
