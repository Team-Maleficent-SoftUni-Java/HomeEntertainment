package code.graphics;

import code.global.GlobalVariables;
import code.intersectObjects.IntersectsObjectLevel2;
import code.player.Sprite;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.List;

import static code.global.GlobalVariables.CANVAS_FAKE_HEIGHT;
import static code.graphics.ImageController.*;
import static code.graphics.ImageController.BRICK_SINGLE_HORIZONTAL;
import static code.graphics.ImageController.BRICK_SINGLE_VERTICAL;

public class DrawLevel2 {

    public static List<Sprite> plants = new ArrayList<>();

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

            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getDownBorder());
            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getUpperBorder());
            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getLeftBorder());
            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getRightBorder());
        }

        createPlant();

        GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());

        //draw down border
        for (int i = 0; i < 4 ; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25, CANVAS_FAKE_HEIGHT - (2 * BRICK_SINGLE_HORIZONTAL.getHeight() - 20));
        }

        for (int i = 6; i < GlobalVariables.getCanvas().getWidth() ; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25, CANVAS_FAKE_HEIGHT - (2 * BRICK_SINGLE_HORIZONTAL.getHeight() - 20));
        }

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
        boolean intersects = false;
        if (GlobalVariables.getInput().contains("Q")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFirstTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFirstTree());
                addIntersectObjectLevel2("tree");
            }
        } else if (GlobalVariables.getInput().contains("W")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getSecondTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getSecondTree());
                addIntersectObjectLevel2("tree");
            }
        } else if (GlobalVariables.getInput().contains("E")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getThirdTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getThirdTree());
                addIntersectObjectLevel2("tree");
            }
        } else if (GlobalVariables.getInput().contains("R")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFirstFlower() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFirstFlower());
                addIntersectObjectLevel2("flower");
            }
        } else if (GlobalVariables.getInput().contains("T")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getSecondFlower() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getSecondFlower());
                addIntersectObjectLevel2("flower");
            }
        } else if (GlobalVariables.getInput().contains("Y")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getThirdFlower() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getThirdFlower());
                addIntersectObjectLevel2("flower");
            }
        } else if (GlobalVariables.getInput().contains("U")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getDwarf() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getDwarf());
                addIntersectObjectLevel2("dwarf");
            }
        } else if (GlobalVariables.getInput().contains("I")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFountain() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFountain());
                addIntersectObjectLevel2("fountain");
            }
        } else if (GlobalVariables.getInput().contains("O")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFern() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFern());
                addIntersectObjectLevel2("fern");
            }
        } else if (GlobalVariables.getInput().contains("A")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getSmallRock() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getSmallRock());
                addIntersectObjectLevel2("smallRock");
            }
        } else if (GlobalVariables.getInput().contains("S")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getBigRock() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getBigRock());
                addIntersectObjectLevel2("bigRock");
            }
        } else if (GlobalVariables.getInput().contains("D")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFourthTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFourthTree());
                addIntersectObjectLevel2("tree");
            }
        } else if (GlobalVariables.getInput().contains("F")) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFifthTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFifthTree());
                addIntersectObjectLevel2("tree");
            }
        } else if (GlobalVariables.getInput().contains("Z")) {
            GlobalVariables.getInput().clear();
            removeIntersectObjectLevel2();
            if (!plants.isEmpty()) {
                plants.remove(plants.size() - 1);
            }
        }
    }

    private static void addIntersectObjectLevel2(String type) {
        Sprite gardenObject = plants.get(plants.size() - 1);
        Rectangle2D rectangle2D = null;
        switch (type) {
            case "tree":
                rectangle2D = new Rectangle2D(gardenObject.getX() + gardenObject.getWidth() / 2 - 20,
                        gardenObject.getY() + gardenObject.getHeight() - 20, 20, 20);
                break;
            case "flower":
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "dwarf":
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "bigRock":
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "smallRock":
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "fern":
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - 20, gardenObject.getWidth(), 20);
                break;
            case "fountain":
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - 50, gardenObject.getWidth(), 50);
                break;
        }
        if(rectangle2D != null) {
            GlobalVariables.getIntersectsObject().addElement(rectangle2D);
        }
    }

    private static void removeIntersectObjectLevel2() {
        Rectangle2D rectangle2D = GlobalVariables.getIntersectsObject().getRectangle2DList()
                .get(GlobalVariables.getIntersectsObject().getRectangle2DList().size() - 1);
        GlobalVariables.getIntersectsObject().removeElement(rectangle2D);
    }
}