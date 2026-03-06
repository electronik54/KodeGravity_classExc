package feb21;

import java.util.Random;
import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {

        //BREAK AND CONTINUE KEYWORDS

        Scanner scan = new Scanner(System.in);

        //LOTTERY SYSTEM WITH 3 ATTEMPTS USING THE LOOPS WE HAVE LEARNT
        System.out.println("--ENTER YOUR LUCKY NUMBER BETWEEN 1-30--");
        int jackpot;
        //Random rand = new Random();
        //jackpot = rand.nextInt(30);
        jackpot = 25;
        int userIn;

        for (int i = 1; i <= 3; i++){
            System.out.println("Your number is: ");
            userIn = scan.nextInt();

            if(userIn != jackpot && i<3){
                System.out.println("-Sorry try again-");
                continue;
            }
            else if (userIn != jackpot && i==3){
                System.out.println("-Out of attempts. Exiting loop-");
                continue;
            }
            else{
                System.out.println("-Its a match!!-");
                break;
            }
        }








    }
}
