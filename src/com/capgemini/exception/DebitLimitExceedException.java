package com.capgemini.exception;

public class DebitLimitExceedException extends Exception {

	public DebitLimitExceedException() {
		super();
	}

	public DebitLimitExceedException(String message) {
		super(message);
	}
}
