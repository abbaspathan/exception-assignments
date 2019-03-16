package com.capgemini.facotrial.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.exception.InvalidDayException;
import com.capgemini.exception.InvalidMonthException;
import com.capgemini.factorial.model.MyDate;

public class MyDateTest {

	@Test(expected = InvalidMonthException.class)
	public void testMonthInvalidException() throws InvalidMonthException, InvalidDayException {
		MyDate date = new MyDate(12, 13, 2018);
	}
	
	@Test
	public void testValidMonth() throws InvalidMonthException, InvalidDayException {
		MyDate date = new MyDate(12, 12, 2018);
		assertEquals(12, date.getMonth());
	}
	
	@Test(expected = InvalidDayException.class)
	public void testDayInvalidException() throws InvalidMonthException, InvalidDayException {
		MyDate date = new MyDate(31, 2, 2018);
	}

	@Test
	public void testValidDay() throws InvalidMonthException, InvalidDayException {
		MyDate date = new MyDate(13, 12, 2018);
		assertEquals(13, date.getDay());
	}
	
	@Test
	public void testValiLeapYearDate() throws InvalidMonthException, InvalidDayException {
		MyDate date = new MyDate(29, 2, 2000);
		assertEquals(29, date.getDay());
	}
}
