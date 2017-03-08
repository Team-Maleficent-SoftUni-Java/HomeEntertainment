package code.Graphics;

import code.GlobalVariables;
import code.Player.Sprite;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

import static code.GlobalVariables.*;
import static code.Graphics.ImageController.*;

public class DrawLevel1 {

    public static void displayObjects() {
        //The kitchenDresser object
        Image kitchenDresserImage = new Image(
                "img/kitchenDresser.png", 80, 135, false, false);
        FurnitureObjects.getKitchenDresser().setImage(kitchenDresserImage);
        FurnitureObjects.getKitchenDresser().setPosition(BRICK_SINGLE_VERTICAL.getWidth() + 5, 25);

        //The stove object
        Image stoveImage = new Image("img/stove.png", 80, 110, false, false);
        FurnitureObjects.getStove().setImage(stoveImage);
        FurnitureObjects.getStove()
                .setPosition(BRICK_SINGLE_VERTICAL.getWidth() + FurnitureObjects.getKitchenDresser().getWidth() + 5, 50);

        //The kitchenSink object
        Image kitchenSinkImage = new Image("img/kitchenSink.png", 80, 120, false, false);
        FurnitureObjects.getKitchenSink().setImage(kitchenSinkImage);
        FurnitureObjects.getKitchenSink()
                .setPosition(FurnitureObjects.getStove().getX() + FurnitureObjects.getStove().getWidth() + 5, 36);

        //The fridge object
        Image fridgeImage = new Image("img/fridge.png", 70, 125, false, false);
        FurnitureObjects.getFridge().setImage(fridgeImage);
        FurnitureObjects.getFridge().setPosition(FurnitureObjects.getKitchenSink().getX()
                + FurnitureObjects.getKitchenSink().getWidth() + (2 * BRICK_SINGLE_HORIZONTAL.getWidth()) + 20, 30);

        //The kitchenTable object
        Image kitchenTableImage = new Image(
                "img/table_burned_burned.png", 267, 151, false, false);
        FurnitureObjects.getKitchenTable().setImage(kitchenTableImage);
        FurnitureObjects.getKitchenTable().setPosition(30, 199);

        //The sofa object
        Image sofaImage = new Image("img/sofa.png", 240, 140, false, false);
        FurnitureObjects.getSofa().setImage(sofaImage);
        FurnitureObjects.getSofa()
                .setPosition(LIVING_ROOM_X + LIVING_ROOM_WIDTH - FurnitureObjects.getSofa().getWidth() + 5, LIVING_ROOM_Y - 80);

        //The coffeeTable object
        Image coffeeTableImage = new Image("img/coffeeTable.png", 150, 100, false, false);
        FurnitureObjects.getCoffeeTable().setImage(coffeeTableImage);
        FurnitureObjects.getCoffeeTable().setPosition(LIVING_ROOM_WIDTH - FurnitureObjects.getCoffeeTable().getWidth() - 70, LIVING_ROOM_Y);

        //The livingRoomChair object
        Image livingRoomChairImage = new Image("img/livingChair.png", 150, 100, false, false);
        FurnitureObjects.getLivingRoomChair().setImage(livingRoomChairImage);
        FurnitureObjects.getLivingRoomChair().setPosition(LIVING_ROOM_WIDTH - FurnitureObjects
                .getLivingRoomChair().getWidth() - 20, LIVING_ROOM_Y + FurnitureObjects.getLivingRoomChair().getHeight());

        //The livingDresser object
        Image livingDresserImage = new Image("img/dresser.png", 150, 100, false, false);
        FurnitureObjects.getLivingDresser().setImage(livingDresserImage);
        FurnitureObjects.getLivingDresser().setPosition(LIVING_ROOM_X + 20, LIVING_ROOM_Y - 60);

        //The rubberPlant object
        Image rubberPlantImage = new Image(
                "img/robber plant_burned.png", 65, 90, false, false);
        FurnitureObjects.getRubberPlant().setImage(rubberPlantImage);
        FurnitureObjects.getRubberPlant()
                .setPosition(LIVING_ROOM_X + FurnitureObjects.getLivingDresser().getWidth() + 25, LIVING_ROOM_Y - 60);

        //The tv object
        Image tvImage = new Image("img/tv.png", 180, 150, false, false);
        FurnitureObjects.getTv().setImage(tvImage);
        FurnitureObjects.getTv().setPosition(LIVING_ROOM_X, LIVING_ROOM_Y + 130);

        //The desk object
        Image deskImage = new Image("img/desk.png", 180, 140, false, false);
        FurnitureObjects.getDesk().setImage(deskImage);
        FurnitureObjects.getDesk().setPosition(BEDROOM_X + 10, CANVAS_FAKE_HEIGHT / 2 - 60);

        //The bed object
        Image bedImage = new Image("img/bed.png", 200, 170, false, false);
        FurnitureObjects.getBed().setImage(bedImage);
        FurnitureObjects.getBed().setPosition(GlobalVariables.getCanvas()
                .getWidth() - bedImage.getWidth() - BRICK_SINGLE_VERTICAL.getWidth() - 10, 50);

        //The wardrobe object
        Image wardrobeImage = new Image("img/wardrobe_burned.png", 150, 150, false, false);
        FurnitureObjects.getWardrobe().setImage(wardrobeImage);
        FurnitureObjects.getWardrobe().setPosition(FurnitureObjects.getBed().getX() - FurnitureObjects.getWardrobe().getWidth() - 90, 23);

        //The toilet object
        Image toiletImage = new Image("img/toilet.png", 100, 110, false, false);
        FurnitureObjects.getToilet().setImage(toiletImage);
        FurnitureObjects.getToilet().setPosition(GlobalVariables.getCanvas()
                .getWidth() - FurnitureObjects.getToilet().getWidth() - BRICK_SINGLE_VERTICAL.getWidth(), BATHROOM_Y - 70);

        //The bathtub object
        Image bathtubImage = new Image("img/bathtub.png", BATHROOM_WIDTH - 50, 170, false, false);
        FurnitureObjects.getBathtub().setImage(bathtubImage);
        FurnitureObjects.getBathtub().setPosition(BATHROOM_X + 30, BATHROOM_Y + 120);

        //The bathroomSink object
        Image sinkImage = new Image("img/sink.png", 110, 130, false, false);
        FurnitureObjects.getBathroomSink().setImage(sinkImage);
        FurnitureObjects.getBathroomSink().setPosition(BATHROOM_X + 10, BATHROOM_Y - 70);
    }

    public static void displayIntroduce() {
        Image mainImage = new Image("img/07.jpg", GlobalVariables.getCanvas()
                .getWidth(), CANVAS_FAKE_HEIGHT, false, false);
        GlobalVariables.getGraphicContext().drawImage(mainImage, 0, 0);

        //Introduce title
        Font introduce = Font.font(java.awt.Font.DIALOG, 43);
        GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.CENTER);
        GlobalVariables.getGraphicContext().setFont(introduce);
        final Effect glow = new Glow(1.0);
        GlobalVariables.getGraphicContext().setEffect(glow);
        GlobalVariables.getGraphicContext().setFill(Color.CADETBLUE);
        String text = "Team Maleficent introduce Home Entertainment";
        GlobalVariables.getGraphicContext()
                .fillText(text, GlobalVariables.getCanvas().getWidth() / 2, CANVAS_FAKE_HEIGHT - 50);
    }

    public static void drawWalls(boolean drawDoor) {
        // Render the image objects
        double doorWidth = 2 * BRICK_SINGLE_HORIZONTAL.getWidth();
        double wallKitchenLivingRoomWidth = 0;
        double wallKitchenLivingRoomBedroomBathroomWidth = 0;
        double wallUpBorder1 = 0;
        double wallKitchenBedroomHeight = 0;

        //Draw pavements of different rooms
        GlobalVariables.getGraphicContext().clearRect(0, 0, 1024, 768);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getParquet(), KITCHEN_X, KITCHEN_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getParquet(), KITCHEN_X, KITCHEN_Y + KITCHEN_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet2(), BEDROOM_X, BEDROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet2(), BEDROOM_X, BEDROOM_Y + BEDROOM_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getTiles(), BATHROOM_X, BATHROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getTiles(), BATHROOM_X, BATHROOM_Y + BATHROOM_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), LIVING_ROOM_X, LIVING_ROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), LIVING_ROOM_X + LIVING_ROOM_WIDTH / 2, LIVING_ROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(), LIVING_ROOM_X, LIVING_ROOM_Y + LIVING_ROOM_HEIGHT / 2 + 15);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getCarpet(),
                LIVING_ROOM_X + LIVING_ROOM_WIDTH / 2, LIVING_ROOM_Y + LIVING_ROOM_HEIGHT / 2 + 15);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getGardenGrass(), 0, LIVING_ROOM_Y + LIVING_ROOM_HEIGHT + 100);
        GlobalVariables.getGraphicContext().drawImage(ImageController.getGardenGrass(), 600, LIVING_ROOM_Y + LIVING_ROOM_HEIGHT + 100);

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
        GlobalVariables.getGraphicContext().drawImage(drawDoor ? DOOR_IMAGE : ImageController.getSmallGardenGrass(), 270, -20);

        for (int i = 0; i < GlobalVariables.getCanvas().getWidth() / BRICK_SINGLE_HORIZONTAL.getWidth(); i++) {
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallUpBorder1 + doorWidth + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), BRICK_SINGLE_HORIZONTAL.getHeight());
            //Stats board
            GlobalVariables.getGraphicContext().drawImage(ImageController.getStatsBoard(), GlobalVariables.getCanvas().getWidth() - 240, 3);
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
        if (GlobalVariables.getPlayer().bottomBoundary().intersects(0, 0, GlobalVariables.getCanvas().getWidth(),
                BRICK_SINGLE_HORIZONTAL.getHeight() + WALL_SHORT.getHeight() + KITCHEN_HEIGHT)) {
            GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
        }

        FurnitureObjects.getDesk().render(GlobalVariables.getGraphicContext());

        //wall between kitchen and bedroom(single brick)
        //POSITION MUST BE HERE!!!
        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallUpBorder1 + doorWidth + (2 * BRICK_SINGLE_HORIZONTAL.getWidth()), wallKitchenBedroomHeight
                    + (2 * WALL_COLON.getHeight()) + BRICK_SINGLE_VERTICAL.getHeight());
        }

        //render the  middle walls
        //wall between kitchen and livingRoom(draw 4 bricks)
        for (int i = 0; i < 4; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), CANVAS_FAKE_HEIGHT / 2);
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), (CANVAS_FAKE_HEIGHT / 2)
                    + BRICK_SINGLE_HORIZONTAL.getHeight());
            wallKitchenLivingRoomWidth += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //wall between kitchen, livingRoom, bedroom and bathroom(draw 6 bricks)
        for (int i = 0; i < 6; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), CANVAS_FAKE_HEIGHT / 2);
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), (CANVAS_FAKE_HEIGHT / 2)
                    + BRICK_SINGLE_HORIZONTAL.getHeight());
            wallKitchenLivingRoomBedroomBathroomWidth += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //wall between bedroom and bathroom(draw 2 bricks)
        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), CANVAS_FAKE_HEIGHT / 2);
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth
                    + doorWidth + (i * BRICK_SINGLE_HORIZONTAL.getWidth()), (CANVAS_FAKE_HEIGHT / 2)
                    + BRICK_SINGLE_HORIZONTAL.getHeight());
        }

        //wall between living room and bathroom
        for (int i = 0; i < 6; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, 2 * (GlobalVariables.getCanvas().getWidth() / 3)
                    - BRICK_SINGLE_HORIZONTAL.getWidth(), CANVAS_FAKE_HEIGHT / 2 + (i * BRICK_SINGLE_VERTICAL.getHeight()));
        }

        //Render the bricks
        //Left border
        for (int i = 0; i < CANVAS_FAKE_HEIGHT / BRICK_SINGLE_VERTICAL.getHeight() - 1; i++) {
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
        GlobalVariables.getGraphicContext().drawImage(ImageController.getSiphon(), BATHROOM_X + (BATHROOM_WIDTH / 2)
                - (ImageController.getSiphon().getWidth() / 2), BATHROOM_Y + 100);

        //Player above the middle wall and the obstacles in the low middle part of the screen
        if (GlobalVariables.getPlayer().bottomBoundary().intersects(0, BRICK_SINGLE_HORIZONTAL.getHeight() + WALL_SHORT.getHeight()
                + KITCHEN_HEIGHT, GlobalVariables.getCanvas().getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight() + LIVING_ROOM_HEIGHT + 40)) {
            GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
        }

        FurnitureObjects.getBathtub().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getTv().render(GlobalVariables.getGraphicContext());

        //Down border
        for (int i = 0; i < GlobalVariables.getCanvas().getWidth() ; i++) {
            GlobalVariables.getGraphicContext().drawImage(WALL_SHORT, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25, CANVAS_FAKE_HEIGHT - (2 * BRICK_SINGLE_HORIZONTAL.getHeight()) + 20);
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_HORIZONTAL, BRICK_SINGLE_VERTICAL.getWidth()
                    + (i * BRICK_SINGLE_HORIZONTAL.getWidth()) - 25, CANVAS_FAKE_HEIGHT - 2 * BRICK_SINGLE_HORIZONTAL.getHeight());
            wallKitchenLivingRoomWidth += BRICK_SINGLE_HORIZONTAL.getWidth();
        }

        //Right border
        for (int i = 0; i < CANVAS_FAKE_HEIGHT / BRICK_SINGLE_VERTICAL.getHeight() - 1; i++) {
            GlobalVariables.getGraphicContext().drawImage(BRICK_SINGLE_VERTICAL, GlobalVariables.getCanvas().getWidth()
                    - BRICK_SINGLE_VERTICAL.getWidth(), i * BRICK_SINGLE_VERTICAL.getHeight());
        }

        //Display scores on the stats board
        String pointsText = "Points: " + GlobalVariables.getPlayer().getScore();
        GlobalVariables.getGraphicContext().fillText(pointsText, GlobalVariables.getCanvas().getWidth()
                - ImageController.getStatsBoard().getWidth() + 5, GlobalVariables.getCanvas().getLayoutY() + 40);

        //Display health on stats board
        String healthText = "Health " + (int) (GlobalVariables.getPlayer().getPlayerHealth()) + "%";

        GlobalVariables.getGraphicContext().fillText(healthText, GlobalVariables.getCanvas().getWidth()
                - ImageController.getStatsBoard().getWidth() + 5, GlobalVariables.getCanvas().getLayoutY() + 20);
    }
}