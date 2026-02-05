package Lesson3;

public class Park {

    class Attraction {
        String title;
        String workingHours;
        int price;

        Attraction(String title, String workingHours, int price) {
            this.title = title;
            this.workingHours = workingHours;
            this.price = price;
        }

        void infoAttraction() {
            System.out.println("Attraction: " + title);
            System.out.println("Working hours: " + workingHours);
            System.out.println("Price: " + price);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // ====== ЧАСТЬ 1–2: ТОВАРЫ ======
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);

        productsArray[1] = new Product("iPhone 15 Pro", "15.09.2024",
                "Apple Inc.", "USA", 6999, true);

        productsArray[2] = new Product("Xiaomi 14 Pro", "20.01.2025",
                "Xiaomi", "China", 4899, false);

        productsArray[3] = new Product("PlayStation 5", "10.11.2023",
                "Sony", "Japan", 5499, false);

        productsArray[4] = new Product("LG OLED TV C3", "05.08.2024",
                "LG Electronics", "South Korea", 8999, true);

        for (Product product : productsArray) {
            product.infoProduct();
        }

        // ====== ЧАСТЬ 3: ПАРК ======
        Park park = new Park();

        Attraction rollerCoaster = park.new Attraction(
                "Roller Coaster", "10:00 - 22:00", 1500);

        Attraction ferrisWheel = park.new Attraction(
                "Ferris Wheel", "09:00 - 21:00", 800);

        rollerCoaster.infoAttraction();
        ferrisWheel.infoAttraction();
    }
}
