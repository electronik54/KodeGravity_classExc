package mar17.MediaPlayer;

public class Player implements IntMusic {

    private String musicFile;
    private boolean isPlayingMusic = false;

    Player(String name){
        System.out.println("-STARTING MEDIA PLAYER:"+name+"-");
    }

    boolean isPlayingMusic() {
        return isPlayingMusic;
    }

    @Override
    public void setMusic(String musicFile) {
        this.musicFile = musicFile;
    }

    @Override
    public String getMusic() {
        return musicFile;
    }

    @Override
    public boolean playMusic() {
        if(getMusic() == null) {
            System.out.println("-SET MUSIC FILE BEFORE PLAYING MUSIC-");
            return false;
        }
        System.out.println("PLAYING MEDIA:" + musicFile);
        isPlayingMusic = true;
        return true;
    }

    @Override
    public void stopMusic() {
        System.out.println("STOPPED MUSIC");
        isPlayingMusic = false;
//        return true;
    }

    public void displayButtonConsole(String buttonText){
        System.out.println();
        System.out.println("-CHOOSE FROM THE FOLLOWING OPTIONS---------------------");
        System.out.println(buttonText);
        System.out.println("-------------------------------------------------------");
    }
    public void displayButtonConsole(){
        System.out.println("-NO OPTIONS TO DISPLAY---------------------------------");
    }

}
