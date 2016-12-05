package com.james.main;

import org.apache.commons.io.FilenameUtils;

import java.util.List;

/**
 * @author James McGarr.
 */
public class SongPlayer {
    private ObservableSoundBehaviour observableSoundBehaviour;
    private List<Observer> observers;

    public SongPlayer(List<Observer> observers) {
        registerObservers(observers);
        setAlgorithmForSong(SongFile.getInstance().getSongPath());
    }
    public void registerObservers(List<Observer> observers) {
        this.observers = observers;
    }
    public List<Observer> getObservers() {
        return this.observers;
    }
    public void setAlgorithmForSong(String songPath) {
        String ext = FilenameUtils.getExtension(songPath);

        switch (ext) {
            case "mp3":
                observableSoundBehaviour = new Mp3Sound();
                observableSoundBehaviour.registerObservers(getObservers()); // todo | every time a song is played a algorithm is
                                                                            // todo | created to decode the file. This knocks off
                                                                            // todo | previously attached observers. Any better solution?
                break;
            case "wav":
                observableSoundBehaviour = new WavSound();
                observableSoundBehaviour.registerObservers(getObservers());
                break;
            default:
                observableSoundBehaviour = new DumSound();
                observableSoundBehaviour.registerObservers(getObservers());
                System.out.println("No strategy for file with extension ." + ext);
        }
    }
    public void playSong() {
        observableSoundBehaviour.playSoundFile();
    }
    public void stopSong() {
        observableSoundBehaviour.stopSoundFile();
    }
    public void nextSong() {
        System.out.println("song player next song");
    }
    public void prevSong() {
        System.out.println("song player previous song");
    }
}
