package com.james.main;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author James McGarr
 */
public class SongFile {
    private String songPath;

    private SongFile() {}
    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
    public String getSongPath() {
        return this.songPath != null ? this.songPath : "";
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
    private static class LazyHolder {
        private static final SongFile INSTANCE = new SongFile();
    }
    public static SongFile getInstance() {
        return LazyHolder.INSTANCE;
    }
}
