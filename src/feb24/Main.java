package feb24;

// CLASS, DEFAULT & PARAMETERIZED CONSTRUCTORS, METHODS, THIS KEYWORD, NESTED CONSTRUCTORS, NAMING CONVENTIONS
public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------");
        System.out.println("--CLASS IN-DEPTH: CONSTRUCTORS--");
        System.out.println("--------------------------------");

        System.out.println();

        /*
        //DEFAULT CONSTRUCTOR
        Order Macbook = new Order();
        Macbook.printOrder();

        System.out.println();

        //PARAMETERIZED CONSTRUCTOR
        Order iphone = new Order("Nikhil", 12212, 1499.99);
        iphone.printOrder();

        System.out.println(iphone.id);

        //NESTED CONSTRUCTORS
        DateDemo dateDemo = new DateDemo(10, 2, 23);
        */
        //
        Person johnDoe = new Person();
        johnDoe.sayHi();
        johnDoe.age = 10; // SET VALUE WITHOUT USING METHOD
        johnDoe.addAge(0);

        System.out.println();

        Person nik = new Person("nikhil");
        nik.sayHi();
        nik.say("lets have my birthday!!");
        nik.haveBirthday();

        System.out.println();

        Person dhruv = new Person("dhruv", 21);
        dhruv.addAge(10);

        System.out.println("---------------");

        Person cloneDhruv = dhruv;//POINT TOWARDS SAME OBJECT
        cloneDhruv.getInfo();

        System.out.println();
        dhruv.haveBirthday();

        System.out.println();

        dhruv.getInfo();
        System.out.println("how to separate these person?");
        cloneDhruv.getInfo();

        System.out.println("---------------");

        Person niketan = new Person("niketan", 35, 1000.23);
        //niketan.money; //CANNOT ACCESS SINCE PRIVATE VARAIBLE IN CLASS
        niketan.getInfo();
        niketan.earnInterestOnBalance();
        niketan.getBalance();
        niketan.getInfo();

    }
}
