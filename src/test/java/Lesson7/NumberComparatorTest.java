package Lesson7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberComparatorTest {

    @Test
    public void testCompareGreater() {
        Assert.assertEquals(NumberComparator.compare(5, 3), "Первое число больше");
    }

    @Test
    public void testCompareEqual() {
        Assert.assertEquals(NumberComparator.compare(4, 4), "Числа равны");
    }
}