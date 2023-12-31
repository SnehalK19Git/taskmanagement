package com.simplesystems.taskmanagement.exception.handlers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TaskManagementExceptionHandler  extends ResponseEntityExceptionHandler {
	
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	  MethodArgumentNotValidException ex,HttpHeaders headers,
      HttpStatus status, WebRequest request) {
//	    Map<String, String> errors = new HashMap<>();
//	    StringBuilder errorMessage = new StringBuilder();
//	    ex.getBindingResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        errorMessage.append(error.getDefaultMessage());
//	        errors.put(fieldName, error.getDefaultMessage());
//	    });
//	    
	    Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all fields errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
	    return new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);
	    
	    
	    
	}
	

}
