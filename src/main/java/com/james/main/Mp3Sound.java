package com.james.main;

import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author James McGarr
 */
public class Mp3Sound implements SoundBehaviour {
    private static Mp3MusicRunnable threadInstance;
    private static SoundBehaviour instance = null;
    private boolean playing;
    private String songPath;
    public Mp3Sound(String songPath) {
        this.songPath = songPath;
    }
    public void playSoundFile() {
        if (playing == true)
            return;
        playing = true;
        System.out.println("Playing mp3 from strategy");

        try {
            Thread soundPlayingThread = new Thread(new Mp3MusicRunnable());
            soundPlayingThread.start();
        } catch (Exception ex) {
            System.out.println("Thread exception in Mp3Sound.java");
            ex.printStackTrace();
        }
    }
    public void stopSoundFile() {
        playing = false;
    }
    private class Mp3MusicRunnable extends Player implements Runnable {

        public Mp3MusicRunnable() throws Exception {
            super(new FileInputStream(new File(songPath))); // todo change this
        }
        public void run() {
            try {
                while (super.play(1)) {
                    if (!playing) {
                        super.close();
                    }
                }
                System.out.println("bugged out");
            } catch (Exception ex) {
                System.out.println("an exception occurred while decoding an mp3 file");
            }
        }
    }
    public static Mp3MusicRunnable getRunnableInstance() throws Exception {
        if (threadInstance == null) {
            threadInstance = new Mp3MusicRunnable();
        }
    }
    public static SoundBehaviour getInstance(String songPath) {
        if (instance == null) {
            instance = new Mp3Sound(songPath);
        }
        return instance;
    }

}
