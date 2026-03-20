package mar17.MediaPlayer;

public class Winamp extends Player {
    public Winamp() {
        super("Winamp");
    }

    public void displayButtonConsole(){
        super.displayButtonConsole("(0)[load music]    (1)[play music]    (2)[stop music]");
        System.out.print("YOUR CHOICE:");
    }

}
