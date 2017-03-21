package com.james.music;

import org.junit.Test;

import java.io.FileNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by t00126681 on 21/02/2017.
 */
public class SongFileTest {
    @Test
    public void SetSongPathTest()
    {
        String songFilePath = "/example/song/path";

        SongFile sFile = SongFile.getInstance();
        sFile.setSongPath(songFilePath);
        String result = sFile.getSongPath();

        assertEquals(songFilePath, result);
    }
    @Test
    public void GetInstanceTest() {
        SongFile sf = SongFile.getInstance();

        assertTrue(sf instanceof SongFile);
    }
    @Test
    public void GetFileInputStreamTest() {
        SongFile sf = SongFile.getInstance();

        try {
            sf.getFileInputStream();
        } catch (Exception ex) {
            assertTrue(ex instanceof FileNotFoundException);
        }
    }
}
