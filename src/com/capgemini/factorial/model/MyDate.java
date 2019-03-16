package com.capgemini.factorial.model;

import com.capgemini.exception.InvalidDayException;
import com.capgemini.exception.InvalidMonthException;

public class MyDate {

	private int day;
	private int month;
	private int year;
	private static int array[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public MyDate() {
		super();
	}

	public MyDate(int day, int month, int year) throws InvalidMonthException, InvalidDayException {
		checkLeapYear(year);
		setMonth(month);
		setDay(day);
		System.out.println("Valid Date");
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) throws InvalidDayException {

		if ((day <= array[month - 1]) && (day >= 1)) {
			this.day = day;
		} else {
			throw new InvalidDayException("Invalid day");
		}

	}

	public int getMonth() {

		return month;
	}

	public void setMonth(int month) throws InvalidMonthException {

		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			throw new InvalidMonthException();
		}

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void checkLeapYear(int year) {

		boolean flag = false;
		
		if (year % 400 == 0) {
			flag = true;
		} else if (year % 100 == 0) {
			flag = false;
		} else if (year % 4 == 0) {
			flag = true;
		} else {
			flag = false;
		}
		if(flag) {
			array[1]=29;
		}
	}

}
