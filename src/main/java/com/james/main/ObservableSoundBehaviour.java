package com.james.main;

import com.james.pattern.strategy.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author James McGarr
 */
public class ObservableSoundBehaviour implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private String playDuration;

    public void setPlayDuration(String playDuration) {
        this.playDuration = playDuration;
    }
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
}
