/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.boolapi;

import static com.lordofthejars.bool.Bool.*;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author fernando
 */
public class BoolApiTest {

    @Test
    public void test() {
        boolean isValid = the("A", is(lessThan("B")));
        boolean isValid2 = is(lessThan("B")).matches("A");
        boolean isValid3 = false;

        if ("A".compareTo("B") == -1) {
            isValid3 = true;
        }

        Assert.assertTrue(isValid);
        Assert.assertTrue(isValid2);
        Assert.assertTrue(isValid3);
    }

    @Test
    public void test2() {
        String value = "teste";
        MatcherAssert.assertThat(2, either(is(1)).or(is(2)));
        MatcherAssert.assertThat("nome", isA(String.class));
        MatcherAssert.assertThat("nao deu", value, anyOf(nullValue(), equalTo("teste")));
    }

}
