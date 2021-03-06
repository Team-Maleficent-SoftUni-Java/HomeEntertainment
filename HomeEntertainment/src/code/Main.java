package code;

import code.buttons.GameActionController;
import code.buttons.ButtonController;
import code.enemy.MonstersController;
import code.graphics.DrawLevel1;
import code.graphics.ImageController;
import code.intersectObjects.IntersectsObject;
import code.player.Player;
import code.sounds.SoundController;
import code.global.GlobalVariables;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {

        //Set stage properties
        theStage.setTitle("Home entertainment");
        GlobalVariables.setRoot(new Group());
        GlobalVariables.setIntersectsObject(new IntersectsObject());
        Scene theScene = new Scene(GlobalVariables.getRoot(), GlobalVariables.CANVAS_WIDTH,
                GlobalVariables.CANVAS_HEIGHT, Color.WHITESMOKE);
        theStage.setScene(theScene);
        GlobalVariables.getRoot().getChildren().add(GlobalVariables.getCanvas());

        // Define object images
        ImageController.defineImages();

        //Set player images for all directions
        ImageController.setPlayerRightImages(new ArrayDeque<>());
        ImageController.setPlayerLeftImages(new ArrayDeque<>());
        ImageController.setPlayerDownImages(new ArrayDeque<>());
        ImageController.setPlayerUpImages(new ArrayDeque<>());

        //Set monster images
        MonstersController.setMonsterImages();

        //Start create different monsters
        MonstersController.createMonsters();
        GlobalVariables.setMonstersToRender(new ArrayList<>());

        //Take the keys inputs
        GlobalVariables.setInput(new ArrayList<>());

        //add event handlers on the scene
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!GlobalVariables.getInput().contains(code))
                            GlobalVariables.getInput().add(code);
                    }
                });
        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        GlobalVariables.getInput().remove(code);
                    }
                });

        //Display introduce on Main page
        DrawLevel1.displayIntroduce();

        //Display all objects in the house.
        DrawLevel1.displayObjects();

        // Load sounds
        SoundController.loadSounds();

        //CreateButtons
        ButtonController.createButtons();

        //Set all buttons parameters
        ButtonController.setButtonsParameters();

        //Set all buttons events
        GameActionController.attachSoundButtonEvent();
        GameActionController.attachCloseButtonEvent();
        GameActionController.attachButtonMenuAction();
        GameActionController.attachButtonQuitAction(theStage);
        GameActionController.attachButtonStartAction(theStage);
        theStage.show();
        ButtonController.blinkedButton.play();
    }
}