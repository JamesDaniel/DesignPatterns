/**
 * Created by user on 20/10/16.
 */
public class MusicRunner {
    public static void main(String args[]) {
        MusicPlayer player = new Mp3Player();

        player.setSound("path to sound");
        player.play();
        player.stop();
    }
}
