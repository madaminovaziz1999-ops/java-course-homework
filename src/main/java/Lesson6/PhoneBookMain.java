package Lesson6;

public class PhoneBookMain {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "89001234567");
        phoneBook.add("Иванов", "89112223344");
        phoneBook.add("Петров", "89223334455");

        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Сидоров");
    }
}