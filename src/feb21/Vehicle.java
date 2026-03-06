package feb21;

public class Vehicle {

    int wheels;
    int color;
    int brand;
    int model;

    public Vehicle(int wheels, int color, int brand, int model) {
        this.wheels = wheels;
        this.color = color;
        this.brand = brand;
        this.model = model;
    }
    public Vehicle() {

    }

    public void start(){
        System.out.println("Starting the car");
    }

    public void stop(){
        System.out.println("Stopping the car");
    }

}
