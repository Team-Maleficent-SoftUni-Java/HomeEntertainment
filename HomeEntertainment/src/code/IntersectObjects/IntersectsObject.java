package code.IntersectObjects;

import code.Player.Sprite;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntersectsObject {

    private List<Rectangle2D> rectangle2DList;

    public IntersectsObject() {
        rectangle2DList = new ArrayList<>();
    }

    public List<Rectangle2D> getRectangle2DList() {
        return this.rectangle2DList;
    }

    public void addElement(Rectangle2D rect) {
        this.getRectangle2DList().add(rect);
    }

    public void removeElement(Rectangle2D rectangle2D) {
        this.getRectangle2DList().remove(rectangle2D);
    }

    void setRectangle2DList(List<Rectangle2D> rectangle2DList) {
        this.rectangle2DList = rectangle2DList;
    }

    public boolean intersect(Rectangle2D playerBoundry) {
        for (Rectangle2D rectangle2D : this.getRectangle2DList()) {
            if (playerBoundry.intersects(rectangle2D)) {
                return true;
            }
        }
        return false;
    }

    public boolean intersect(Sprite monster) {
        for (Rectangle2D rectangle2D : this.getRectangle2DList()) {
            if (monster.intersects(rectangle2D)) {
                return true;
            }
        }
        return false;
    }
}
