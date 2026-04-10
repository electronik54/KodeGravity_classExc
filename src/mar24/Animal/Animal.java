package mar24.Animal;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract String makeSound();
}
