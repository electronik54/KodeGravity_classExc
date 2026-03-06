package feb14;

import java.util.Scanner;

public class Ivr {
    public static void main(String[] args) {

        System.out.println("-IF & SWITCH-CASE-DEFAULT STATEMENTS-");
        System.out.println();
        Scanner scan = new Scanner(System.in);

        //TAKE HOME WORK: create an IVR
        System.out.println("--------IVR--------");
        System.out.println("Welcome to Fix-Your-Kids! The only service where we pretend we can fix your child’s behavior while you enjoy three minutes of hold music and a moment of peace.");
        System.out.println();
        System.out.println("--Please select the language you would like to proceed with.--");
        System.out.println("Press 1 For English.");
        System.out.println("Press 2 For the language your child understands when they want snacks.");
        int languageChoice = scan.nextInt();
        System.out.println();

        switch (languageChoice){
            case 1:
                System.out.println("You selected 'English'. How can we help you today?");
                System.out.println("--On the scale of 1-3, how chaotic is your house hold today with 3 being the most chaotic?--");
                int chaos = scan.nextInt();
                System.out.println("Follow the following steps...");
                switch (chaos) {
                    case 1:
                        System.out.println("We’ll transfer you to our ‘You’re Doing Fine, Sweetie' department. If they are not able to help then...");
                    case 2:
                        System.out.println("We’ll connect you to our ‘Deep Breaths and Snacks’ support line. If that does not help then...");
                    case 3:
                        System.out.println("We will transfer you to our Emergency Parent Support Squad.");
                        break;
                    default:
                        System.out.println("May the God give you strength to handle this coz we do not have a solution for this!");
                }
                break;

            case 2:
                System.out.println("You selected 'the language your child understands when they want snacks.' Excellent choice!");
                System.out.println();
                System.out.println("--Please select you choice of snack--");
                System.out.println("Press 1 for 'Cookie' Dialect");
                System.out.println("Press 2 for the 'Chip & Crunch' Dialect");
                System.out.println("Press 3 for the 'I Don't know, they just eat everything' Dialect");
                int snack = scan.nextInt();

                switch(snack){
                    case 1:
                        System.out.println("Transferring to 'Cookie' department");
                        break;
                    case 2:
                        System.out.println("Transferring to 'Chip & Crunch' department");
                        break;
                    case 3:
                        System.out.println("Transferring to 'I Don't know, they just eat everything' department");
                        break;
                    default:
                        System.out.println("I guess we are just out of that option.. Good luck!");
                        break;
                }
                break;

            default:
                System.out.println("Wrong language selected! It cannot be that bad...");
                System.out.println();
        }
        System.out.println();

        System.out.println("--Would you like to take part in our email survey that will be sent to you after the end of this session?--");
        System.out.println("Press 1 for YES, because you enjoy suffering");
        System.out.println("Press 2 for NO, because you have already answered enough questions.");
        System.out.println("Press 3, since you don't check your email anyways.");
        int survey = scan.nextInt();

        if(survey != 2){
            System.out.println("--Please provide your email--");
            scan.nextLine();// to clear buffer and the next code can accept the string input
            String email = scan.nextLine();
            System.out.println("Email sent to:"+email);
        }

        System.out.println("Thank you for choosing Fix‑Your‑Kids, where the only thing we fix is your expectations. Remember: parenting is hard, but at least you’re doing it better than your neighbor. :)");
        System.out.println("--------IVR EXIT--------");


/*
        System.out.println("--------CALCULATOR--------");
        //CALC
        System.out.println("(1): +");
        System.out.println("(2): -");
        System.out.println("(3): /");
        System.out.println("(4): *");
        System.out.println("(5): %");
        System.out.println("(0): Exit");

        System.out.print("Choose operation:");
        int operation = scan.nextInt();

        System.out.print("First number:");
        int first = scan.nextInt();
        System.out.print("Second number:");
        int second = scan.nextInt();
        float result;
        float result2;

        //IF
        System.out.print("USING IF: ");
        if(operation == 1){
            result = first+second;
            System.out.println("+:" + result);
        }else if(operation == 2){
            result = first-second;
            System.out.println("-:" + result);
        }else if(operation == 3){
            result = first /second;
            System.out.println("/:" + result);
        }else if(operation == 4){
            result = first*second;
            System.out.println("*:" + result);
        }else if(operation == 5){
            result = first%second;
            System.out.println("%:" + result);
        }else{
            System.out.println("Bye!");
        }

        //SWITCH
        System.out.print("USING SWITCH: ");
        switch (operation){
            case 1:
                result2 = first+second;
                System.out.println("+:" + result2);
                break;
            case 2:
                result2 = first-second;
                System.out.println("-:" + result2);
                break;
            case 3:
                result2 = first/second;
                System.out.println("/:" + result2);
                break;
            case 4:
                result2 = first*second;
                System.out.println("*:" + result2);
                break;
            case 5:
                result2 = first%second;
                System.out.println("%:" + result2);
                break;
            default:
                System.out.println("Bye!");
        }
        System.out.println("--------CALCULATOR EXIT--------");
        System.out.println();
*/

    }
}
