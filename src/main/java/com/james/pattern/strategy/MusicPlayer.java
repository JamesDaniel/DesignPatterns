package com.james.pattern.strategy;

/**
 * Created by user on 20/10/16.
 */
public class MusicPlayer {
    private SoundBehaviour soundBehaviour;

    public MusicPlayer() {

    }

    public void setSoundSource(String source) {
        soundBehaviour.setSoundFile(source);
    }
    public void setSound(SoundBehaviour sound) {
        this.soundBehaviour = sound;
        System.out.println("setting sound file type");
    }
    public void play() {
        soundBehaviour.playSoundFile();
    }
    public void stop() {
        soundBehaviour.stopSoundFile();
    }


}
