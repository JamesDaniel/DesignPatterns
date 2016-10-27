package com.james.pattern.strategy;

/**
 * Created by user on 20/10/16.
 */
public class WavSound implements SoundBehaviour {
    public void setSoundFile(String filePath) {
        System.out.println("Setting source of wav");
    }
    public void playSoundFile() {
        System.out.println("Playing wav");
    }
    public void stopSoundFile() {
        System.out.println("Stopping wav");
    }
}
