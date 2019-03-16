package com.capgemini.facotrial.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.exception.CountryNotValidException;
import com.capgemini.exception.EmployeeNameInvalidException;
import com.capgemini.exception.TaxNotEligibleException;
import com.capgemini.factorial.model.TaxCalculator;

public class TaxCalculatorTest {

	@Test(expected = CountryNotValidException.class)
	public void tsetemployeeNotIndianException() throws CountryNotValidException, EmployeeNameInvalidException {
		TaxCalculator employee = new TaxCalculator("John Deo", 23000, false);
	}

	@Test
	public void testEmployeeIsIndianOrNot() throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee = new TaxCalculator("John Deo", 40000, true);
		assertTrue(employee.isEmployeeIsIndian());
	}
	
	@Test(expected = EmployeeNameInvalidException.class)
	public void tsetemployeeNameIsEmptyException() throws CountryNotValidException, EmployeeNameInvalidException {
		TaxCalculator employee = new TaxCalculator( "", 23000, true);
	}
	
	@Test(expected = EmployeeNameInvalidException.class)
	public void tsetemployeeNameIsNullException() throws CountryNotValidException, EmployeeNameInvalidException {
		TaxCalculator employee = new TaxCalculator( null, 23000, true);
	}
	
	@Test(expected=TaxNotEligibleException.class)
	public void testEmployeeTaxNotEligibleException() throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee = new TaxCalculator("John Deo", 9000, true);
		employee.calculateTax();
	}
	
	@Test
	public void testEmployeeCalculateTaxFunction() throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		TaxCalculator employee = new TaxCalculator("John Deo", 40000, true);
		assertEquals(2000,employee.calculateTax(),0.02);
	}
}
