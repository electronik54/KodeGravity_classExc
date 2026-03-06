package feb21;

public class Laptop {

    String brand;
    String model;
    int price;
    int capacity;

    public Laptop(String brand, String model, int price, int capacity) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.capacity = capacity;
    }

    public void startLaptop() {
        System.out.println("Starting your laptop");
    }
    public void stopLaptop() {
        System.out.println("Stopping your laptop");
    }
    public void surfInternet() {
        System.out.println("Open web browser");
    }

    public void getSpecs() {
        System.out.println("-SPECS-");
        System.out.println("Brand:"+ brand);
        System.out.println("Capacity:"+capacity+"gb");
        System.out.println("Model:"+model);
        System.out.println("Price:$"+price);
    }
}
