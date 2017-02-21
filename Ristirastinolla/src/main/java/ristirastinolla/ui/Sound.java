//TODO
package ristirastinolla.ui;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

/**
 * This class gets the sound effects and plays them.
 *
 * @author jtamland
 */
public class Sound {

    private Clip soundClipX;
    private Clip soundClipO;
    private Clip winnerSound;

    /**
     * This method will get the sound.
     */
    public Sound() {
        try {
            URL url = this.getClass().getResource("/Xselection.wav");
            if (url == null) {
                System.out.println("No audio source");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                soundClipX = AudioSystem.getClip();
                soundClipX.open(audio);
            }

            url = this.getClass().getResource("/Oselection.wav");
            if (url == null) {
                System.out.println("No audio source");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                soundClipO = AudioSystem.getClip();
                soundClipO.open(audio);
            }

            url = this.getClass().getResource("/winner.wav");
            if (url == null) {
                System.out.println("No audio source");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                winnerSound = AudioSystem.getClip();
                winnerSound.open(audio);

            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Catch");

        }
    }

    /**
     * Plays the sound for player X.
     */
    public void playSoundX() {
        soundClipX.setFramePosition(0);
        soundClipX.start();

    }

    /**
     * Plays the sound for player O.
     */
    public void playSoundO() {
        soundClipO.setFramePosition(0);
        soundClipO.start();
    }

    /**
     * If either one of the players has won this sound will be played.
     *
     * @throws InterruptedException
     */
    public void playWinnerSound() throws InterruptedException {
        Thread.sleep(100);
        winnerSound.setFramePosition(0);
        winnerSound.start();
    }

}
