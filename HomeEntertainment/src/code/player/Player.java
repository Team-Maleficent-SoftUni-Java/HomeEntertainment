package code.player;

import code.achievments.Achievement;
import code.global.GlobalVariables;
import code.graphics.ImageController;
import code.sounds.SoundController;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Iterator;

import static code.graphics.ImageController.BRICK_SINGLE_HORIZONTAL;

public class Player extends Sprite {

    private static final int PLAYER_INITIAL_HEALTH = 100;
    private static final double SUBTRACT_PLAYER_HEALTH_VALUE = 0.10;
    private static final int PLAYER_SLOW_DOWN_SPRAY_VALUE = 100000000;
    private static final int PLAYER_IMAGE_WIDTH = 45;
    private static final int PLAYER_IMAGE_HEIGHT = 120;

    private double health;
    private int score;

    private Player(){
        this.health = PLAYER_INITIAL_HEALTH;
    }

    public double getPlayerHealth(){
        return this.health;
    }

    public int getScore() {
        return this.score;
    }
    public void addScore(double score) { this.score += score; }
    public void subtractPlayerHealth(){
        this.health -= SUBTRACT_PLAYER_HEALTH_VALUE;
    }

    public ArrayList<Achievement> achievements = new ArrayList<>();

    private static void changeImage(String direction) {
        switch (direction) {
            case "down":
                String tempImage = ImageController.getPlayerDownImages().pop();
                ImageController.getPlayerDownImages().addLast(tempImage);
                GlobalVariables.getPlayer().setImage(tempImage);
                break;
            case "up":
                String tempImageUp = ImageController.getPlayerUpImages().pop();
                ImageController.getPlayerUpImages().addLast(tempImageUp);
                GlobalVariables.getPlayer().setImage(tempImageUp);
                break;
            case "right":
                String tempImageRight = ImageController.getPlayerRightImages().pop();
                ImageController.getPlayerRightImages().addLast(tempImageRight);
                GlobalVariables.getPlayer().setImage(tempImageRight);
                break;
            case "left":
                String tempImageLeft = ImageController.getPlayerLeftImages().pop();
                ImageController.getPlayerLeftImages().addLast(tempImageLeft);
                GlobalVariables.getPlayer().setImage(tempImageLeft);
                break;
            default:
                break;
        }
    }

    public static void move(int x, int y, String direction, int x1, int y1) {
        GlobalVariables.getStepCounter().addAndGet(1);
        //Running
        if (GlobalVariables.getInput().contains("SHIFT")) {
            GlobalVariables.getPlayer().addVelocity(x, y);
            if (GlobalVariables.getStepCounter().get() == 5) {
                if (GlobalVariables.getWalking().isPlaying()) {
                    GlobalVariables.getWalking().stop();
                }
                if (!GlobalVariables.getRunning().isPlaying()) {
                    if (!GlobalVariables.getMute()[0]) {
                        GlobalVariables.getRunning().play(1, 0, 1.0, 0.0, -5);
                    }
                }
                Player.changeImage(direction);
                GlobalVariables.getStepCounter().set(0);
            }
            //Walking
        }
        GlobalVariables.getPlayer().addVelocity(x1, y1);

        if (GlobalVariables.getStepCounter().get() == 10) {
            if (GlobalVariables.getRunning().isPlaying()) {
                GlobalVariables.getRunning().stop();
            }
            if (!GlobalVariables.getWalking().isPlaying()) {
                if (!GlobalVariables.getMute()[0]) {
                    GlobalVariables.getWalking().play(1, 0, 1.2, 0.0, -5);
                }
            }
            Player.changeImage(direction);
            GlobalVariables.getStepCounter().set(0);
        }
        GlobalVariables.getPlayer().setHasAlreadyHit(false);
    }

    public static void checkIfPlayerCollidesLR() {
        //checks if LEFT or RIGHT is already pressed; prevents sound spam
        if (GlobalVariables.getInput().contains("LEFT") || GlobalVariables.getInput().contains("RIGHT")) {
            GlobalVariables.getPlayer().setHasAlreadyHit(true);
        }
        if (!GlobalVariables.getPlayer().getHasAlreadyHit()) {
            GlobalVariables.getWalking().stop();
            GlobalVariables.getRunning().stop();
            if (!GlobalVariables.getMute()[0]) {
                GlobalVariables.getWallHit().play(1);
            }
        }
        GlobalVariables.getPlayer().setHasAlreadyHit(true);
        GlobalVariables.getPlayer().addVelocity(0, 0);
    }

    public static void checkIfPlayerCollidesUD() {
        //checks if UP or DOWN is already pressed; prevents sound spam
        if (GlobalVariables.getInput().contains("UP") || GlobalVariables.getInput().contains("DOWN")) {
            GlobalVariables.getPlayer().setHasAlreadyHit(true);
        }
        if (!GlobalVariables.getPlayer().getHasAlreadyHit()) {
            GlobalVariables.getWalking().stop();
            GlobalVariables.getRunning().stop();
            if (!GlobalVariables.getMute()[0]) {
                GlobalVariables.getWallHit().play(1);
            }
        }
        GlobalVariables.getPlayer().setHasAlreadyHit(true);
        GlobalVariables.getPlayer().addVelocity(0, 0);
    }

    public static void createPlayerObject() {
        Image playerImage = new Image("img/playerFront0.png", PLAYER_IMAGE_WIDTH, PLAYER_IMAGE_HEIGHT, false, false);
        GlobalVariables.setPlayer(new Player());
        GlobalVariables.getPlayer().setImage(playerImage);
        GlobalVariables.getPlayer().setPosition(5 * BRICK_SINGLE_HORIZONTAL.getWidth(), 20);
    }

    public static void sprayMonsters() {
        if (GlobalVariables.getInput().contains("SPACE")) {
            if(!SoundController.getSpraying().isPlaying() && !GlobalVariables.getMute()[0])
                SoundController.getSpraying().play();

            if("left".equals(GlobalVariables.getDirection()))
                GlobalVariables.getPlayer().setSprayImage("img/SprayLeft.gif");
            if("right".equals(GlobalVariables.getDirection()))
                GlobalVariables.getPlayer().setSprayImage("img/SprayRight.gif");
            if("up".equals(GlobalVariables.getDirection()))
                GlobalVariables.getPlayer().setSprayImage("img/SprayUp.gif");
            if("down".equals(GlobalVariables.getDirection()))
                GlobalVariables.getPlayer().setSprayImage("img/SprayDown.gif");

            Iterator<Sprite> monstersIter = GlobalVariables.getMonstersToRender().iterator();
            while ( monstersIter.hasNext())
            {
                Sprite monster = monstersIter.next();

                if ( GlobalVariables.getPlayer().sprayBoundary().intersects(monster.sprayBoundary())) {
                    for (long i = 0; i < PLAYER_SLOW_DOWN_SPRAY_VALUE; i++) {
                        if ( i == PLAYER_SLOW_DOWN_SPRAY_VALUE - 1){
                            GlobalVariables.getPlayer().score++;
                            if (!GlobalVariables.getMute()[0]) {
                                SoundController.getPickup().play();
                            }
                            monstersIter.remove();
                        }
                    }
                }
            }
        }
    }
}