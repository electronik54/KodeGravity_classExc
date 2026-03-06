package feb28;

import java.util.Scanner;

//STATIC [implemented-VARS, implemented-BLOCKS, CLASS & METHOD], ARRAYS [FOR & FOREACH]

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("--ARRAYS--");
        System.out.print("1 to continue, 0 to skip:");
        if (s.nextInt() == 1) do {
            int arrLength;
            do {
                System.out.print("ENTER THE LENGTH OF ARRAY:");
                arrLength = s.nextInt();
                if (arrLength < 1) System.out.println("-ARRAY LENGTH CANNOT BE SMALLER THAN 1-");
            } while (arrLength < 1);

            int[] intArr = new int[arrLength];
            System.out.println("Provide value at:");
            for (int i = 0; i < intArr.length; i++) {
                System.out.print("[" + i + "] > ");
                int inVal = s.nextInt();
                intArr[i] = inVal;
            }

            System.out.println("------------------");
            System.out.println("-MIN MAX IN ARRAY-");
            int minVal = intArr[0];
            int maxVal = intArr[0];
            for (int i = 1; i < intArr.length; i++) { //SKIP FIRST SINCE FIRST ELEMENT IS ASSUMED TO BE MIN AS WELL AS MAX FOR TIME BEING.
                if (intArr[i] < minVal) minVal = intArr[i];
                if (intArr[i] > maxVal) maxVal = intArr[i];
            }
            System.out.println("RESULT:: MIN:" + minVal + "|MAX:" + maxVal);
            System.out.println();

            System.out.println("----------------------------------------------------------------");
            System.out.println("-REVERSE EXISTING ARRAY WITH SWAPPING (DO NOT CREATE 2nd ARRAY)-");
            for (int i = 0; i < (intArr.length / 2); i++) {
                int firstVal = intArr[i];
                int secondVal = intArr[intArr.length - (i + 1)];
                int secondValIndex = intArr.length - (i + 1);

                intArr[i] = secondVal;
                intArr[secondValIndex] = firstVal;
            }
            System.out.print("REVERSE ARRAY:");
            for (int entry : intArr) {
                System.out.print(entry + "|");
            }
            System.out.println();
            System.out.println();

            //HOMEWORK SORT ARRAY
            System.out.println("------------------------");
            System.out.println("-SORT ELEMENTS OF ARRAY-");
            int iteration = 0;
            for (int currentIndex = 0; currentIndex < intArr.length - 1; currentIndex++) {
                int currentNum = intArr[currentIndex];

                //System.out.println("Checking:" + currentNum + " iteration[" + currentIndex + 1 + "]");
                int maxDifference = 0;
                int swapNumIndex = -1;

                for (int nextIndex = currentIndex + 1; nextIndex < intArr.length; nextIndex++) {
                    iteration++;

                    int nextNum = intArr[nextIndex];

                    int difference = currentNum - nextNum;
                    if (difference > 0 && difference > maxDifference) {
                        maxDifference = difference;
                        swapNumIndex = nextIndex;
                    }
                }
                if (swapNumIndex > 0) {
                    intArr[currentIndex] = intArr[swapNumIndex];
                    intArr[swapNumIndex] = currentNum;
                }
            }
            System.out.println("-ASCENDING ARRAY (iterations:" + iteration + ")-");
            for (int entry : intArr) {
                System.out.print(entry + "|");
            }
            System.out.println();
            System.out.println();

            System.out.print("press 1 to exit:");
        } while (s.nextInt() != 1);

        System.out.println("--STATIC BLOCK & INSTANCE BLOCK--");
        System.out.print("1 to continue, 0 to skip:");
        if (s.nextInt() == 1) do {
            StaticInClass.displayCount();
            StaticInClass sc = new StaticInClass("class1");
            sc.displayName();
            StaticInClass sc2 = new StaticInClass("class2");
            sc2.displayName();

            System.out.print("press 1 to exit:");
        } while (s.nextInt() != 1);

        System.out.println("--STATIC BLOCK & INSTANCE BLOCK IMPLEMENTATION--");
        System.out.print("1 to continue, 0 to skip:");
        int exitCode;
        if (s.nextInt() == 1) do {
            System.out.println("------------------------------");
            System.out.println("-----CREATING NEW ACCOUNT-----");
            double amount;
            s.nextLine();// to clear buffer and the next code can accept the string input
            System.out.print("Please provide your name:");
            String name = s.nextLine();
            System.out.print("Please provide your initial balance:");
            amount = s.nextInt();

            Account acc1 = new Account(name, amount);
            acc1.getAccInfo();

            System.out.print("Please provide amount you want to withdraw:$");
            amount = s.nextDouble();

            if (!acc1.withdraw(amount)) System.out.println("Withdraw failed due to insufficient funds");
            else acc1.getAccInfo();

            System.out.print("Please provide amount you want to deposit:$");
            amount = s.nextDouble();
            acc1.deposit(amount);
            acc1.getAccInfo();

            System.out.println("1 Year later...");
            acc1.addInterest();
            acc1.getAccInfo();

            System.out.print("press 1 to exit:");
            exitCode = s.nextInt();
            if (exitCode == 1)
                Account.getTotalAccounts(); //NO NEED TO INITIALIZE CLASS TO ACCESS getTotalAccounts() AS THE METHOD IS STATIC
        } while (exitCode != 1);

    }
}
