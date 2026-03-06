package feb17;

import java.util.Random;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("-WHILE, DO WHILE LOOPS AND INCREMENT & DECREMENT OPERATORS-");
        System.out.println();


        //homework: DO NOT EXIT LOOP till user enters Y
        //DO-WHILE LOOP
        System.out.println("--DO>WHILE LOOP--");
        System.out.println("-This is 'enter correct answer to exit' loop-");
        int iterationNum=0;
        int a;
        int b;
        int answer;
        Random rand = new Random();

        do {
            ++iterationNum;
            a = rand.nextInt(100);
            b = rand.nextInt(100);
            System.out.print(iterationNum+":Solve > " + a + "+" + b + ":");
            answer = scan.nextInt();
            if (a + b != answer) {
                System.out.println("-Incorrect, try again. Continuing loop-");
            }
        }while(a+b!=answer);
        System.out.println("-Correct, exiting loop after "+iterationNum+" iteration(s)-");
        System.out.println("-------------------------");

        System.out.println("--WHILE LOOP--");
        iterationNum=0;
        char input='n';

        //WHILE LOOP
        System.out.println("-This is press Y to exit loop-");
        while(input != 'y'){
            System.out.print(++iterationNum + ":Press 'y' to exit:");
            char userChar = scan.next().charAt(0);
            if(userChar == 'y'){
                input = userChar;
            }else{
                System.out.println("-Loop continues-");
            }
        }
        System.out.println("-Exiting loop after "+iterationNum+" iteration(s)...-");


/*
        System.out.print("Enter the number:");

        int number = scan.nextInt();
        System.out.println("number:"+number);

        //GET FACTORIAL eg:5x4x3x2x1
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        System.out.println("Result:"+factorial);
*/


        /*
        System.out.println("All numbers");
        int numbs = 1;
        while(numbs <= number){
            System.out.print(numbs+">");
            numbs++;
        }
        numbs=1;
        do{
            System.out.print(numbs+">");
            numbs++;
        }while(numbs <= number);

        System.out.println();

        System.out.println("All Evens");
        int evenNumbs = 1;
        while(evenNumbs <= number){
            if(evenNumbs%2==0){
                System.out.print(evenNumbs+">");
            }
            evenNumbs++;
        }
        evenNumbs=1;
        do{
            if(evenNumbs%2==0){
                System.out.print(evenNumbs+">");
            }
            evenNumbs++;
        }while(evenNumbs <= number);
        System.out.println();

        System.out.println("Table of 5");
        int multi = 1;
        while(multi <= number){
            System.out.println("5x"+multi+"="+5*multi);
            multi++;
        }
        multi = 1;
        do{
            System.out.println("5x"+multi+"="+5*multi);
            multi++;
        } while(multi <= number);
*/

    }
}
