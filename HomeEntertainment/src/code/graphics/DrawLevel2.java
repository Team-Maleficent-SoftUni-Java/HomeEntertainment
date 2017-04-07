package code.graphics;

import code.global.GlobalVariables;
import code.intersectObjects.IntersectsObjectLevel2;
import code.player.Player;
import code.player.Sprite;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.List;

import static code.global.GlobalVariables.CANVAS_HEIGHT;
import static code.graphics.ImageController.BRICK_SINGLE_HORIZONTAL;
import static code.graphics.ImageController.BRICK_SINGLE_VERTICAL;

public class DrawLevel2 {

    private static final int TREE_WIDTH_AND_HEIGHT = 20;
    private static final int FOUNTAIN_HEIGHT = 50;
    private static final String KEYBOARD_Q = "Q";
    private static final String KEYBOARD_W = "W";
    private static final String KEYBOARD_E = "E";
    private static final String KEYBOARD_R = "R";
    private static final String KEYBOARD_T = "T";
    private static final String KEYBOARD_Y = "Y";
    private static final String KEYBOARD_U = "U";
    private static final String KEYBOARD_I = "I";
    private static final String KEYBOARD_O = "O";
    private static final String KEYBOARD_A = "A";
    private static final String KEYBOARD_S = "S";
    private static final String KEYBOARD_D = "D";
    private static final String KEYBOARD_F = "F";
    private static final String KEYBOARD_Z = "Z";
    private static final String TREE_TYPE = "tree";
    private static final String FLOWER_TYPE = "flower";
    private static final String DWARF_TYPE = "dwarf";
    private static final String FOUNTAIN_TYPE = "fountain";
    private static final String FERN_TYPE = "fern";
    private static final String SMALL_ROCK_TYPE = "smallRock";
    private static final String BIG_ROCK_TYPE = "bigRock";

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
        GlobalVariables.getGraphicContext().clearRect(GlobalVariables.CANVAS_X_Y, GlobalVariables.CANVAS_X_Y,
                GlobalVariables.CANVAS_WIDTH, GlobalVariables.CANVAS_HEIGHT);

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
            Player.getInstance().render(GlobalVariables.getGraphicContext());

            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getDownBorder());
            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getUpperBorder());
            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getLeftBorder());
            GlobalVariables.getIntersectsObject().addElement(IntersectsObjectLevel2.getRightBorder());
        }

        createPlant();

        Player.getInstance().render(GlobalVariables.getGraphicContext());

        //draw down border
        for (int i = 0; i < 4 ; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25, CANVAS_HEIGHT - (2 * BRICK_SINGLE_HORIZONTAL.getHeight() - 20));
        }

        for (int i = 6; i < GlobalVariables.getCanvas().getWidth() ; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25, CANVAS_HEIGHT - (2 * BRICK_SINGLE_HORIZONTAL.getHeight() - 20));
        }

        for (Sprite plant1 : plants) {
            if (plant1.intersects(Player.getInstance())) {
                if (plant1.getY() + plant1.getHeight() > Player.getInstance().getY() + Player.getInstance().getHeight()) {
                    Player.getInstance().render(GlobalVariables.getGraphicContext());
                    plant1.render(GlobalVariables.getGraphicContext());
                } else if (plant1.getY() + plant1.getHeight() <= Player.getInstance().getY() + Player.getInstance().getHeight()) {
                    plant1.render(GlobalVariables.getGraphicContext());
                    Player.getInstance().render(GlobalVariables.getGraphicContext());
                }
            } else {
                plant1.render(GlobalVariables.getGraphicContext());
            }
        }
    }

    private static Plant plant() {
        double x = Player.getInstance().getX() + Player.getInstance().getWidth();
        double y = Player.getInstance().getY() + Player.getInstance().getHeight();
        return new Plant(x, y);
    }

    private static void createPlant() {
        boolean intersects = false;
        if (GlobalVariables.getInput().contains(KEYBOARD_Q)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFirstTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFirstTree());
                addIntersectObjectLevel2(TREE_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_W)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getSecondTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getSecondTree());
                addIntersectObjectLevel2(TREE_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_E)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getThirdTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getThirdTree());
                addIntersectObjectLevel2(TREE_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_R)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFirstFlower() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFirstFlower());
                addIntersectObjectLevel2(FLOWER_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_T)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getSecondFlower() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getSecondFlower());
                addIntersectObjectLevel2(FLOWER_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_Y)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getThirdFlower() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getThirdFlower());
                addIntersectObjectLevel2(FLOWER_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_U)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getDwarf() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getDwarf());
                addIntersectObjectLevel2(DWARF_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_I)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFountain() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFountain());
                addIntersectObjectLevel2(FOUNTAIN_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_O)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFern() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFern());
                addIntersectObjectLevel2(FERN_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_A)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getSmallRock() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getSmallRock());
                addIntersectObjectLevel2(SMALL_ROCK_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_S)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getBigRock() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getBigRock());
                addIntersectObjectLevel2(BIG_ROCK_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_D)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFourthTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFourthTree());
                addIntersectObjectLevel2(TREE_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_F)) {
            GlobalVariables.getInput().clear();
            for (Sprite plant : plants) {
                if (plant().getFifthTree() .intersects(plant)) {
                    intersects = true;
                }
            }
            if (!intersects) {
                plants.add(plant().getFifthTree());
                addIntersectObjectLevel2(TREE_TYPE);
            }
        } else if (GlobalVariables.getInput().contains(KEYBOARD_Z)) {
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
            case TREE_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX() + gardenObject.getWidth() / 2 - TREE_WIDTH_AND_HEIGHT,
                        gardenObject.getY() + gardenObject.getHeight() - TREE_WIDTH_AND_HEIGHT,
                        TREE_WIDTH_AND_HEIGHT, TREE_WIDTH_AND_HEIGHT);
                break;
            case FLOWER_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - TREE_WIDTH_AND_HEIGHT,
                        gardenObject.getWidth(), TREE_WIDTH_AND_HEIGHT);
                break;
            case DWARF_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - TREE_WIDTH_AND_HEIGHT,
                        gardenObject.getWidth(), TREE_WIDTH_AND_HEIGHT);
                break;
            case BIG_ROCK_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - TREE_WIDTH_AND_HEIGHT,
                        gardenObject.getWidth(), TREE_WIDTH_AND_HEIGHT);
                break;
            case SMALL_ROCK_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - TREE_WIDTH_AND_HEIGHT,
                        gardenObject.getWidth(), TREE_WIDTH_AND_HEIGHT);
                break;
            case FERN_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - TREE_WIDTH_AND_HEIGHT,
                        gardenObject.getWidth(), TREE_WIDTH_AND_HEIGHT);
                break;
            case FOUNTAIN_TYPE:
                rectangle2D = new Rectangle2D(gardenObject.getX(),
                        gardenObject.getY() + gardenObject.getHeight() - FOUNTAIN_HEIGHT,
                        gardenObject.getWidth(), FOUNTAIN_HEIGHT);
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