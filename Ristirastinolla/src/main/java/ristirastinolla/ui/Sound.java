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

    private Clip soundClipX;
    private Clip soundClipO;

    /**
     * This method will get the sound.
     */
    public Sound() {
        try {
            URL url = this.getClass().getResource("/Xselection.wav");
            if (url == null) {
                System.out.println("No file source");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                soundClipX = AudioSystem.getClip();
                soundClipX.open(audio);
            }

            url = this.getClass().getResource("/Oselection.wav");
            if (url == null) {
                System.out.println("Something went wrong");
            } else {
                AudioInputStream audio = AudioSystem.getAudioInputStream(url);
                soundClipO = AudioSystem.getClip();
                soundClipO.open(audio);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Catch");

        }
    }

    
    public void playSoundX() {
        soundClipX.setFramePosition(0);
        soundClipX.start();
        
        }
    
    public void playSoundO() {
        soundClipO.setFramePosition(0);
        soundClipO.start();
    }
    
}
