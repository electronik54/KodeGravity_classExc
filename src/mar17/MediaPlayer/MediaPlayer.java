package mar17.MediaPlayer;

import java.util.Scanner;

public final class MediaPlayer extends Player implements IntPlayMovie{

    private String mediaFile;
    private boolean isPlayingMedia;

    public MediaPlayer(){
        super("Media player");
    }

    boolean isPlayingMedia() {
        return isPlayingMedia;
    }

    @Override
    public void setMedia(String musicFile) {
        this.mediaFile = musicFile;
    }

    @Override
    public String getMedia() {
        return mediaFile;
    }

    @Override
    public boolean playMedia() {
        if(super.isPlayingMusic()){
            System.out.println("-YOU NEED TO STOP MUSIC FIRST-");
            return false;
        }

        if(getMedia() == null) {
            System.out.println("-SET MEDIA FILE BEFORE PLAYING MEDIA-");
            return false;
        }

        System.out.println("PLAYING MEDIA:" + mediaFile);
        isPlayingMedia = true;
        return true;
    }

    @Override
    public void stopMedia() {
        System.out.println("STOPPED MEDIA");
        isPlayingMedia = false;
//        return true;
    }

    //OVERRIDE playMusic() FROM PARENT CLASS
    public boolean playMusic() {
        if(isPlayingMedia()){
            System.out.println("-YOU NEED TO STOP MEDIA FIRST-");
            return false;
        }
        return super.playMusic();
    }

    public void displayButtonConsole(){
        super.displayButtonConsole("(0)[load music]    (1)[play music]    (2)[stop music] \n (3)[load media]    (4)[play media]    (5)[stop media]");
        System.out.print("YOUR CHOICE:");
    }
}
