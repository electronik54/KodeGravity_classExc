package mar10;
import java.util.Scanner;

// ENCAPSULATION, GETTER SETTER, super KEYWORD
public class Main {
    public static void main(String[] args) {

        /*
        IMPLEMENT AGGREGATION AND INHERITANCE

        BANK CLASS
            -BMO #interest rate(prime+0.5)
            -SCOTIA #interest rate(prime+0.6)
            -RBC #interest rate(prime+0.7)

        ACCOUNT
            getBalance()
            withdraw()
            deposit()

        OPERATION
            -Press 1 to get balance
            -Press 2 to deposit
            -press 3 to withdraw
                -with balance check before withdrawal
            -press 4 to exit
         */

        System.out.println("--ENCAPSULATION & AGGREGATION--");
        System.out.println();

        var s = new Scanner(System.in);

        var user1 = new User("Nikhil", "123456");
        var user2 = new User("Ryan", "123456");
        var user3 = new User("Zhanna", "123456");
        var acc1 = new Account(user1, 1000.43, "CURRENT");
        var acc2 = new Account(user2, 2350.99, "CURRENT");
        var acc3 = new Account(user3, 1013.00, "SAVING");
        Account[] accArray = new Account[]{acc1, acc2, acc3};
        var bank = new Scotia(accArray);

        var user4 = new User("Manya", "123456");
        var user5 = new User("Amarjot", "123456");
        var acc4 = new Account(user4, 1000.43, "CURRENT");
        var acc5 = new Account(user5, 2350.99, "CURRENT");
        Account[] accArray2 = new Account[]{acc4, acc5};
        var bank1 = new BMO(accArray2);

        var user6 = new User("Sunny", "123456");
        var acc6 = new Account(user6, 2350.99, "SAVING");
        Account[] accArray3 = new Account[]{acc6};
        var bank2 = new RBC( accArray3);

        Bank[] bankArr = new Bank[]{bank, bank1, bank2};

        System.out.println("--WELCOME USER--");

        do {
            System.out.println("-PLEASE SELECT WHICH BANK YOU WANT TO OPERATE TODAY-");
            for (int bnkCtr = 0; bnkCtr < bankArr.length; bnkCtr++) {
                System.out.println("PRESS (" + (bnkCtr + 1) + ") FOR " + bankArr[bnkCtr].getName());
            }
            int bankChoiceCode;
            do {
                System.out.print("PRESS (0) TO EXIT OR YOUR BANK CHOICE:");
                bankChoiceCode = s.nextInt();
                if (bankChoiceCode < -1 || bankChoiceCode > bankArr.length) {
                    System.out.println("INCORRECT SELECTION. TRY AGAIN...");
                }
            } while (bankChoiceCode <= -1 || bankChoiceCode > bankArr.length);

            if (bankChoiceCode == 0) {
                break;
            }

            System.out.println();
            s.nextLine();// to clear buffer and the next code can accept the string
            Bank userBank = bankArr[(bankChoiceCode - 1)];

            System.out.println("-SELECT THE ACCOUNT YOU WANT TO OPERATE-");

            do {
                Account userAcc = null;
                int retryCount = 1;
                do {
                    if (retryCount > 3) {
                        break;
                    }
                    System.out.println("(ATTEMPT:" + retryCount + "/3)ENTER THE CREDENTIALS:");
                    userAcc = userBank.getAccFromLoginPrompt(s);
                    if (userAcc == null) System.out.println("-ACC NOT FOUND. TRY AGAIN!-");
                    else System.out.println("-YOU SELECTED " + userBank.getName() + "-");
                    retryCount++;
                } while (userAcc == null);
                if (retryCount > 3) {
                    System.out.println("-RETRY ATTEMPT EXCEEDED. SELECT THE BANK AGAIN-");
                    break;
                }

                System.out.println();
                if (userAcc != null)
                    System.out.println("-WELCOME " + userAcc.accHolderName() + " | AC#:" + userAcc.getAccNumber() + ". CHOOSE FROM THE FOLLOWING OPTIONS...-");

                do {
                    System.out.println("PRESS (1) TO GET BALANCE");
                    System.out.println("PRESS (2) TO DEPOSIT");
                    System.out.println("PRESS (3) TO WITHDRAW");
                    System.out.println("PRESS (4) TO ADD YEARLY INTEREST");
                    System.out.print("PRESS (0) TO EXIT:");
                    int oprChoice = s.nextInt();

                    switch (oprChoice) {
                        case 1:
                            System.out.println("YOUR BALANCE IS:$" + userAcc.getBalance());
                            break;
                        case 2:
                            System.out.print("ENTER AMOUNT TO DEPOSIT:$");
                            if(userAcc.deposit(s.nextDouble()))
                                System.out.println("SUCCESS. YOUR CURRENT BALANCE IS " + userAcc.getBalance());
                            else System.out.println("-INSUFFICIENT DEPOSIT AMOUNT-");
                            break;
                        case 3:
                            System.out.print("ENTER AMOUNT TO WITHDRAW:$");
                            if(userAcc.withdraw(s.nextDouble()))
                                System.out.println("SUCCESS. YOUR CURRENT BALANCE IS " + userAcc.getBalance());
                            else  System.out.println("-INSUFFICIENT BALANCE TO WITHDRAW-");
                            break;
                        case 4:
                            System.out.println("-SYSTEM OUT. A YEAR PASSED. ADDING YEARLY INTEREST-");
                            System.out.println("YOUR BALANCE WAS:$" + userAcc.getBalance()+ ". ADDING INTEREST...");
                            userAcc.earnInterestOnBalance(userBank.getInterestRate());
                            System.out.println("YOUR BALANCE IS:$" + userAcc.getBalance());
                            break;
                        default:
                            System.out.println("-INCORRECT SELECTION. TRY AGAIN...-");
                            break;
                    }

                    System.out.println();
                    System.out.print("PRESS \n (1) TO PERFORM ANOTHER TRANSACTION \n (0) TO LOGIN TO A DIFFERENT ACCOUNT:");
                }while(s.nextInt() == 1);

                System.out.println();
                System.out.print("PRESS\n (1) TO LOG INTO ANOTHER ACCOUNT IN "+userBank.getName()+" BANK \n (0) TO SELECT ANOTHER BANK:");
            } while (s.nextInt() == 1);

            System.out.println();
            System.out.print("PRESS \n (1) TO SELECT THE BANK \n (O) TO EXIT THE BANK APP:");
        } while (s.nextInt() == 1);

        System.out.println();
        System.out.println("--GOOD BYE!--");
    }
}