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
                soundBehaviour = new Mp3Sound();
                soundBehaviour.registerObservers(getObservers()); // todo | every time a song is played a algorithm is
                                                                            // todo | created to decode the file. This knocks off
                                                                            // todo | previously attached observers. Any better solution?
                break;
            case "wav":
                soundBehaviour = new WavSound();
                soundBehaviour.registerObservers(getObservers());
                break;
            default:
                soundBehaviour = new DumSound();
                soundBehaviour.registerObservers(getObservers());
                System.out.println("No strategy for file with extension ." + ext);
        }
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
