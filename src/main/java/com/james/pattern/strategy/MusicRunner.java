package com.james.pattern.strategy;

/**
 * Created by user on 20/10/16.
 */
public class MusicRunner {
    public static void main(String args[]) {
        MusicPlayer player = new MusicPlayer();

        player.setSound(new WavSound());
        player.setSoundSource("stub source");
        player.play();
        player.stop();
    }
}
