package sample.Achievments;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.Player.Player;

public class AchievementManager {

    private final GraphicsContext gc;
    private final int achievementY;
    private final int achievementX;
    public Player player;
    private Group root;

    public AchievementManager(Player player, GraphicsContext gc, Group root) {

        this.player = player;
        this.gc = gc;
        this.achievementX = 200;
        this.achievementY = 100;
        this.root = root;
    }

    public void observe() {

        switch ((int) this.player.score) {

            case 200:

                Achievement assassin = new Achievement("assassin", "Congrats! You unlocked the begginer assassin achievement.");
                this.player.achievements.add(assassin);
                this.renderAchievement(assassin);
                break;

            case 500:

                Achievement maniac = new Achievement("maniac", "Congrats! You unlocked the maniac behaviour achievement.");
                this.player.achievements.add(maniac);
                this.renderAchievement(maniac);
                break;
        }
    }

    public void renderAchievement(Achievement ach) {

        addAchievment(ach, 10000, Color.GREEN);
    }

    private void addAchievment(Achievement ach, int duration, Color color) {

        Text t = new Text(this.achievementX, this.achievementY, ach.unlockingText);
        FadeTransition ft = new FadeTransition(Duration.millis(duration), t);
        t.setFont(Font.font ("Verdana", 25));
        t.setFill(color);
        root.getChildren().add(t);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.play();
    }
}