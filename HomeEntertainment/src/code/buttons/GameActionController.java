package code.buttons;

import code.achievments.GameMessage;
import code.enemy.MonstersController;
import code.global.GlobalVariables;
import code.graphics.DrawLevel2;
import code.graphics.DrawLevel1;
import code.intersectObjects.IntersectsObject;
import code.intersectObjects.IntersectsObjectLevel1;
import code.Main;
import code.player.Player;
import code.sounds.SoundController;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class GameActionController {

    private static final int IMAGE_SOUND_REQUESTED_SIZE = 30;
    private static final int SCORE_FONT_SIZE = 20;
    private static final int BUTTONS_HEIGHT = 50;
    private static final int BUTTONS_WIDTH = 150;
    private static final int ATOMIC_INTEGER_INITIAL_VALUE = 0;
    private static final int BUTTON_START_NEW_GAME_X = 252;
    private static final int BUTTONS_Y = 588;
    private static final int BUTTONS_X = 452;
    private static final int PAUSE_Y = 518;
    private static final int PLAYER_INITIAL_POSITION_X = 300;
    private static final int PLAYER_INITIAL_GARDEN_POSITION_Y = 630;
    private static final int PLAYER_INITIAL_HOUSE_POSITION_Y = 20;
    private static final int DOOR_LEFT_X = 240;
    private static final int DOOR_RIGHT_X = 320;
    private static final int GARDEN_DOOR_Y = 630;
    private static final int HOUSE_DOOR_Y = -50;
    private static final int COMPLETE_LEVEL1_MESSAGE_X = 197;
    private static final int COMPLETE_LEVEL1_MESSAGE_Y = 299;
    private static final double NANO_TIME_DIVIDER = 1000000000.0;
    private static final String SOUND_ON_TEXT = "Sound ON";
    private static final String SOUND_OFF_TEST = "Sound OFF";
    private static final String IMG_SOUND_ON_URL = "img/soundOn.png";
    private static final String IMG_SOUND_OFF_URL = "img/soundOff.png";
    private static final String SCORE_FONT_TYPE = "Arial";
    private static final String BUTTONS_STYLE = "-fx-font: 22 arial";
    private static final String PAUSE_BUTTON_TEXT = "Pause";
    private static final String ESCAPE = "ESCAPE";
    private static final String KEYBOARD_P = "KEYBOARD_P";
    private static final String FIRST_LEVEL_CONGRATS_MESSAGE = "Congratulations!!!\n You pass the first level please go through the door!";
    private static final String KEYBOARD_LEFT = "LEFT";
    private static final String KEYBOARD_SPACE = "SPACE";
    private static final String DIRECRION_LEFT = "left";
    private static final String DIRECTION_RIGHT = "RIGHT";
    private static final String DIRECTION_UP = "UP";
    private static final String DIRECTION_DOWN = "DOWN";

    public static void attachSoundButtonEvent() {
        ButtonController.buttonSound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GlobalVariables.getMute()[0]) {
                    changeSoundMode(false, SOUND_ON_TEXT, IMG_SOUND_ON_URL);
                } else {
                    changeSoundMode(true, SOUND_OFF_TEST, IMG_SOUND_OFF_URL);
                }
            }

            private void changeSoundMode(boolean b, String soundStatus, String url) {
                ButtonController.IMAGE_SOUND[0] = new Image(
                        url, IMAGE_SOUND_REQUESTED_SIZE, IMAGE_SOUND_REQUESTED_SIZE, false, false);
                ButtonController.buttonSound.setGraphic(new ImageView(ButtonController.IMAGE_SOUND[0]));
                ButtonController.menuSoundText1.setText(soundStatus);
                GlobalVariables.setMute(b);
            }
        });
    }

    public static void attachCloseButtonEvent() {
        ButtonController.buttonClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ButtonController.IS_MAIN_WINDOW[0]) {
                    GlobalVariables.getRoot().getChildren().add(ButtonController.buttonMenu);
                } else {
                    GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonQuit);
                }
                removeButtonsFromRoot();
                GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonStartNewGame);
                GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonResume);
            }
        });
    }

    public static void attachButtonMenuAction() {
        ButtonController.buttonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonMenu);
                addButtonsToRoot();
                GlobalVariables.getRoot().getChildren().add(ButtonController.buttonClose);
            }
        });
    }

    public static void attachButtonQuitAction(Stage theStage) {
        ButtonController.buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                theStage.close();
            }
        });
    }

    public static void attachButtonStartAction(Stage theStage) {
        ButtonController.buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ButtonController.IS_MAIN_WINDOW[0] = false;

                //Prepare the score text
                Font scoreFont = Font.font(SCORE_FONT_TYPE, FontWeight.NORMAL, SCORE_FONT_SIZE);
                GlobalVariables.getGraphicContext().setFont(scoreFont);
                GlobalVariables.getGraphicContext().setStroke(Color.BLACK);
                GlobalVariables.getGraphicContext().setLineWidth(1);
                GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.LEFT);
                final Long[] lastNanoTime = {System.nanoTime()};
                GlobalVariables.setStepCounter(new AtomicInteger(ATOMIC_INTEGER_INITIAL_VALUE));
                AtomicInteger monsterCounter = new AtomicInteger(ATOMIC_INTEGER_INITIAL_VALUE);

                final int[] level = {1};

                //The animation begins
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {
                        // calculate time since last update.
                        double elapsedTime = (currentNanoTime - lastNanoTime[0]) / NANO_TIME_DIVIDER;
                        lastNanoTime[0] = currentNanoTime;

                        removeButtonsFromRoot();
                        GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonStart);
                        GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonMenu);
                        GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonQuit);
                        GlobalVariables.getGraphicContext().setEffect(null);

                        //Button start new game
                        ButtonController.buttonStartNewGame.setPrefHeight(BUTTONS_HEIGHT);
                        ButtonController.buttonStartNewGame.setPrefWidth(BUTTONS_WIDTH);
                        ButtonController.buttonStartNewGame.setLayoutX(BUTTON_START_NEW_GAME_X);
                        ButtonController.buttonStartNewGame.setLayoutY(BUTTONS_Y);
                        ButtonController.buttonStartNewGame.setStyle(BUTTONS_STYLE);

                        ButtonController.buttonStartNewGame.setOnAction(__ -> {
                            theStage.close();
                            //remove old plants from level 2
                            DrawLevel2.plants.clear();
                            Platform.runLater(() -> new Main().start(new Stage()));
                        });

                        //Button Resume game
                        ButtonController.buttonResume.setPrefHeight(BUTTONS_HEIGHT);
                        ButtonController.buttonResume.setPrefWidth(BUTTONS_WIDTH);
                        ButtonController.buttonResume.setLayoutX(BUTTONS_X);
                        ButtonController.buttonResume.setLayoutY(BUTTONS_Y);
                        ButtonController.buttonResume.setStyle(BUTTONS_STYLE);

                        //Button Pause game
                        Button pause = new Button(PAUSE_BUTTON_TEXT);
                        pause.setPrefHeight(BUTTONS_HEIGHT);
                        pause.setPrefWidth(BUTTONS_WIDTH);
                        pause.setLayoutX(BUTTONS_X);
                        pause.setLayoutY(PAUSE_Y);
                        pause.setStyle(BUTTONS_STYLE);

                        ButtonController.buttonResume.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                removeButtonsFromRoot();
                                GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonResume);
                                GlobalVariables.getRoot().getChildren().remove(pause);
                                GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonStartNewGame);
                                start();
                            }
                        });

                        //show menu
                        if (GlobalVariables.getInput().contains(ESCAPE)) {
                            addButtonsToRoot();
                            GlobalVariables.getRoot().getChildren().add(ButtonController.buttonQuit);
                            GlobalVariables.getRoot().getChildren().add(ButtonController.buttonResume);
                            GlobalVariables.getRoot().getChildren().add(ButtonController.buttonStartNewGame);
                            stop();
                        }

                        //Pause control
                        if (GlobalVariables.getInput().contains(KEYBOARD_P)) {
                            GlobalVariables.getRoot().getChildren().add(pause);
                            GlobalVariables.getRoot().getChildren().add(ButtonController.buttonResume);
                            stop();
                        }

                        IntersectsObjectLevel1 intersectsObjectLevel1 = new IntersectsObjectLevel1();

                        GameMessage GM = new GameMessage(GlobalVariables.getPlayer(), GlobalVariables.getRoot());

                        //Stops sound effects while standing in place
                        SoundController.stopSoundEffects();
                        GlobalVariables.getPlayer().update(elapsedTime);

                        if (GlobalVariables.getPlayer().getScore() < 1 && level[0] == 1) {

                            // player movement
                            playerMovement(intersectsObjectLevel1);

                            // draw obstacles
                            DrawLevel1.drawWalls(true);

                            // show monsters
                            MonstersController.displayMonsters(monsterCounter);

                            //Spraying the monsters
                            Player.sprayMonsters();

                            // Check collision with monsters
                            MonstersController.checkCollision(this);
                        } else {
                            if(GlobalVariables.getPlayer().getScore() >= 1 && GlobalVariables.getPlayer().getY() <= HOUSE_DOOR_Y) {
                                level[0] = 2;

                                //set player position in garden
                                GlobalVariables.getPlayer().setPosition(PLAYER_INITIAL_POSITION_X, PLAYER_INITIAL_GARDEN_POSITION_Y);

                                playerMovement(GlobalVariables.getIntersectsObject());
                            } else if (level[0] == 1){
                                if (!GlobalVariables.beenInSecondLevel) {
                                    GM.renderMessage(FIRST_LEVEL_CONGRATS_MESSAGE,
                                            1, Color.DEEPSKYBLUE, COMPLETE_LEVEL1_MESSAGE_X, COMPLETE_LEVEL1_MESSAGE_Y);
                                }

                                // remove door
                                intersectsObjectLevel1.setIntersectObjectsWithoutDoor();

                                // draw obstacles
                                DrawLevel1.drawWalls(false);

                                playerMovement(intersectsObjectLevel1);

                            } else if(level[0] == 2){
                                playerMovement(GlobalVariables.getIntersectsObject());
                                DrawLevel2.drawGarden();
                                if (GlobalVariables.getPlayer().getX() > DOOR_LEFT_X &&  GlobalVariables.getPlayer().getX() < DOOR_RIGHT_X
                                        && GlobalVariables.getPlayer().getY() > GARDEN_DOOR_Y) {
                                    level[0] = 1;
                                    GlobalVariables.getPlayer().setPosition(PLAYER_INITIAL_POSITION_X, PLAYER_INITIAL_HOUSE_POSITION_Y);
                                }
                                GlobalVariables.beenInSecondLevel = true;
                            }
                        }
                    }
                }.start();
            }
        });
    }

    private static void removeButtonsFromRoot() {
        GlobalVariables.getRoot().getChildren().remove(ButtonController.menu);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonClose);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.menuTitle);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.menuSoundText1);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.menuSoundText2);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonSound);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.keyboardGuideTitle);
        GlobalVariables.getRoot().getChildren().remove(ButtonController.keyboardGuide);
    }

    private static void addButtonsToRoot() {
        GlobalVariables.getRoot().getChildren().add(ButtonController.menu);
        GlobalVariables.getRoot().getChildren().add(ButtonController.menuTitle);
        GlobalVariables.getRoot().getChildren().add(ButtonController.menuSoundText1);
        GlobalVariables.getRoot().getChildren().add(ButtonController.menuSoundText2);
        GlobalVariables.getRoot().getChildren().add(ButtonController.keyboardGuideTitle);
        GlobalVariables.getRoot().getChildren().add(ButtonController.keyboardGuide);
        GlobalVariables.getRoot().getChildren().add(ButtonController.buttonSound);
    }

    private static void playerMovement(IntersectsObject intersectObject) {

        GlobalVariables.getPlayer().setVelocity(0, 0);
        if (GlobalVariables.getInput().contains(KEYBOARD_LEFT) && !GlobalVariables.getInput().contains(KEYBOARD_SPACE)) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().leftBoundary())) {
                Player.checkIfPlayerCollidesUD();
            } else {
                GlobalVariables.setDirection(DIRECRION_LEFT);
                Player.move(-180, 0, GlobalVariables.getDirection(), -90, 0);
            }
        }

        if (GlobalVariables.getInput().contains(DIRECTION_RIGHT) && !GlobalVariables.getInput().contains(KEYBOARD_SPACE)) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().rightBoundary())) {
                Player.checkIfPlayerCollidesUD();
            } else {
                GlobalVariables.setDirection(DIRECTION_RIGHT.toLowerCase());
                Player.move(180, 0, GlobalVariables.getDirection(), 90, 0);
            }
        }

        if (GlobalVariables.getInput().contains(DIRECTION_UP) && !GlobalVariables.getInput().contains(KEYBOARD_SPACE)) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().upperBoundary())) {

                Player.checkIfPlayerCollidesLR();
            } else {
                GlobalVariables.setDirection(DIRECTION_UP.toLowerCase());
                Player.move(0, -180, GlobalVariables.getDirection(), 0, -90);
            }
        }

        if (GlobalVariables.getInput().contains(DIRECTION_DOWN) && !GlobalVariables.getInput().contains(KEYBOARD_SPACE)) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().bottomBoundary())) {
                Player.checkIfPlayerCollidesLR();
            } else {
                GlobalVariables.setDirection(DIRECTION_DOWN.toLowerCase());
                Player.move(0, 180, GlobalVariables.getDirection(), 0, 90);
            }
        }
    }
}