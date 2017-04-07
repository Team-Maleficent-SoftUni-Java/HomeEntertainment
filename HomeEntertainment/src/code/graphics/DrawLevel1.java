package code.graphics;

import code.global.GlobalVariables;
import code.player.Player;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static code.global.GlobalVariables.*;
import static code.graphics.ImageController.*;

public class DrawLevel1 {

    private static final int KITCHEN_DRESSER_WIDTH = 80;
    private static final int KITCHEN_DRESSER_HEIGHT = 135;
    private static final double KITCHEN_DRESSER_X = BRICK_SINGLE_VERTICAL.getWidth() + 5;
    private static final int KITCHEN_DRESSER_Y = 25;
    private static final int STOVE_WIDTH = 80;
    private static final int STOVE_HEIGHT = 110;
    private static final double STOVE_X = KITCHEN_DRESSER_X + 80;
    private static final int STOVE_Y = 50;
    private static final int KITCHEN_SINK_WIDTH = 80;
    private static final int KITCHEN_SINK_HEIGHT = 120;
    private static final double KITCHEN_SINK_X = STOVE_X + 80;
    private static final int KITCHEN_SINK_Y = 36;
    private static final int FRIDGE_WIDTH = 70;
    private static final int FRIDGE_HEIGHT = 125;
    private static final double FRIDGE_X = KITCHEN_SINK_X + 230;
    private static final int FRIDGE_Y = 30;
    private static final int TABLE_WIDTH = 267;
    private static final int TABLE_HEIGHT = 151;
    private static final int TABLE_X = 30;
    private static final int TABLE_Y = 199;
    private static final int SOFA_WIDTH = 240;
    private static final int SOFA_HEIGHT = 140;
    private static final double SOFA_X = 385;
    private static final double SOFA_Y = LIVING_ROOM_Y - 80;
    private static final int COFFEE_TABLE_WIDTH = 150;
    private static final int COFFEE_TABLE_HEIGHT = 100;
    private static final int COFFEE_TABLE_X = 375;
    private static final int LIVING_ROOM_CHAIR_WIDTH = 150;
    private static final int LIVING_ROOM_CHAIR_HEIGHT = 100;
    private static final double LIVING_ROOM_CHAIR_X = 300;
    private static final double LIVING_ROOM_CHAIR_Y = 580;
    private static final int DRESSER_WIDTH = 150;
    private static final int DRESSER_HEIGHT = 100;
    private static final double DRESSER_X = 110;
    private static final double DRESSER_Y = LIVING_ROOM_Y - 60;
    private static final int PLANT_WIDTH = 65;
    private static final int PLANT_HEIGHT = 90;
    private static final double PLANT_X = GlobalVariables.LIVING_ROOM_X + FurnitureObjects.getLivingDresser().getWidth() + 25;
    private static final double PLANT_Y = LIVING_ROOM_Y - 60;
    private static final int TV_WIDTH = 180;
    private static final int TV_HEIGHT = 150;
    private static final double TV_Y = LIVING_ROOM_Y + 130;
    private static final int DESK_WIDTH = 180;
    private static final int DESK_HEIGHT = 140;
    private static final double DESK_X = BEDROOM_X + 10;
    private static final int DESK_Y = GlobalVariables.CANVAS_HEIGHT / 2 - 60;
    private static final int BED_WIDTH = 200;
    private static final int BED_HEIGHT = 170;
    private static final int BED_Y = 50;
    private static final int WARDROBE_WIDTH = 150;
    private static final int WARDROBE_HEIGHT = 150;
    private static final double WARDROBE_X = 550;
    private static final int WARDROBE_Y = 23;
    private static final int TOILET_WIDTH = 100;
    private static final int TOILET_HEIGHT = 110;
    private static final double TOILET_X = 900;
    private static final double TOILET_Y = BATHROOM_Y - 70;
    private static final double BATHTUB_WIDTH = BATHROOM_WIDTH - 50;
    private static final int BATHTUB_HEIGHT = 170;
    private static final double BATHTUB_X = BATHROOM_X + 30;
    private static final double BATHTUB_Y = BATHROOM_Y + 120;
    private static final int SINK_WIDTH = 110;
    private static final int SINK_HEIGHT = 130;
    private static final double SINK_X = BATHROOM_X + 10;
    private static final double SINK_Y = BATHROOM_Y - 70;
    private static final int INTRODUCE_IMAGE_X_AND_Y = 0;
    private static final int FONT_INTRODUCE_SIZE = 43;
    private static final int INTRODUCE_TEXT_X = GlobalVariables.CANVAS_WIDTH / 2;
    private static final int INTRODUCE_TEXT_Y = GlobalVariables.CANVAS_HEIGHT - 50;
    private static final double DRAW_PARQUET_Y = KITCHEN_Y + KITCHEN_HEIGHT / 2;
    private static final double DRAW_CARPET_2_Y = BEDROOM_Y + BEDROOM_HEIGHT / 2;
    private static final double DRAW_TILES_Y = BATHROOM_Y + BATHROOM_HEIGHT / 2;
    private static final double DRAW_CARPET_1_X = GlobalVariables.LIVING_ROOM_X + LIVING_ROOM_WIDTH / 2;
    private static final double DRAW_CARPET_1_Y = LIVING_ROOM_Y + LIVING_ROOM_HEIGHT / 2 + 15;
    private static final double DRAW_CARPET_3_X = GlobalVariables.LIVING_ROOM_X + LIVING_ROOM_WIDTH / 2;
    private static final double DRAW_CARPET_3_Y = LIVING_ROOM_Y + LIVING_ROOM_HEIGHT / 2 + 15;
    private static final int DRAW_GARDEN_GRASS_1_X = 0;
    private static final double DRAW_GARDEN_GRASS_1_Y = LIVING_ROOM_Y + LIVING_ROOM_HEIGHT + 100;
    private static final int DRAW_GARDEN_GRASS_2_X = 600;
    private static final double DRAW_GARDEN_GRASS_2_Y = LIVING_ROOM_Y + LIVING_ROOM_HEIGHT + 100;
    private static final int DRAW_DOOR_X = 270;
    private static final int DRAW_DOOR_Y = -20;
    private static final int DRAW_STATS_BOARD_X = GlobalVariables.CANVAS_WIDTH - 240;
    private static final int DRAW_STATS_BOARD_Y = 3;
    private static final double DRAW_SIPHON_Y = BATHROOM_Y + 100;
    private static final double DRAW_SIPHON_X = BATHROOM_X + (BATHROOM_WIDTH / 2)
            - (ImageController.getSiphon().getWidth() / 2);
    private static final double POINTS_TEXT_X = GlobalVariables.getCanvas().getWidth()
            - ImageController.getStatsBoard().getWidth() + 5;
    private static final double POINTS_TEXT_Y = GlobalVariables.getCanvas().getLayoutY() + 40;
    private static final double HEALTH_TEXT_X = GlobalVariables.getCanvas().getWidth()
            - ImageController.getStatsBoard().getWidth() + 5;
    private static final double HEALTH_TEXT_Y = GlobalVariables.getCanvas().getLayoutY() + 20;
    private static final String IMG_TV_PNG = "img/tv.png";
    private static final String IMG_ROBBER_PLANT_BURNED_PNG = "img/robber plant_burned.png";
    private static final String IMG_DRESSER_PNG = "img/dresser.png";
    private static final String IMG_LIVING_CHAIR_PNG = "img/livingChair.png";
    private static final String IMG_COFFEE_TABLE_PNG = "img/coffeeTable.png";
    private static final String IMG_SOFA_PNG = "img/sofa.png";
    private static final String IMG_TABLE_BURNED_BURNED_PNG = "img/table_burned_burned.png";
    private static final String IMG_KITCHEN_DRESSER_PNG = "img/kitchenDresser.png";
    private static final String IMG_STOVE_PNG = "img/stove.png";
    private static final String IMG_KITCHEN_SINK_PNG = "img/kitchenSink.png";
    private static final String IMG_FRIDGE_PNG = "img/fridge.png";
    private static final String IMG_DESK_PNG = "img/desk.png";
    private static final String INTRODUCE_IMAGE_URL = "img/07.jpg";
    private static final String IMG_BED_PNG = "img/bed.png";
    private static final String IMG_WARDROBE_BURNED_PNG = "img/wardrobe_burned.png";
    private static final String IMG_TOILET_PNG = "img/toilet.png";
    private static final String IMG_BATHTUB_PNG = "img/bathtub.png";
    private static final String IMG_SINK_PNG = "img/sink.png";
    private static final String INTRODUCE_TEXT = "Team Maleficent introduce Home Entertainment";
    private static final String POINTS_TEXT = "Points: ";
    private static final String HEALTH_TEXT = "Health ";

    public static void displayObjects() {
        //The kitchenDresser object
        Image kitchenDresserImage = new Image(
                IMG_KITCHEN_DRESSER_PNG, KITCHEN_DRESSER_WIDTH, KITCHEN_DRESSER_HEIGHT, false, false);
        FurnitureObjects.getKitchenDresser().setImage(kitchenDresserImage);
        FurnitureObjects.getKitchenDresser().setPosition(KITCHEN_DRESSER_X, KITCHEN_DRESSER_Y);

        //The stove object
        Image stoveImage = new Image(IMG_STOVE_PNG, STOVE_WIDTH, STOVE_HEIGHT, false, false);
        FurnitureObjects.getStove().setImage(stoveImage);
        FurnitureObjects.getStove().setPosition(STOVE_X, STOVE_Y);

        //The kitchenSink object
        Image kitchenSinkImage = new Image(IMG_KITCHEN_SINK_PNG, KITCHEN_SINK_WIDTH, KITCHEN_SINK_HEIGHT, false, false);
        FurnitureObjects.getKitchenSink().setImage(kitchenSinkImage);
        FurnitureObjects.getKitchenSink()
                .setPosition(KITCHEN_SINK_X, KITCHEN_SINK_Y);

        //The fridge object
        Image fridgeImage = new Image(IMG_FRIDGE_PNG, FRIDGE_WIDTH, FRIDGE_HEIGHT, false, false);
        FurnitureObjects.getFridge().setImage(fridgeImage);
        FurnitureObjects.getFridge().setPosition(FRIDGE_X, FRIDGE_Y);

        //The kitchenTable object
        Image kitchenTableImage = new Image(
                IMG_TABLE_BURNED_BURNED_PNG, TABLE_WIDTH, TABLE_HEIGHT, false, false);
        FurnitureObjects.getKitchenTable().setImage(kitchenTableImage);
        FurnitureObjects.getKitchenTable().setPosition(TABLE_X, TABLE_Y);

        //The sofa object
        Image sofaImage = new Image(IMG_SOFA_PNG, SOFA_WIDTH, SOFA_HEIGHT, false, false);
        FurnitureObjects.getSofa().setImage(sofaImage);
        FurnitureObjects.getSofa().setPosition(SOFA_X, SOFA_Y);

        //The coffeeTable object
        Image coffeeTableImage = new Image(IMG_COFFEE_TABLE_PNG, COFFEE_TABLE_WIDTH, COFFEE_TABLE_HEIGHT, false, false);
        FurnitureObjects.getCoffeeTable().setImage(coffeeTableImage);
        FurnitureObjects.getCoffeeTable().setPosition(COFFEE_TABLE_X, LIVING_ROOM_Y);

        //The livingRoomChair object
        Image livingRoomChairImage = new Image(IMG_LIVING_CHAIR_PNG, LIVING_ROOM_CHAIR_WIDTH, LIVING_ROOM_CHAIR_HEIGHT, false, false);
        FurnitureObjects.getLivingRoomChair().setImage(livingRoomChairImage);
        FurnitureObjects.getLivingRoomChair().setPosition(LIVING_ROOM_CHAIR_X, LIVING_ROOM_CHAIR_Y);

        //The livingDresser object
        Image livingDresserImage = new Image(IMG_DRESSER_PNG, DRESSER_WIDTH, DRESSER_HEIGHT, false, false);
        FurnitureObjects.getLivingDresser().setImage(livingDresserImage);
        FurnitureObjects.getLivingDresser().setPosition(DRESSER_X, DRESSER_Y);

        //The rubberPlant object
        Image rubberPlantImage = new Image(
                IMG_ROBBER_PLANT_BURNED_PNG, PLANT_WIDTH, PLANT_HEIGHT, false, false);
        FurnitureObjects.getRubberPlant().setImage(rubberPlantImage);
        FurnitureObjects.getRubberPlant()
                .setPosition(PLANT_X, PLANT_Y);

        //The tv object
        Image tvImage = new Image(IMG_TV_PNG, TV_WIDTH, TV_HEIGHT, false, false);
        FurnitureObjects.getTv().setImage(tvImage);
        FurnitureObjects.getTv().setPosition(GlobalVariables.LIVING_ROOM_X, TV_Y);

        //The desk object
        Image deskImage = new Image(IMG_DESK_PNG, DESK_WIDTH, DESK_HEIGHT, false, false);
        FurnitureObjects.getDesk().setImage(deskImage);
        FurnitureObjects.getDesk().setPosition(DESK_X, DESK_Y);

        //The bed object
        Image bedImage = new Image(IMG_BED_PNG, BED_WIDTH, BED_HEIGHT, false, false);
        FurnitureObjects.getBed().setImage(bedImage);
        FurnitureObjects.getBed().setPosition(GlobalVariables.getCanvas().getWidth() - bedImage.getWidth()
                - BRICK_SINGLE_VERTICAL.getWidth() - 10, BED_Y);

        //The wardrobe object
        Image wardrobeImage = new Image(IMG_WARDROBE_BURNED_PNG, WARDROBE_WIDTH, WARDROBE_HEIGHT, false, false);
        FurnitureObjects.getWardrobe().setImage(wardrobeImage);
        FurnitureObjects.getWardrobe().setPosition(WARDROBE_X, WARDROBE_Y);

        //The toilet object
        Image toiletImage = new Image(IMG_TOILET_PNG, TOILET_WIDTH, TOILET_HEIGHT, false, false);
        FurnitureObjects.getToilet().setImage(toiletImage);
        FurnitureObjects.getToilet().setPosition(TOILET_X, TOILET_Y);

        //The bathtub object
        Image bathtubImage = new Image(IMG_BATHTUB_PNG, BATHTUB_WIDTH, BATHTUB_HEIGHT, false, false);
        FurnitureObjects.getBathtub().setImage(bathtubImage);
        FurnitureObjects.getBathtub().setPosition(BATHTUB_X, BATHTUB_Y);

        //The bathroomSink object
        Image sinkImage = new Image(IMG_SINK_PNG, SINK_WIDTH, SINK_HEIGHT, false, false);
        FurnitureObjects.getBathroomSink().setImage(sinkImage);
        FurnitureObjects.getBathroomSink().setPosition(SINK_X, SINK_Y);
    }

    public static void displayIntroduce() {
        Image mainImage = new Image(INTRODUCE_IMAGE_URL, GlobalVariables.getCanvas()
                .getWidth(), GlobalVariables.CANVAS_HEIGHT, false, false);
        GlobalVariables.getGraphicContext().drawImage(mainImage, INTRODUCE_IMAGE_X_AND_Y, INTRODUCE_IMAGE_X_AND_Y);

        //Introduce title
        Font introduce = Font.font(java.awt.Font.DIALOG, FONT_INTRODUCE_SIZE);
        GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.CENTER);
        GlobalVariables.getGraphicContext().setFont(introduce);
        final Effect glow = new Glow(1.0);
        GlobalVariables.getGraphicContext().setEffect(glow);
        GlobalVariables.getGraphicContext().setFill(Color.CADETBLUE);
        GlobalVariables.getGraphicContext().fillText(INTRODUCE_TEXT, INTRODUCE_TEXT_X, INTRODUCE_TEXT_Y);
    }

    public static void drawWalls(boolean drawDoor) {
        // Render the image objects
        double doorWidth = 2 * BRICK_SINGLE_HORIZONTAL.getWidth();
        double wallKitchenLivingRoomWidth = 0;
        double wallKitchenLivingRoomBedroomBathroomWidth = 0;
        double wallUpBorder1 = 0;
        double wallKitchenBedroomHeight = 0;

        //Draw pavements of different rooms
        GlobalVariables.getGraphicContext().clearRect(GlobalVariables.CANVAS_X_Y, GlobalVariables.CANVAS_X_Y,
                GlobalVariables.CANVAS_WIDTH, GlobalVariables.CANVAS_HEIGHT);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getParquet(), KITCHEN_X, KITCHEN_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getParquet(), KITCHEN_X, DRAW_PARQUET_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet2(), BEDROOM_X, BEDROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet2(), BEDROOM_X, DRAW_CARPET_2_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getTiles(), BATHROOM_X, BATHROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getTiles(), BATHROOM_X, DRAW_TILES_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), GlobalVariables.LIVING_ROOM_X, LIVING_ROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), DRAW_CARPET_1_X, LIVING_ROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), GlobalVariables.LIVING_ROOM_X, DRAW_CARPET_1_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), DRAW_CARPET_3_X, DRAW_CARPET_3_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getGardenGrass(), DRAW_GARDEN_GRASS_1_X, DRAW_GARDEN_GRASS_1_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getGardenGrass(), DRAW_GARDEN_GRASS_2_X, DRAW_GARDEN_GRASS_2_Y);

        //Draw upper walls and bricks
        //Upper border
        for (int i = 0; i < 4; i++) {
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), BRICK_SINGLE_HORIZONTAL.getHeight());
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), 0);
            wallUpBorder1 += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //draw door
        GlobalVariables.getGraphicContext().drawImage(drawDoor ? DOOR_IMAGE : ImageController.getSmallGardenGrass(),
                DRAW_DOOR_X, DRAW_DOOR_Y);

        for (int i = 0; i < GlobalVariables.getCanvas().getWidth() / BRICK_SINGLE_HORIZONTAL.getWidth(); i++) {
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallUpBorder1 + doorWidth + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), BRICK_SINGLE_HORIZONTAL.getHeight());
            //Stats board
            GlobalVariables.getGraphicContext().drawImage(ImageController.getStatsBoard(), DRAW_STATS_BOARD_X, DRAW_STATS_BOARD_Y);
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallUpBorder1 + doorWidth + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), 0);
        }

        //wall between kitchen and bedroom
        for (int i = 0; i < 3; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallUpBorder1 + doorWidth + (2 * BRICK_SINGLE_HORIZONTAL.getWidth()), i * BRICK_SINGLE_VERTICAL.getHeight());
            wallKitchenBedroomHeight += BRICK_SINGLE_VERTICAL.getHeight();
        }

        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(WALL_COLON, BRICK_SINGLE_VERTICAL.getWidth() + wallUpBorder1
                    + doorWidth + (2 * BRICK_SINGLE_HORIZONTAL.getWidth()), wallKitchenBedroomHeight + (i * WALL_COLON.getHeight()));
        }

        FurnitureObjects.getKitchenDresser().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getStove().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getKitchenSink().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getFridge().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getKitchenTable().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getWardrobe().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getBed().render(GlobalVariables.getGraphicContext());

        //Draw the player if it`s in the first half of the screen(above the top walls and behind the middle walls)
        if (Player.getInstance().bottomBoundary().intersects(GlobalVariables.CANVAS_X_Y, GlobalVariables.CANVAS_X_Y,
                GlobalVariables.CANVAS_WIDTH, BRICK_SINGLE_HORIZONTAL.getHeight() + WALL_SHORT.getHeight() + KITCHEN_HEIGHT)) {
            Player.getInstance().render(GlobalVariables.getGraphicContext());
        }

        FurnitureObjects.getDesk().render(GlobalVariables.getGraphicContext());

        //wall between kitchen and bedroom(single brick)
        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallUpBorder1 + doorWidth + (2 * BRICK_SINGLE_HORIZONTAL.getWidth()), wallKitchenBedroomHeight
                    + (2 * WALL_COLON.getHeight()) + BRICK_SINGLE_VERTICAL.getHeight());
        }

        //render the  middle walls
        //wall between kitchen and livingRoom(draw 4 bricks)
        for (int i = 0; i < 4; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), GlobalVariables.CANVAS_HEIGHT / 2);
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), (GlobalVariables.CANVAS_HEIGHT / 2)
                    + BRICK_SINGLE_HORIZONTAL.getHeight());
            wallKitchenLivingRoomWidth += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //wall between kitchen, livingRoom, bedroom and bathroom(draw 6 bricks)
        for (int i = 0; i < 6; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), GlobalVariables.CANVAS_HEIGHT / 2);
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), (GlobalVariables.CANVAS_HEIGHT / 2)
                    + BRICK_SINGLE_HORIZONTAL.getHeight());
            wallKitchenLivingRoomBedroomBathroomWidth += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //wall between bedroom and bathroom(draw 2 bricks)
        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), GlobalVariables.CANVAS_HEIGHT / 2);
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth
                    + doorWidth + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), (GlobalVariables.CANVAS_HEIGHT / 2)
                    + BRICK_SINGLE_HORIZONTAL.getHeight());
        }

        //wall between living room and bathroom
        for (int i = 0; i < 6; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, 2 * (GlobalVariables.getCanvas().getWidth() / 3)
                    - BRICK_SINGLE_HORIZONTAL.getWidth(), GlobalVariables.CANVAS_HEIGHT / 2 + (i * BRICK_SINGLE_VERTICAL.getHeight()));
        }

        //Render the bricks
        //Left border
        for (int i = 0; i < GlobalVariables.CANVAS_HEIGHT / BRICK_SINGLE_VERTICAL.getHeight() - 1; i++) {
            GlobalVariables
                    .getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, 0, i * BRICK_SINGLE_VERTICAL.getHeight());
        }

        FurnitureObjects.getSofa().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getCoffeeTable().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getRubberPlant().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getLivingDresser().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getLivingRoomChair().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getToilet().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getBathroomSink().render(GlobalVariables.getGraphicContext());
        GlobalVariables.getGraphicContext().drawImage(ImageController.getSiphon(), DRAW_SIPHON_X, DRAW_SIPHON_Y);

        //player above the middle wall and the obstacles in the low middle part of the screen
        if (Player.getInstance().bottomBoundary().intersects(0, BRICK_SINGLE_HORIZONTAL.getHeight() + WALL_SHORT.getHeight()
                + KITCHEN_HEIGHT, GlobalVariables.getCanvas().getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight() + LIVING_ROOM_HEIGHT + 40)) {
            Player.getInstance().render(GlobalVariables.getGraphicContext());
        }

        FurnitureObjects.getBathtub().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getTv().render(GlobalVariables.getGraphicContext());

        //Down border
        for (int i = 0; i < GlobalVariables.getCanvas().getWidth() ; i++) {
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25,
                    GlobalVariables.CANVAS_HEIGHT - (2 * BRICK_SINGLE_HORIZONTAL.getHeight()) + 20);
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25,
                    GlobalVariables.CANVAS_HEIGHT - 2 * BRICK_SINGLE_HORIZONTAL.getHeight());
            wallKitchenLivingRoomWidth += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //Right border
        for (int i = 0; i < GlobalVariables.CANVAS_HEIGHT / BRICK_SINGLE_VERTICAL.getHeight() - 1; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, GlobalVariables.getCanvas().getWidth()
                    - BRICK_SINGLE_VERTICAL.getWidth(), i * BRICK_SINGLE_VERTICAL.getHeight());
        }

        //Display scores on the stats board
        String pointsText = POINTS_TEXT + Player.getInstance().getScore();
        GlobalVariables.getGraphicContext().fillText(pointsText, POINTS_TEXT_X, POINTS_TEXT_Y);

        //Display health on stats board
        String healthText = HEALTH_TEXT + (int) (Player.getInstance().getPlayerHealth()) + "%";

        GlobalVariables.getGraphicContext().fillText(healthText, HEALTH_TEXT_X, HEALTH_TEXT_Y);
    }
}