package com.james.pattern.observer;

import java.util.ArrayList;

/**
 * Created by user on 27/10/16.
 */
public class MusicRunner {
    public static void main(String args[]) {
        SoundCloud sc = new SoundCloud();
        sc.setSongs(new ArrayList());

        AllSongs songs = new AllSongs(sc);

        sc.addSong(new Song());
    }
}
