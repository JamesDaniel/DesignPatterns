package com.james.main;

import javax.swing.*;
import java.awt.*;

/**
 * This module contains the presentation logic for a music player.
 * @author James McGarr
 */
public class AppRunner extends JFrame{
    private SongPlayer songPlayer;
    private AppRunner() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,120);
        this.setLayout(new FlowLayout());

        JButton play = new JButton("Play");
        JButton stop = new JButton("Stop");
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

        SongFile.getInstance().setSongPath("data/test.mp3");
        songPlayer = new SongPlayer();
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
        songPlayer.nextSong();
    }
    private void prevSong() {
        songPlayer.prevSong();
    }
    private void exit() {
        System.exit(0);
    }
    private void openFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filePath = fc.getSelectedFile().getAbsolutePath();
            System.out.println("opening file " + filePath);
            SongFile.getInstance().setSongPath(filePath);
            songPlayer.setAlgorithmForSong(SongFile.getInstance().getSongPath());
        }
    }
    private void play() {
        songPlayer.playSong();
    }
    private void stop() {
        songPlayer.stopSong();
    }

    public static void main(String ... args) {
        AppRunner guiApp = new AppRunner();
    }
}
