/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.boolapi;

import static com.lordofthejars.bool.Bool.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
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
        
        if ("A".compareTo("B") == -1){
            isValid3 = true;
        }
        
        Assert.assertTrue(isValid);
        Assert.assertTrue(isValid2);
        Assert.assertTrue(isValid3);
    }
}
