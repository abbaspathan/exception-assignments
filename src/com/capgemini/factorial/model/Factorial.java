package com.capgemini.factorial.model;

import com.capgemini.exception.FactorialException;
import com.capgemini.exception.InvalidInputException;

public class Factorial {

	public long getFactorial(int number) throws InvalidInputException, FactorialException {

		long result = 1;

		if (number < 2) {
			throw new InvalidInputException("Number is less than 2");
		} else {
			for (int iterator = number; iterator >= 1; iterator--) {
				result = result * iterator;
				
				if (result > Integer.MAX_VALUE) {
					throw new FactorialException("Integer limit exceed");
				}
			}
		}

		return result;
	}
}
