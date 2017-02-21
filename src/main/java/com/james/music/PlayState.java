package com.james.music;

/**
 * @author James McGarr
 */
public class PlayState implements PlayStopState {
    PlayStopButton playStopButton;
    public PlayState(PlayStopButton playStopButton) {
        this.playStopButton = playStopButton;
    }
    public void playStopButtonClick() {
        playStopButton.setState(playStopButton.getStopSate());
        playStopButton.setText("Play");
        playStopButton.getSongPlayer().stopSong();
        System.out.println("set to stop state");


    }
}
