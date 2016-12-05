package com.james.main;

import java.util.List;

/**
 * @author James McGarr
 */
public interface Observable {
    void registerObservers(List<Observer> o);
    void removeObserver(Observer o);
    void notifyObservers();
}
