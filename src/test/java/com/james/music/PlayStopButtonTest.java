package com.james.music;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by t00126681 on 21/02/2017.
 */
public class PlayStopButtonTest {
    @Test
    public void PlayStopButtonTest() {
        String btnText = "Play";
        SongPlayer sPlayer = new SongPlayer(null);

        PlayStopButton btn = new PlayStopButton(btnText, sPlayer);

        assertTrue(btn instanceof PlayStopButton);
    }
    @Test
    public void PlayStopButtonTextTest() {
        String btnText = "Play";
        SongPlayer sPlayer = new SongPlayer(null);

        PlayStopButton btn = new PlayStopButton(btnText, sPlayer);

        assertEquals(btn.getText(), btnText);
    }
    @Test
    public void GetPlayStateTest() {
        String btnText = "Play";
        SongPlayer sPlayer = new SongPlayer(null);

        PlayStopButton btn = new PlayStopButton(btnText, sPlayer);

        btn.buttonClicked();
        assertEquals(btn.getText(), "Stop");
        btn.buttonClicked();
        assertEquals(btn.getText(), "Play");
    }
}
