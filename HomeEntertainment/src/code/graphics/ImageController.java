package code.graphics;

import code.global.GlobalVariables;
import javafx.scene.image.Image;

import java.util.ArrayDeque;

import static code.global.GlobalVariables.*;

public class ImageController {

    private static final double CARPET_REQUESTED_HEIGHT = LIVING_ROOM_HEIGHT / 2 + 60;
    private static final double CARPET_REQUESTED_WIDTH = LIVING_ROOM_WIDTH / 2;
    private static final int SIPHON_REQUESTED_WIDTH = 40;
    private static final int SIPHON_REQUESTED_HEIGHT = 40;
    private static final int GARDEN_WALL_WIDTH = 100;
    private static final int SMALL_GARDEN_GRASS_WIDTH = 150;
    private static final int SMALL_GARDEN_GRASS_HEIGHT1 = 120;
    private static final int GARDEN_WALL_HEIGHT = 50;
    private static final String IMG_BRICK_SINGLE_HORIZONTAL_URL = "img/brickSingleHorizontal.png";
    private static final String IMG_BRICK_SINGLE_VERTICAL_URL = "img/brickSingleVert.png";
    private static final String IMG_WALL_SHORT_URL = "img/wallShort.png";
    private static final String IMG_WALL_COLON_URL = "img/wallColon.png";
    private static final String IMG_DOOR_URL = "img/door.png";
    private static final String IMG_PARQUET_URL = "img/parquet.jpg";
    private static final String IMG_TILES2_URL = "img/tiles2.jpg";
    private static final String IMG_CARPET_URL = "img/carpet.jpg";
    private static final String IMG_CARPET03_URL = "img/carpet03.jpg";
    private static final String IMG_SIPHON_URL = "img/siphon.png";
    private static final String IMG_STATS_BOARD_URL = "img/statsBoard.png";
    private static final String IMG_GARDEN_FENCE_URL = "img/gardenFence.png";
    private static final String IMG_GARDEN_GRASS_URL = "img/gardenGrass.jpg";
    private static final String IMG_PLAYER_FRONT1_URL = "img/playerFront0.png";
    private static final String IMG_PLAYER_FRONT2_URL = "img/playerFront1.png";
    private static final String IMG_PLAYER_FRONT3_URL = "img/playerFront2.png";
    private static final String IMG_PLAYER_RIGHT1_URL = "img/playerRight0.png";
    private static final String IMG_PLAYER_RIGHT2_URL = "img/playerRight1.png";
    private static final String IMG_PLAYER_RIGHT3_URL = "img/playerRight2.png";
    private static final String IMG_PLAYER_LEFT1_URL = "img/playerLeft0.png";
    private static final String IMG_PLAYER_LEFT2_URL = "img/playerLeft1.png";
    private static final String IMG_PLAYER_LEFT3_URL = "img/playerLeft2.png";
    private static final String IMG_PLAYER_BACK1_URL = "img/playerBack0.png";
    private static final String IMG_PLAYER_BACK2_URL = "img/playerBack1.png";
    private static final String IMG_PLAYER_BACK3_URL = "img/playerBack2.png";

    // Create Image and ImageView objects
    public final static Image BRICK_SINGLE_HORIZONTAL = new Image(IMG_BRICK_SINGLE_HORIZONTAL_URL);
    public final static Image BRICK_SINGLE_VERTICAL = new Image(IMG_BRICK_SINGLE_VERTICAL_URL);
    public final static Image WALL_SHORT = new Image(IMG_WALL_SHORT_URL);
    public final static Image WALL_COLON = new Image(IMG_WALL_COLON_URL);
    final static Image DOOR_IMAGE = new Image(IMG_DOOR_URL);

    private static ArrayDeque<String> _playerDownImages, _playerRightImages, _playerLeftImages, _playerUpImages;
    private static Image parquet;
    private static Image tiles;
    private static Image carpet;
    private static Image carpet2;
    private static Image siphon;
    private static Image statsBoard;
    private static Image gardenGrass;
    private static Image gardenWall;
    private static Image smallGardenGrass;

    public static void defineImages () {
        parquet = new Image(IMG_PARQUET_URL, KITCHEN_WIDTH, KITCHEN_HEIGHT / 2, false, false);
        tiles = new Image(IMG_TILES2_URL, BATHROOM_WIDTH, BATHROOM_HEIGHT / 2, false, false);
        carpet = new Image(IMG_CARPET_URL, CARPET_REQUESTED_WIDTH, CARPET_REQUESTED_HEIGHT, false, false);
        carpet2 = new Image(IMG_CARPET03_URL, BEDROOM_WIDTH, BEDROOM_HEIGHT / 2, false, false);
        siphon = new Image(IMG_SIPHON_URL, SIPHON_REQUESTED_WIDTH, SIPHON_REQUESTED_HEIGHT, false, false);
        statsBoard = new Image(IMG_STATS_BOARD_URL);
        gardenGrass = new Image(IMG_GARDEN_GRASS_URL, GlobalVariables.CANVAS_WIDTH / 5,
                GlobalVariables.getCanvas().getHeight() / 5, false, false);
        gardenWall = new Image(IMG_GARDEN_FENCE_URL, GARDEN_WALL_WIDTH, GARDEN_WALL_HEIGHT, false, false);
        smallGardenGrass = new Image(IMG_GARDEN_GRASS_URL, SMALL_GARDEN_GRASS_WIDTH,
                SMALL_GARDEN_GRASS_HEIGHT1, false, false);
    }

    public static ArrayDeque<String> getPlayerDownImages() {
        return _playerDownImages;
    }

    public static void setPlayerDownImages(ArrayDeque<String> playerDownImages) {
        _playerDownImages = playerDownImages;
        ImageController.getPlayerDownImages().addLast(IMG_PLAYER_FRONT1_URL);
        ImageController.getPlayerDownImages().addLast(IMG_PLAYER_FRONT2_URL);
        ImageController.getPlayerDownImages().addLast(IMG_PLAYER_FRONT3_URL);
    }

    public static ArrayDeque<String> getPlayerRightImages() {
        return _playerRightImages;
    }

    public static void setPlayerRightImages(ArrayDeque<String> playerRightImages) {
        _playerRightImages = playerRightImages;
        ImageController.getPlayerRightImages().addLast(IMG_PLAYER_RIGHT1_URL);
        ImageController.getPlayerRightImages().addLast(IMG_PLAYER_RIGHT2_URL);
        ImageController.getPlayerRightImages().addLast(IMG_PLAYER_RIGHT3_URL);
    }

    public static ArrayDeque<String> getPlayerLeftImages() {
        return _playerLeftImages;
    }

    public static void setPlayerLeftImages(ArrayDeque<String> playerLeftImages) {
        _playerLeftImages = playerLeftImages;
        ImageController.getPlayerLeftImages().addLast(IMG_PLAYER_LEFT1_URL);
        ImageController.getPlayerLeftImages().addLast(IMG_PLAYER_LEFT2_URL);
        ImageController.getPlayerLeftImages().addLast(IMG_PLAYER_LEFT3_URL);
    }

    public static ArrayDeque<String> getPlayerUpImages() {
        return _playerUpImages;
    }

    public static void setPlayerUpImages(ArrayDeque<String> playerUpImages) {
        _playerUpImages = playerUpImages;
        ImageController.getPlayerUpImages().addLast(IMG_PLAYER_BACK1_URL);
        ImageController.getPlayerUpImages().addLast(IMG_PLAYER_BACK2_URL);
        ImageController.getPlayerUpImages().addLast(IMG_PLAYER_BACK3_URL);
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

    static Image getGardenGrass() { return gardenGrass; }

    static Image getGardenFence() { return gardenWall; }

    static Image getSmallGardenGrass() {
        return smallGardenGrass;
    }
}