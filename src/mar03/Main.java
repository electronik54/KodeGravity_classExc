package mar03;
import java.util.Scanner;

// STRING AND ITS INITIALIZATION (LITERAL AND USING 'NEW' KEYWORD), METHODS OF STRING
public class Main {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----------");
        System.out.println("--STRINGS--");
        System.out.println();
        StringMethods sm = new StringMethods();
        System.out.println();
        Scanner s = new Scanner(System.in);
        int userIn;

        // HOMEWORK: PALINDROME, VOWELS & CONSONANTS COUNT, CHAR COUNT
        System.out.println("-DETECT A PALINDROME STRING, VOWELS & CONSONANTS COUNT, AND CHARACTER COUNT-");
        do {
            System.out.print("INPUT YOUR WORD:");
            String userString = s.nextLine();
            String userStringNormalized = userString.toLowerCase();
            char[] userStringArr = userStringNormalized.toCharArray();

            System.out.println("IS PALINDROME? : " + sm.isPalindrome(userStringArr));
            sm.countVowelsAndConsonants(userStringArr);
            sm.countEachChar(userStringArr);

            System.out.print("press 1 to try again:");
            userIn = s.nextInt();
            if(userIn == 1) s.nextLine();// to clear buffer and the next code can accept the string input
        }while(userIn == 1);


        System.out.println();
        System.out.println("-------------");
        System.out.println("--CLASSWORK--");
        System.out.print("Press 1 to continue:");

        if (s.nextInt() == 1) {
            String s1 = "a";
            String s2 = "b";
            String s3 = "c";

            System.out.println(s1 + 100 + 200);
            System.out.println(s3 + 100 + s1 + s3);
            System.out.println(200 + 100 + s3 + s2);
            System.out.println(100 + 200 + 300 + s3);

            System.out.println("-----------------------------");
            char[] charArr = {'h', 'e', 'l', 'l', 'o'};
            for (char c : charArr) {
                System.out.print(c + "|");
            }
            System.out.println();

            System.out.println("reversing arr...");
            for (int i = 0; i < charArr.length / 2; i++) {
                char tempChar = charArr[i];
                charArr[i] = charArr[charArr.length - (i + 1)];
                charArr[charArr.length - (i + 1)] = tempChar;
            }
            for (char c : charArr) {
                System.out.print(c + "|");
            }
            System.out.println();

            System.out.println("-----------------------------");
            String s4 = "s4";
            String s5 = "s4";
            String s6 = "s4";

            System.out.println("s4:" + s4 + "| s5:" + s5 + " |s6:" + s6);

            s4 = "a1";
            System.out.println("s4:" + s4 + "| s5:" + s5 + " |s6:" + s6);

            System.out.println("IMPORTANT interviewQuestion: String are immutable object(meaning the OBJECT cannot be updated once created) which can be created in 1 of 2 ways. using literal and using NEW keyword. The strings with the same value will refer to the same location in the heap memory>inside a string \"constant pool\". Changing the value in the HEAP will affect all the references BUT initializing a \"new\" value will assign a new reference to the variable since the object is immutable but the reference is not. This is done for memory efficiency as multiple reference can share the object");
            System.out.println("QUESTION why use new String if it is not memory efficient?");


            System.out.println("-----------------------------");
            System.out.println("-STRING METHODS-");
            String s7 = "    [  some statement HERE  }  ";
            System.out.println("-TEST STATEMENT: " + s7 + "-");

            System.out.println("String.");
            System.out.println("      .length():" + s7.length());
            System.out.println("      .charAt(10):" + s7.charAt(10));
            System.out.println("      .toLowerCase():" + s7.toLowerCase());
            System.out.println("      .toUpperCase():" + s7.toUpperCase());
            System.out.println("      .replace(\"some\", \"NEW\"):" + s7.replace("some", "NEW"));
            System.out.println("      .substring(10,15):" + s7.substring(10, 15));
            System.out.println("      .replaceAll(\"me\", \"1010111\"):" + s7.replaceAll("me", "1010111"));
            System.out.println("      .subSequence(15,20):" + s7.subSequence(15, 20));
            System.out.println("      .replace(\"HERE\", \"there\"):" + s7.replace("HERE", "there"));
            System.out.println("      .trim():" + s7.trim());
            System.out.println("      .matches(\"statement\"):" + s7.matches("statement"));
            System.out.println("      .contains(\"statement\")" + s7.contains("statement"));
        }


    }
}