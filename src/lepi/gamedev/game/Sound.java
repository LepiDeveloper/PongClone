package lepi.gamedev.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    // add you sound here
    public Sound() {
        soundURL[0] = getClass().getResource("/sound/Booty-Shake-Robot.wav");
        soundURL[1] = getClass().getResource("/sound/collision-sound.wav");
        soundURL[2] = getClass().getResource("/sound/scroll_button.wav");
        soundURL[3] = getClass().getResource("/sound/select_button.wav");


    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println("Error loading sound file " + i + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

}
