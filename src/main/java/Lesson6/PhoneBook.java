package Lesson6;

import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        phoneBook.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public void get(String surname) {
        List<String> numbers = phoneBook.get(surname);

        if (numbers == null) {
            System.out.println("Фамилия не найдена");
        } else {
            System.out.println("Номера для фамилии " + surname + ":");
            for (String number : numbers) {
                System.out.println(number);
            }
        }
    }
}