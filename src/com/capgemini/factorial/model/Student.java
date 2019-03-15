package com.capgemini.factorial.model;

import javax.naming.NameNotFoundException;

import com.capgemini.exception.AgeNotWithinRangeException;

public class Student {

	private int studentRollNumber;
	private String studentName;
	private int studentAge;
	private String studentCourse;

	public Student() {
		super();
	}

	public Student(int studentRollNumber, String studentName, int studentAge, String studentCourse)
			throws AgeNotWithinRangeException, NameNotFoundException {
		super();
		this.studentRollNumber = studentRollNumber;
		setStudentAge(studentAge);
		setStudentName(studentName);
		this.studentCourse = studentCourse;
	}

	public int getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(int studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) throws NameNotFoundException {
		if (studentName.matches("^[a-zA-Z\\s]+")) {
			this.studentName = studentName;
		} else {
			throw new NameNotFoundException("Name not valid");
		}

	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) throws AgeNotWithinRangeException {
		if (studentAge < 15 || studentAge > 21) {
			throw new AgeNotWithinRangeException("Age not valid");
		} else {
			this.studentAge = studentAge;
		}

	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

}
