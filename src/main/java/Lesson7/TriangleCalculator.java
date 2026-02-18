package Lesson7;

public class TriangleCalculator {

    public double calculateArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть больше нуля");
        }

        return 0.5 * base * height;
    }
}