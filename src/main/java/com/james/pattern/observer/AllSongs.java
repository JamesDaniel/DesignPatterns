package com.james.pattern.observer;


import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by user on 27/10/16.
 */
public class AllSongs implements Observer {
    Observable observable;
    private Collection<Song> songs;

    public AllSongs(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable obs, Object obj) {
        if (obs instanceof SoundCloud) {
            SoundCloud soundCloud = (SoundCloud)obs;
            this.songs = soundCloud.getSongs();
            System.out.println("List of all songs has changed");
        }
    }
}
