package com.capgemini.facotrial.test;

import static org.junit.Assert.assertEquals;

import javax.naming.NameNotFoundException;

import org.junit.Test;

import com.capgemini.exception.AgeNotWithinRangeException;
import com.capgemini.factorial.model.Student;

public class StudentTest {

	@Test(expected = AgeNotWithinRangeException.class)
	public void testStudentAgeNotInGivenRangeGenrateException()
			throws AgeNotWithinRangeException, NameNotFoundException {
		Student student = new Student(101, "Jonh Deo", 12, "Comuter Engineering");
	}
	
	@Test(expected = AgeNotWithinRangeException.class)
	public void testStudentAgeNotInGivenRangeGenrateExceptionSetterMethod()
			throws AgeNotWithinRangeException, NameNotFoundException {
		Student student = new Student();
		student.setStudentAge(22);
	}

	@Test
	public void tetsStudentValidAge() throws AgeNotWithinRangeException, NameNotFoundException {
		Student student = new Student(101, "Jonh Deo", 16, "Comuter Engineering");
		assertEquals(16, student.getStudentAge());
	}
	
	@Test
	public void tetsStudentValidAgeSetterMethod() throws AgeNotWithinRangeException, NameNotFoundException {
		Student student = new Student();
		 student.setStudentAge(16);
		assertEquals(16,student.getStudentAge());
	}

	@Test(expected = NameNotFoundException.class)
	public void testStudentNameContainDigitOrSpecialSymbolException()
			throws AgeNotWithinRangeException, NameNotFoundException {
		Student student = new Student(101, "Jonh Deo1", 16, "Comuter Engineering");
	}

	@Test
	public void tetsStudentValidName() throws AgeNotWithinRangeException, NameNotFoundException {
		Student student = new Student(101, "John Deo", 16, "Comuter Engineering");
		assertEquals("John Deo", student.getStudentName());
	}
}
