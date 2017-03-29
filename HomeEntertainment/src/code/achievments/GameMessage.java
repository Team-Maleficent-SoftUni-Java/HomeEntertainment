package code.achievments;

import code.player.Player;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class GameMessage {

    private final Group root;
    private final Player player;
    private final int achievementX;
    private final int achievementY;
    private FadeTransition ft;

    public GameMessage(Player player, Group root) {
        
        this.root = root;
        this.player = player;
        this.achievementX = 200;
        this.achievementY = 100;
    }

    public void renderMessage(String text, int duration, Color color, double x, double y) {

        Text t = new Text(x, y, text);
        FadeTransition ft = new FadeTransition(Duration.millis(duration), t);
        t.setFont(Font.font ("Verdana", 25));
        t.setFill(color);
        t.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(t);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.play();
    }
}