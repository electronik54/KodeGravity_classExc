package mar07;

public class Manager extends Employee{

    public Manager(String name, int age, String empName, double salary) {
        super(name, age, empName, salary);
    }

    public void assignWork(){
        System.out.println(name + " is assigning working now.");
    }
}
