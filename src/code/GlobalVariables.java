package code;

import code.Graphics.ImageController;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import code.Player.Player;
import code.Player.Sprite;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalVariables {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final Canvas CANVAS = new Canvas(1024, 768);

    // Create Image and ImageView objects
    public static final Image brickSingleHorizontal = new Image("img/brickSingleHorizontal.png");
    public static final Image brickSingleVert = new Image("img/brickSingleVert.png");
    public static final Image wallShort = new Image("img/wallShort.png");
    public static final Image wallColon = new Image("img/wallColon.png");
    //borders Kitchen
    public static final double KITCHEN_X = brickSingleVert.getWidth();
    public static final double KITCHEN_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight();
    public static final double KITCHEN_WIDTH = brickSingleHorizontal.getWidth() * 8;
    public static final double KITCHEN_HEIGHT = GlobalVariables.getCanvas().getHeight() / 2 - brickSingleHorizontal.getHeight();
    //borders Living room
    public static final double LIVINGROOM_X = brickSingleVert.getWidth();
    public static final double LIVINGROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT + brickSingleHorizontal.getHeight();
    public static final double LIVINGROOM_WIDTH = brickSingleHorizontal.getWidth() * 10 - brickSingleVert.getWidth();
    public static final double LIVINGROOM_HEIGHT = GlobalVariables.getCanvas().getHeight() - LIVINGROOM_Y - (2 * brickSingleHorizontal.getHeight());
    //borders Bedroom
    public static final double BEDROOM_X = brickSingleVert.getWidth() + KITCHEN_WIDTH + brickSingleVert.getWidth();
    public static final double BEDROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight();
    public static final double BEDROOM_WIDTH = GlobalVariables.getCanvas().getWidth() - KITCHEN_WIDTH - (3 * brickSingleVert.getWidth());
    public static final double BEDROOM_HEIGHT = GlobalVariables.getCanvas().getHeight() / 2 - brickSingleHorizontal.getHeight();
    //borders Bathroom
    public static final double BATHROOM_X = brickSingleVert.getWidth() + LIVINGROOM_WIDTH + brickSingleVert.getWidth();
    public static final double BATHROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT + brickSingleHorizontal.getHeight();
    public static final double BATHROOM_WIDTH = GlobalVariables.getCanvas().getWidth() - (3 * brickSingleVert.getWidth()) - LIVINGROOM_WIDTH;
    public static final double BATHROOM_HEIGHT = GlobalVariables.getCanvas().getHeight() - LIVINGROOM_Y - (2 * brickSingleHorizontal.getHeight());

    private static Group root = new Group();
    private static final boolean[] _mute = {false};
    private static Player _player;
    private static ArrayList<String> _input;
    private static AudioClip _walking, _running, _wallHit;
    private static AtomicInteger _stepCounter;
    private static ArrayDeque<String> _playerDownImages, _playerRightImages, _playerLeftImages, _playerUpImages;
    private static String _direction;
    private static GraphicsContext gc = CANVAS.getGraphicsContext2D();
    private static ArrayList<Sprite> monstersToRender;
    private static ArrayDeque<Sprite> monsterList;

    public static Player getPlayer() {
        return _player;
    }

    public static void setPlayer(Player player) {
        _player = player;
    }

    public static ArrayList<String> getInput() {
        return _input;
    }

    public static void setInput(ArrayList<String> input) {
        _input = input;
    }

    public static AudioClip getWalking() {
        return _walking;
    }

    public static void setWalking(AudioClip walking) {
        _walking = walking;
    }

    public static AudioClip getRunning() {
        return _running;
    }

    public static void setRunning(AudioClip running) {
        _running = running;
    }

    public static AudioClip getWallHit() {
        return _wallHit;
    }

    public static void setWallHit(AudioClip wallHit) {
        _wallHit = wallHit;
    }

    public static AtomicInteger getStepCounter() {
        return _stepCounter;
    }

    public static void setStepCounter(AtomicInteger stepCounter) {
        _stepCounter = stepCounter;
    }

    public static boolean[] getMute() {
        return _mute;
    }

    public static void setMute(boolean mute) {
         _mute[0] = mute;
    }

    public static ArrayDeque<String> getPlayerDownImages() {
        return _playerDownImages;
    }

    public static void setPlayerImages(ArrayDeque<String> playerImages) {
        _playerDownImages = playerImages;
        _playerUpImages = playerImages;
        _playerLeftImages = playerImages;
        _playerRightImages = playerImages;
        ImageController.setPlayerImages();
    }

    public static ArrayDeque<String> getPlayerRightImages() {
        return _playerRightImages;
    }

    public static ArrayDeque<String> getPlayerLeftImages() {
        return _playerLeftImages;
    }

    public static ArrayDeque<String> getPlayerUpImages() {
        return _playerUpImages;
    }

    public static Canvas getCanvas() {
        return CANVAS;
    }

    public static String getDirection() {
        return _direction;
    }

    public static void setDirection(String direction) {
        _direction = direction;
    }

    public static String getProjectPath() {
        return PROJECT_PATH;
    }

    public static GraphicsContext getGraphicContext () {
        return gc;
    }

    public static Group getRoot() {
        return root;
    }

    public static void setRoot(Group root) {
        GlobalVariables.root = root;
    }

    public static ArrayList<Sprite> getMonstersToRender() {
        return monstersToRender;
    }

    public static void setMonstersToRender(ArrayList<Sprite> monstersToRender) {
        GlobalVariables.monstersToRender = monstersToRender;
    }

    public static ArrayDeque<Sprite> getMonsterList() {
        return monsterList;
    }

    public static void setMonsterList(ArrayDeque<Sprite> monsterList) {
        GlobalVariables.monsterList = monsterList;
    }
}