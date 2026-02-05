package Lesson4.shapes;

public class Triangle implements Shape {

    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimeter() {
        return a + b + c;
    }

    public String fillColor() {
        return "Жёлтый";
    }

    public String borderColor() {
        return "Чёрный";
    }
}