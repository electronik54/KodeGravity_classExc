package mar14;

import mar14.Notification.Email;
import mar14.Notification.Notification;
import mar14.Notification.Push;
import mar14.Notification.SMS;

import java.util.Scanner;

// OBJECT CLASS and its METHODS, GARBAGE COLLECTOR(interview imp), METHOD OVERLOADING (in the same class with same method name but different signatures), METHOD OVERRIDING(in the inherited class with same method name), ABSTRACTION (abstract class, interface[NOT COVERED])
public class Main {
    /*HOMEWORK:
    (1)
    - IN THE PDF THERE IS AN ARTICLE(and 2 videos in article) ON GARBAGE COLLECTOR, WATCH IT
    - Create a presentation (submit it after a week or 2)

    (2) OBJECT CLASS: learn about its method

    (3) USE ABSTRACT CLASS
            |-NOTIFICATION SYSTEM > sendNotification, receiveNotification
            |-> EMAIL
            |-> SMS
            |-> PUSH NOTIFICATION
     */

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int userIn;
        User ftUser = new User("BOB", "111", "email");
        User ptUser = new User("ROXANE", "roxx123", "rx@email.com", "3134256518");
        User conUser = new User("NIKHIL", "ps", "n@m", "4138432217");

        // FOR KEEPING A RECORD OF ALL USERS
        User[] userArr = new User[]{ftUser, ptUser, conUser};

        System.out.println("-HOMEWORK TO IMPLEMENT ABSTRACT CLASS-");
        System.out.print("CONTINUE? (0)>YES | (1)>NO :");
        userIn = s.nextInt();

        while (userIn == 0) {
            String loginEmail;
            String loginPass;
            User loginUser = null;
            User notiToUser = null;

            // CHOOSE/LOGIN THE USER THAT WILL SEND THE MESSAGE
            s.nextLine();
            System.out.println("--ENTER CREDENTIALS TO LOGIN--");
            System.out.print("EMAIL:");
            loginEmail = s.nextLine();
            System.out.print("PASSWORD:");
            loginPass = s.nextLine();

            // CHECK THE RECORD TO FIND USER WITH MATCHING CREDENTIALS AND SAVE THE USER IN loginUser
            for (User u : userArr) {
                if (u.login(loginEmail, loginPass)) {
                    loginUser = u;
                    break;
                }
            }

            //IF loginUser IS NOT NULL
            if (loginUser != null) {
                System.out.println();
                System.out.println("-WELCOME " + loginUser.getUserName() + "-");

                int notiChoice = -1;
                boolean isError = true;

                // PRINT THE LIST OF ALL USERS FROM RECORDS TO SEND THE NOTIFICATION TO
                for (int counter = 0; counter < userArr.length; counter++) {
                    System.out.println("-PRESS (" + counter + ") FOR " + userArr[counter].getUserName()+"-");
                }

                //CHECK IF THE "SEND THE NOTIFICATION TO" USER INPUT IS VALID
                do {
                    System.out.print("SELECT WHICH USER YOU WANT TO SEND MESSAGE TO FROM THE LIST ABOVE:");
                    notiChoice = s.nextInt();
                    if(notiChoice > userArr.length ||  notiChoice < 0)
                        System.out.println("-INCORRECT CHOICE. TRY AGAIN-");
                    else
                        isError = false;

                }while (isError);

                //SAVE THE "SEND THE NOTIFICATION TO" USER IN notiToUser
                notiToUser = userArr[notiChoice];
                isError = true;

                // PROVIDE THE OPTIONS TO SEND THE NOTIFICATION
                System.out.println();
                System.out.println("YOU CHOOSE " + notiToUser.getUserName() + " TO SEND THE MESSAGE TO");
                System.out.println("-SELECT YOR MESSAGING MODE-");
                System.out.println("PRESS (0) FOR EMAIL");
                System.out.println("PRESS (1) FOR SMS");
                System.out.print("PRESS (2) FOR PUSH NOTIFICATION:");
                do {
                    System.out.print("SELECT WHICH MESSAGING SYSTEM DO YOU PREFER FROM ABOVE LIST:");
                    notiChoice = s.nextInt();

                    //MAKE SURE THE NOTIFICATION OPTION CHOICE IS VALID
                    if(notiChoice > 2 ||  notiChoice <= -1)
                        System.out.println("-INCORRECT CHOICE. TRY AGAIN-");
                    else
                        isError = false;

                }while (isError);
                s.nextLine();

                // DEPENDING ON THE NOTIFICATION CHOICE, BUILD THE OBJECT OF THE RESPECTIVE NOTIFICATION CLASS
                System.out.println();
                String message;
                String subject;
                switch (notiChoice) {
                    case 0:
                        System.out.println("YOU CHOOSE EMAIL NOTIFICATION");
                        System.out.println("-PROVIDE FOLLOWING DETAILS-");
                        System.out.print("SUBJECT:");
                        subject = s.nextLine();
                        System.out.print("MESSAGE:");
                        message = s.nextLine();

                        Notification emailNoti = new Email(subject, message, loginUser, notiToUser);

                        System.out.print("SEND EMAIL? (0)>YES | (1)>ALSO YES | (ANY INT VALUE) NO... BUT STILL SEND IT:");
                        s.nextInt();
                        System.out.println(emailNoti.sendNotification());

                        System.out.println("-ON "+notiToUser.getUserName()+"'s SIDE...-");
                        System.out.println("TINGGGG!! <YOU HAVE 1 NEW NOTIFICATION>");
                        System.out.println(emailNoti.ReceiveNotification());

                        break;

                    case 1:
                        System.out.println("YOU CHOOSE SMS NOTIFICATION");
                        System.out.println("-PROVIDE FOLLOWING DETAILS-");
                        System.out.print("MESSAGE:");
                        message = s.nextLine();

                        Notification smsNoti = new SMS(message, loginUser, notiToUser);

                        System.out.print("SEND EMAIL? (0)>YES | (1)>ALSO YES | (ANY INT VALUE) NO... BUT STILL SEND IT:");
                        s.nextInt();
                        System.out.println(smsNoti.sendNotification());

                        System.out.println("-ON "+notiToUser.getUserName()+"'s SIDE...-");
                        System.out.println("TINGGGG!! <YOU HAVE 1 NEW NOTIFICATION>");
                        System.out.println(smsNoti.ReceiveNotification());
                        break;

                    case 2:
                        System.out.println("YOU CHOOSE PUSH NOTIFICATION");
                        System.out.println("-PROVIDE FOLLOWING DETAILS-");
                        System.out.print("MESSAGE:");
                        message = s.nextLine();

                        Notification pushNoti = new Push(message, loginUser, notiToUser);

                        System.out.print("SEND EMAIL? (0)>YES | (1)>ALSO YES | (ANY INT VALUE) NO... BUT STILL SEND IT:");
                        s.nextInt();
                        System.out.println(pushNoti.sendNotification());

                        System.out.println("-ON "+notiToUser.getUserName()+"'s SIDE...-");
                        System.out.println("TINGGGG!! <YOU HAVE 1 NEW NOTIFICATION>");
                        System.out.println(pushNoti.ReceiveNotification());
                        break;

                    default:
                        System.out.println("WRONG INPUT FOR CHOOSING MESSAGING SYSTEM");

                }

            } else {
                System.out.println("INCORRECT CREDENTIALS");
            }
            s.nextInt();

            //ASK USER FOR A RETRY
            System.out.print("TRY AGAIN? (0)>YES | (1)>NO :");
            userIn = s.nextInt();
        }


        System.out.println("-INCLASS EXE FOR FINDING AREA OF A SHAPE-");
        System.out.print("CONTINUE? (0)>YES | (1)>NO :");
        userIn = s.nextInt();

        while (userIn == 0) {
            System.out.print("ENTER CIRCLE RADIUS:");
            double cirRad = s.nextDouble();
            var circle = new Circle(cirRad);
            System.out.println("Area of circle with radius:" + circle.getRadius() + " is " + circle.getArea());

            System.out.print("ENTER SQUARE LENGTH:");
            double sqLen = s.nextDouble();
            var square = new Square(sqLen);
            System.out.println("Area of square with side:" + square.getSide() + " is " + square.getArea());

            System.out.print("ENTER RECTANGLE LENGTH:");
            double recLen = s.nextDouble();
            System.out.print("ENTER RECTANGLE WIDTH:");
            double recWidth = s.nextDouble();

            var rectangle = new Rectangle(recLen, recWidth);
            var sides = rectangle.getSides();
            System.out.println("Area of rectangle with length:" + sides[0] + "and width:" + sides[1] + " is " + rectangle.getArea());

            //ASK USER FOR A RETRY
            System.out.print("TRY AGAIN? (0)>YES | (1)>NO :");
            userIn = s.nextInt();
        }


        System.out.println();
        System.out.println("-----------------------");
        System.out.println("--INCLASS METHOD OVERRIDING(in the inherited class with same method name)--");
        System.out.print("CONTINUE? (0)>YES | (1)>NO :");
        userIn = s.nextInt();

        while (userIn == 0) {
            Employee ftEmployee = new FullTimeEmp(ftUser);
            System.out.print("HOURS FOR FULL-TIME EMPLOYEE:" + ftEmployee.getEmpName() + " ::");
            double ftEmpHours = s.nextDouble();
            System.out.println("PAY FOR FULL-TIME EMPLOYEE:" + ftEmployee.getEmpName() + " IS SALARY:$" + ftEmployee.getPay(ftEmpHours));
            System.out.println("--------");


            Employee ptEmployee = new PartTimeEmp(ptUser);
            System.out.print("HOURS FOR PART-TIME EMPLOYEE:" + ptEmployee.getEmpName() + " ::");
            double ptEmpHours = s.nextDouble();
            System.out.println("PAY FOR PART-TIME EMPLOYEE:" + ptEmployee.getEmpName() + " IS SALARY:$" + ptEmployee.getPay(ptEmpHours));
            System.out.println("--------");


            Employee conEmployee = new ContractEmp(conUser);
            System.out.print("HOURS FOR CONTRACT EMPLOYEE:" + conEmployee.getEmpName() + " ::");
            double conEmpHours = s.nextDouble();
            System.out.println("PAY FOR CONTRACT EMPLOYEE:" + conEmployee.getEmpName() + " IS SALARY:$" + conEmployee.getPay(conEmpHours));

            //ASK USER FOR A RETRY
            System.out.print("TRY AGAIN? (0)>YES | (1)>NO :");
            userIn = s.nextInt();
        }

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("--METHOD OVERLOADING (in the same class with same method name but different signatures)--");
        System.out.print("CONTINUE? (0)>YES | (1)>NO :");
        userIn = s.nextInt();
        s.nextLine();
        while (userIn == 0) {

            // CREATE A NEW USER FOR THIS TEST
            do {
                System.out.println("SAMPLE DATA: [" + ftUser.getUserData() + "]");

                //COLLECT DATA
                System.out.print("ENTER USER EMAIL:");
                String email = s.nextLine();
                System.out.print("ENTER USER PASSWORD:");
                String pass = s.nextLine();
                System.out.print("ENTER USER NAME:");
                String username = s.nextLine();

                //THIS WILL STORE THE RESULT OF LOGIN ATTEMPT
                boolean login = false;

                //DECIDE WHICH OVERLOADED METHOD TO CALL
                if (!username.isEmpty() && !pass.isEmpty() && !email.isEmpty()) {
                    login = ftUser.login(email, pass, username);
                    System.out.println("ATTEMPTING LOGIN WITH login(String email, String password,  String username)");
                } else if (!username.isEmpty() && !pass.isEmpty()) {
                    login = ftUser.login(email, pass);
                    System.out.println("ATTEMPTING LOGIN WITH login(String email, String password)");
                } else if (!username.isEmpty()) {
                    login = ftUser.login(email);
                    System.out.println("ATTEMPTING LOGIN WITH login(String email)");
                } else {
                    System.out.println("CREDENTIALS NOT PROVIDED");
                }

                //CHECK IF LOGIN WAS SUCCESS
                if (login) {
                    System.out.println("LOGIN SUCCESS");
                } else {
                    System.out.println("LOGIN FAILED");
                }
                System.out.println();

                //ASK USER FOR A RETRY
                System.out.print("RETRY LOGIN? (0)>YES | (1)>NO :");
                userIn = s.nextInt();

                //IF RETRY>YES THEN CLEAR BUFFER
                if (userIn == 0) s.nextLine();

            } while (userIn == 0);


            s.nextLine();//clear buffer
            var emp = new Employee(ftUser);
            System.out.println("SETTING PAY FOR " + emp.getEmpName());
            do {
                System.out.println("-FOR THE FOLLOWING QUESTIONS ENTER '0' IF YOU DO NOT WANT TO PROVIDE VALUE-");
                System.out.print("ENTER SALARY:");
                double salary = s.nextDouble();
                System.out.print("ENTER USER BONUS:");
                double bonus = s.nextDouble();
                System.out.print("ENTER USER OVERTIME:");
                double otPay = s.nextDouble();

                if (salary > 0 && bonus > 0 && otPay > 0) {
                    System.out.println("CALCULATING SALARY WITH getSalary(double basicPay, double bonus,  double overtime)");
                    emp.getSalary(salary, bonus, otPay);
                } else if (salary > 0 && bonus > 0) {
                    System.out.println("CALCULATING SALARY WITH getSalary(double basicPay, double bonus)");
                    emp.getSalary(salary, bonus);
                } else if (salary > 0) {
                    System.out.println("CALCULATING SALARY WITH getSalary(double basicPay)");
                    emp.getSalary(salary);
                } else {
                    System.out.println("EMPLOYEES WONT WORK FOR FREE");
                }

                System.out.print("TRY AGAIN? (0)>YES | (1)>NO :");
            } while (s.nextInt() == 0);
        }

        System.out.println("THAT'S ALL FOLKS!!! BYE");
    }

}