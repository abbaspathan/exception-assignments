package com.capgemini.facotrial.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exception.FactorialException;
import com.capgemini.exception.InvalidInputException;
import com.capgemini.factorial.model.Factorial;

public class FactorialTest {

	Factorial factorial;

	@Before
	public void setUp() {
		factorial = new Factorial();
	}

	@Test(expected = InvalidInputException.class)
	public void testGetFactorialNumberIsLessThan2() throws InvalidInputException, FactorialException {
		factorial.getFactorial(1);
	}

	@Test(expected = FactorialException.class)
	public void testGetFactorialIntegerLimitExceed() throws FactorialException, InvalidInputException {
		factorial.getFactorial(99999999);
	}

	@Test
	public void testFactorialOfNumberValidAnswer() throws InvalidInputException, FactorialException {
		assertEquals(120, factorial.getFactorial(5));
	}
}
