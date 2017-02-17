//TODO
package ristirastinolla.ui;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

/**
 * This class gives the sound for the game TODO.
 *
 * @author jtamland
 */
public class Sound {

    private String playerXSound = "/Ristirastinolla/Sound/Xselection.wav";
    private String playerOSound = "/Ristirastinolla/Sound/Oselection.wav";
    private Clip soundClipX;
    private Clip soundClipO;

    Sound() {

    }

    /**
     * This method will get the sound.
     */
    public void playSound() {
        try {
            URL url = this.getClass().getClassLoader().getResource(playerXSound);
            if (url == null) {
                System.out.println("Something went wrong");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                soundClipX = AudioSystem.getClip();
                soundClipX.open(audio);
            }

            url = this.getClass().getClassLoader().getResource(playerOSound);
            if (url == null) {
                System.out.println("Something went wrong");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                soundClipO = AudioSystem.getClip();
                soundClipO.open(audio);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Something went wrong");
        }
    }

    /**
     * This method returns the clipX.
     *
     * @return soundX.
     */
    public Clip getXClip() {
        return soundClipX;
    }

    /**
     * This method returns the clipO.
     *
     * @return ClipO.
     */
    public Clip getOClip() {
        return soundClipO;
    }
}
