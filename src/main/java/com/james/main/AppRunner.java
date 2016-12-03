package com.james.main;

import javax.swing.*;
import java.awt.*;

/**
 * This module contains the presentation logic for a music player.
 * @author James McGarr
 */
public class AppRunner extends JFrame{
    private JButton play;
    private JButton stop;
    private AppRunner() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,120);
        this.setLayout(new FlowLayout());

        play = new JButton("Play");
        stop = new JButton("Stop");
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());

        play.addActionListener(e -> play());
        stop.addActionListener(e -> stop());

        this.setJMenuBar(menuBar);
        this.add(play);
        this.add(stop);
        this.setVisible(true);
    }

    //
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");

        JMenuItem item = new JMenuItem("Open");
        item.addActionListener(e -> openFile());
        menu.add(item);

        JMenuItem item2 = new JMenuItem("Exit");
        item2.addActionListener(e -> exit());
        menu.add(item2);

        return menu;
    }
    private JMenu createEditMenu() {
        JMenu menu = new JMenu("Edit");

        JMenuItem item = new JMenuItem("Next");
        item.addActionListener(e -> nextSong());
        menu.add(item);

        JMenuItem item2 = new JMenuItem("Prev");
        item2.addActionListener(e -> prevSong());
        menu.add(item2);

        return menu;
    }

    // Event handler methods
    private void nextSong() {
        System.out.println("next song");
    }
    private void prevSong() {
        System.out.println("previous song");
    }
    private void exit() {
        System.out.println("exiting");
    }
    private void openFile() {
        System.out.println("opening file");
    }
    private void play() {
        System.out.println("playing music player");
    }
    private void stop() {
        System.out.println("stopping music player");
    }

    public static void main(String ... args) {
        AppRunner guiApp = new AppRunner();
    }
}
