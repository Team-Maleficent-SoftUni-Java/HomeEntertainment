package code.Graphics;

import code.GlobalVariables;
import javafx.scene.image.Image;
import static code.GlobalVariables.*;

public class ImageController {
    private static Image parquet;
    private static Image tiles;
    private static Image carpet;
    private static Image carpet2;
    private static Image siphon;
    private static Image statsBoard;

    public static void defineImages () {
        parquet = new Image("img/parquet.jpg", KITCHEN_WIDTH, KITCHEN_HEIGHT / 2, false, false);
        tiles = new Image("img/tiles2.jpg", BATHROOM_WIDTH, BATHROOM_HEIGHT / 2, false, false);
        carpet = new Image("img/carpet.jpg", LIVINGROOM_WIDTH / 2, LIVINGROOM_HEIGHT / 2, false, false);
        carpet2 = new Image("img/carpet03.jpg", BEDROOM_WIDTH, BEDROOM_HEIGHT / 2, false, false);
        siphon = new Image("img/siphon.png", 40, 40, false, false);
        statsBoard = new Image("img/statsBoard.png");
    }

    public static void setPlayerImages () {
        //down
        GlobalVariables.getPlayerDownImages().addLast("img/playerFront0.png");
        GlobalVariables.getPlayerDownImages().addLast("img/playerFront1.png");
        GlobalVariables.getPlayerDownImages().addLast("img/playerFront2.png");
        //up
        GlobalVariables.getPlayerUpImages().addLast("img/playerBack0.png");
        GlobalVariables.getPlayerUpImages().addLast("img/playerBack1.png");
        GlobalVariables.getPlayerUpImages().addLast("img/playerBack2.png");
        //right
        GlobalVariables.getPlayerRightImages().addLast("img/playerRight0.png");
        GlobalVariables.getPlayerRightImages().addLast("img/playerRight1.png");
        GlobalVariables.getPlayerRightImages().addLast("img/playerRight2.png");
        //left
        GlobalVariables.getPlayerLeftImages().addLast("img/playerLeft0.png");
        GlobalVariables.getPlayerLeftImages().addLast("img/playerLeft1.png");
        GlobalVariables.getPlayerLeftImages().addLast("img/playerLeft2.png");
    }

    public static Image getParquet() {
        return parquet;
    }

    public static Image getTiles() {
        return tiles;
    }

    public static Image getCarpet() {
        return carpet;
    }

    public static Image getCarpet2() {
        return carpet2;
    }

    public static Image getSiphon() {
        return siphon;
    }

    public static Image getStatsBoard() {
        return statsBoard;
    }
}