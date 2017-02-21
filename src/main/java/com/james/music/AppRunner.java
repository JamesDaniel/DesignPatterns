package com.james.music;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This module contains the presentation logic for a music player.
 * @author James McGarr
 */
public class AppRunner extends JFrame{
    private SongPlayer songPlayer;
    private PlayStopButton playStop;
    private FrontController frontController;

    private AppRunner() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,120);
        this.setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();
        ObservingLabel playTimeLabel = new ObservingLabel("00:00:00");
        this.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());

        this.setJMenuBar(menuBar);
        this.add(playTimeLabel);

        ArrayList<Observer> observingComponents = new ArrayList<>();
        observingComponents.add(playTimeLabel);
        songPlayer = new SongPlayer(observingComponents);


        playStop = new PlayStopButton("Play", songPlayer);
        this.add(playStop);

        frontController = new FrontController(playStop, songPlayer);


        playStop.addActionListener(e -> userEventHandler(USER_EVENT.CLICK_PLAY_STOP));
        this.setVisible(true);
    }
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");

        JMenuItem item = new JMenuItem("Open");
        item.addActionListener(e ->  userEventHandler(USER_EVENT.OPEN_FILE));
        menu.add(item);

        JMenuItem item2 = new JMenuItem("Exit");
        item2.addActionListener(e -> userEventHandler(USER_EVENT.EXIT));
        menu.add(item2);

        return menu;
    }
    private JMenu createEditMenu() {
        JMenu menu = new JMenu("Edit");

        JMenuItem item = new JMenuItem("Next");
        item.addActionListener(e -> userEventHandler(USER_EVENT.CLICK_NEXT));
        menu.add(item);

        JMenuItem item2 = new JMenuItem("Prev");
        item2.addActionListener(e -> userEventHandler(USER_EVENT.CLICK_PREV));
        menu.add(item2);

        return menu;
    }

    // Event handler method
    public void userEventHandler(USER_EVENT userEvent) {
        frontController.dispatchRequest(userEvent);
    }

    public static void main(String ... args) {
        AppRunner guiApp = new AppRunner();
    }
}
