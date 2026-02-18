package Lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void testFactorialFive() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeFactorial() {
        FactorialCalculator.factorial(-3);
    }
}