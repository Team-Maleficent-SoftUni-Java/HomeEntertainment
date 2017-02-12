package sample;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
        theStage.setTitle("Home entertainment");

        Group root = new Group();

        Scene theScene = new Scene(root, 1024, 768, Color.WHITESMOKE);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1024, 768);
        root.getChildren().add(canvas);

        // Create Image and ImageView objects
        Image brickSingleHorizontal = new Image("img/brickSingleHorizontal.png");
        Image brickSingleVert = new Image("img/brickSingleVert.png");
        Image wallShort = new Image("img/wallShort.png");
        Image wallColon = new Image("img/wallColon.png");

        //borders Kitchen
        double KITCHEN_X = brickSingleVert.getWidth();
        double KITCHEN_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight();
        double KITCHEN_WIDTH = brickSingleHorizontal.getWidth() * 8;
        double KITCHEN_HEIGHT = canvas.getHeight() / 2 - brickSingleHorizontal.getHeight();

        //borders Living room
        double LIVINGROOM_X = brickSingleVert.getWidth();
        double LIVINGROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT + brickSingleHorizontal.getHeight();
        double LIVINGROOM_WIDTH = brickSingleHorizontal.getWidth() * 10 - brickSingleVert.getWidth();
        double LIVINGROOM_HEIGHT = canvas.getHeight() - LIVINGROOM_Y - (2 * brickSingleHorizontal.getHeight());

        //borders Bedroom
        double BEDROOM_X = brickSingleVert.getWidth() + KITCHEN_WIDTH + brickSingleVert.getWidth();
        ;
        double BEDROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight();
        double BEDROOM_WIDTH = canvas.getWidth() - KITCHEN_WIDTH - (3 * brickSingleVert.getWidth());
        ;
        double BEDROOM_HEIGHT = canvas.getHeight() / 2 - brickSingleHorizontal.getHeight();

        //borders Bathroom
        double BATHROOM_X = brickSingleVert.getWidth() + LIVINGROOM_WIDTH + brickSingleVert.getWidth();
        double BATHROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT + brickSingleHorizontal.getHeight();
        double BATHROOM_WIDTH = canvas.getWidth() - (3 * brickSingleVert.getWidth()) - LIVINGROOM_WIDTH;
        double BATHROOM_HEIGHT = canvas.getHeight() - LIVINGROOM_Y - (2 * brickSingleHorizontal.getHeight());
        ;

        Image parquet = new Image("img/parquet.jpg", KITCHEN_WIDTH, KITCHEN_HEIGHT / 2, false, false);
        Image tiles = new Image("img/tiles2.jpg", BATHROOM_WIDTH, BATHROOM_HEIGHT / 2, false, false);
        Image carpet = new Image("img/carpet.jpg", LIVINGROOM_WIDTH / 2, LIVINGROOM_HEIGHT / 2, false, false);
        Image carpet2 = new Image("img/carpet03.jpg", BEDROOM_WIDTH, BEDROOM_HEIGHT / 2, false, false);
        Image siphon = new Image("img/siphon.png", 40, 40, false, false);

        ArrayDeque<String> playerRightImages = new ArrayDeque<>();
        playerRightImages.addLast("img/playerRight0.png");
        playerRightImages.addLast("img/playerRight1.png");
        playerRightImages.addLast("img/playerRight2.png");

        ArrayDeque<String> playerLeftImages = new ArrayDeque<>();
        playerLeftImages.addLast("img/playerLeft0.png");
        playerLeftImages.addLast("img/playerLeft1.png");
        playerLeftImages.addLast("img/playerLeft2.png");

        ArrayDeque<String> playerDownImages = new ArrayDeque<>();
        playerDownImages.addLast("img/playerFront0.png");
        playerDownImages.addLast("img/playerFront1.png");
        playerDownImages.addLast("img/playerFront2.png");

        ArrayDeque<String> playerUpImages = new ArrayDeque<>();
        playerUpImages.addLast("img/playerBack0.png");
        playerUpImages.addLast("img/playerBack1.png");
        playerUpImages.addLast("img/playerBack2.png");


        //Take the keys inputs
        ArrayList<String> input = new ArrayList<String>();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!input.contains(code))
                            input.add(code);
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });

        // Display the graphics and movement
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //The player object
        Image playerImage = new Image("img/playerFront0.png", 45, 120, false, false);
        Sprite player = new Sprite();
        player.setImage(playerImage);
        player.setPosition(5 * brickSingleHorizontal.getWidth(), 20);

        //The kitchenDresser object
        Image kitchenDresserImage = new Image("img/kitchenDresser.png", 80, 135, false, false);
        Sprite kitchenDresser = new Sprite();
        kitchenDresser.setImage(kitchenDresserImage);
        kitchenDresser.setPosition(brickSingleVert.getWidth() + 5, 25);

        //The stove object
        Image stoveImage = new Image("img/stove.png", 80, 110, false, false);
        Sprite stove = new Sprite();
        stove.setImage(stoveImage);
        stove.setPosition(brickSingleVert.getWidth() + kitchenDresser.getWidth() + 5, 50);

        //The kitchenSink object
        Image kitchenSinkImage = new Image("img/kitchenSink.png", 80, 120, false, false);
        Sprite kitchenSink = new Sprite();
        kitchenSink.setImage(kitchenSinkImage);
        kitchenSink.setPosition(stove.getX() + stove.getWidth() + 5, 36);

        //The fridge object
        Image fridgeImage = new Image("img/fridge.png", 70, 125, false, false);
        Sprite fridge = new Sprite();
        fridge.setImage(fridgeImage);
        fridge.setPosition(kitchenSink.getX() + kitchenSink.getWidth() + (2 * brickSingleHorizontal.getWidth()) + 20, 30);

        //The kitchenTable object
        Image kitchenTableImage = new Image("img/table_burned_burned.png", 267, 151, false, false);
        Sprite kitchenTable = new Sprite();
        kitchenTable.setImage(kitchenTableImage);
        kitchenTable.setPosition(30, 199);


        //The sofa object
        Image sofaImage = new Image("img/sofa.png", 240, 140, false, false);
        Sprite sofa = new Sprite();
        sofa.setImage(sofaImage);
        sofa.setPosition(LIVINGROOM_X + LIVINGROOM_WIDTH - sofa.getWidth() + 5, LIVINGROOM_Y - 80);

        //The coffeeTable object
        Image coffeeTableImage = new Image("img/coffeeTable.png", 150, 100, false, false);
        Sprite coffeeTable = new Sprite();
        coffeeTable.setImage(coffeeTableImage);
        coffeeTable.setPosition(LIVINGROOM_WIDTH - coffeeTable.getWidth() - 70, LIVINGROOM_Y);

        //The livingRoomChair object
        Image livingRoomChairImage = new Image("img/livingChair.png", 150, 100, false, false);
        Sprite livingRoomChair = new Sprite();
        livingRoomChair.setImage(livingRoomChairImage);
        livingRoomChair.setPosition(LIVINGROOM_WIDTH - livingRoomChair.getWidth() - 20, LIVINGROOM_Y + livingRoomChair.getHeight());

        //The livingDresser object
        Image livingDresserImage = new Image("img/dresser.png", 150, 100, false, false);
        Sprite livingDresser = new Sprite();
        livingDresser.setImage(livingDresserImage);
        livingDresser.setPosition(LIVINGROOM_X + 20, LIVINGROOM_Y - 60);

        //The rubberPlant object
        Image rubberPlantImage = new Image("img/robber plant_burned.png", 65, 90, false, false);
        Sprite rubberPlant = new Sprite();
        rubberPlant.setImage(rubberPlantImage);
        rubberPlant.setPosition(LIVINGROOM_X + livingDresser.getWidth() + 25, LIVINGROOM_Y - 60);

        //The tv object
        Image tvImage = new Image("img/tv.png", 180, 150, false, false);
        Sprite tv = new Sprite();
        tv.setImage(tvImage);
        tv.setPosition(LIVINGROOM_X, LIVINGROOM_Y + 130);

        //The desk object
        Image deskImage = new Image("img/desk.png", 180, 140, false, false);
        Sprite desk = new Sprite();
        desk.setImage(deskImage);
        desk.setPosition(BEDROOM_X + 10, canvas.getHeight() / 2 - 60);

        //The bed object
        Image bedImage = new Image("img/bed.png", 200, 170, false, false);
        Sprite bed = new Sprite();
        bed.setImage(bedImage);
        bed.setPosition(canvas.getWidth() - bedImage.getWidth() - brickSingleVert.getWidth() - 10, 50);

        //The wardrobe object
        Image wardrobeImage = new Image("img/wardrobe_burned.png", 150, 150, false, false);
        Sprite wardrobe = new Sprite();
        wardrobe.setImage(wardrobeImage);
        wardrobe.setPosition(bed.getX() - wardrobe.getWidth() - 90, 23);

        //The toilet object
        Image toiletImage = new Image("img/toilet.png", 100, 110, false, false);
        Sprite toilet = new Sprite();
        toilet.setImage(toiletImage);
        toilet.setPosition(canvas.getWidth() - toilet.getWidth() - brickSingleVert.getWidth(), BATHROOM_Y - 70);

        //The bathtub object
        Image bathtubImage = new Image("img/bathtub.png", BATHROOM_WIDTH - 50, 170, false, false);
        Sprite bathtub = new Sprite();
        bathtub.setImage(bathtubImage);
        bathtub.setPosition(BATHROOM_X + 30, BATHROOM_Y + 120);

        //The bathroomSink object
        Image sinkImage = new Image("img/sink.png", 110, 130, false, false);
        Sprite bathroomSink = new Sprite();
        bathroomSink.setImage(sinkImage);
        bathroomSink.setPosition(BATHROOM_X + 10, BATHROOM_Y - 70);

        // Preparing sounds
        AudioClip wallHit = new AudioClip(Paths.get("src/sounds/wall_hit.wav").toUri().toString());
//      AudioClip walking = new AudioClip(Paths.get("src/sounds/walking.wav").toUri().toString());


        LongValue lastNanoTime = new LongValue(System.nanoTime());
        IntValue score = new IntValue(0);
        AtomicInteger stepCounter = new AtomicInteger(0);

        //The animation begins
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;

                Rectangle2D sofaBoundary = sofa.getBoundary();
                Rectangle2D wardrobeBoundary = wardrobe.getBoundary();
                Rectangle2D stoveBoundary = stove.getBoundary();
                Rectangle2D kitchenDresserBoundary = kitchenDresser.getBoundary();
                Rectangle2D kitchenSinkBoundary = kitchenSink.getBoundary();
                Rectangle2D kitchenTableBoundary = kitchenTable.getBoundary();
                Rectangle2D fridgeBoundary = fridge.getBoundary();
                Rectangle2D rubberPlantBoundary = rubberPlant.getBoundary();
                Rectangle2D livingDresserBoundary = livingDresser.getBoundary();
                Rectangle2D oldRadioBoundary = livingRoomChair.getBoundary();
                Rectangle2D tvBoundary = tv.getBoundary();
                Rectangle2D livingRoomChairBoundary = livingRoomChair.getBoundary();
                Rectangle2D coffeeTableBoundary = coffeeTable.getBoundary();
                Rectangle2D bedBoundary = bed.getBoundary();
                Rectangle2D deskBoundary = desk.getBoundary();
                Rectangle2D toiletBoundary = toilet.getBoundary();
                Rectangle2D bathtubBoundary = bathtub.getBoundary();
                Rectangle2D bathroomSinkBoundary = bathroomSink.getBoundary();

                // Player movement

                player.setVelocity(0, 0);
                if (input.contains("LEFT")) {
                    if (player.leftBoundary().intersects(kitchenSinkBoundary) ||
                            player.leftBoundary().intersects(kitchenTableBoundary) ||
                            player.leftBoundary().intersects(wardrobeBoundary) ||
                            player.leftBoundary().intersects(livingRoomChairBoundary) ||
                            player.leftBoundary().intersects(fridgeBoundary) ||
                            player.leftBoundary().intersects(desk.getX(), desk.getY() + 40, desk.getWidth(), desk.getHeight()) || //desk
                            player.leftBoundary().intersects(toilet.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), toilet.getWidth(), 50) || //toilet
                            player.leftBoundary().intersects(bathtub.getX(), bathtub.getY() + 100, bathtub.getWidth(), bathtub.getHeight()) || //bathtub
                            player.leftBoundary().intersects(bathroomSink.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), bathroomSink.getWidth(), 70) || //bathroom sink
                            player.leftBoundary().intersects(rubberPlant.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), rubberPlant.getWidth(), carpet.getHeight() / 4 + brickSingleHorizontal.getHeight()) || //rubber plant
                            player.leftBoundary().intersects(tv.getX(), tv.getY() + 100, tv.getWidth(), tv.getHeight()) || //tv
                            player.leftBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight())) || // wall between kitchen and bedroom
                            player.leftBoundary().intersects(0, 0, brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall left from entrance
                            player.leftBoundary().intersects(0, 0, brickSingleVert.getWidth(), canvas.getHeight() + wallShort.getHeight()) || //left border
                            player.leftBoundary().intersects(brickSingleVert.getWidth(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between kitchen and living room
                            player.leftBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                            player.leftBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert.getWidth(), brickSingleVert.getHeight() * 2) || // wall between kitchen and bedroom(one brick)
                            player.leftBoundary().intersects(BATHROOM_X - brickSingleVert.getWidth(), BATHROOM_Y, brickSingleVert.getWidth(), BATHROOM_HEIGHT + 40)) { //wall between living room and bathroom

                        //checks if another button is already pressed; prevents sound spam
                        if (input.contains("UP") || input.contains("DOWN")) {
                            player.hasAlreadyHit = true;
                        }

                        if (!player.hasAlreadyHit) {
                            wallHit.play(1);
                        }

                        player.hasAlreadyHit = true;
                        player.addVelocity(0, 0);
                    } else {
                        player.addVelocity(-90, 0);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10) {
                            String tempImage = playerLeftImages.pop();
                            playerLeftImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                        player.hasAlreadyHit = false;
                    }
                }
                if (input.contains("RIGHT")) {
                    if (player.rightBoundary().intersects(fridgeBoundary) ||
                            player.rightBoundary().intersects(bedBoundary) ||
                            player.rightBoundary().intersects(livingRoomChairBoundary) ||
                            player.rightBoundary().intersects(desk.getX(), desk.getY() + 40, desk.getWidth(), desk.getHeight()) || //desk
                            player.rightBoundary().intersects(bathtub.getX(), bathtub.getY() + 100, bathtub.getWidth(), bathtub.getHeight()) || //bathtub
                            player.rightBoundary().intersects(toilet.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), toilet.getWidth(), 50) || //toilet
                            player.rightBoundary().intersects(coffeeTable.getX(), coffeeTable.getY(), coffeeTable.getWidth(), 3 * (carpet.getHeight() / 4) - 30) || // coffee table
                            player.rightBoundary().intersects(sofa.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), sofa.getWidth(), carpet.getHeight() / 2 + (2 * brickSingleHorizontal.getHeight())) || // sofa
                            player.rightBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight())) || // wall between kitchen and bedroom
                            player.rightBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), 0, 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                            player.rightBoundary().intersects(canvas.getWidth() - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), canvas.getHeight() + 40) || //right border
                            player.rightBoundary().intersects(brickSingleVert.getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal.getHeight(), 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between bedroom and bathroom
                            player.rightBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                            player.rightBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert.getWidth(), brickSingleVert.getHeight() * 2) || // wall between kitchen and bedroom(one brick)
                            player.rightBoundary().intersects(BATHROOM_X - brickSingleVert.getWidth(), BATHROOM_Y, brickSingleVert.getWidth(), BATHROOM_HEIGHT + 40)) { //wall between living room and bathroom

                        if (input.contains("UP") || input.contains("DOWN")) {
                            player.hasAlreadyHit = true;
                        }

                        if (!player.hasAlreadyHit) {
                            wallHit.play(1);
                        }

                        player.hasAlreadyHit = true;
                        player.addVelocity(0, 0);
                    } else {
                        player.addVelocity(90, 0);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10) {
                            String tempImage = playerRightImages.pop();
                            playerRightImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                        player.hasAlreadyHit = false;
                    }
                }
                if (input.contains("UP")) {
                    if (player.upperBoundary().intersects(kitchenDresserBoundary) ||
                            player.upperBoundary().intersects(kitchenSinkBoundary) ||
                            player.upperBoundary().intersects(kitchenTableBoundary) ||
                            player.upperBoundary().intersects(fridgeBoundary) ||
                            player.upperBoundary().intersects(wardrobeBoundary) ||
                            player.upperBoundary().intersects(stoveBoundary) ||
                            player.upperBoundary().intersects(coffeeTableBoundary) ||
                            player.upperBoundary().intersects(bedBoundary) ||
                            player.upperBoundary().intersects(livingRoomChairBoundary) ||
                            player.rightBoundary().intersects(toilet.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), toilet.getWidth(), 50) || //toilet
                            player.upperBoundary().intersects(bathroomSink.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), bathroomSink.getWidth(), 70) || //bathroom sink
                            player.upperBoundary().intersects(sofa.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), sofa.getWidth(), carpet.getHeight() / 2 + (2 * brickSingleHorizontal.getHeight())) || // sofa
                            player.upperBoundary().intersects(livingDresser.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), livingDresser.getWidth(), carpet.getHeight() / 4 + brickSingleHorizontal.getHeight()) || //living room dresser
                            player.upperBoundary().intersects(rubberPlant.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), rubberPlant.getWidth(), carpet.getHeight() / 4 + brickSingleHorizontal.getHeight()) || //rubber plant
                            player.upperBoundary().intersects(0, 0, brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight()) || //upper wall right from entrance
                            player.upperBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), wallShort.getHeight(), 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //upper wall right from entrance
                            player.upperBoundary().intersects(brickSingleVert.getWidth(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between kitchen and living room
                            player.upperBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                            player.upperBoundary().intersects(brickSingleVert.getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal.getHeight(), 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between bedroom and bathroom
                            player.upperBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()))) { //wall between kitchen and bedroom

                        if (input.contains("LEFT") || input.contains("RIGHT")) {
                            player.hasAlreadyHit = true;
                        }

                        if (!player.hasAlreadyHit) {
                            wallHit.play(1);
                        }

                        player.hasAlreadyHit = true;
                        player.addVelocity(0, 0);
                    } else {
                        player.addVelocity(0, -90);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10) {
                            String tempImage = playerUpImages.pop();
                            playerUpImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                        player.hasAlreadyHit = false;
                    }
                }
                if (input.contains("DOWN")) {
                    if (player.bottomBoundary().intersects(kitchenTableBoundary) ||
                            player.bottomBoundary().intersects(livingRoomChairBoundary) ||
                            player.bottomBoundary().intersects(desk.getX(), desk.getY() + 40, desk.getWidth(), desk.getHeight()) || //desk
                            player.bottomBoundary().intersects(tv.getX(), tv.getY() + 100, tv.getWidth(), tv.getHeight()) || //tv
                            player.bottomBoundary().intersects(bathtub.getX(), bathtub.getY() + 100, bathtub.getWidth(), bathtub.getHeight()) || //bathtub
                            player.bottomBoundary().intersects(0, 0, brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                            player.bottomBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), 0, 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                            player.bottomBoundary().intersects(brickSingleVert.getWidth(), LIVINGROOM_Y - brickSingleHorizontal.getHeight() - 5, 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between kitchen and living room
                            player.bottomBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight() - 5, 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                            player.bottomBoundary().intersects(brickSingleVert.getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal.getHeight() - 5, 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between bedroom and bathroom
                            player.bottomBoundary().intersects(0, canvas.getHeight() - 10, canvas.getWidth(), brickSingleHorizontal.getHeight()) || //down border
                            player.bottomBoundary().intersects(0, wallShort.getHeight(), brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight()) || //upper wall left from entrance
                            player.bottomBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), wallShort.getHeight(), 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //upper wall right from entrance
                            player.bottomBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert.getWidth(), brickSingleVert.getHeight() * 2)) { // wall between kitchen and bedroom(one brick)

                        if (input.contains("LEFT") || input.contains("RIGHT")) {
                            player.hasAlreadyHit = true;
                        }

                        if (!player.hasAlreadyHit) {
                            wallHit.play(1);
                        }

                        player.hasAlreadyHit = true;
                        player.addVelocity(0, 0);
                    } else {
                        player.addVelocity(0, 90);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10) {
                            String tempImage = playerDownImages.pop();
                            playerDownImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                        player.hasAlreadyHit = false;
                    }
                }
                player.update(elapsedTime);

                // Render the image objects

//                double startCarpetY = brickHorizontal.getHeight() + wallShort.getHeight() + (2 * parquet.getHeight()) + brickHorizontal.getHeight();
//                double tilesStartX = (2 * brickVertical.getWidth()) + (2 * carpet.getWidth());
                double doorWidth = 2 * brickSingleHorizontal.getWidth();
                double wallKitchenLivingRoomWidth = 0;
                double wallKitchenLivingRoomBedroomBathroomWidth = 0;
                double wallUpBorder1 = 0;
                double wallKitchenBedroomHeight = 0;

                //Draw pavements of different rooms
                gc.clearRect(0, 0, 1024, 768);
                gc.drawImage(parquet, KITCHEN_X, KITCHEN_Y);
                gc.drawImage(parquet, KITCHEN_X, KITCHEN_Y + KITCHEN_HEIGHT / 2);
                gc.drawImage(carpet2, BEDROOM_X, BEDROOM_Y);
                gc.drawImage(carpet2, BEDROOM_X, BEDROOM_Y + BEDROOM_HEIGHT / 2);
                gc.drawImage(tiles, BATHROOM_X, BATHROOM_Y);
                gc.drawImage(tiles, BATHROOM_X, BATHROOM_Y + BATHROOM_HEIGHT / 2);
                gc.drawImage(carpet, LIVINGROOM_X, LIVINGROOM_Y);
                gc.drawImage(carpet, LIVINGROOM_X + LIVINGROOM_WIDTH / 2, LIVINGROOM_Y);
                gc.drawImage(carpet, LIVINGROOM_X, LIVINGROOM_Y + LIVINGROOM_HEIGHT / 2);
                gc.drawImage(carpet, LIVINGROOM_X + LIVINGROOM_WIDTH / 2, LIVINGROOM_Y + LIVINGROOM_HEIGHT / 2);

                //Draw upper walls and bricks

                //Upper border
                for (int i = 0; i < 4; i++) {
                    gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), 0);
                    gc.drawImage(wallShort, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight());
                    wallUpBorder1 += brickSingleHorizontal.getWidth();
                }
                for (int i = 0; i < canvas.getWidth() / brickSingleHorizontal.getWidth(); i++) {
                    gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (i * brickSingleHorizontal.getWidth()), 0);
                    gc.drawImage(wallShort, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (i * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight());
                }

                //wall between kitchen and bedroom
                for (int i = 0; i < 3; i++) {
                    gc.drawImage(brickSingleVert, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), i * brickSingleVert.getHeight());
                    wallKitchenBedroomHeight += brickSingleVert.getHeight();
                }
                for (int i = 0; i < 2; i++) {
                    gc.drawImage(wallColon, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), wallKitchenBedroomHeight + (i * wallColon.getHeight()));
                }

                kitchenDresser.render(gc);
                stove.render(gc);
                kitchenSink.render(gc);
                fridge.render(gc);
                kitchenTable.render(gc);
                wardrobe.render(gc);
                bed.render(gc);

                //Draw the player if it`s in the first half of the screen(above the top walls
                // and behind the middle walls)
                if (player.bottomBoundary().intersects(0, 0, canvas.getWidth(), brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT)) {
                    player.render(gc);
                }

                desk.render(gc);

                //wall between kitchen and bedroom(single brick)
                //POSITION MUST BE HERE!!!
                for (int i = 0; i < 2; i++) {
                    gc.drawImage(brickSingleVert, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), wallKitchenBedroomHeight + (2 * wallColon.getHeight()) + brickSingleVert.getHeight());
                }

                //render the  middle walls

                //wall between kitchen and livingRoom(draw 4 bricks)
                for (int i = 0; i < 4; i++) {
                    gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() / 2);
                    gc.drawImage(wallShort, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), (canvas.getHeight() / 2) + brickSingleHorizontal.getHeight());
                    wallKitchenLivingRoomWidth += brickSingleHorizontal.getWidth();
                }

                //wall between kitchen, livingRoom, bedroom and bathroom(draw 6 bricks)
                for (int i = 0; i < 6; i++) {
                    gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() / 2);
                    gc.drawImage(wallShort, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), (canvas.getHeight() / 2) + brickSingleHorizontal.getHeight());
                    wallKitchenLivingRoomBedroomBathroomWidth += brickSingleHorizontal.getWidth();
                }

                //wall between bedroom and bathroom(draw 2 bricks)
                for (int i = 0; i < 2; i++) {
                    gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() / 2);
                    gc.drawImage(wallShort, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), (canvas.getHeight() / 2) + brickSingleHorizontal.getHeight());
                }

                //wall between living room and bathroom
                for (int i = 0; i < canvas.getHeight(); i++) {
                    gc.drawImage(brickSingleVert, 2 * (canvas.getWidth() / 3) - brickSingleHorizontal.getWidth(), canvas.getHeight() / 2 + (i * brickSingleVert.getHeight()));
                }

                //Render the bricks

                //Left border
                for (int i = 0; i < canvas.getHeight() / brickSingleVert.getHeight(); i++) {
                    gc.drawImage(brickSingleVert, 0, i * brickSingleVert.getHeight());
                }

                sofa.render(gc);
                coffeeTable.render(gc);
                rubberPlant.render(gc);
                livingDresser.render(gc);
                livingRoomChair.render(gc);
                toilet.render(gc);
                bathroomSink.render(gc);
                gc.drawImage(siphon, BATHROOM_X + (BATHROOM_WIDTH / 2) - (siphon.getWidth() / 2), BATHROOM_Y + 100);

                //Player above the middle wall and the obstacles in the low middle part of the screen
                if (player.bottomBoundary().intersects(0, brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT, canvas.getWidth(), brickSingleHorizontal.getHeight() + LIVINGROOM_HEIGHT + 40)) {
                    player.render(gc);
                }

                bathtub.render(gc);
                tv.render(gc);

                //Down border
                for (int i = 0; i < canvas.getWidth() / brickSingleHorizontal.getWidth(); i++) {
                    gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() - 2 * brickSingleHorizontal.getHeight());
                }


                //Right border
                for (int i = 0; i < canvas.getHeight() / brickSingleVert.getHeight(); i++) {
                    gc.drawImage(brickSingleVert, canvas.getWidth() - brickSingleVert.getWidth(), i * brickSingleVert.getHeight());
                }

            }
        }.start();

        theStage.show();
    }
}