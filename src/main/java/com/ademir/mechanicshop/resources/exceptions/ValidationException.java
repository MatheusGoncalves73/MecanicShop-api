package com.ademir.mechanicshop.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends StandardException {

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationException(Long timestamp, Integer status, String message) {
		super(timestamp, status, message);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
