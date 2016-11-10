package core.com.spring.test.decimal;

import java.text.DecimalFormat;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class DecimalFormatTest {

	@Test
	public void test() throws Exception {
		DecimalFormat myFormatter = new DecimalFormat(",##0.00");
		Assert.assertThat(myFormatter.parse("2.000,00"),Matchers.is(2000L));
	}
}
