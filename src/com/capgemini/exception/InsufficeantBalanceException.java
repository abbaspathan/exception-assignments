package com.capgemini.exception;

public class InsufficeantBalanceException extends Exception {

	public InsufficeantBalanceException() {
		super();
	}

	public InsufficeantBalanceException(String message) {
		super(message);
	}
}
