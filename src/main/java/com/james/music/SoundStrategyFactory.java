package com.james.music;

/**
 * @author James McGarr
 */
public class SoundStrategyFactory {
    public static SoundBehaviour createSoundStrategy(String fileExtension) {
        switch (fileExtension) {
            case "mp3":
                return new Mp3Sound();
            case "wav":
                return new WavSound();
            default:
                System.out.println("No strategy for file with extension " + fileExtension);
                return new DumSound();
        }
    }
}
