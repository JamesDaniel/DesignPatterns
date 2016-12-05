package com.james.main;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by t00126681 on 05/12/2016.
 */
public class SongFile {
    private String songPath;
    private FileInputStream fis;
    private static SongFile instance;

    private SongFile() {}
    public void setSongPath(String songPath) {
        this.songPath = songPath;
        this.setFileInputStream(songPath);
    }
    public String getSongPath() {
        return this.songPath;
    }
    public void setFileInputStream(String songPath) {
        try {
            fis = new FileInputStream(new File(songPath));
        } catch (Exception ex) {
            System.out.println("An error occurred while creating file input stream.");
            ex.printStackTrace();
        }
    }
    public FileInputStream getFileInputStream() {
        return this.fis;
    }
    public static SongFile getInstance() {
        if (instance == null) {
            instance = new SongFile();
        }
        return instance;
    }
}
