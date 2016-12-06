package com.james.main;

import javazoom.jl.player.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author James McGarr
 */
public class Mp3Sound implements SoundBehaviour {
    private Observable observable;
    private boolean playing;

    // Mp3Sound Code
    public Mp3Sound() {
        observable = new ObservableSoundBehaviour();
    }
    private class Mp3MusicRunnable extends Player implements Runnable {

        public Mp3MusicRunnable() throws Exception {
            super(SongFile.getInstance().getFileInputStream());
        }
        public void run() {
            try {
                while (super.play(1)) {
                    setPlayDuration(super.getPosition());
                    if (!playing) {
                        super.close();
                    }
                }
                setPlayDuration(0);
                System.out.println("Finished decoding mp3 or playing stopped.");
            } catch (Exception ex) {
                System.out.println("An exception occurred while decoding an mp3 file.");
                ex.printStackTrace();
            }
        }
    }
    public void setPlayDuration(int playDuration) {
        Date date = new Date(playDuration - 3600000);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        observable.setPlayDuration(formatter.format(date));

        observable.playDurationChanged();
    }

    // Contract with Observable interface
    public void registerObservers(List<Observer> o) {
        observable.registerObservers(o);
    }
    public void notifyObservers() {
        observable.notifyObservers();
    }
    public void removeObserver(Observer o) {
        observable.removeObserver(o);
    }
    public void setPlayDuration(String playDuration) {}

    // Contract with SoundBehaviour interface
    public void playSoundFile() {
        if (playing == true)
            return;
        playing = true;
        System.out.println("Playing mp3 from strategy");

        try {
            Thread soundPlayingThread = new Thread(new Mp3MusicRunnable());
            soundPlayingThread.start();
        } catch (Exception ex) {
            System.out.println("Thread exception in Mp3Sound.java");
            ex.printStackTrace();
        }
    }
    public void stopSoundFile() {
        playing = false;
    }
    public void playDurationChanged() {}
}
