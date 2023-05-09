package Controllers;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundController {
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

}
