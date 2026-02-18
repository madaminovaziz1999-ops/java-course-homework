package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathOperationsTest {

    private final MathOperations math = new MathOperations();

    @Test
    void testAdd() {
        assertEquals(7, math.add(3, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(2, math.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, math.multiply(3, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, math.divide(5, 2));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,
                () -> math.divide(5, 0));
    }
}