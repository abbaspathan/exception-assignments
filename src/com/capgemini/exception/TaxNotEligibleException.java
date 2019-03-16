package com.capgemini.exception;

public class TaxNotEligibleException extends Exception {

	public TaxNotEligibleException() {
		super();
	}

	public TaxNotEligibleException(String message) {
		super(message);
	}
}
