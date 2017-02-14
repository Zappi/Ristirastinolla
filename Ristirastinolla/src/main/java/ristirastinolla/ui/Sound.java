//TODO
package ristirastinolla.ui;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

public class Sound {

    private String playerXSound = "/Ristirastinolla/Sound/Xselection.wav";
    private String playerOSound = "/Ristirastinolla/Sound/Oselection.wav";
    private Clip soundClipX;
    private Clip soundClipO;

    Sound() {

    }

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
            if(url == null) {
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
    
    public Clip getXClip() {
        return soundClipX;
    }

    public Clip getOClip() {
        return soundClipO;
    }
}
