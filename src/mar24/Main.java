package mar24;

import mar24.Payments.Bank.Email.Email;

import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * INNER CLASS > (1) LOCAL INNER CLASS, ANONYMOUS CLASS, PACKAGE[USER DEFINED(dev created), INBUILT(provided by java)], EXCEPTION HANDLING
 * HOMEWORK; DIY: PROTECTED KEYWORD, WRAPPER CLASSES, TYPE CASTING
 */
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

            System.out.print("TEST AGAIN? (1)>YES | (0)>NO :");
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

                System.out.print("TEST AGAIN? (1)>YES | (0)>NO :");
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

            System.out.print("TEST AGAIN? (1)>YES | (0)>NO :");
            userIn = sc.nextInt();
            System.out.println();
        }

        System.out.println();
        System.out.print("READ ABOUT STATIC IMPORT? (1)>YES | (0)>NO :");
        userIn = sc.nextInt();
        while (userIn == 1) {

            System.out.print("ENTER A NUMBER(double) AND JAVA WILL FIND A SQUARE ROOT OF IT:");
            double userInDob = sc.nextDouble();

            System.out.println("SQUARE ROOT OF (" + userInDob + "): " + sqrt(userInDob));
            System.out.println("-WE JUST USED sqrt(" + userInDob + ") INSTEAD OF Math.sqrt(" + userInDob + ") HERE. THIS WAS MADE POSSIBLE AS WE USED <import static java.lang.Math.sqrt;>. NOTICE THE KEYWORD <static> IN THE IMPORT STATEMENT-");
            System.out.println("-SIMILARLY, YOU CAN IMPORT <import static java.lang.Math.PI;> AND READ THE VALUE OF PI JUST BY USING STATIC MEMBER <PI> INSTEAD OF <Math.PI>-");
            System.out.println("-ALL STATIC MEMBERS OF <Math> LIBRARY CAN BE IMPORTED BY USING <import static java.lang.Math.*;>-");
            System.out.println("-PROS: \n   STATIC IMPORT IS USED TO FOR CLEANER & LESS REPETITIVE CODE INCASE WE ARE USING A CERTAIN MEMBER OR METHOD FREQUENTLY.-");
            System.out.println("-CONS: \n   INCASE WHERE <import static java.lang.Integer.*;> & <import static java.lang.Long.*;> IS USED. BOTH THE CLASSES CONTAINS A MEMBER CALLED <MAX_VALUE> WHICH WILL CAUSE CONFLICT.-");

            userIn = 0;
            System.out.println();
        }

        System.out.println();
        System.out.print("READ ABOUT SUB PACKAGES? (1)>YES | (0)>NO :");
        userIn = sc.nextInt();
        while (userIn == 1) {

            System.out.println("-IN JAVA, PACKAGE IS A GROUP OF SIMILAR TYPES OF CLASSES, INTERFACE AND SUB-PACKAGES-");
            System.out.println("-A SUB-PACKAGES IS SIMPLY A PACKAGE INSIDE ANOTHER PACKAGE, LIKE A FOLDER INSIDE A FOLDER. FOR EG <java.util> IS A SUBPACKAGE INSIDE <java>. HOWEVER JAVA WILL TREAT THE SUB-PACKAGE AS A COMPLETELY DIFFERENT PACKAGE. THE RELATION IS ONLY IN THE NAME 'NOT' IN ACCESS OR STRUCTURE-");
            System.out.println("-ALSO IMPORTING FIRST PACKAGE DOES NOT GIVES YOU ACCESS TO ITS SUB-PACKAGE. FOR EG <import java.*> DOES NOT GIVES ACCESS TO <java.util>");

            userIn = 0;
            System.out.println();
        }

        System.out.println();
        System.out.print("READ ABOUT PROTECTED KEYWORD? (1)>YES | (0)>NO :");
        userIn = sc.nextInt();
        while (userIn == 1) {

            System.out.println("-'PROTECTED' IS A ACCESS MODIFIER, USED WITH VARIABLES, METHOD, CONSTRUCTORS-");
            System.out.println("-PROTECTED KEYWORD ALLOWS ACCESS TO MEMBER WITHIN THE SAME PACKAGE OR SUB-PACKAGE-");
            System.out.println("-IMPORTANT:: IF INHERITED, ALL THE MEMBERS WILL BE ACCESSIBLE IRRESPECTIVE OF PACKAGE OR SUB-PACKAGES-");
            System.out.println("-IN THE EXAMPLE, THE PACKAGE <mar24.Payments> LETS THE USER LOGIN WITH EMAIL.-");
            System.out.println("    -THE <Bank.Email> LETS USER TO LOGIN WITH JUST EMAIL AS BANK IS A SECURED ENVIRONMENT.-");
            System.out.println("    -ON THE OTHER HAND <ThirdParty> LETS USER TO LOGIN WITH EMAIL AND PASSWORD AS THIRD PARTY IS A NON-SECURED ENVIRONMENT.-");
            System.out.println("    -BOTH PACKAGES REFERS TO CLASS CALLED <Bank.Auth> UNDER <Bank.Email> PACKAGE. HOWEVER THE <Bank.Email> HAS ACCESS TO PROTECTED METHOD IN <Bank.Auth> CALLED <autoAuth> AS <Bank.Email> AND <Bank.Auth> ARE IN THE SAME PACKAGE-");
            System.out.println("    -ON THE OTHER HAND <ThirdParty.Email> DOES NOT HAVE ACCESS TO THIS PROTECTED METHOD IN <Bank.Auth> AS <ThirdParty.Email> AND <Bank.Auth> ARE IN THE DIFFERENT PACKAGES-");

            System.out.println("-LOGIN SYSTEM-");
            System.out.println("-CHOOSE HOW YOU WANT TO LOGIN-");
            System.out.println("PRESS (1) FOR BANK LOGIN");
            System.out.print("PRESS (2) FOR THIRD PARTY LOGIN :");
            userIn = sc.nextInt();

            String email;
            String pass;

            switch (userIn) {
                case 1:
                    sc.nextLine();
                    System.out.print("ENTER YOUR EMAIL:");
                    email = sc.nextLine();

                    Email bankMail = new Email(email);
                    if(bankMail.loginUser()){
                        System.out.println("-LOGIN SUCCESS-");
                    }else{
                        System.out.println("-LOGIN FAILURE-");
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("ENTER YOUR EMAIL:");
                    email = sc.nextLine();

                    System.out.print("ENTER YOUR PASSWORD:");
                    pass = sc.nextLine();

                    mar24.Payments.ThirdParty.Email thirdPartyMail = new mar24.Payments.ThirdParty.Email(email, pass);
                    if(thirdPartyMail.loginUser()){
                        System.out.println("-LOGIN SUCCESS-");
                    }else{
                        System.out.println("-LOGIN FAILURE-");
                    }
                    break;

                default:
                    System.out.println("YOU CHOOSE WRONG OPTION");
                    break;
            }

            System.out.print("TEST AGAIN? (1)>YES | (0)>NO :");
            userIn = sc.nextInt();
            System.out.println();
        }

    }
}