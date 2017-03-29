package code.player;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private boolean hasAlreadyHit;
    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    public Sprite() {
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;
        this.setHasAlreadyHit(false);
    }

    public void setImage(Image i) {
        this.image = i;
        this.width = i.getWidth();
        this.height = i.getHeight();
    }

    void setHasAlreadyHit(boolean hasAlreadyHit) {
        this.hasAlreadyHit = hasAlreadyHit;
    }

    boolean getHasAlreadyHit() {
        return hasAlreadyHit;
    }

    void setImage(String filename) {
        Image i = new Image(filename, 45, 120, false, false);
        setImage(i);
    }

    void setSprayImage(String filename) {
        Image i = new Image(filename, 70, 120, false, false);
        setImage(i);
    }

    Rectangle2D sprayBoundary() {
        return new Rectangle2D(this.positionX, this.positionY, this.width+50, this.height+50);
    }

    public void setPosition(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }

    public double getX(){
        return this.positionX;
    }

    public double getY(){
        return this.positionY;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public void setVelocity(double x, double y) {
        this.velocityX = x;
        this.velocityY = y;
    }

    void addVelocity(double x, double y) {
        this.velocityX += x;
        this.velocityY += y;
    }

    public void update(double time) {
        this.positionX += this.velocityX * time;
        this.positionY += this.velocityY * time;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(this.image, this.positionX, this.positionY);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(this.positionX, this.positionY, this.width, this.height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public boolean intersects(Rectangle2D rect) {
        return rect.intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + this.positionX + "," + this.positionY + "]"
                + " Velocity: [" + this.velocityX + "," + this.velocityY + "]";
    }
    public Rectangle2D bottomBoundary(){
        return new Rectangle2D(this.positionX+2, this.positionY+height,this.width-4,0);
    }

    public Rectangle2D upperBoundary(){
        return new Rectangle2D(this.positionX+2,this.positionY+height-20,this.width-4,0);
    }

    public Rectangle2D leftBoundary(){
        return new Rectangle2D(this.positionX,this.positionY+height-18,0,14);
    }

    public Rectangle2D rightBoundary(){
        return new Rectangle2D(this.positionX + this.width,this.positionY + this.height-18,0,14);
    }
}