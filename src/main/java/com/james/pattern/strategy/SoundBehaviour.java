package com.james.pattern.strategy;

/**
 * Created by user on 20/10/16.
 */
public interface SoundBehaviour {
    public void setSoundFile(String filePath);
    public void playSoundFile();
    public void stopSoundFile();
}
