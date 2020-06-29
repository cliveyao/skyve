package org.skyve.domain.types.converters.datetime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.skyve.domain.types.DateTime;
import org.skyve.util.Time;

public class MM_DD_YYYY_HH_MITest {

	private MM_DD_YYYY_HH_MI formatter;

	@Before
	public void before() {
		formatter = new MM_DD_YYYY_HH_MI();
	}

	@Test(expected = ParseException.class)
	public void testFromDisplayValueInvalidFormat() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 02, 30, 0);

		// call the method under test
		assertThat(formatter.fromDisplayValue("03-01-2020 02:30"), is(testDate));
	}

	@Test
	public void testFromDisplayValueAM() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 02, 30, 0);

		// call the method under test
		assertThat(formatter.fromDisplayValue("03/01/2020 02:30 AM"), is(testDate));
	}

	/**
	 * Note: This formatter cannot parse PM times. See {@link MM_DD_YYYY_HH24_MI} instead.
	 */
	@Test(expected = ParseException.class)
	public void testFromDisplayValuePM() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 14, 30, 0);

		// call the method under test
		assertThat(formatter.fromDisplayValue("03/01/2020 14:30"), is(testDate));
	}

	@Test
	public void testToDisplayValue() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 12, 30, 0);

		// call the method under test
		assertThat(formatter.toDisplayValue(testDate), is("03/01/2020 12:30 PM"));
	}
}
