package com.james.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author James McGarr
 */
public abstract class ObservableSoundBehaviour implements Observable, SoundBehaviour {
    private List<Observer> observers;
    private String playDuration;

    public void registerObservers(List<Observer> o) {
        this.observers = o;
    }
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(playDuration);
        }
    }
    public void playDurationChanged() {
        notifyObservers();
    }
    public void setPlayDuration(int playDuration) {
        Date date = new Date(playDuration - 3600000);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        this.playDuration = formatter.format(date);

        playDurationChanged();
    }
}
