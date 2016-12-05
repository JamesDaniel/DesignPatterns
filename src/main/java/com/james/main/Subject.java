package com.james.main;

import java.util.List;

/**
 * @author James McGarr
 */
public interface Subject {
    void registerObservers(List<Observer> o);
    void removeObserver(Observer o);
    void notifyObservers();
}
