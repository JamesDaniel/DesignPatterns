package com.james.main;

import javazoom.jl.player.Player;

/**
 * @author James McGarr
 */
public class Mp3Sound implements SoundBehaviour {
    private boolean playing;
    public Mp3Sound() {

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
            super(SongFile.getInstance().getFileInputStream());
        }
        public void run() {
            try {
                while (super.play(1)) {
                    if (!playing) {
                        super.close();
                    }
                }
                System.out.println("Finished decoding mp3 or playing stopped.");
            } catch (Exception ex) {
                System.out.println("An exception occurred while decoding an mp3 file.");
            }
        }
    }
}
