package Lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {

    @Test
    public void testTriangleArea() {
        Assert.assertEquals(TriangleCalculator.area(10, 4), 20.0);
    }
}