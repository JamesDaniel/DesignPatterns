package com.james.music;

import javax.swing.*;

/**
 * @author James McGarr
 */
public class ObservingLabel extends JLabel implements Observer {
    private String playDuration;
    public ObservingLabel (String labelText) {
        super(labelText);
    }
    public void update(String playDuration) {
        this.playDuration = playDuration;
        this.setText(this.playDuration);
    }
}
