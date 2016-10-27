package com.james.pattern.strategy;

/**
 * Created by user on 20/10/16.
 */
public class Mp3Sound implements SoundBehaviour{
    public void setSoundFile(String filePath) {
        System.out.println("Setting source of mp3");
    }
    public void playSoundFile() {
        System.out.println("Playing mp3");
    }
    public void stopSoundFile() {
        System.out.println("Stopping mp3");
    }
}
