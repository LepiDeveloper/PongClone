package lepi.gamedev.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl fc;
    int musicVolumeScale = 3;
    int sfxVolumeScale = 3;
    float volume;

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
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            if (i == 0) {
                checkVolume(musicVolumeScale);
            } else {
                checkVolume(sfxVolumeScale);
            }
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

    public void checkVolume(int volumeScale) {
        switch (volumeScale) {
            case 0: volume = -80f; break;
            case 1: volume = -20f; break;
            case 2: volume = -12f; break;
            case 3: volume = -5f; break;
            case 4: volume = 1f; break;
            case 5: volume = 6f; break;
        }
        if (fc != null) {
            fc.setValue(volume);
        }
    }

    public void checkVolume() {
        checkVolume(musicVolumeScale);
    }

}
