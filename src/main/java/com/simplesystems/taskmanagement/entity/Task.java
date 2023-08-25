package com.simplesystems.taskmanagement.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.simplesystems.taskmanagement.dto.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TASK")
public class Task {
	
	@Id
	@Column(name="task_id",nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@Column(name="task_title",nullable = false, updatable = true)
	private String taskTitle;
	
	@Column(name="task_description",nullable = true, updatable = true)
	private String taskDescription;
	
	@Column(name="task_status",nullable = false, updatable = true)
	private String taskStatus;
	
	@Column(name="task_due_date",nullable = false, updatable = true)
	private LocalDate taskDueDate;
	
	@Column(name="completion_date",nullable = true, updatable = true)
	private LocalDate taskCompletedDate;
	
	@CreationTimestamp
	private Instant creationDate;
	
	@UpdateTimestamp
	private Instant updatedDate;
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

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

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public Instant getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Instant updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDate getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(LocalDate taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	public LocalDate getTaskCompletedDate() {
		return taskCompletedDate;
	}

	public void setTaskCompletedDate(LocalDate taskCompletedDate) {
		this.taskCompletedDate = taskCompletedDate;
	}

}
