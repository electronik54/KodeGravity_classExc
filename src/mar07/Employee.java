package mar07;

public class Employee extends Person {
    static int empId;
    String empName;
    double salary;

    static{}
    {
        empId++;
    }

    public Employee(String name, int age, String empName, double salary) {
        super(name, age);
        this.empName = empName;
        this.salary = salary;
    }

    public void work(){
        System.out.println(name + " is working now.");
    }

    public int getEmpId() {
        return empId;
    }
    public String getEmployeeName() {
        return empName;
    }
}
