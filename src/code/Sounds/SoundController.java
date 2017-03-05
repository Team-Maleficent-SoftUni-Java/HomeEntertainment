package code.Sounds;

import code.GlobalVariables;
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;

public class SoundController {

    private static AudioClip pickup;
    private static AudioClip spraying;

    public static void loadSounds() {
        GlobalVariables.setWallHit(new AudioClip(Paths.get(GlobalVariables.getProjectPath() + "/src/sounds/wall_hit.wav").toUri().toString()));
        pickup = new AudioClip(Paths.get(GlobalVariables.getProjectPath() + "/src/sounds/pickup.wav").toUri().toString());
        GlobalVariables.setWalking(new AudioClip(Paths.get(GlobalVariables.getProjectPath() + "/src/sounds/walking.wav").toUri().toString()));
        GlobalVariables.setRunning(new AudioClip(Paths.get(GlobalVariables.getProjectPath() + "/src/sounds/running.mp4").toUri().toString()));
        spraying = new AudioClip(Paths.get(GlobalVariables.getProjectPath() + "/src/sounds/sprayingSound.mp4").toUri().toString());
    }

    public static void stopSoundEffects() {
        if ((!GlobalVariables.getInput().contains("LEFT") && !GlobalVariables.getInput()
                .contains("RIGHT") && !GlobalVariables.getInput().contains("UP") && !GlobalVariables.getInput()
                .contains("DOWN")) || GlobalVariables.getInput().contains("SPACE")) {
            GlobalVariables.getWalking().stop();
            GlobalVariables.getRunning().stop();
        }
    }

    public static AudioClip getPickup() {
        return pickup;
    }

    public static AudioClip getSpraying() {
        return spraying;
    }
}
