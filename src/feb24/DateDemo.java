package feb24;

public class DateDemo {
    int day;
    int month;
    int year;

    //NESTED CONSTRUCTORS

    //default constructor
    public DateDemo() {
        System.out.println("Default constructor");
    }

    //parameterized constructor
    public DateDemo(int day) {
        this();
        System.out.println("Constructor with 1 parameter");
        this.day = day;
    }

    //parameterized constructor
    public DateDemo(int day, int month) {
        this(10);
        System.out.println("Constructor with 2 parameter");
        this.day = day;
        this.month = month;
    }

    //parameterized constructor
    public DateDemo(int day, int month, int year) {
        this(10, 22);
        System.out.println("Constructor with 3 parameter");
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
