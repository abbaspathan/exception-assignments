package com.capgemini.factorial.model;

import com.capgemini.exception.CountryNotValidException;
import com.capgemini.exception.EmployeeNameInvalidException;
import com.capgemini.exception.TaxNotEligibleException;

public class TaxCalculator {

	private String employeeName;
	private double employeeSalary;
	private boolean employeeIsIndian;

	public TaxCalculator() {
		super();
	}

	public TaxCalculator(String employeeName, double employeeSalary, boolean employeeIsIndian)
			throws CountryNotValidException, EmployeeNameInvalidException {
		super();
		setEmployeeIsIndian(employeeIsIndian);
		setEmployeeName(employeeName);
		this.employeeSalary = employeeSalary;

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) throws EmployeeNameInvalidException {
		if (employeeName == null || employeeName.length()==0) {
			throw new EmployeeNameInvalidException("The employee name cannot be empty");
		}
		this.employeeName = employeeName;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {

		this.employeeSalary = employeeSalary;
	}

	public boolean isEmployeeIsIndian() {

		return employeeIsIndian;
	}

	public void setEmployeeIsIndian(boolean employeeIsIndian) throws CountryNotValidException {

		if (employeeIsIndian) {

		} else {
			throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
		}

		this.employeeIsIndian = employeeIsIndian;
	}

	public double calculateTax() throws TaxNotEligibleException {
		
		double employeeTax=0.0;
		
		if(employeeSalary>100000) {
			employeeTax=0.08*employeeSalary;
		}
		else if(employeeSalary>50000 && employeeSalary<=100000) {
			employeeTax=0.06*employeeSalary;
		}
		else if(employeeSalary>30000 && employeeSalary<=50000) {
			employeeTax=0.05*employeeSalary;
		}
		else if(employeeSalary>10000 && employeeSalary<=30000) {
			employeeTax=0.04*employeeSalary;
		}
		else {
			throw new TaxNotEligibleException("The employee does not need to pay tax");
		}
		
		return employeeTax;
		
	}
}
