package com.james.main;

import org.apache.commons.io.FilenameUtils;

import java.util.List;

/**
 * @author James McGarr.
 */
public class SongPlayer {
    private SoundBehaviour soundBehaviour;
    private List<Observer> observers;

    public SongPlayer(List<Observer> observers) {
        registerObservers(observers);
        setAlgorithmForSong(SongFile.getInstance().getSongPath());
    }
    private void registerObservers(List<Observer> observers) {
        this.observers = observers;
    }
    private List<Observer> getObservers() {
        return this.observers;
    }
    public void setAlgorithmForSong(String songPath) {
        String ext = FilenameUtils.getExtension(songPath);

        soundBehaviour = SoundStrategyFactory.createSoundStrategy(ext);
        soundBehaviour.registerObservers(getObservers());

    }
    public void playSong() {
        soundBehaviour.playSoundFile();
    }
    public void stopSong() {
        soundBehaviour.stopSoundFile();
    }
    public void nextSong() {
        System.out.println("song player next song");
    }
    public void prevSong() {
        System.out.println("song player previous song");
    }
}
