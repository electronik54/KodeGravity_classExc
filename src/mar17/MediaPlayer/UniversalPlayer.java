package mar17.MediaPlayer;

import java.util.Random;

public class UniversalPlayer extends Player implements IntPlayMovie, IntPlayOnlineMusic{

    private boolean isConnectedToInternet;
    private String onlineMusicFile;
    private boolean isPlayingOnlineMusic;

    public UniversalPlayer(){
        super("Universal player");
    }

    @Override
    public boolean isConnectedToInternet() {
        Random rand = new Random();
        isConnectedToInternet = rand.nextBoolean();

        if (isConnectedToInternet) System.out.println("CONNECTED TO INTERNET");
        else System.out.println("NOT CONNECTED TO INTERNET. CANNOT PLAY ONLINE MUSIC");

        return isConnectedToInternet;
    }

    @Override
    public void setOnlineMusic() {
        if (isConnectedToInternet()) {

        } else {
            onlineMusicFile = null;
        }
    }

    @Override
    public String getOnlineMusic() {
        return onlineMusicFile;
    }

    @Override
    public void playOnlineMusic() {
        if(super.isPlayingMusic()){
            System.out.println("-YOU NEED TO STOP MUSIC FIRST-");
            return;
        }

        if(getOnlineMusic() == null) {
            System.out.println("-SET MEDIA FILE BEFORE PLAYING MEDIA-");
            return;
        }

        System.out.println("PLAYING MEDIA:" + onlineMusicFile);
        isPlayingOnlineMusic = true;
        System.out.println("PLAYING ONLINE MUSIC:" + onlineMusicFile);
//        return isPlayingOnlineMusic;
    }

    @Override
    public void stopOnlineMusic() {
        isPlayingOnlineMusic = false;
        System.out.println("STOPPED ONLINE MUSIC");
    }

    @Override
    public boolean playMusic() {
        if(isPlayingOnlineMusic){
            System.out.println("-YOU NEED TO STOP ONLINE MUSIC FIRST-");
            return false;
        }
        return super.playMusic();
    }

    public void displayButtonConsole(){
        super.displayButtonConsole("(0)[load music]    (1)[play music]    (2)[stop music] \n (3)[load online music]    (4)[play online music]    (5)[stop online music] \n (6)[load movie]    (7)[play movie]    (8)[stop movie] \n (9)[Check internet connection]");
        System.out.print("YOUR CHOICE:");
    }








    @Override
    public void setMedia(String musicFile) {

    }

    @Override
    public String getMedia() {
        return "";
    }

    @Override
    public boolean playMedia() {
        return false;
    }

    @Override
    public void stopMedia() {
//        return false;
    }
}
