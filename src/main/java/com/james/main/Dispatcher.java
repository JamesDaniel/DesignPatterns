package com.james.main;

import javax.swing.*;

/**
 * @author James McGarr
 * REFERENCE https://www.tutorialspoint.com/design_pattern/front_controller_pattern.htm
 */
public class Dispatcher {
    private PlayStopButton playStopButton;
    private SongPlayer songPlayer;
    public Dispatcher(PlayStopButton playStopButton, SongPlayer songPlayer) {
        this.setPlayStopButton(playStopButton);
        this.setSongPlayer(songPlayer);
    }
    private void setPlayStopButton(PlayStopButton playStopButton) {
        this.playStopButton = playStopButton;
    }
    private void setSongPlayer(SongPlayer songPlayer) {
        this.songPlayer = songPlayer;
    }
    public void dispatch(USER_EVENT request) {
        if (request == USER_EVENT.CLICK_PLAY_STOP) {
            playStopButton.buttonClicked();
        } else if (request == USER_EVENT.CLICK_NEXT) {
            songPlayer.nextSong();
        } else if (request == USER_EVENT.CLICK_PREV) {
            songPlayer.prevSong();
        } else if (request == USER_EVENT.EXIT) {
            System.exit(0);
        } else if (request == USER_EVENT.OPEN_FILE) {
            this.openFile();
        }
    }
    private void openFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filePath = fc.getSelectedFile().getAbsolutePath();
            System.out.println("opening file " + filePath);
            SongFile.getInstance().setSongPath(filePath);
            songPlayer.setAlgorithmForSong(SongFile.getInstance().getSongPath());
        }
    }
}
