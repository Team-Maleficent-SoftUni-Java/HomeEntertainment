package code.Graphics;

import code.GlobalVariables;
import code.Player.Player;
import code.Player.Sprite;
import jdk.nashorn.internal.objects.Global;

import java.util.ArrayList;
import java.util.List;

public class DrawLevel2 {

    private static List<Sprite> plants = new ArrayList<>();

    public static void drawGarden() {

        //draw garden
        GlobalVariables.getGraphicContext().clearRect(0, 0, 1024, 768);

        //draw garden grass
        int y = 0;
        for (int i = 0; i < 5; i++) {
            int x = 0;
            for (int j = 0; j < 5; j++) {
                GlobalVariables.getGraphicContext().drawImage(ImageController.getGardenGrass(), x, y);
                x += GlobalVariables.getCanvas().getWidth() / 5;
            }
            y += GlobalVariables.getCanvas().getHeight() / 5;
        }

        //draw gardenFence
        int x = 0;
        for (int i = 0; i < 15; i++) {
            GlobalVariables.getGraphicContext().drawImage(ImageController.getGardenFence(), x, 0);
            x += 90;
        }

        //Stats board
        GlobalVariables.getGraphicContext().drawImage(ImageController.getStatsBoard(), GlobalVariables.getCanvas().getWidth() - 240, 3);

        //Display scores on the stats board
        String pointsText = "Points: " + GlobalVariables.getPlayer().getScore();
        GlobalVariables.getGraphicContext().fillText(pointsText, GlobalVariables.getCanvas().getWidth()
                - ImageController.getStatsBoard().getWidth() + 5, GlobalVariables.getCanvas().getLayoutY() + 40);

        //Display health on stats board
        String healthText = "Health " + (int) (GlobalVariables.getPlayer().getPlayerHealth()) + "%";

        GlobalVariables.getGraphicContext().fillText(healthText, GlobalVariables.getCanvas().getWidth()
                - ImageController.getStatsBoard().getWidth() + 5, GlobalVariables.getCanvas().getLayoutY() + 20);

        if(GlobalVariables.getInput().contains("Q")) {
            plants.add(plant().getFirstTree());
            //GlobalVariables.getPlayer().addScore(Plant.TREE_POINTS);
        } else if (GlobalVariables.getInput().contains("W")) {
            plants.add(plant().getSecondTree());
            //GlobalVariables.getPlayer().addScore(Plant.TREE_POINTS);
        } else if (GlobalVariables.getInput().contains("E")) {
            plants.add(plant().getThirdTree());
            //GlobalVariables.getPlayer().addScore(Plant.TREE_POINTS);
        } else if (GlobalVariables.getInput().contains("R")) {
            plants.add(plant().getFirstFlower());
            //GlobalVariables.getPlayer().addScore(Plant.FLOWER_POINTS);
        } else if (GlobalVariables.getInput().contains("T")) {
            plants.add(plant().getSecondFlower());
            //GlobalVariables.getPlayer().addScore(Plant.FLOWER_POINTS);
        } else if (GlobalVariables.getInput().contains("Y")) {
            plants.add(plant().getThirdFlower());
            //GlobalVariables.getPlayer().addScore(Plant.FLOWER_POINTS);
        } else if (GlobalVariables.getInput().contains("U")) {
            plants.add(plant().getDwarf());
            //GlobalVariables.getPlayer().addScore(Plant.DWARF_POINTS);
        } else if (GlobalVariables.getInput().contains("I")) {
            plants.add(plant().getFountain());
            //GlobalVariables.getPlayer().addScore(Plant.FOUNTAIN_POINTS);
        } else if (GlobalVariables.getInput().contains("O")) {
            plants.add(plant().getFern());
            //GlobalVariables.getPlayer().addScore(Plant.FERN_POINTS);
        } else if (GlobalVariables.getInput().contains("A")) {
            plants.add(plant().getSmallRock());
            //GlobalVariables.getPlayer().addScore(Plant.SMALL_ROCK_POINTS);
        } else if (GlobalVariables.getInput().contains("S")) {
            plants.add(plant().getBigRock());
            //GlobalVariables.getPlayer().addScore(Plant.BIG_ROCK__POINTS);
        } else if (GlobalVariables.getInput().contains("D")) {
            plants.add(plant().getFourthTree());
            //GlobalVariables.getPlayer().addScore(Plant.BIG_ROCK__POINTS);
        } else if (GlobalVariables.getInput().contains("F")) {
            plants.add(plant().getFifthTree());
            //GlobalVariables.getPlayer().addScore(Plant.BIG_ROCK__POINTS);
        } else if (GlobalVariables.getInput().contains("Z")) {
            plants.remove(plants.size() - 1);
        }

        for (Sprite plant1 : plants) {
            plant1.render(GlobalVariables.getGraphicContext());
        }
        GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
    }

    public static Plant plant() {
        double x = GlobalVariables.getPlayer().getX() + GlobalVariables.getPlayer().getWidth();
        double y = GlobalVariables.getPlayer().getY() + GlobalVariables.getPlayer().getHeight();
        return new Plant(x, y);
    }
}