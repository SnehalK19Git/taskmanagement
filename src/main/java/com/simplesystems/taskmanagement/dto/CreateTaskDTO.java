package com.simplesystems.taskmanagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public class CreateTaskDTO {

	@NotNull(message="Task Title is mandatory")
	public String taskTitle;
	
	public String taskDescription;
	
	@NotNull(message="Task Due Date is mandatory")
	@FutureOrPresent(message="Due date cannot be past date")
	public LocalDate taskDueDate;
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public LocalDate getTaskDueDate() {
		return taskDueDate;
	}
	public void setTaskDueDate(LocalDate taskDueDate) {
		this.taskDueDate = taskDueDate;
	}
	
	
}
