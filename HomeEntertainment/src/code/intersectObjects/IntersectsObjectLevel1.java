package code.intersectObjects;

import code.global.GlobalVariables;
import code.graphics.FurnitureObjects;
import code.graphics.ImageController;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static code.global.GlobalVariables.*;
import static code.graphics.ImageController.*;

public class IntersectsObjectLevel1 extends IntersectsObject{

    private static final int TOILET_HEIGHT = 50;
    private static final int BATHROOM_SINK_HEIGHT = 70;
    private static final double COFFEE_TABLE_HEIGHT = 3 * (ImageController.getCarpet().getHeight() / 4) - 30;
    private static final double LIVING_ROOM_DRESSER_HEIGHT =
            ImageController.getCarpet().getHeight() / 4 + BRICK_SINGLE_HORIZONTAL.getHeight();
    private static final int RIGHT_BORDER_HEIGHT = GlobalVariables.CANVAS_HEIGHT + 40;
    private static final int DOOR_X = 270;
    private static final int DOOR_Y = -20;
    private static final int DOOR_WIDTH = 110;
    private static final int DOOR_HEIGHT = 120;
    private static final double SOFA_HEIGHT = ImageController.getCarpet().getHeight() / 2 + (2 * BRICK_SINGLE_HORIZONTAL.getHeight());
    private static final double TV_Y = FurnitureObjects.getTv().getY() + 100;
    private static final double DESK_Y = FurnitureObjects.getDesk().getY() + 40;
    private static final double BATH_HUB_Y = FurnitureObjects.getBathtub().getY() + 100;
    private static final int LEFT_BORDER_X_AND_Y = 0;
    private static final int RIGHT_BORDER_Y = GlobalVariables.CANVAS_HEIGHT - 10;
    private static final double UPPER_LEFT_WALL_WIDTH = BRICK_SINGLE_VERTICAL.getWidth() + (4 * BRICK_SINGLE_HORIZONTAL.getWidth());
    private static final double UPPER_RIGHT_WALL_X = BRICK_SINGLE_VERTICAL.getWidth() + (6 * BRICK_SINGLE_HORIZONTAL.getWidth());
    private static final double UPPER_RIGHT_WALL_WIDTH = 10 * BRICK_SINGLE_HORIZONTAL.getWidth();
    private static final double WALL_BETWEEN_KITCHEN_AND_BEDROOM_HEIGHT =
            (3 * BRICK_SINGLE_VERTICAL.getHeight()) + (2 * WALL_COLON.getHeight());
    private static final double SMALL_WALL_BETWEEN_KITCHEN_AND_BEDROOM_Y =
            (3 * BRICK_SINGLE_VERTICAL.getHeight()) + (2 * WALL_COLON.getHeight()) + BRICK_SINGLE_VERTICAL.getHeight() + 40;

    private List<Rectangle2D> rectangle2DList = new ArrayList<>();
    private Rectangle2D wardrobeBoundary = FurnitureObjects.getWardrobe().getBoundary();
    private Rectangle2D stoveBoundary = FurnitureObjects.getStove().getBoundary();
    private Rectangle2D kitchenDresserBoundary = FurnitureObjects.getKitchenDresser().getBoundary();
    private Rectangle2D kitchenSinkBoundary = FurnitureObjects.getKitchenSink().getBoundary();
    private Rectangle2D kitchenTableBoundary = FurnitureObjects.getKitchenTable().getBoundary();
    private Rectangle2D fridgeBoundary = FurnitureObjects.getFridge().getBoundary();
    private Rectangle2D livingRoomChairBoundary = FurnitureObjects.getLivingRoomChair().getBoundary();
    private Rectangle2D coffeeTableBoundary = FurnitureObjects.getCoffeeTable().getBoundary();
    private Rectangle2D bedBoundary = FurnitureObjects.getBed().getBoundary();
    private Rectangle2D desk = new Rectangle2D(FurnitureObjects.getDesk().getX(),
            DESK_Y, FurnitureObjects.getDesk().getWidth(), FurnitureObjects.getDesk().getHeight());
    private Rectangle2D toilet = new Rectangle2D(FurnitureObjects.getToilet().getX(),
            BATHROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight(), FurnitureObjects.getToilet().getWidth(), TOILET_HEIGHT);
    private Rectangle2D bathtub = new Rectangle2D(FurnitureObjects.getBathtub().getX(),
            BATH_HUB_Y, FurnitureObjects.getBathtub().getWidth(), FurnitureObjects.getBathtub().getHeight());
    private Rectangle2D bathroomSink = new Rectangle2D(FurnitureObjects.getBathroomSink()
            .getX(), BATHROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight(),
            FurnitureObjects.getBathroomSink().getWidth(), BATHROOM_SINK_HEIGHT);
    private Rectangle2D rubberPlant = new Rectangle2D(FurnitureObjects.getRubberPlant().getX(),
            LIVING_ROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight(), FurnitureObjects.getRubberPlant().getWidth(),
            ImageController.getCarpet().getHeight() / 4 + BRICK_SINGLE_HORIZONTAL.getHeight());
    private Rectangle2D tv = new Rectangle2D(FurnitureObjects.getTv().getX(),
            TV_Y, FurnitureObjects.getTv().getWidth(), FurnitureObjects.getTv().getHeight());
    private Rectangle2D coffeeTable = new Rectangle2D(FurnitureObjects.getCoffeeTable().getX(),
            FurnitureObjects.getCoffeeTable().getY(), FurnitureObjects.getCoffeeTable().getWidth(), COFFEE_TABLE_HEIGHT);
    private Rectangle2D sofa = new Rectangle2D(FurnitureObjects.getSofa().getX(),
            LIVING_ROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight(), FurnitureObjects.getSofa().getWidth(), SOFA_HEIGHT);
    private Rectangle2D livingRoomDresser = new Rectangle2D(FurnitureObjects.getLivingDresser()
            .getX(), LIVING_ROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight(), FurnitureObjects
            .getLivingDresser().getWidth(), LIVING_ROOM_DRESSER_HEIGHT);
    private Rectangle2D leftBorder = new Rectangle2D(LEFT_BORDER_X_AND_Y, LEFT_BORDER_X_AND_Y, BRICK_SINGLE_VERTICAL
            .getWidth(), GlobalVariables.CANVAS_HEIGHT + WALL_SHORT.getHeight());
    private Rectangle2D rightBorder = new Rectangle2D(GlobalVariables.getCanvas().getWidth() - BRICK_SINGLE_VERTICAL.getWidth(),
            LEFT_BORDER_X_AND_Y, BRICK_SINGLE_VERTICAL.getWidth(), RIGHT_BORDER_HEIGHT);
    private Rectangle2D downBorder = new Rectangle2D(LEFT_BORDER_X_AND_Y, RIGHT_BORDER_Y,
            GlobalVariables.getCanvas().getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight());
    private Rectangle2D upperWallLeftFromEntrance = new Rectangle2D(LEFT_BORDER_X_AND_Y, LEFT_BORDER_X_AND_Y,
            UPPER_LEFT_WALL_WIDTH, BRICK_SINGLE_HORIZONTAL.getHeight() + WALL_SHORT.getHeight());
    private Rectangle2D upperWallRightFromEntrance = new Rectangle2D(
            UPPER_RIGHT_WALL_X, LEFT_BORDER_X_AND_Y, UPPER_RIGHT_WALL_WIDTH,
            BRICK_SINGLE_HORIZONTAL.getHeight() + WALL_SHORT.getHeight());
    private Rectangle2D wallBetweenKitchenAndBedroom = new Rectangle2D(BEDROOM_X - BRICK_SINGLE_VERTICAL
            .getWidth(), LEFT_BORDER_X_AND_Y, BRICK_SINGLE_VERTICAL.getWidth(), WALL_BETWEEN_KITCHEN_AND_BEDROOM_HEIGHT);
    private Rectangle2D wallBetweenKitchenAndBedroomOneBrick = new Rectangle2D(BEDROOM_X - BRICK_SINGLE_VERTICAL.getWidth(),
            SMALL_WALL_BETWEEN_KITCHEN_AND_BEDROOM_Y, BRICK_SINGLE_VERTICAL.getWidth(), BRICK_SINGLE_VERTICAL.getHeight() * 2);
    private Rectangle2D wallBetweenKitchenAndLivingRoom = new Rectangle2D(BRICK_SINGLE_VERTICAL.getWidth(),
            LIVING_ROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight() - 8,
            4 * BRICK_SINGLE_HORIZONTAL.getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight());
    private Rectangle2D wallBetweenEveryRooms = new Rectangle2D(
            BRICK_SINGLE_VERTICAL.getWidth() + (6 * BRICK_SINGLE_HORIZONTAL.getWidth()),
            LIVING_ROOM_Y - BRICK_SINGLE_HORIZONTAL.getHeight() - 8,
            6 * BRICK_SINGLE_HORIZONTAL.getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight());
    private Rectangle2D wallBetweenLivingRoomAndBathroom = new Rectangle2D(BATHROOM_X - BRICK_SINGLE_VERTICAL
            .getWidth(), BATHROOM_Y, BRICK_SINGLE_VERTICAL
            .getWidth(), BATHROOM_HEIGHT + 40);
    private Rectangle2D wallBetweenBedroomAndBathroom = new Rectangle2D(BRICK_SINGLE_VERTICAL.getWidth()
            + (14 * BRICK_SINGLE_HORIZONTAL.getWidth()), BATHROOM_Y - BRICK_SINGLE_HORIZONTAL
            .getHeight() - 8, 2 * BRICK_SINGLE_HORIZONTAL.getWidth(), BRICK_SINGLE_HORIZONTAL
            .getHeight());
    private Rectangle2D door = new Rectangle2D(DOOR_X, DOOR_Y, DOOR_WIDTH, DOOR_HEIGHT);

    private void setIntersectObjects() {
        Collections.addAll(rectangle2DList, wallBetweenBedroomAndBathroom, wallBetweenEveryRooms, wallBetweenKitchenAndBedroom,
                wallBetweenKitchenAndBedroomOneBrick, wallBetweenKitchenAndLivingRoom, wallBetweenLivingRoomAndBathroom, wardrobeBoundary,
                fridgeBoundary, stoveBoundary, bathroomSink, kitchenDresserBoundary, kitchenSinkBoundary, kitchenTableBoundary,
                livingRoomChairBoundary, livingRoomDresser, desk, toilet, tv, sofa, coffeeTable, coffeeTableBoundary, bedBoundary,
                rubberPlant, bathtub, downBorder, rightBorder, leftBorder, upperWallLeftFromEntrance, upperWallRightFromEntrance, door);
    }

    public void setIntersectObjectsWithoutDoor() {
        rectangle2DList.clear();
        Collections.addAll(rectangle2DList, wallBetweenBedroomAndBathroom, wallBetweenEveryRooms, wallBetweenKitchenAndBedroom,
                wallBetweenKitchenAndBedroomOneBrick, wallBetweenKitchenAndLivingRoom, wallBetweenLivingRoomAndBathroom, wardrobeBoundary,
                fridgeBoundary, stoveBoundary, bathroomSink, kitchenDresserBoundary, kitchenSinkBoundary, kitchenTableBoundary,
                livingRoomChairBoundary, livingRoomDresser, desk, toilet, tv, sofa, coffeeTable, coffeeTableBoundary, bedBoundary,
                rubberPlant, bathtub, downBorder, rightBorder, leftBorder, upperWallLeftFromEntrance, upperWallRightFromEntrance);
    }

    private List<Rectangle2D> getIntersectObjects() {
        return rectangle2DList;
    }

    public IntersectsObjectLevel1() {
        this.setIntersectObjects();
        super.setRectangle2DList(getIntersectObjects());
    }
}