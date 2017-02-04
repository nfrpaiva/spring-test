package core.com.spring.test.data;

import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.joda.time.Weeks;
import org.junit.Assert;
import org.junit.Test;

public class CalendarioTest {

	@Test
	public void testObterSemanaDoAno() {
		DateTime date = new DateTime(2016,10,23,0,0);
		Assert.assertThat(date.getWeekOfWeekyear(),Matchers.is(42));
		date = new DateTime(2016,1,1,0,0);
		Assert.assertThat(date.getWeekOfWeekyear(),Matchers.is(53));
		Assert.assertThat(date.getWeekyear(),Matchers.is(2015));
		Weeks.weeks(date.getWeekyear());
		Assert.assertThat(date.withDayOfWeek(1).getYear(),Matchers.is(2015));
	}
}
