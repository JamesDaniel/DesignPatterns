package com.james.music;

import java.util.List;

/**
 * @author James McGarr
 */
public class WavSound implements SoundBehaviour {
    public void playSoundFile() {
        System.out.println("Playing wav from strategy");
    }
    public void stopSoundFile() {
        System.out.println("Stopping wav from strategy");
    }

    public void registerObservers(List<Observer> o) {

    }
    public void notifyObservers() {

    }
    public void removeObserver(Observer o) {

    }
    public void playDurationChanged() {

    }
    public void setPlayDuration(String playDuration) {}
}
