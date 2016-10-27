package com.james.pattern.observer;

import java.util.Collection;
import java.util.Observable;

/**
 * Created by user on 27/10/16.
 */
public class SoundCloud extends Observable {
    public Collection<Song> songs;

    public SoundCloud() {

    }
    public void setSongs(Collection<Song> songs) {
        this.songs = songs;
    }

    public Collection<Song> getSongs() {
        return songs;
    }
    public void songListChanged() {
        setChanged();
        notifyObservers();
    }
    public void addSong(Song s) {
        this.songs.add(s);
        this.songListChanged();
    }
}
