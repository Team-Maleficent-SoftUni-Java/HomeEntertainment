package code.graphics;

import code.player.Sprite;
import javafx.scene.image.Image;


public class Plant {

    private static final String IMG_TREE1_URL = "img/Tree1.png";
    private static final String IMG_TREE2_URL = "img/Tree2.png";
    private static final String IMG_TREE3_URL = "img/Tree3.png";
    private static final String IMG_BOR_URL = "img/bor.png";
    private static final String IMG_PEACH_URL = "img/peach.png";
    private static final String IMG_FERN_URL = "img/paprat.png";
    private static final String IMG_FLOWER1_URL = "img/flower1.png";
    private static final String IMG_FLOWER2_URL = "img/flower2.png";
    private static final String IMG_FLOWER3_URL = "img/flower3.png";
    private static final String IMG_DWARF1_URL = "img/dwarf1.png";
    private static final String IMG_ROCK_URL = "img/rock.png";
    private static final String IMG_FOUNTAIN_URL = "img/fontan.png";
    private static final int TREE_WIDTH = 150;
    private static final int TREE_HEIGHT = 200;
    private static final int FERN_WIDTH = 70;
    private static final int FERN_HEIGHT = 100;
    private static final int FLOWER2_WIDTH = 90;
    private static final int FLOWER2_HEIGHT = 50;
    private static final int FLOWER3_WIDTH = 100;
    private static final int FLOWER3_HEIGHT = 60;
    private static final int DWARF_HEIGHT = 80;
    private static final int DWARF_WIDTH = 50;
    private static final int SMALL_ROCK_WIDTH = 30;
    private static final int SMALL_ROCK_HEIGHT = 20;
    private static final int BIG_ROCK_WIDTH = 60;
    private static final int BIG_ROCK_HEIGHT = 40;
    private static final int FOUNTAIN_WIDTH = 250;
    private static final int FOUNTAIN_HEIGHT = 180;

    private static final Image BIG_ROCK_IMAGE = new Image(IMG_ROCK_URL, BIG_ROCK_WIDTH, BIG_ROCK_HEIGHT, false, false);
    private static final Image SMALL_ROCK_IMAGE = new Image(IMG_ROCK_URL, SMALL_ROCK_WIDTH, SMALL_ROCK_HEIGHT, false, false);
    private static final Image DWARF_IMAGE = new Image(IMG_DWARF1_URL, DWARF_WIDTH, DWARF_HEIGHT, false, false);
    private static final Image THIRD_FLOWER_IMAGE = new Image(IMG_FLOWER3_URL, FLOWER3_WIDTH, FLOWER3_HEIGHT, false, false);
    private static final Image SECOND_FLOWER_IMAGE = new Image(IMG_FLOWER2_URL, FLOWER2_WIDTH, FLOWER2_HEIGHT, false, false);
    private static final Image FIRST_TREE_IMAGE = new Image(IMG_TREE1_URL, TREE_WIDTH, TREE_HEIGHT, false, false);
    private static final Image SECOND_TREE_IMAGE = new Image(IMG_TREE2_URL, TREE_WIDTH, TREE_HEIGHT, false, false);
    private static final Image THIRD_TREE_IMAGE = new Image(IMG_TREE3_URL, TREE_WIDTH, TREE_HEIGHT, false, false);
    private static final Image FOURTH_TREE_IMAGE = new Image(IMG_BOR_URL, TREE_WIDTH, TREE_HEIGHT, false, false);
    private static final Image FIFTH_TREE_IMAGE = new Image(IMG_PEACH_URL, TREE_WIDTH, TREE_HEIGHT, false, false);
    private static final Image FERN_IMAGE = new Image(IMG_FERN_URL, FERN_WIDTH, FERN_HEIGHT, false, false);
    private static final Image FIRST_FLOWER_IMAGE = new Image(IMG_FLOWER1_URL, TREE_WIDTH, FERN_HEIGHT, false, false);
    private static final Image FOUNTAIN_IMAGE = new Image(IMG_FOUNTAIN_URL, FOUNTAIN_WIDTH, FOUNTAIN_HEIGHT, false, false);

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
