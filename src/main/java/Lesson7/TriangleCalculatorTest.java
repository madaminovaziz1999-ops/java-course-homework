package Lesson7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleCalculatorTest {

    private final TriangleCalculator calculator = new TriangleCalculator();

    @Test
    void testCalculateArea() {
        assertEquals(25.0, calculator.calculateArea(10, 5));
    }

    @Test
    void testInvalidValues() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateArea(-5, 10));
    }
}
