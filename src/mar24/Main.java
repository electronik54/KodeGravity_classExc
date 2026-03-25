package mar24;

import java.util.Scanner;

//INNER CLASS > (1) LOCAL INNER CLASS, ANONYMOUS CLASS, LOCAL INNER CLASS, PACKAGE[USER DEFINED(dev created), INBUILT(provided by java)], EXCEPTION HANDLING

//HOMEWORK; DIY: PROTECTED KEYWORD, WRAPPER CLASSES, TYPE CASTING
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int userIn;

        System.out.print("CONTINUE WITH EXCEPTION HANDLING? (1)>YES | (0)>NO :");
        userIn = sc.nextInt();
        while (userIn == 1) {

            System.out.print("ENTER FIRST NUMBER(int):");
            int firstNum = sc.nextInt();

            System.out.print("ENTER SECOND NUMBER(int):");
            int secondNum = sc.nextInt();

            try {
                int thirdNum = firstNum / secondNum;
                System.out.println("RESULT OF FIRST_NUMBER/SECOND_NUMBER: " + thirdNum);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            System.out.println("TEST AGAIN? (1)>YES | (0)>NO :");
            userIn = sc.nextInt();
            System.out.println();
        }

        System.out.println();
        System.out.print("CONTINUE WITH INNER CLASS? (1)>YES | (0)>NO :");
        userIn = sc.nextInt();
        while (userIn == 1) {

            //INNER CLASS IMPLEMENTATION IN <Devices> CLASS
            Devices smartDevice1 = new Devices("Speaker");
            Devices smartDevice2 = new Devices("Light");

            System.out.print("TEST CONNECTION? (1)>YES | (0)>NO :");
            userIn = sc.nextInt();

            while (userIn == 1) {
                Devices.ConnectionToInternet connection = new Devices.ConnectionToInternet();
                System.out.println("INTERNET CONNECTION : " + connection.checkConnection());

                Devices.LocalConnection smartDevice1Local1 = smartDevice1.new LocalConnection();
                System.out.println("LAN CONNECTION FOR DEVICE1: " + smartDevice1Local1.checkConnection());

                Devices.LocalConnection smartDevice2Local = smartDevice2.new LocalConnection();
                System.out.println("LAN CONNECTION FOR DEVICE2: " + smartDevice2Local.checkConnection());

                System.out.println("TEST AGAIN? (1)>YES | (0)>NO :");
                userIn = sc.nextInt();
                System.out.println();
            }
        }

        System.out.println();
        System.out.print("CONTINUE WITH ANONYMOUS CLASS? (1)>YES | (0)>NO :");
        userIn = sc.nextInt();
        while (userIn == 1) {

            //ANONYMOUS CLASS SINCE <Payment> IS INTERFACE, BUT STILL INSTANTIATED WITHOUT A CLASS
            Payment upi = new Payment() {
                @Override
                public void pay() {
                    System.out.println("-PAYING BY UPI. ENTER THE UPI ID-");
                }
            };
            upi.pay();

            Payment creditCard = new Payment() {
                @Override
                public void pay() {
                    System.out.println("-PAYING BY CC.");
                }
            };
            creditCard.pay();

            Payment amex = new Payment() {
                @Override
                public void pay() {
                    System.out.println("-PAYING BY AMEX.");
                }
            };
            amex.pay();

            System.out.println("TEST AGAIN? (1)>YES | (0)>NO :");
            userIn = sc.nextInt();
            System.out.println();
        }
    }
}