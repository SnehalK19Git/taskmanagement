package com.simplesystems.taskmanagement.exception;

public class InvalidTaskException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public InvalidTaskException(){
		super("Invalid Task Number");
	}

}
