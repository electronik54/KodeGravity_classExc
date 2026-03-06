package feb14;

import java.util.Scanner;

public class Decisions{
    public static void main(String[] args){

        //IF
        int number = -438;

        if(number%2 == 0){
            System.out.println("number is even");
        }else{
            System.out.println("number is odd");
        }

        if(number > 0){
            System.out.println("number is >0");
        }else{
            System.out.println("number is <0");
        }

        //ELSE IF
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Salary($):");
        int sal = scan.nextInt();

        if(sal >= 258482){
            System.out.println("Tax is 33%");
        }else if(sal >=181440 && sal < 258482){
            System.out.println("Tax is 29%");
        }else if(sal >=117045 && sal < 181440){
            System.out.println("Tax is 26%");
        }else if(sal >=58523 && sal < 117045){
            System.out.println("Tax is 20.5%");
        }else {
            System.out.println("Tax is 14%");
        }



    }

}