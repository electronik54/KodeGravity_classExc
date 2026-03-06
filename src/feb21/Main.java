package feb21;

// LOOPS > BREAK, CONTINUE
// CLASS > METHODS, return types, constructors

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("---------");
        System.out.println("--CLASS--");
        System.out.println("---------");
        System.out.println();
        /*
        Laptop firstLaptop = new Laptop("Dell", "XPS", 1200, 512);
        firstLaptop.getSpecs();
        firstLaptop.startLaptop();
        firstLaptop.stopLaptop();
        firstLaptop.surfInternet();
        */

        Math m = new Math();
        /*
        int addResult = m.add(3,5);
        int subtractResult = m.subtract(7,2);
        int MultiplyResult = m.multiply(5,2);
        int DivideResult = m.divide(17,5);
        int ModResult = m.mod(17,5);
        */

        //HOMEWORK: create a calculator implementing math class for operations
        Scanner scan = new Scanner(System.in);

        System.out.println("-CALCULATOR WITH MATH CLASS AND SWITCH & IF LOOPS-");
        System.out.println("-SELECT THE OPERATIONS YOU NEED TO PERFORM-");
        System.out.println("PRESS 1 FOR (+)");
        System.out.println("PRESS 2 FOR (-)");
        System.out.println("PRESS 3 FOR (*)");
        System.out.println("PRESS 4 FOR (/)");
        System.out.println("PRESS 5 FOR (%)");
        System.out.print("PRESS 6 or HIGHER FOR TO EXIT:");
        int operationCode = scan.nextInt();

        float result;

        while (operationCode < 6) {

            int firstNum = 0;
            int secondNumber = 0;
            // ASK ONLY IF OPERATION CODE IS VALID
            if (operationCode > 0) {
                System.out.print("ENTER FIRST NUMBER:");
                firstNum = scan.nextInt();
                System.out.print("ENTER SECOND NUMBER:");
                secondNumber = scan.nextInt();
                System.out.println();
            }

            switch (operationCode) {
                case 1:
                    result = m.add(firstNum, secondNumber);
                    System.out.println("ADDITION IS:" + result);

                case 2:
                    result = m.subtract(firstNum, secondNumber);
                    System.out.println("SUBTRACTION IS:" + result);
                    break;

                case 3:
                    result = m.multiply(firstNum, secondNumber);
                    System.out.println("MULTIPLICATION IS:" + result);
                    break;

                case 4:
                    result = m.divide(firstNum, secondNumber);
                    System.out.println("DIVISION IS:" + result);
                    break;

                case 5:
                    result = m.mod(firstNum, secondNumber);
                    System.out.println("MOD IS:" + result);
                    break;

                default:
                    System.err.println("-YOU CHOOSE INVALID OPERATION-");
            }
            System.out.print("PRESS 6 TO EXIT OR THE MATH OPERATION CODE TO PERFORM ANOTHER OPERATION:");
            operationCode = scan.nextInt();
            System.out.println();
        }

        System.out.println("-CLOSING CALCULATOR. BYE-");
    }
}
