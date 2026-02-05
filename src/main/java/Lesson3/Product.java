package Lesson3;

public class Product {
    String title;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    int price;
    Boolean bookingStatus;

    public Product(String title,
                   String productionDate,
                   String manufacturer,
                   String countryOfOrigin,
                   int price,
                   Boolean bookingStatus) {

        this.title = title;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }


    public void infoProduct() {
        System.out.println("Title: " + title);
        System.out.println("Production Date: " + productionDate);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Country Of Origin: " + countryOfOrigin);
        System.out.println("Price: " + price);
        System.out.println("Booking Status: " + bookingStatus);
        System.out.println();

    }
}
