package org.skyve.impl.web.faces.converters.datetime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import javax.faces.convert.ConverterException;

import org.junit.Before;
import org.junit.Test;
import org.skyve.domain.types.DateTime;
import org.skyve.util.Time;

public class DD_MMM_YYYYTest {

	private DD_MMM_YYYY formatter;

	@Before
	public void before() {
		formatter = new DD_MMM_YYYY();
	}

	@Test(expected = ConverterException.class)
	public void testGetAsObjectInvalidFormat() throws Exception {
		// call the method under test
		formatter.getAsObject(null, null, "01-03-2020");

		fail("Should throw exception before this line.");
	}

	@Test
	public void testGetAsObjectValidFormat() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));

		// call the method under test
		assertThat(formatter.getAsObject(null, null, "01-Mar-2020"), is(testDate));
	}

	@Test
	public void testGetAsString() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));

		// call the method under test
		assertThat(formatter.getAsString(null, null, testDate), is("01-Mar-2020"));
	}
}
