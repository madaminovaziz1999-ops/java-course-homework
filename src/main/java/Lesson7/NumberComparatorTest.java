package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {

    private final NumberComparator comparator = new NumberComparator();

    @Test
    void testGreater() {
        assertEquals("a больше b", comparator.compare(10, 5));
    }

    @Test
    void testLess() {
        assertEquals("a меньше b", comparator.compare(3, 7));
    }

    @Test
    void testEqual() {
        assertEquals("числа равны", comparator.compare(5, 5));
    }
}