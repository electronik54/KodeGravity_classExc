package mar17;

import mar17.MediaPlayer.*;

import java.util.Scanner;

/* INTERFACE: is a contract that has to be fulfilled that inherits it
 * DIFFERENCE INTERFACE VS ABSTRACT: ALL METHODS IN INTERFACE HAVE TO BE IMPLEMENTED AND ALL VARIABLES ARE FINAL. ONLY ABSTRACT METHODS IN ABSTRACT HAVE TO BE IMPLEMENTED
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--INTERFACE--");

        Scanner sc = new Scanner(System.in);
        int intUserIn;
        boolean isError = true;
        Player player = null;

        System.out.println("-IMPLEMENT INTERFACE WITH INHERITANCE-");
        System.out.print("CONTINUE (0)>YES | (1)>NO :");
        intUserIn = sc.nextInt();

        while(intUserIn == 0) {
            while (isError) {
                System.out.println("-CHOOSE FROM THE FOLLOWING PLAYERS-");
                System.out.println("PRESS (1) FOR WINAMP");
                System.out.println("PRESS (2) FOR MEDIA PLAYER");
                System.out.println("PRESS (3) FOR SPOTIFY");
                System.out.print("PRESS (4) FOR UNIVERSAL PLAYER:");
                intUserIn = sc.nextInt();

                if (intUserIn > 0 && intUserIn < 5) {
                    isError = false;
                    player = switch (intUserIn) {
                        case 1 -> new Winamp();
                        case 2 -> new MediaPlayer();
                        case 3 -> new Spotify();
                        case 4 -> new UniversalPlayer();
                        default -> player;
                    };
                } else {
                    System.out.println("-INVALID CHOICE, CHOOSE THE CORRECT OPTION-");
                }
            }

            player.displayButtonConsole();

            System.out.print("RETRY (0)>YES | (1)>NO :");
            intUserIn = sc.nextInt();
        }




    }
}
