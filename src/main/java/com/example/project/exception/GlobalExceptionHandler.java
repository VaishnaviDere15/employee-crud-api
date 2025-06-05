package com.example.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler{
	@ExceptionHandler(EmployeeNotFoundException.class)
	
		public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException ex, WebRequest request)
		{
		   ErrorResponse error =new ErrorResponse(
				   
				   LocalDateTime.now(),
				   ex.getMessage(),
				   request.getDescription(false)
				   );
		   return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}   
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<ErrorResponse>   handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request)
	 {
		 StringBuilder messages= new StringBuilder();
		 ex.getBindingResult().getFieldErrors().forEach(error ->messages.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; "));
		 
		 
		ErrorResponse error = new ErrorResponse(
				 LocalDateTime.now(),
				 "Validation failed",
				 messages.toString()
				 );
		 return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	 }	 
				 
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex,WebRequest request)
	 {
		 ErrorResponse error= new ErrorResponse(
				 LocalDateTime.now(),
				 "An unexpected Error Occured",
				 request.getDescription(false)
				 
				 );
		 return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
				 
				 
	 }	 
				 
	 
	 
				 
		 
	 
	 
			   
		   
		
	
}
