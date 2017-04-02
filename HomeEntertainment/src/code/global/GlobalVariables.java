package code.global;

import code.intersectObjects.IntersectsObject;
import code.player.Player;
import code.player.Sprite;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalVariables {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final int CANVAS_HEIGHT = 768;
    public static final int CANVAS_WIDTH = 1024;
    public static final int CANVAS_X_Y = 0;

    //borders Kitchen
    public static final double KITCHEN_X = 20;
    public static final double KITCHEN_Y = 100;
    public static final double KITCHEN_WIDTH = 496;
    public static final double KITCHEN_HEIGHT = 364;

    //borders Living room
    public static final double LIVING_ROOM_X = 20;
    public static final double LIVING_ROOM_Y = 484;
    public static final double LIVING_ROOM_WIDTH = 600;
    public static final double LIVING_ROOM_HEIGHT = 244;

    //borders Bedroom
    public static final double BEDROOM_X = 536;
    public static final double BEDROOM_Y = 100;
    public static final double BEDROOM_WIDTH = 468;
    public static final double BEDROOM_HEIGHT = 364;

    //borders Bathroom
    public static final double BATHROOM_X = 640;
    public static final double BATHROOM_Y = 484;
    public static final double BATHROOM_WIDTH = 364;
    public static final double BATHROOM_HEIGHT = 244;

    private static final boolean[] MUTE = {false};

    private static Group root = new Group();
    private static Player player;
    private static ArrayList<String> input;
    private static AudioClip walking, running, wallHit, attack;
    private static AtomicInteger stepCounter;
    private static Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    private static String direction;
    private static GraphicsContext gc = canvas.getGraphicsContext2D();
    private static ArrayList<Sprite> monstersToRender;
    private static ArrayDeque<Sprite> monsterList;
    private static IntersectsObject intersectsObject;

    public static Player getPlayer() {
        return player;
    }

    public static IntersectsObject getIntersectsObject() { return intersectsObject; }

    public static void setIntersectsObject(IntersectsObject intersectsObject) { GlobalVariables.intersectsObject = intersectsObject; }

    public static void setPlayer(Player player) {
        GlobalVariables.player = player;
    }

    public static ArrayList<String> getInput() {
        return input;
    }

    public static void setInput(ArrayList<String> input) {
        GlobalVariables.input = input;
    }

    public static AudioClip getWalking() {
        return walking;
    }

    public static void setWalking(AudioClip walking) {
        GlobalVariables.walking = walking;
    }

    public static AudioClip getRunning() {
        return running;
    }

    public static void setRunning(AudioClip running) {
        GlobalVariables.running = running;
    }

    public static AudioClip getWallHit() {
        return wallHit;
    }

    public static AudioClip getAttack() {
        return attack;
    }

    public static void setWallHit(AudioClip wallHit) {
        GlobalVariables.wallHit = wallHit;
    }

    public static void setAttack(AudioClip attack) {
        GlobalVariables.attack = attack;
    }

    public static AtomicInteger getStepCounter() {
        return stepCounter;
    }

    public static void setStepCounter(AtomicInteger stepCounter) {
        GlobalVariables.stepCounter = stepCounter;
    }

    public static boolean[] getMute() {
        return MUTE;
    }

    public static void setMute(boolean mute) {
         MUTE[0] = mute;
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    public static void setCanvas(Canvas canvas) {
        GlobalVariables.canvas = canvas;
    }

    public static String getDirection() {
        return direction;
    }

    public static void setDirection(String direction) {
        GlobalVariables.direction = direction;
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