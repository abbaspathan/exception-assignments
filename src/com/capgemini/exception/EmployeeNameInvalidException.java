package com.capgemini.exception;

public class EmployeeNameInvalidException extends Exception {

	public EmployeeNameInvalidException() {
		super();
	}

	public EmployeeNameInvalidException(String message) {
		super(message);
	}

}
