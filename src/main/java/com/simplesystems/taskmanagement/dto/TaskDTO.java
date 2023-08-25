package com.simplesystems.taskmanagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class TaskDTO extends CreateTaskDTO{

	@NotNull(message= "Task Id cannot be blank.")
	public long taskId;
	
	@NotNull(message= "Task Status should be DONE, NOT_DONE, DUE_DATE")
	public String taskStatus;
	
	public LocalDate completeDate;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public LocalDate getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(LocalDate completeDate) {
		this.completeDate = completeDate;
	}
	

}
