package com.simplesystems.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplesystems.taskmanagement.dto.TaskDTO;
import com.simplesystems.taskmanagement.dto.CreateTaskDTO;
import com.simplesystems.taskmanagement.dto.TaskDTO;
import com.simplesystems.taskmanagement.service.TaskManagementService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/task-management")
public class TaskManagementController {
	
	@Autowired
	private TaskManagementService service;

	@GetMapping(value = "/tasks")
	public List<TaskDTO> getAllTasks(){
		return service.getAllTasks();
	}
	
	@GetMapping(value = "/tasks/{taskId}")
	public TaskDTO getTask(@NotNull(message="Task Id cannot be null") @PathVariable Long taskId){
		return service.getTask(taskId);
	}
	
	@PostMapping(value = "/tasks")
	public TaskDTO createTask(@Valid @RequestBody CreateTaskDTO taskReqDTO){
		return service.createTask(taskReqDTO);
	}
	
	@PutMapping(value = "/tasks/{taskId}")
	public TaskDTO updateTask(@Valid @RequestBody TaskDTO taskUpdateRequestDTO){
		return service.updateTask(taskUpdateRequestDTO);
	}
}
