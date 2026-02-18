package Lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Assert.assertEquals(Calculator.add(2, 3), 5);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(Calculator.divide(10, 2), 5.0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(5, 0);
    }
}