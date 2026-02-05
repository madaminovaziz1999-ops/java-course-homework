package Lesson4;

public class Cat extends Animal {

    static int catCount = 0;
    private boolean full = false;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            full = true;
        }
    }

    public boolean isFull() {
        return full;
    }
}