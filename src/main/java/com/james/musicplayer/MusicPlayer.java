package com.james.musicplayer;

import org.apache.commons.io.FilenameUtils;

/**
 * Created by user on 20/10/16.
 */
public abstract class MusicPlayer {
    private SoundFile soundFile;

    public void setSound(String filePath) {
        String ext1 = FilenameUtils.getExtension(filePath);
        //if ()
//        soundFile.setSoundFile(filePath);
    }
    public void play() {
  //      soundFile.playSoundFile();
    }
    public void stop() {
    //    soundFile.stopSoundFile();
    }


}
