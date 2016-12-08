package com.james.main;

import javax.swing.*;

/**
 * @author James McGarr
 */
public class PlayStopButton extends JButton {
    private PlayStopState playState;
    private PlayStopState stopState;
    private SongPlayer songPlayer;

    private PlayStopState currentState;
    public PlayStopButton(String buttonText, SongPlayer songPlayer) {
        super(buttonText);
        this.setSongPlayer(songPlayer);
        playState = new PlayState(this);
        stopState = new StopState(this);
        this.setState(stopState);
        this.addActionListener(e -> playStop());
    }
    public void playStop() {
        this.buttonClicked();
    }
    public void setSongPlayer(SongPlayer songPlayer) {
        this.songPlayer = songPlayer;
    }
    public SongPlayer getSongPlayer() {
        return this.songPlayer;
    }
    public void setState(PlayStopState state) {
        this.currentState = state;
    }
    private PlayStopState getCurrentState() {
        return this.currentState;
    }
    public PlayStopState getPlayState() {
        return this.playState;
    }
    public PlayStopState getStopSate() {
        return this.stopState;
    }
    public void buttonClicked() {
        this.getCurrentState().playStopButtonClick();
    }
}
