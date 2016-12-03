package com.james.main;

import org.apache.commons.io.FilenameUtils;

/**
 * @author James McGarr.
 */
public class SongPlayer {
    private SoundBehaviour soundBehaviour;

    public SongPlayer() {}
    public SongPlayer(String songPath) {
        setSongFilePath(songPath);
    }
    public void setSongFilePath(String songPath) {
        String ext = FilenameUtils.getExtension(songPath);

        switch (ext) {
            case "mp3":
                soundBehaviour = new Mp3Sound();
                break;
            case "wav":
                soundBehaviour = new WavSound();
                break;
            default:
                soundBehaviour = new DumSound();
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
