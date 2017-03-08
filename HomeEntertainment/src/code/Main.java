package code;

import code.Buttons.ButtonEventsController;
import code.Buttons.ButtonController;
import code.Enemy.MonstersController;
import code.Graphics.GraphicController;
import code.Graphics.ImageController;
import code.Player.Player;
import code.Sounds.SoundController;
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
        Scene theScene = new Scene(GlobalVariables.getRoot(), 1024, 768, Color.WHITESMOKE);
        theStage.setScene(theScene);
        GlobalVariables.getRoot().getChildren().add(GlobalVariables.getCanvas());

        // Define object images
        ImageController.defineImages();

        //Set player images for all directions
        ImageController.setPlayerRightImages(new ArrayDeque<>());
        ImageController.setPlayerLeftImages(new ArrayDeque<>());
        ImageController.setPlayerDownImages(new ArrayDeque<>());
        ImageController.setPlayerUpImages(new ArrayDeque<>());

        //Create the player object
        Player.createPlayerObject();

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
        GraphicController.displayIntroduce();

        //Display all objects in the house.
        GraphicController.displayObjects();

        // Load sounds
        SoundController.loadSounds();

        //CreateButtons
        ButtonController.createButtons();

        //Set all buttons parameters
        ButtonController.setButtonsParameters();

        //Set all buttons events
        ButtonEventsController.attachSoundButtonEvent();
        ButtonEventsController.attachCloseButtonEvent();
        ButtonEventsController.attachButtonMenuAction();
        ButtonEventsController.attachButtonQuitAction(theStage);
        ButtonEventsController.attachButtonStartAction(theStage);
        theStage.show();
        ButtonController.getBlinkedButton().play();
    }
}