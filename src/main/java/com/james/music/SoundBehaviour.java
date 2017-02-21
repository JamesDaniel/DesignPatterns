package com.james.music;

/**
 * @author James McGarr.
 */
public interface SoundBehaviour extends Observable {
    void playSoundFile();
    void stopSoundFile();
}
