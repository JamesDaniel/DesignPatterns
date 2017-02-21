package com.james.music;

/**
 * @author James McGarr
 */
public class StopState implements PlayStopState {
    PlayStopButton playStopButton;
    public StopState(PlayStopButton playStopButton) {
        this.playStopButton = playStopButton;
    }
    public void playStopButtonClick() {
        playStopButton.setState(playStopButton.getPlayState());
        playStopButton.setText("Stop");
        playStopButton.getSongPlayer().playSong();
        System.out.println("set to Play state");
    }
}
