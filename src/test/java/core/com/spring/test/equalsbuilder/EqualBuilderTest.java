package core.com.spring.test.equalsbuilder;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import core.com.spring.test.pkcomposta.Item;

public class EqualBuilderTest {

	@Test
	public void test() {
		Item a = new Item(1l);
		Item b = null;// new Item();
		Assert.assertThat(a.equals(b),Matchers.is(false));
		b = new Item();
		Assert.assertThat(a.equals(b),Matchers.is(false));
		b = new Item(1l);
		Assert.assertThat(a.equals(b),Matchers.is(true));
	}
}
