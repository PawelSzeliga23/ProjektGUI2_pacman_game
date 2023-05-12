package Controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundController {
    private static Clip mainMenuMusic;
    private static Clip gameMusic;

    public static void clickSound() {
        try {
            File audioFile = new File("src/Content/Audio/ClickSound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clickSound = AudioSystem.getClip();
            clickSound.open(audioInputStream);
            clickSound.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void errorSound() {
        try {
            File audioFile = new File("src/Content/Audio/ErrorSound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip errorSound = AudioSystem.getClip();
            errorSound.open(audioInputStream);
            errorSound.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void chompSound() {
        try {
            File audioFile = new File("src/Content/Audio/pacManChomp.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            Clip chompSound = AudioSystem.getClip();
            chompSound.open(audioInputStream);
            chompSound.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mainMenuMusic() {
        try {
            File audioFile = new File("src/Content/Audio/MainMenuMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            mainMenuMusic = AudioSystem.getClip();
            mainMenuMusic.open(audioInputStream);
            mainMenuMusic.loop(20);
            mainMenuMusic.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopMainMenuMusic() {
        mainMenuMusic.stop();
    }

    public static void gameMusic() {
        try {
            File audioFile = new File("src/Content/Audio/GameMusic.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            gameMusic = AudioSystem.getClip();
            gameMusic.open(audioInputStream);
            gameMusic.loop(20);
            gameMusic.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopGameMusic() {
        gameMusic.stop();
    }
}
