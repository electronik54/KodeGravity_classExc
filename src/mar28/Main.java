package mar28;

import mar28.Bank.Account;
import mar28.Bank.BalanceError;
import mar28.Generics.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * [1]. EXCEPTION HANDLING (deep dive)
 *  - CHECKED EXCEPTION(compile-time exception), UNCHECKED EXCEPTION(run-time exception)
 *  - EXCEPTION CLASS HIERARCHY
 *  - FINALLY (this will block execute regardless of error state. The program execution will stop if exception is not handled but still finally will execute)
 *  - CUSTOMIZED EXCEPTION
 *  - THROW VS THROWS
 * [2]. COLLECTIONS
 * [3]. GENERICS
 * */
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int userIn;
        int amount;

        System.out.print("-LIST & GENERICS (1)>YES (0)>NO :");
        userIn = s.nextInt();
        while (userIn == 1){

            Product<String, Double> prod1 = new Product<>("Orange", 1.19);
            Product<String, Double> prod2 = new Product<>("Bread", 3.99);
            Product<String, Double> prod3 = new Product<>("Cereals", 8.49);

            Product<String, Integer> prod4 = new Product<>("Car", 3);
            Product<String, Integer> prod5 = new Product<>("House", 1);
            Product<String, Integer> prod6 = new Product<>("Plane", 0);


            List<Product> list1 = new ArrayList<>();
            list1.add(prod1);
            list1.add(prod2);
            list1.add(prod3);
            list1.add(prod4);
            list1.add(prod5);
            list1.add(prod6);
            for (Product p : list1) {
                System.out.println("FILED1: " + p.getField1() + " HAS FILED2: " + p.getField2());
            }
            System.out.println();

            List<Product<String, Double>> list2 = new ArrayList<>();
            list2.add(prod1);
            list2.add(prod2);
            list2.add(prod3);
            for(Product<String, Double> prod: list2){
                System.out.println("PRODUCT:" + prod.getField1() + " COSTS: $" + prod.getField2());
            }
            System.out.println();

            List<Product<String, Integer>> list3 = new ArrayList<>();
            list3.add(prod4);
            list3.add(prod5);
            list3.add(prod6);
            for(Product<String, Integer> prod: list3){
                System.out.println("QUANTITY OF:" + prod.getField1() + " IS: " + prod.getField2());
            }


            System.out.print("TRY AGAIN? (1)>YES (0)>NO :");
            userIn = s.nextInt();
            System.out.println();
        }


        System.out.print("-CONTINUE WITH CUSTOMIZED EXCEPTION HANDLING (1)>YES (0)>NO :");
        userIn = s.nextInt();
        while (userIn == 1) {
            s.nextLine();

            boolean isError = true;
            Account acc = new Account(0);

            while (isError) {
                try {
                    System.out.print("ENTER THE INITIAL AMOUNT IN THE ACCOUNT:");
                    amount = Integer.parseInt(s.nextLine());
                    acc = new Account(amount);

                    isError = false;
                } catch (BalanceError e) {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println("INVALID INPUT. TRY AGAIN...");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println("INVALID INPUT. TRY AGAIN...");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("UNKNOWN ERROR...");
                }

            }
            System.out.println("SUCCESS. ACCOUNT WITH BALANCE $" + acc.getBalance() + " CREATED");

            while (userIn == 1) {
                System.out.println("PRESS (1) TO WITHDRAW");
                System.out.print("PRESS (2) TO DEPOSIT : ");
                userIn = s.nextInt();
                isError = true;
                s.nextLine();

                switch (userIn) {

                    case 1:
                        try {
                            System.out.print("ENTER THE WITHDRAWAL AMOUNT:");
                            amount = Integer.parseInt(s.nextLine());
                            if(! acc.withdraw(amount)){
                                System.out.println("TRANSACTION FAILED");
                            }else{
                                isError = false;
                            }

                        }
                        //<acc.withdraw> HANDLES EXCEPTION <BalanceError> INSIDE ITSELF SO <catch (BalanceError e)> IS NOT REQUIRED HERE
                        catch (NumberFormatException e) {
                            e.printStackTrace();
                            System.out.println();
                            System.out.println("INVALID INPUT.");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("UNKNOWN ERROR...");
                            s.nextLine();
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("ENTER THE DEPOSIT AMOUNT:");
                            amount = Integer.parseInt(s.nextLine());
                            if(! acc.deposit(amount)){
                                System.out.println("TRANSACTION FAILED");
                            }else{
                                isError = false;
                            }

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            System.out.println();
                            System.out.println("INVALID INPUT.");
                        } catch (BalanceError e) { //HANDLED HERE AS <acc.deposit> <throws> EXCEPTION
                            e.printStackTrace();
                            System.out.println();
                            System.out.println("INVALID INPUT.");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("UNKNOWN ERROR...");
                            s.nextLine();
                        }
                        break;
                }

                if(! isError) System.out.println("SUCCESS... YOUR BALANCE IS :$" + acc.getBalance());

                System.out.print("PERFORM ANOTHER TRANSACTION? (1)>YES (0)>NO :");
                userIn = s.nextInt();
                System.out.println();
            }

            System.out.print("TRY AGAIN? (1)>YES (0)>NO :");
            userIn = s.nextInt();
            System.out.println();
        }


        System.out.print("-CONTINUE WITH EXCEPTION HANDLING (1)>YES (0)>NO :");
        userIn = s.nextInt();
        while (userIn == 1) {

            int firstInt;
            int secondInt;
            int thirdInt;
            int[] intArr = new int[]{1, 2, 3, 4};
            String someString = "";
            Boolean anyError = true;

            s.nextLine();
            try {
                System.out.println("-PARSING <String> TO <int>-");
                System.out.print("ENTER 1st NUMBER(int) : ");
                firstInt = Integer.parseInt(s.nextLine());
                System.out.print("SUCCESS.. INPUT WAS : " + firstInt);
                System.out.println();

                System.out.println("-ARITHMATIC EXCEPTION BY DIVIDING-");
                System.out.print("ENTER 2nd NUMBER(int) : ");
                secondInt = Integer.parseInt(s.nextLine());
                System.out.println("INPUT WAS : " + secondInt);
                thirdInt = firstInt / secondInt;
                System.out.println("SUCCESS.. DIVISION WAS : " + thirdInt);
                System.out.println();

                System.out.println("-NULL POINTER EXCEPTION-");
                System.out.print("ENTER A VALUE IN <someString>:");
                someString = s.nextLine();
                System.out.println("SETTING <someString=null>");
                someString = null;
                System.out.println("EXECUTING <someString.trim()>");
                System.out.println(someString.trim());

                anyError = false;
            } catch (NumberFormatException e) {
                System.out.println("<NumberFormatException> OCCURRED");
                e.printStackTrace();

            } catch (ArithmeticException e) {
                System.out.println("<ArithmeticException> OCCURRED");
                e.printStackTrace();

            } catch (NullPointerException e) {
                System.out.println("<NullPointerException> OCCURRED");
                e.printStackTrace();

            } catch (Exception e) {
                System.out.println("<Exception> OCCURRED. UNKNOWN ERROR");
                e.printStackTrace();

            } finally {
                if (anyError) {
                    System.out.println("-YOUR CODE HAS ERRORS. DEAL WITH IT!!-");
                } else {
                    System.out.println("YOUR CODE IS CLEAN!!");
                }
            }

            System.out.print("TRY AGAIN? (1)>YES (0)>NO :");
            userIn = s.nextInt();
        }


        System.out.println("BYE...");
        s.close();
    }
}
