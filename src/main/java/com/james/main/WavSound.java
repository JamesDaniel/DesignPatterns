package com.james.main;

/**
 * @author James McGarr
 */
public class WavSound implements SoundBehaviour {
    public WavSound() {

    }
    public void playSoundFile() {
        System.out.println("Playing wav from strategy");
    }
    public void stopSoundFile() {
        System.out.println("Stopping wav from strategy");
    }
}
