package Lesson6;

import java.util.*;

public class StudentMain {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван", "А1", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Мария", "А1", 1, Arrays.asList(5, 5, 5)));
        students.add(new Student("Пётр", "Б2", 2, Arrays.asList(2, 3, 3)));
        students.add(new Student("Анна", "Б2", 2, Arrays.asList(4, 4, 4)));

        System.out.println("Все студенты:");
        for (Student s : students) {
            System.out.println(s);
        }

        removeLowAverage(students);

        promoteStudents(students);

        System.out.println("\nСтуденты после обработки:");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\nСтуденты 2 курса:");
        printStudents(students, 2);
    }

    public static void removeLowAverage(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3);
        System.out.println("\nСтуденты со средним баллом меньше 3 удалены");
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
        System.out.println("Студенты со средним баллом 3 и выше переведены на следующий курс");
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}