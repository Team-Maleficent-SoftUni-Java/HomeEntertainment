package code.buttons;

import code.achievments.GameMessage;
import code.enemy.MonstersController;
import code.global.GlobalVariables;
import code.graphics.DrawLevel2;
import code.graphics.FurnitureObjects;
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

import static code.global.GlobalVariables.CANVAS_FAKE_HEIGHT;

public class ButtonEventsController {

    public static void attachSoundButtonEvent() {
        ButtonController.getButtonSound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GlobalVariables.getMute()[0]) {
                    changeSoundMode(false, "Sound ON", "img/soundOn.png");
                } else {
                    changeSoundMode(true, "Sound OFF", "img/soundOff.png");
                }
            }

            private void changeSoundMode(boolean b, String soundStatus, String url) {
                ButtonController.getImageSound()[0] = new Image(
                        url, 30, 30, false, false);
                ButtonController.getButtonSound().setGraphic(new ImageView(ButtonController.getImageSound()[0]));
                ButtonController.getMenuSoundText1().setText(soundStatus);
                GlobalVariables.setMute(b);
            }
        });
    }

    public static void attachCloseButtonEvent() {
        ButtonController.getButtonClose().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ButtonController.getIsMainWindow()[0]) {
                    GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonMenu());
                } else {
                    GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonQuit());
                }
                removeButtonsFromRoot();
                GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonStartNewGame());
                GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonResume());
            }
        });
    }

    public static void attachButtonMenuAction() {
        ButtonController.getButtonMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonMenu());
                addButtonsToRoot();
                GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonClose());
            }
        });
    }

    public static void attachButtonQuitAction(Stage theStage) {
        ButtonController.getButtonQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                theStage.close();
            }
        });
    }

    public static void attachButtonStartAction(Stage theStage) {
        ButtonController.getButtonStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ButtonController.getIsMainWindow()[0] = false;

                //Prepare the score text
                Font scoreFont = Font.font("Arial", FontWeight.NORMAL, 20);
                GlobalVariables.getGraphicContext().setFont(scoreFont);
                GlobalVariables.getGraphicContext().setStroke(Color.BLACK);
                GlobalVariables.getGraphicContext().setLineWidth(1);
                GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.LEFT);
                final Long[] lastNanoTime = {System.nanoTime()};
                GlobalVariables.setStepCounter(new AtomicInteger(0));
                AtomicInteger monsterCounter = new AtomicInteger(0);

                final int[] level = {1};

                //The animation begins
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {
                        // calculate time since last update.
                        double elapsedTime = (currentNanoTime - lastNanoTime[0]) / 1000000000.0;
                        lastNanoTime[0] = currentNanoTime;

                        removeButtonsFromRoot();
                        GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonStart());
                        GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonMenu());
                        GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonQuit());
                        GlobalVariables.getGraphicContext().setEffect(null);

                        //Button start new game
                        ButtonController.getButtonStartNewGame().setPrefHeight(50);
                        ButtonController.getButtonStartNewGame().setPrefWidth(150);
                        ButtonController.getButtonStartNewGame().setLayoutX((GlobalVariables.getCanvas().getWidth()
                                - (3 * ButtonController.getButtonMenu().getPrefWidth()) - (2 * 50)) / 2 + 15);
                        ButtonController.getButtonStartNewGame().setLayoutY(CANVAS_FAKE_HEIGHT - 180);
                        ButtonController.getButtonStartNewGame().setStyle("-fx-font: 22 arial");

                        ButtonController.getButtonStartNewGame().setOnAction(__ -> {
                            theStage.close();
                            //remove old plants from level 2
                            DrawLevel2.plants.clear();
                            Platform.runLater(() -> new Main().start(new Stage()));
                        });

                        //Button Resume game
                        ButtonController.getButtonResume().setPrefHeight(50);
                        ButtonController.getButtonResume().setPrefWidth(150);
                        ButtonController.getButtonResume().setLayoutX(ButtonController.getButtonMenu().getLayoutX()
                                + ButtonController.getButtonMenu().getPrefWidth() + 50);
                        ButtonController.getButtonResume().setLayoutY(CANVAS_FAKE_HEIGHT - 180);
                        ButtonController.getButtonResume().setStyle("-fx-font: 22 arial");

                        //Button Pause game
                        Button pause = new Button("Pause");
                        pause.setPrefHeight(50);
                        pause.setPrefWidth(150);
                        pause.setLayoutX(ButtonController.getButtonMenu().getLayoutX() + ButtonController.getButtonMenu().getPrefWidth() + 50);
                        pause.setLayoutY(ButtonController.getButtonResume().getLayoutY() - 20 - ButtonController.getButtonResume().getPrefHeight());
                        pause.setStyle("-fx-font: 22 arial");

                        ButtonController.getButtonResume().setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                removeButtonsFromRoot();
                                GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonResume());
                                GlobalVariables.getRoot().getChildren().remove(pause);
                                GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonStartNewGame());
                                start();
                            }
                        });

                        //show menu
                        if (GlobalVariables.getInput().contains("ESCAPE")) {
                            addButtonsToRoot();
                            GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonQuit());
                            GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonResume());
                            GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonStartNewGame());
                            stop();
                        }

                        //Pause control
                        if (GlobalVariables.getInput().contains("P")) {
                            GlobalVariables.getRoot().getChildren().add(pause);
                            GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonResume());
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
                            if(GlobalVariables.getPlayer().getScore() >= 1 && GlobalVariables.getPlayer().getY() <= -50) {
                                level[0] = 2;

                                //set player position in garden
                                GlobalVariables.getPlayer().setPosition(300, 630);

                                playerMovement(GlobalVariables.getIntersectsObject());
                            } else if (level[0] == 1){
                                GM.renderMessage("Congratulations!!!\n You pass the first level please go through the door!",
                                        1, Color.DEEPSKYBLUE, FurnitureObjects.getKitchenTable().getX() + FurnitureObjects
                                                .getKitchenTable().getWidth() - 100, FurnitureObjects.getKitchenTable().getY() + 100);

                                // remove door
                                intersectsObjectLevel1.setIntersectObjectsWithoutDoor();

                                // draw obstacles
                                DrawLevel1.drawWalls(false);

                                playerMovement(intersectsObjectLevel1);

                            } else if(level[0] == 2){
                                playerMovement(GlobalVariables.getIntersectsObject());
                                DrawLevel2.drawGarden();
                                if (GlobalVariables.getPlayer().getX() > 270 &&  GlobalVariables.getPlayer().getX() < 330
                                        && GlobalVariables.getPlayer().getY() > 630) {
                                    level[0] = 1;
                                    GlobalVariables.getPlayer().setPosition(300, 20);
                                }
                            }
                        }
                    }
                }.start();
            }
        });
    }

    private static void removeButtonsFromRoot() {
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getMenu());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonClose());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getMenuTitle());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getMenuSoundText1());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getMenuSoundText2());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonSound());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getKeyboardGuideTitle());
        GlobalVariables.getRoot().getChildren().remove(ButtonController.getKeyboardGuide());
    }

    private static void addButtonsToRoot() {
        GlobalVariables.getRoot().getChildren().add(ButtonController.getMenu());
        GlobalVariables.getRoot().getChildren().add(ButtonController.getMenuTitle());
        GlobalVariables.getRoot().getChildren().add(ButtonController.getMenuSoundText1());
        GlobalVariables.getRoot().getChildren().add(ButtonController.getMenuSoundText2());
        GlobalVariables.getRoot().getChildren().add(ButtonController.getKeyboardGuideTitle());
        GlobalVariables.getRoot().getChildren().add(ButtonController.getKeyboardGuide());
        GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonSound());
    }

    private static void playerMovement(IntersectsObject intersectObject) {
        GlobalVariables.getPlayer().setVelocity(0, 0);
        if (GlobalVariables.getInput().contains("LEFT") && !GlobalVariables.getInput().contains("SPACE")) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().leftBoundary())) {

                Player.checkIfPlayerCollidesUD();

            } else {
                GlobalVariables.setDirection("left");
                Player.move(-180, 0, GlobalVariables.getDirection(), -90, 0);
            }
        }
        if (GlobalVariables.getInput().contains("RIGHT") && !GlobalVariables.getInput().contains("SPACE")) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().rightBoundary())) {

                Player.checkIfPlayerCollidesUD();
            } else {
                GlobalVariables.setDirection("right");
                Player.move(180, 0, GlobalVariables.getDirection(), 90, 0);
            }
        }
        if (GlobalVariables.getInput().contains("UP") && !GlobalVariables.getInput().contains("SPACE")) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().upperBoundary())) {

                Player.checkIfPlayerCollidesLR();
            } else {
                GlobalVariables.setDirection("up");
                Player.move(0, -180, GlobalVariables.getDirection(), 0, -90);
            }
        }
        if (GlobalVariables.getInput().contains("DOWN") && !GlobalVariables.getInput().contains("SPACE")) {
            if (intersectObject.intersect(GlobalVariables.getPlayer().bottomBoundary())) {
                Player.checkIfPlayerCollidesLR();
            } else {
                GlobalVariables.setDirection("down");
                Player.move(0, 180, GlobalVariables.getDirection(), 0, 90);
            }
        }
    }
}