package code.Graphics;

import javafx.scene.image.Image;

import java.util.ArrayDeque;

import static code.GlobalVariables.*;

public class ImageController {

    // Create Image and ImageView objects
    public final static Image BRICK_SINGLE_HORIZONTAL = new Image("img/brickSingleHorizontal.png");
    public final static Image BRICK_SINGLE_VERTICAL = new Image("img/brickSingleVert.png");
    public final static Image WALL_SHORT = new Image("img/wallShort.png");
    public final static Image WALL_COLON = new Image("img/wallColon.png");

    private static ArrayDeque<String> _playerDownImages, _playerRightImages, _playerLeftImages, _playerUpImages;
    private static Image parquet;
    private static Image tiles;
    private static Image carpet;
    private static Image carpet2;
    private static Image siphon;
    private static Image statsBoard;

    public static void defineImages () {
        parquet = new Image("img/parquet.jpg", KITCHEN_WIDTH, KITCHEN_HEIGHT / 2, false, false);
        tiles = new Image("img/tiles2.jpg", BATHROOM_WIDTH, BATHROOM_HEIGHT / 2, false, false);
        carpet = new Image("img/carpet.jpg", LIVING_ROOM_WIDTH / 2, LIVING_ROOM_HEIGHT / 2, false, false);
        carpet2 = new Image("img/carpet03.jpg", BEDROOM_WIDTH, BEDROOM_HEIGHT / 2, false, false);
        siphon = new Image("img/siphon.png", 40, 40, false, false);
        statsBoard = new Image("img/statsBoard.png");
    }

    public static ArrayDeque<String> getPlayerDownImages() {
        return _playerDownImages;
    }

    public static void setPlayerDownImages(ArrayDeque<String> playerDownImages) {
        _playerDownImages = playerDownImages;
        ImageController.getPlayerDownImages().addLast("img/playerFront0.png");
        ImageController.getPlayerDownImages().addLast("img/playerFront1.png");
        ImageController.getPlayerDownImages().addLast("img/playerFront2.png");
    }

    public static ArrayDeque<String> getPlayerRightImages() {
        return _playerRightImages;
    }

    public static void setPlayerRightImages(ArrayDeque<String> playerRightImages) {
        _playerRightImages = playerRightImages;
        ImageController.getPlayerRightImages().addLast("img/playerRight0.png");
        ImageController.getPlayerRightImages().addLast("img/playerRight1.png");
        ImageController.getPlayerRightImages().addLast("img/playerRight2.png");
    }

    public static ArrayDeque<String> getPlayerLeftImages() {
        return _playerLeftImages;
    }

    public static void setPlayerLeftImages(ArrayDeque<String> playerLeftImages) {
        _playerLeftImages = playerLeftImages;
        ImageController.getPlayerLeftImages().addLast("img/playerLeft0.png");
        ImageController.getPlayerLeftImages().addLast("img/playerLeft1.png");
        ImageController.getPlayerLeftImages().addLast("img/playerLeft2.png");
    }

    public static ArrayDeque<String> getPlayerUpImages() {
        return _playerUpImages;
    }

    public static void setPlayerUpImages(ArrayDeque<String> playerUpImages) {
        _playerUpImages = playerUpImages;
        ImageController.getPlayerUpImages().addLast("img/playerBack0.png");
        ImageController.getPlayerUpImages().addLast("img/playerBack1.png");
        ImageController.getPlayerUpImages().addLast("img/playerBack2.png");
    }


    static Image getParquet() {
        return parquet;
    }

    static Image getTiles() {
        return tiles;
    }

    public static Image getCarpet() {
        return carpet;
    }

    static Image getCarpet2() {
        return carpet2;
    }

    static Image getSiphon() {
        return siphon;
    }

    static Image getStatsBoard() {
        return statsBoard;
    }
}