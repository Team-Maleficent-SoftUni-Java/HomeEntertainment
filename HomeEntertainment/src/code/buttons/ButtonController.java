package code.buttons;

import code.global.GlobalVariables;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ButtonController {

    private static final int REQUESTED_WIDTH_SOUND_IMAGE = 30;
    private static final int REQUESTED_HEIGHT_SOUND_IMAGE = 30;
    private static final int BUTTONS_HEIGHT = 50;
    private static final int BUTTONS_WIDTH = 150;
    private static final int BUTTON_MENU_LAYOUT_X = 252;
    private static final int BUTTONS_LAYOUT_Y = 588;
    private static final int START_BUTTON_LAYOUT_X = 452;
    private static final int QUIT_BUTTON_LAYOUT_X = 652;
    private static final int MENU_WIDTH = 550;
    private static final int MENU_HEIGHT = 484;
    private static final int MENU_Y = 92;
    private static final int MENU_TITLE_FONT_SIZE = 43;
    private static final int MENU_TITLE_X = 432;
    private static final int MENU_TITLE_Y = 142;
    private static final int MENU_SOUND_SIZE = 20;
    private static final int MENU_SOUND_TEXT1_X = 312;
    private static final int MENU_SOUND_TEXT1_Y = 192;
    private static final int MENU_SOUND2_SIZE = 15;
    private static final int MENU_SOUND_TEXT2_X = 312;
    private static final int MENU_SOUND_TEXT2_Y = 212;
    private static final int BUTTON_SOUND_X = 262;
    private static final int KEYBOARD_GUIDE_TITLE_X = 262;
    private static final int KEYBOARD_GUIDE_TITLE_Y = 272;
    private static final int KEYBOARD_GUIDE_X = 262;
    private static final int KEYBOARD_GUIDE_Y = 292;
    private static final int KEYBOARD_GUIDE_WRAPPING_WIDTH = 530;
    private static final int BUTTON_SOUND_Y = 172;
    private static final int BUTTON_CLOSE_X = 252;
    private static final int BUTTON_CLOSE_Y = 92;

    private static final String QUIT_BUTTON_TEXT = "Quit";
    private static final String MENU_BUTTON_TEXT = "Settings";
    private static final String BUTTONS_STYLE = "-fx-font: 22 arial";
    private static final String START_BUTTON_TEXT = "Start";
    private static final String SOUND_ON_BUTTON_TEXT = "Sound ON";
    private static final String SOUND_OFF_BUTTON_TEXT = "Affects all sounds and music";
    private static final String KEYBOARD_GUIDE_TITLE = "Keyboard guide:\n";
    private static final String KEYBOARD_GUIDE_TEXT = "\t-'KEYBOARD_P' button - pause;\n\t-'Esc' button - show settings;" +
            "\n\t-'Left' button - player moving left;\n\t-'Right' button - player moving right;" +
            "\n\t-'Up' button - player moving up;\n\t-'Down' button - player moving down;" +
            "\n\t-'Shift' button with combination('Left', 'Right', 'Up', or 'Down' buttons) - player start running;";
    private static final String NEW_GAME_BUTTON_TEXT = "New Game";
    private static final String RESUME_BUTTON_TEXT = "Resume";
    private static final String IMG_DEFINE_URL = "img/not1.png";

    static final Image[] IMAGE_SOUND = {new Image("img/soundOn.png",
            REQUESTED_WIDTH_SOUND_IMAGE, REQUESTED_HEIGHT_SOUND_IMAGE, false, false)};
    static final boolean[] IS_MAIN_WINDOW = {true};

    static Button buttonMenu;
    static Button buttonStart;
    public static Button buttonQuit;
    static Button buttonClose;
    static Button buttonSound;
    public static Button buttonStartNewGame;
    static Button buttonResume;
    public static SequentialTransition blinkedButton;
    static Text menuTitle;
    static Text menuSoundText1;
    static Text menuSoundText2;
    static Text keyboardGuideTitle;
    static Text keyboardGuide;
    static Rectangle menu;

    public static void createButtons() {
        //Button menu
        buttonMenu = new Button(MENU_BUTTON_TEXT);
        buttonMenu.setPrefHeight(BUTTONS_HEIGHT);
        buttonMenu.setPrefWidth(BUTTONS_WIDTH);
        buttonMenu.setLayoutX(BUTTON_MENU_LAYOUT_X);
        buttonMenu.setLayoutY(BUTTONS_LAYOUT_Y);
        buttonMenu.setStyle(BUTTONS_STYLE);
        GlobalVariables.getRoot().getChildren().add(buttonMenu);

        //Button start
        buttonStart = new Button(START_BUTTON_TEXT);
        buttonStart.setPrefHeight(BUTTONS_HEIGHT);
        buttonStart.setPrefWidth(BUTTONS_WIDTH);
        buttonStart.setLayoutX(START_BUTTON_LAYOUT_X);
        buttonStart.setLayoutY(BUTTONS_LAYOUT_Y);
        buttonStart.setStyle(BUTTONS_STYLE);
        GlobalVariables.getRoot().getChildren().add(buttonStart);

        //Button quit
        buttonQuit = new Button(QUIT_BUTTON_TEXT);
        buttonQuit.setPrefHeight(BUTTONS_HEIGHT);
        buttonQuit.setPrefWidth(BUTTONS_WIDTH);
        buttonQuit.setLayoutX(QUIT_BUTTON_LAYOUT_X);
        buttonQuit.setLayoutY(BUTTONS_LAYOUT_Y);
        buttonQuit.setStyle(BUTTONS_STYLE);
        GlobalVariables.getRoot().getChildren().add(buttonQuit);

        //Blink option
        Timeline blinker = Blinker.createBlinker(buttonStart);
        blinkedButton = new SequentialTransition(buttonStart, blinker);

        menuTitle = new Text(MENU_BUTTON_TEXT);
        menuSoundText1 = new Text(SOUND_ON_BUTTON_TEXT);
        menuSoundText2 = new Text(SOUND_OFF_BUTTON_TEXT);
        keyboardGuideTitle = new Text(KEYBOARD_GUIDE_TITLE);
        keyboardGuide = new Text(KEYBOARD_GUIDE_TEXT);
        buttonClose = new Button();
        buttonSound = new Button();
        buttonStartNewGame = new Button(NEW_GAME_BUTTON_TEXT);
        buttonResume = new Button(RESUME_BUTTON_TEXT);
    }

    public static void setButtonsParameters() {
        //Menu params
        menu = new Rectangle(ButtonController.buttonMenu.getLayoutX(), MENU_Y, MENU_WIDTH, MENU_HEIGHT);
        menu.setFill(Color.SKYBLUE);

        //Menu Title
        Font menuTitleFont = Font.font(java.awt.Font.MONOSPACED, MENU_TITLE_FONT_SIZE);
        menuTitle.setFont(menuTitleFont);
        menuTitle.setFill(Color.MEDIUMVIOLETRED);
        menuTitle.setX(MENU_TITLE_X);
        menuTitle.setY(MENU_TITLE_Y);

        //Menu Sound control
        Font menuSound1 = Font.font(java.awt.Font.MONOSPACED, MENU_SOUND_SIZE);
        menuSoundText1.setFont(menuSound1);
        menuSoundText1.setFill(Color.MEDIUMVIOLETRED);
        menuSoundText1.setX(MENU_SOUND_TEXT1_X);
        menuSoundText1.setY(MENU_SOUND_TEXT1_Y);
        Font menuSound2 = Font.font(java.awt.Font.MONOSPACED, MENU_SOUND2_SIZE);
        menuSoundText2.setFont(menuSound2);
        menuSoundText2.setFill(Color.MEDIUMVIOLETRED);
        menuSoundText2.setX(MENU_SOUND_TEXT2_X);
        menuSoundText2.setY(MENU_SOUND_TEXT2_Y);
        keyboardGuideTitle.setFont(menuSound1);
        keyboardGuideTitle.setFill(Color.MEDIUMVIOLETRED);
        keyboardGuideTitle.setX(KEYBOARD_GUIDE_TITLE_X);
        keyboardGuideTitle.setY(KEYBOARD_GUIDE_TITLE_Y);
        keyboardGuide.setFont(menuSound2);
        keyboardGuide.setFill(Color.MEDIUMVIOLETRED);
        keyboardGuide.setX(KEYBOARD_GUIDE_X);
        keyboardGuide.setY(KEYBOARD_GUIDE_Y);
        keyboardGuide.setWrappingWidth(KEYBOARD_GUIDE_WRAPPING_WIDTH);

        //Button Sound
        buttonSound.setGraphic(new ImageView(IMAGE_SOUND[0]));
        buttonSound.setLayoutX(BUTTON_SOUND_X);
        buttonSound.setLayoutY(BUTTON_SOUND_Y);

        //Button Menu close
        Image imageDecline = new Image(IMG_DEFINE_URL, REQUESTED_WIDTH_SOUND_IMAGE,
                REQUESTED_HEIGHT_SOUND_IMAGE, false, false);
        buttonClose.setGraphic(new ImageView(imageDecline));
        buttonClose.setLayoutX(BUTTON_CLOSE_X);
        buttonClose.setLayoutY(BUTTON_CLOSE_Y);
    }
}