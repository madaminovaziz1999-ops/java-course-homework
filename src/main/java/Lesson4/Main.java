package Lesson4;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = {
                new Dog("Бобик"),
                new Cat("Мурзик"),
                new Dog("Рекс"),
                new Cat("Барсик")
        };

        for (Animal animal : animals) {
            animal.run(150);
            animal.swim(5);
        }

        System.out.println("Животных: " + Animal.animalCount);
        System.out.println("Собак: " + Dog.dogCount);
        System.out.println("Котов: " + Cat.catCount);

        Bowl bowl = new Bowl(20);

        Cat[] cats = {
                new Cat("Кот1"),
                new Cat("Кот2"),
                new Cat("Кот3")
        };

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }

        bowl.addFood(20);
    }
}