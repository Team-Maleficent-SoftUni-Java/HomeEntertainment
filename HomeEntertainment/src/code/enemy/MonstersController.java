package code.enemy;

import code.achievments.AchievementController;
import code.achievments.GameMessage;
import code.buttons.ButtonController;
import code.global.GlobalVariables;
import code.graphics.FurnitureObjects;
import code.intersectObjects.IntersectsObjectLevel1;
import code.player.Sprite;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class MonstersController {

    private static final int MONSTER_IMAGE_REQUESTED_WIDTH = 50;
    private static final int MONSTER_IMAGE_REQUESTED_HEIGHT = 44;
    private static final int MAXIMUM_MONSTERS_COUNT = 15;
    private static final int ATTACK_SOUND_VOLUME = 1;
    private static final int ATTACK_SOUND_BALANCE = 0;
    private static final double ATTACK_SOUND_RATE = 1.0;
    private static final double ATTACK_SOUND_PAN = 0.0;
    private static final int ATTACK_SOUND_PRIORITY = -5;
    private static final int GAME_OVER_MESSAGE_DURATION = 100000000;
    private static final int PLAYER_MIN_HEALTH = 0;
    private static final int MONSTERS_MAX_COUNT = 200;
    private static final int GAME_OVER_MESSAGE_X = 317;
    private static final int GAME_OVER_MESSAGE_Y = 299;
    private static final int MONSTER_RANDOM_POSITION_ADDITION = 100;

    private static ArrayDeque<String> monstersImages;

    public static void setMonsterImages() {
        monstersImages = new ArrayDeque<>();
        monstersImages.addLast("img/monster.gif");
        monstersImages.addLast("img/monster1.png");
        monstersImages.addLast("img/monster2.png");
    }

    public static void createMonsters() {
        GlobalVariables.setMonsterList(new ArrayDeque<>());
        for (int i = 0; i < MAXIMUM_MONSTERS_COUNT; i++) {
            Sprite monster = new Sprite();
            String tempImage = monstersImages.pop();
            monstersImages.addLast(tempImage);
            Image monsterImage = new Image(tempImage, MONSTER_IMAGE_REQUESTED_WIDTH, MONSTER_IMAGE_REQUESTED_HEIGHT,
                    false, false);
            monster.setImage(monsterImage);
            GlobalVariables.getMonsterList().add(monster);
        }
    }

    public static void checkCollision(AnimationTimer animationTimer) {
        AchievementController AM = new AchievementController(GlobalVariables.getPlayer(),
                GlobalVariables.getGraphicContext(), GlobalVariables.getRoot());
        GameMessage GM = new GameMessage(GlobalVariables.getPlayer(), GlobalVariables.getRoot());

        for (Sprite monster : GlobalVariables.getMonstersToRender()) {
            if (GlobalVariables.getPlayer().intersects(monster)) {

                GM.renderMessage("Ouch!", 2, Color.RED, GlobalVariables.getPlayer().getX(), GlobalVariables.getPlayer().getY());
                if (!GlobalVariables.getMute()[0]  && !GlobalVariables.getAttack().isPlaying()) {
                    GlobalVariables.getAttack().play(ATTACK_SOUND_VOLUME, ATTACK_SOUND_BALANCE, ATTACK_SOUND_RATE,
                            ATTACK_SOUND_PAN, ATTACK_SOUND_PRIORITY);
                }

                if ((int) GlobalVariables.getPlayer().getPlayerHealth() <= PLAYER_MIN_HEALTH)
                    GM.renderMessage("Bugs owned the house and ate you, Game Over!", GAME_OVER_MESSAGE_DURATION,
                            Color.RED, GAME_OVER_MESSAGE_X, GAME_OVER_MESSAGE_Y);

                GlobalVariables.getPlayer().subtractPlayerHealth();

                if (GlobalVariables.getPlayer().getPlayerHealth() <= PLAYER_MIN_HEALTH) {
                    GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonQuit);
                    GlobalVariables.getRoot().getChildren().add(ButtonController.buttonQuit);
                    GlobalVariables.getRoot().getChildren().remove(ButtonController.buttonStartNewGame);
                    GlobalVariables.getRoot().getChildren().add(ButtonController.buttonStartNewGame);
                    animationTimer.stop();
                }

                AM.observe();
            }
        }
    }

    public static void displayMonsters(AtomicInteger monsterCounter) {
        IntersectsObjectLevel1 intersectObject = new IntersectsObjectLevel1();

        monsterCounter.addAndGet(1);
        if (monsterCounter.get() == MONSTERS_MAX_COUNT) {
            Sprite tempMonster = GlobalVariables.getMonsterList().pop();
            GlobalVariables.getMonsterList().addLast(tempMonster);
            double px = (GlobalVariables.getPlayer().getX() * Math.random() + MONSTER_RANDOM_POSITION_ADDITION);
            double py = (GlobalVariables.getPlayer().getY() * Math.random() + MONSTER_RANDOM_POSITION_ADDITION);
            tempMonster.setPosition(px, py);
            if (!intersectObject.intersect(tempMonster)) {
                GlobalVariables.getMonstersToRender().add(tempMonster);
            }
            monsterCounter.set(0);
        }

        for (Sprite monster : GlobalVariables.getMonstersToRender()) {
            monster.render(GlobalVariables.getGraphicContext());
        }
    }
}