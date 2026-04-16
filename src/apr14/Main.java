package apr14;

/*
 * homework: BALANCED PARENTHESIS, anonymous inner class, functional interface, Lambda
 *
 * <Stack> SEE THE <ArrayList>vs<Stack>
 * <Queue>
 * <Comparable> INTERFACE:: INTERVIEW QUEST
 *
 */

import mar31.Product;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char userInputChar;
        String userInputStr;
        boolean userInContinue;

        System.out.print("HOMEWORK (Stack): BALANCED PARENTHESIS ('y')>YES (other key)>NO :");
        userInputChar = sc.nextLine().charAt(0);
        userInContinue = userInputChar == 'y' || userInputChar == 'Y';

        while (userInContinue) {

            TreeMap<Character, Character> paranthesisPairTrm = new TreeMap<>(Map.of(
                    '[', ']',
                    '{', '}',
                    '(', ')'
            ));
            Collection<Character> openPar = new ArrayList(paranthesisPairTrm.keySet());
            Collection<Character> closePar = new ArrayList(paranthesisPairTrm.values());

            Stack<Character> characters = new Stack<>();

            System.out.println();
            System.out.print("ENTER YOUR PARENTHESIS STRING:");
            userInputStr = sc.nextLine();

            for (char nextpar : userInputStr.toCharArray()) {
                System.out.print("ANALYZING: " + nextpar);

                if (openPar.contains(nextpar)) {
                    System.out.print(" >ADDING");
                    characters.push(nextpar);
                    
                } else if (closePar.contains(nextpar)) {
                    char charOnTop = characters.pop();
                    System.out.print(" >COMPARING:" + charOnTop);
                    if (paranthesisPairTrm.get(charOnTop) == nextpar) {
                        System.out.print(" >'" + charOnTop + "'POPPED!");
                    } else {
                        System.out.println(" >INVALID PARENTHESIS, EXPECTED:"+paranthesisPairTrm.get(charOnTop)+". EXITING...");
                        break;
                    }
                }
                System.out.println();
            }

            System.out.print("TRY AGAIN? ('y')>YESS (other key)>NO :");
            userInputChar = sc.nextLine().charAt(0);
            userInContinue = userInputChar == 'y' || userInputChar == 'Y';
        }
        System.out.println();


        System.out.print("CONTINUE <Queue>? ('y')>YES (other key)>NO :");
        userInputChar = sc.nextLine().charAt(0);
        if (userInputChar == 'y' || userInputChar == 'Y') {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(10);
            queue.offer(20);
            queue.offer(30);
            queue.offer(40);

            System.out.println("<queue>:" + queue);
            System.out.println("<queue.poll()>:" + queue.poll());
            System.out.println("<queue.poll()>:" + queue.poll());

            System.out.println("<queue>:" + queue);
        }
        System.out.println();


        System.out.println("--<Comparable>--");
        System.out.print("CONTINUE <Comparable>? ('y')>YES (other key)>NO :");
        userInputChar = sc.nextLine().charAt(0);
        if (userInputChar == 'y' || userInputChar == 'Y') {

            List<Product> prodList = new ArrayList<>(Arrays.asList(
                    new Product("box of chips", 20),
                    new Product("truck of chips", 20000),
                    new Product("skit of chips", 200),
                    new Product("chips", 2.49))
            );

            System.out.println("<prodList>:" + prodList);

            Collections.sort(prodList);
            System.out.println("ASC ORDER:" + prodList);

            Collections.sort(prodList, Collections.reverseOrder());
            System.out.println("DEC ORDER:" + prodList);
        }
        System.out.println();
    }
}
