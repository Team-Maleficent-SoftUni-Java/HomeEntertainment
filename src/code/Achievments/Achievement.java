package code.Achievments;

import code.Player.Sprite;

public class Achievement extends Sprite {

    public String type = null;
    public String unlockingText = null;

    public Achievement(String type, String unlockingText)
    {
        this.type = type;
        this.unlockingText = unlockingText;
    }
}
