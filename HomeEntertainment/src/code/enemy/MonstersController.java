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

    private static ArrayDeque<String> monstersImages;

    public static void setMonsterImages() {
        monstersImages = new ArrayDeque<>();
        monstersImages.addLast("img/monster.gif");
        monstersImages.addLast("img/monster1.png");
        monstersImages.addLast("img/monster2.png");
    }

    public static void createMonsters() {
        GlobalVariables.setMonsterList(new ArrayDeque<>());
        for (int i = 0; i < 15; i++) {
            Sprite monster = new Sprite();
            String tempImage = monstersImages.pop();
            monstersImages.addLast(tempImage);
            Image monsterImage = new Image(tempImage, 50, 44, false, false);
            monster.setImage(monsterImage);
            GlobalVariables.getMonsterList().add(monster);
        }
    }

    public static void checkCollision(AnimationTimer animationTimer) {
        AchievementController AM = new AchievementController(GlobalVariables.getPlayer(), GlobalVariables.getGraphicContext(), GlobalVariables.getRoot());
        GameMessage GM = new GameMessage(GlobalVariables.getPlayer(), GlobalVariables.getRoot());

        for (Sprite monster : GlobalVariables.getMonstersToRender()) {
            if (GlobalVariables.getPlayer().intersects(monster)) {

                GM.renderMessage("Ouch!", 2, Color.RED, GlobalVariables.getPlayer().getX(), GlobalVariables.getPlayer().getY());
                if (!GlobalVariables.getMute()[0]  && !GlobalVariables.getAttack().isPlaying()) {
                    GlobalVariables.getAttack().play(1, 0, 1.0, 0.0, -5);
                }

                if ((int) GlobalVariables.getPlayer().getPlayerHealth() <= 0)
                    GM.renderMessage("Bugs owned the house and ate you, Game Over!", 1000000000, Color.RED, FurnitureObjects.getKitchenTable().getX() + FurnitureObjects.getKitchenTable().getWidth() + 20, FurnitureObjects.getKitchenTable().getY() + 100);

                GlobalVariables.getPlayer().subtractPlayerHealth();

                if (GlobalVariables.getPlayer().getPlayerHealth() <= 0) {
                    GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonQuit());
                    GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonQuit());
                    GlobalVariables.getRoot().getChildren().remove(ButtonController.getButtonStartNewGame());
                    GlobalVariables.getRoot().getChildren().add(ButtonController.getButtonStartNewGame());
                    animationTimer.stop();
                }

                AM.observe();
            }
        }
    }

    public static void displayMonsters(AtomicInteger monsterCounter) {
        IntersectsObjectLevel1 intersectObject = new IntersectsObjectLevel1();

        monsterCounter.addAndGet(1);
        if (monsterCounter.get() == 200) {
            Sprite tempMonster = GlobalVariables.getMonsterList().pop();
            GlobalVariables.getMonsterList().addLast(tempMonster);
            double px = (GlobalVariables.getPlayer().getX() * Math.random() + 100);
            double py = (GlobalVariables.getPlayer().getY() * Math.random() + 100);
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