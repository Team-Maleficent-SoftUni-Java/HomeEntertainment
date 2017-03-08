package code.Graphics;

import code.GlobalVariables;
import code.IntersectObjects.IntersectsObject;
import code.IntersectObjects.IntersectsObjectLevel2;
import code.Player.Player;
import code.Player.Sprite;
import javafx.geometry.Rectangle2D;
import jdk.nashorn.internal.objects.Global;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawLevel2 {

    private static List<Sprite> plants = new ArrayList<>();

    public static List<Rectangle2D> getPlants() {
        return convertSpriteToRectList();
    }

    private static List<Rectangle2D> convertSpriteToRectList() {
        List<Rectangle2D> rectangle2DList = new ArrayList<>();

        for (Sprite plant : plants) {
            rectangle2DList.add(plant.getBoundary());
        }
        return rectangle2DList;
    }

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

        if (plants.size() == 0) {
            GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
        }

        createPlant();

        GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getDownBorder());
        GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getUpperBorder());
        GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getLeftBorder());
        GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getRightBorder());

        GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());

        for (Sprite plant1 : plants) {
            if (plant1.intersects(GlobalVariables.getPlayer())) {
                if (plant1.getY() + plant1.getHeight() > GlobalVariables.getPlayer().getY() + GlobalVariables.getPlayer().getHeight()) {
                    GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
                    plant1.render(GlobalVariables.getGraphicContext());
                } else if (plant1.getY() + plant1.getHeight() <= GlobalVariables.getPlayer().getY() + GlobalVariables.getPlayer().getHeight()) {
                    plant1.render(GlobalVariables.getGraphicContext());
                    GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
                }
            } else {
                plant1.render(GlobalVariables.getGraphicContext());
            }
        }
    }

    private static Plant plant() {
        double x = GlobalVariables.getPlayer().getX() + GlobalVariables.getPlayer().getWidth();
        double y = GlobalVariables.getPlayer().getY() + GlobalVariables.getPlayer().getHeight();
        return new Plant(x, y);
    }

    private static void createPlant() {
        if (GlobalVariables.getInput().contains("Q")) {
            plants.add(plant().getFirstTree());
            addIntersectObjectLevel2("tree");
            //GlobalVariables.getPlayer().addScore(Plant.TREE_POINTS);
        } else if (GlobalVariables.getInput().contains("W")) {
            plants.add(plant().getSecondTree());
            addIntersectObjectLevel2("tree");
            //GlobalVariables.getPlayer().addScore(Plant.TREE_POINTS);
        } else if (GlobalVariables.getInput().contains("E")) {
            plants.add(plant().getThirdTree());
            addIntersectObjectLevel2("tree");
            //GlobalVariables.getPlayer().addScore(Plant.TREE_POINTS);
        } else if (GlobalVariables.getInput().contains("R")) {
            plants.add(plant().getFirstFlower());
            addIntersectObjectLevel2("flower");
            //GlobalVariables.getPlayer().addScore(Plant.FLOWER_POINTS);
        } else if (GlobalVariables.getInput().contains("T")) {
            plants.add(plant().getSecondFlower());
            addIntersectObjectLevel2("flower");
            //GlobalVariables.getPlayer().addScore(Plant.FLOWER_POINTS);
        } else if (GlobalVariables.getInput().contains("Y")) {
            plants.add(plant().getThirdFlower());
            addIntersectObjectLevel2("flower");
            //GlobalVariables.getPlayer().addScore(Plant.FLOWER_POINTS);
        } else if (GlobalVariables.getInput().contains("U")) {
            plants.add(plant().getDwarf());
            addIntersectObjectLevel2("dwarf");
            //GlobalVariables.getPlayer().addScore(Plant.DWARF_POINTS);
        } else if (GlobalVariables.getInput().contains("I")) {
            plants.add(plant().getFountain());
            addIntersectObjectLevel2("fountain");
            //GlobalVariables.getPlayer().addScore(Plant.FOUNTAIN_POINTS);
        } else if (GlobalVariables.getInput().contains("O")) {
            plants.add(plant().getFern());
            addIntersectObjectLevel2("fern");
            //GlobalVariables.getPlayer().addScore(Plant.FERN_POINTS);
        } else if (GlobalVariables.getInput().contains("A")) {
            plants.add(plant().getSmallRock());
            addIntersectObjectLevel2("smallRock");
            //GlobalVariables.getPlayer().addScore(Plant.SMALL_ROCK_POINTS);
        } else if (GlobalVariables.getInput().contains("S")) {
            plants.add(plant().getBigRock());
            addIntersectObjectLevel2("bigRock");
            //GlobalVariables.getPlayer().addScore(Plant.BIG_ROCK__POINTS);
        } else if (GlobalVariables.getInput().contains("D")) {
            plants.add(plant().getFourthTree());
            addIntersectObjectLevel2("tree");
            //GlobalVariables.getPlayer().addScore(Plant.BIG_ROCK__POINTS);
        } else if (GlobalVariables.getInput().contains("F")) {
            plants.add(plant().getFifthTree());
            addIntersectObjectLevel2("tree");
            //GlobalVariables.getPlayer().addScore(Plant.BIG_ROCK__POINTS);
        } else if (GlobalVariables.getInput().contains("Z")) {
            removeIntersectObjectLevel2();
            plants.remove(plants.size() - 1);
        }
    }

    private static void addIntersectObjectLevel2(String type) {
        Sprite gardenObject = plants.get(plants.size() - 1);
        Rectangle2D rectangle2D = null;
        switch (type) {
            case "tree":
                rectangle2D = new Rectangle2D(gardenObject.getX() + gardenObject.getWidth() / 2 - 20, gardenObject.getY() + gardenObject.getHeight() - 20, 20, 20);
                break;
            case "flower":
                rectangle2D = new Rectangle2D(gardenObject.getX(), gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "dwarf":
                rectangle2D = new Rectangle2D(gardenObject.getX(), gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "bigRock":
                rectangle2D = new Rectangle2D(gardenObject.getX(), gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "smallRock":
                rectangle2D = new Rectangle2D(gardenObject.getX(), gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "fern":
                rectangle2D = new Rectangle2D(gardenObject.getX(), gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "fountain":
                rectangle2D = new Rectangle2D(gardenObject.getX(), gardenObject.getY() + gardenObject.getHeight() - 50, gardenObject.getWidth(), 50);
                break;
        }
        if(rectangle2D != null) {
            GlobalVariables.getIntersectsObject().addElement(rectangle2D);
        }
    }

    private static void removeIntersectObjectLevel2() {
        Rectangle2D rectangle2D = GlobalVariables.getIntersectsObject().getRectangle2DList().get(GlobalVariables.getIntersectsObject().getRectangle2DList().size() - 1);
        GlobalVariables.getIntersectsObject().removeElement(rectangle2D);

    }
}