package com.ademir.mechanicshop.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ademir.mechanicshop.services.exceptions.DataIntegrityException;
import com.ademir.mechanicshop.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardException> objectNotFound(ObjectNotFoundException e, ServletRequest request) {
		StandardException exception = new StandardException(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(exception.getStatus()).body(exception);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardException> dataIntegrity(DataIntegrityException e, ServletRequest request) {
		StandardException exception = new StandardException(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(exception.getStatus()).body(exception);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationException> validationException(MethodArgumentNotValidException e,
			ServletRequest request) {
		ValidationException exception = new ValidationException(System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos");

		e.getBindingResult().getFieldErrors().stream()
				.forEach((error) -> exception.addError(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.status(exception.getStatus()).body(exception);
	}
}
