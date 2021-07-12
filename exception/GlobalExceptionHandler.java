package com.onlineadmission.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(AdmissionNotFoundException.class)
	public ResponseEntity<Object> handleException( AdmissionNotFoundException exception, WebRequest weRequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<Object> handleException( PaymentNotFoundException exception, WebRequest weRequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<Object> handleException(ApplicationNotFoundException exception, WebRequest webrequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(BranchNotFoundException.class)
	public ResponseEntity<Object> handleException(BranchNotFoundException exception, WebRequest webrequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(CollegeNotFoundException.class)
	public ResponseEntity<Object> handleException(CollegeNotFoundException exception, WebRequest webrequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleException(CourseNotFoundException exception, WebRequest webrequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(LoginNotFoundException.class)
	public ResponseEntity<Object> handleException(LoginNotFoundException exception, WebRequest webrequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<Object> handleException(UsersNotFoundException exception, WebRequest webrequest){
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
		return entity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);	
		});
		ResponseEntity<Object> entity = new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		return entity;
	}
		
}
