package com.james.main;

import org.apache.commons.io.FilenameUtils;

/**
 * @author James McGarr.
 */
public class SongPlayer {
    public static int numberOfSongPlayers = 0;
    private SoundBehaviour soundBehaviour;

    public SongPlayer(String songPath) {
        setSongFilePath(songPath);
        numberOfSongPlayers++;
        System.out.println("number of song players = " + numberOfSongPlayers);
    }
    private void setSongFilePath(String songPath) {
        String ext = FilenameUtils.getExtension(songPath);

        switch (ext) {
            case "mp3":
                soundBehaviour = new Mp3Sound(songPath);
                break;
            case "wav":
                soundBehaviour = new WavSound(songPath);
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
