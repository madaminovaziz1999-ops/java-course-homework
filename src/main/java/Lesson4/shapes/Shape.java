package Lesson4.shapes;

public interface Shape {

    double area();

    double perimeter();

    String fillColor();
    String borderColor();

    default void printInfo() {
        System.out.println(
                "Площадь: " + area() +
                        ", Периметр: " + perimeter() +
                        ", Цвет заливки: " + fillColor() +
                        ", Цвет границы: " + borderColor()
        );
    }
}
