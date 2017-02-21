package com.james.music;

import java.util.List;

/**
 * @author James McGarr
 */
public interface Observable {
    void registerObservers(List<Observer> o);
    void removeObserver(Observer o);
    void notifyObservers();
    void playDurationChanged();
    void setPlayDuration(String playDuration);
}
