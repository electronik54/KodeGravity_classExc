package mar07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //HOMEWORK: create a customer class with Order class and address inside. implement using 'Aggregation'
        //Customer has-a Order | Customer has-a Address

        Scanner s = new Scanner(System.in);

        System.out.println("--CONCEPT OF OOPS--");

        System.out.println("-HOMEWORK: IMPLEMENT AGGREGATION WITH CLASS-");
        System.out.print("enter 1 to CONTINUE:");

        while (s.nextInt() == 1) {

            System.out.println();
            System.out.println("----ORDERING  SYSTEM----");
            System.out.println("-ENTER CUSTOMER DETAILS-");
            do {
                System.out.println("-PROVIDE FOLLOWING ADDRESS DETAILS-");
                boolean error = true;
                String customerName;
                s.nextLine();// to clear buffer and the next code can accept the string

                do {
                    System.out.print("Customer name:");
                    customerName = s.nextLine();
                    if (!customerName.isEmpty()) error = false;
                    else System.out.println("-NAME CANNOT BE EMPTY. TRY AGAIN...-");
                } while (error);
                error = true;

                System.out.println();
                Address custAddr = new Address();
                do {
                    System.out.print("Street #:");
                    if (custAddr.setStreet(s.nextLine())) error = false;
                    else System.out.println("-INCORRECT STREET#. TRY AGAIN...-");
                } while (error);
                error = true;

                do {
                    System.out.print("City:");
                    if (custAddr.setCity(s.nextLine())) error = false;
                    else System.out.println("-INCORRECT CITY NAME. TRY AGAIN...-");
                } while (error);
                error = true;

                do {
                    System.out.print("Province:");
                    if (custAddr.setState(s.nextLine())) error = false;
                    else System.out.println("-INCORRECT PROVINCE CODE. TRY AGAIN...-");
                } while (error);
                error = true;

                do {
                    System.out.print("Zip code:");
                    if (custAddr.setZip(s.nextLine())) error = false;
                    else System.out.println("-INCORRECT ZIP CODE. TRY AGAIN...-");
                } while (error);
                error = true;
                System.out.println();

                System.out.println("-ENTER THE FOLLOWING ORDER DETAILS-");
                String orderName;
                do {
                    System.out.print("Item name:");
                    orderName = s.nextLine();
                    if (!orderName.isEmpty()) error = false;
                    else System.out.println("-ITEM NAME CANNOT BE EMPTY. TRY AGAIN...-");
                } while (error);
                error = true;

                int orderQuantity;
                do {
                    System.out.print("Item quantity:");
                    orderQuantity = s.nextInt();
                    if (orderQuantity>0) error = false;
                    else System.out.println("-ORDER QUANTITY CANNOT BE 0. TRY AGAIN...-");
                } while (error);
                error = true;

                double orderPrice;
                do {
                    System.out.print("Item price:$");
                    orderPrice = s.nextDouble();
                    if (orderPrice>0) error = false;
                    else System.out.println("-ORDER PRICE CANNOT BE 0. TRY AGAIN...-");
                } while (error);
                System.out.println();

                Order custOrd = new Order(orderName, orderQuantity, orderPrice);

                Person customer = new Person(customerName, custAddr, custOrd);

                System.out.println("-COMPLETE ORDER DETAILS-");
                System.out.println("------------------------");
                System.out.println("-ADDRESS----------------");
                System.out.println(customer.getAddress());
                System.out.println("-ORDER------------------");
                System.out.println(customer.getOrderDetails());
                System.out.println("-xxxx-------------------");


            } while (s.nextInt() == 1);

        }


        System.out.println("-INHERITANCE- (inclass exc)");
        System.out.print("enter 1 to CONTINUE:");
        while (s.nextInt() == 1) {

            System.out.println("-ENTER THE FOLLOWING DETAILS OF THE PERSON-");

            System.out.print("Name: ");
            s.nextLine();// to clear buffer and the next code can accept the string
            String personName = s.nextLine();

            System.out.print("Age: ");
            int personAge = s.nextInt();

            Person p = new Person(personName, personAge);
            p.sayHi();
            System.out.println(p.name + " is " + p.getAge() + "yrs old!!");
            p.haveBirthday();
            System.out.println(p.name + " is now " + p.getAge() + "yrs old!!");


            System.out.println();
            System.out.println("-ENTER THE FOLLOWING DETAILS OF THE EMPLOYEE-");

            System.out.print("Name: ");
            s.nextLine();// to clear buffer and the next code can accept the string
            String empName = s.nextLine();

            System.out.print("Age: ");
            s.nextLine();// to clear buffer and the next code can accept the string
            int empAge = s.nextInt();

            System.out.print("Employeer: ");
            s.nextLine();// to clear buffer and the next code can accept the string
            String empEmplyer = s.nextLine();

            System.out.print("Salary: ");
            s.nextLine();// to clear buffer and the next code can accept the string
            double empSal = s.nextDouble();

            Employee e = new Employee(empName, empAge, empEmplyer, empSal);
            e.sayHi();
            System.out.println(e.name + " now works at " + e.getEmployeeName() + " and started working when their age was " + e.getAge() + "yrs. ID is " + e.getEmpId());
            e.haveBirthday();
            System.out.println("now " + e.name + " is " + e.getAge() + "yrs old");
            e.work();

            System.out.println(e.name + " got promoted to Manager!! with a salary hike of $1000");
            Manager m = new Manager(e.name, e.age, e.getEmployeeName(), (e.salary + 1000));
            m.assignWork();

        }


        System.out.println("--STRINGBUFFER & STRINGBUILDERS--");
        System.out.print("enter 1 to CONTINUE:");
        while (s.nextInt() == 1) {

            System.out.println("-Student Entry system-");
            System.out.println();

            System.out.print("How many students would you like to add to the system?:");
            int arrLen = s.nextInt();
            s.nextLine();// to clear buffer and the next code can accept the string
            Student[] stuArr = new Student[arrLen];

            for (int i = 0; i < stuArr.length; i++) {
                System.out.println();
                System.out.println("-ENTER DETAILS FOR STUDENT:" + (i + 1) + "-");
                System.out.print("Name of the student:");
                String name = s.nextLine();

                System.out.print("Age of the student:");
                int age = s.nextInt();

                System.out.print("Course for the student:");
                s.nextLine();// to clear buffer and the next code can accept the string
                String course = s.nextLine();

                System.out.print("Grade for the student:");
                String grade = s.nextLine();

                Student stu = new Student(name, age, course, grade);

                stuArr[i] = stu;
                System.out.println("-STUDENT ADDED TO THE SYSTEM-");
            }

            System.out.println();
            System.out.println("-PRINTING DETAILS OF ALL STUDENTS-");
            for (Student student : stuArr) {
                System.out.println(student.getProfile());
            }
        }
    }
}
