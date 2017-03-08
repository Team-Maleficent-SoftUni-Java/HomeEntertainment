package code.Graphics;

import code.Player.Sprite;
import javafx.scene.image.Image;


public class Plant {

    private static final Image FIRST_TREE_IMAGE = new Image("img/Tree1.png", 150, 200, false, false);
    private static final Image SECOND_TREE_IMAGE = new Image("img/Tree2.png", 150, 200, false, false);
    private static final Image THIRD_TREE_IMAGE = new Image("img/Tree3.png", 150, 200, false, false);
    private static final Image FOURTH_TREE_IMAGE = new Image("img/bor.png", 150, 200, false, false);
    private static final Image FIFTH_TREE_IMAGE = new Image("img/peach.png", 150, 200, false, false);
    private static final Image FERN_IMAGE = new Image("img/paprat.png", 70, 100, false, false);
    private static final Image FIRST_FLOWER_IMAGE = new Image("img/flower1.png", 150, 100, false, false);
    private static final Image SECOND_FLOWER_IMAGE = new Image("img/flower2.png", 90, 50, false, false);
    private static final Image THIRD_FLOWER_IMAGE = new Image("img/flower3.png", 100, 60, false, false);
    private static final Image DWARF_IMAGE = new Image("img/dwarf1.png", 50, 80, false, false);
    private static final Image SMALL_ROCK_IMAGE = new Image("img/rock.png", 30, 20, false, false);
    private static final Image BIG_ROCK_IMAGE = new Image("img/rock.png", 60, 40, false, false);
    private static final Image FOUNTAIN_IMAGE = new Image("img/fontan.png", 250, 180, false, false);
    public static final int TREE_POINTS = 3;
    public static final int FLOWER_POINTS = 2;
    public static final int FOUNTAIN_POINTS = 5;
    public static final double SMALL_ROCK_POINTS = 0.5;
    public static final int BIG_ROCK__POINTS = 1;
    public static final int FERN_POINTS = 1;
    public static final double DWARF_POINTS = 0.5;

    private Sprite firstTree = new Sprite();
    private Sprite secondTree = new Sprite();
    private Sprite thirdTree = new Sprite();
    private Sprite fourthTree = new Sprite();
    private Sprite fifthTree = new Sprite();
    private Sprite firstFlower = new Sprite();
    private Sprite secondFlower = new Sprite();
    private Sprite thirdFlower = new Sprite();
    private Sprite dwarf = new Sprite();
    private Sprite fountain = new Sprite();
    private Sprite smallRock = new Sprite();
    private Sprite bigRock = new Sprite();
    private Sprite fern = new Sprite();

    public Plant(double x, double y) {
        this.setFirstTree(x, y);
        this.setSecondTree(x, y);
        this.setThirdTree(x, y);
        this.setFourthTree(x, y);
        this.setFifthTree(x, y);
        this.setFirstFlower(x, y);
        this.setSecondFlower(x, y);
        this.setThirdFlower(x, y);
        this.setDwarf(x, y);
        this.setFountain(x, y);
        this.setSmallRock(x, y);
        this.setBigRock(x, y);
        this.setFern(x, y);
    }

    public Sprite getFirstTree() {
        return this.firstTree;
    }

    public Sprite getSecondTree() {
        return this.secondTree;
    }

    public Sprite getThirdTree() {
        return this.thirdTree;
    }

    public Sprite getFourthTree() {
        return this.fourthTree;
    }

    public Sprite getFifthTree() {
        return this.fifthTree;
    }

    public Sprite getFirstFlower() {
        return this.firstFlower;
    }

    public Sprite getSecondFlower() {
        return this.secondFlower;
    }

    public Sprite getThirdFlower() {
        return this.thirdFlower;
    }

    public Sprite getDwarf() {
        return this.dwarf;
    }

    public Sprite getFountain() {
        return this.fountain;
    }

    public Sprite getSmallRock() {
        return this.smallRock;
    }

    public Sprite getBigRock() {
        return this.bigRock;
    }

    public Sprite getFern() {
        return this.fern;
    }

    private void setFirstTree(double x, double y) {
        firstTree.setImage(FIRST_TREE_IMAGE);
        firstTree.setPosition(x, y);
    }

    private void setSecondTree(double x, double y) {
        this.secondTree.setImage(SECOND_TREE_IMAGE);
        this.secondTree.setPosition(x, y);
    }

    private void setThirdTree(double x, double y) {
        this.thirdTree.setImage(THIRD_TREE_IMAGE);
        this.thirdTree.setPosition(x, y);
    }

    public void setFourthTree(double x, double y) {
        this.fourthTree.setImage(FOURTH_TREE_IMAGE);
        this.fourthTree.setPosition(x, y);
    }

    public void setFifthTree(double x, double y) {
        this.fifthTree.setImage(FIFTH_TREE_IMAGE);
        this.fifthTree.setPosition(x, y);
    }

    private void setFirstFlower(double x, double y) {
        this.firstFlower.setImage(FIRST_FLOWER_IMAGE);
        this.firstFlower.setPosition(x, y);
    }

    private void setSecondFlower(double x, double y) {
        this.secondFlower.setImage(SECOND_FLOWER_IMAGE);
        this.secondFlower.setPosition(x, y);
    }

    private void setThirdFlower(double x, double y) {
        this.thirdFlower.setImage(THIRD_FLOWER_IMAGE);
        this.thirdFlower.setPosition(x, y);
    }

    private void setDwarf(double x, double y) {
        this.dwarf.setImage(DWARF_IMAGE);
        this.dwarf.setPosition(x, y);
    }

    private void setFountain(double x, double y) {
        this.fountain.setImage(FOUNTAIN_IMAGE);
        this.fountain.setPosition(x, y);
    }

    private void setSmallRock(double x, double y) {
        this.smallRock.setImage(SMALL_ROCK_IMAGE);
        this.smallRock.setPosition(x, y);
    }

    private void setBigRock(double x, double y) {
        this.bigRock.setImage(BIG_ROCK_IMAGE);
        this.bigRock.setPosition(x, y);
    }

    private void setFern(double x, double y) {
        this.fern.setImage(FERN_IMAGE);
        this.fern.setPosition(x, y);
    }
}
