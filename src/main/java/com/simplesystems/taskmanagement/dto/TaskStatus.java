package com.simplesystems.taskmanagement.dto;

public enum TaskStatus {

	DONE("DONE"), PAST_DUE("PAST_DUE"), NOT_DONE("NOT_DONE"), INVALID("INVALID");

	private String status;

	private TaskStatus(String status) {
		this.status = status;
	}

	
	public static TaskStatus getValue(String taskStatus) {
		return switch (taskStatus) {
		case "NOT_DONE" -> TaskStatus.NOT_DONE;
		case "PAST_DUE" -> TaskStatus.PAST_DUE;
		case "DONE" -> TaskStatus.DONE;
		default -> TaskStatus.INVALID;
		};
	}

	public String getStringValue() {
		return status;
	}

}
