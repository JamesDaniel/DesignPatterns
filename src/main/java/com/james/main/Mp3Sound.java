package com.james.main;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author James McGarr
 */
public class Mp3Sound implements SoundBehaviour {
    private boolean play = true;
    public void playSoundFile() {
        System.out.println("Playing mp3 from strategy");

        try {
            Thread t1 = new Thread(new Music());
            t1.start();
        } catch (Exception ex) {
            System.out.println("Thread exception");
        }
    }
    public void stopSoundFile() {
        System.out.println("Stopping mp3 from strategy");
    }
    private class Music extends Player implements Runnable {
        public Music() throws Exception {
            super(new FileInputStream(new File("data/test.mp3")));
        }
        public void run() {
            try {
                while (super.play(1)) {
                    if (!play) {
                        super.close();
                    }
                }
            } catch (Exception ex) {
                System.out.println("an exception occurred while decoding an mp3 file");
            }
        }
    }
}
