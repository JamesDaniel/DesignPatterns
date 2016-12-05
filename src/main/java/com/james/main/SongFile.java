package com.james.main;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author James McGarr
 */
public class SongFile {
    private String songPath;
    private static SongFile instance;

    private SongFile() {}
    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
    public String getSongPath() {
        return this.songPath;
    }
    public FileInputStream getFileInputStream() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(this.getSongPath()));
        } catch (Exception ex) {
            System.out.println("An error occurred while creating file input stream.");
            ex.printStackTrace();
        }
        return fis;
    }
    public static SongFile getInstance() {
        if (instance == null) {
            instance = new SongFile();
        }
        return instance;
    }
}
