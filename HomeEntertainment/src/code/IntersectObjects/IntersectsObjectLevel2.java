package code.IntersectObjects;

import code.GlobalVariables;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static code.GlobalVariables.CANVAS_FAKE_HEIGHT;
import static code.Graphics.ImageController.BRICK_SINGLE_HORIZONTAL;
import static code.Graphics.ImageController.BRICK_SINGLE_VERTICAL;
import static code.Graphics.ImageController.WALL_SHORT;

public class IntersectsObjectLevel2 extends IntersectsObject {
    //private Rectangle2D wardrobeBoundary = FurnitureObjects.getWardrobe().getBoundary();
    private Rectangle2D leftBorder = new Rectangle2D(0, 0, BRICK_SINGLE_VERTICAL
            .getWidth(), CANVAS_FAKE_HEIGHT + WALL_SHORT.getHeight());
    private Rectangle2D rightBorder = new Rectangle2D(GlobalVariables.getCanvas()
            .getWidth() - BRICK_SINGLE_VERTICAL.getWidth(), 0, BRICK_SINGLE_VERTICAL
            .getWidth(), CANVAS_FAKE_HEIGHT + 40);
    private Rectangle2D downBorder = new Rectangle2D(0, CANVAS_FAKE_HEIGHT - 10,
            GlobalVariables.getCanvas().getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight());
    //private Rectangle2D upperBorder = new Rectangle2D(0, 0, GlobalVariables.getCanvas().getWidth(), BRICK_SINGLE_HORIZONTAL
    //        .getHeight() + WALL_SHORT.getHeight());

    public IntersectsObjectLevel2() {
        super.setRectangle2DList(this.setIntersectObjects());
    }

    private List<Rectangle2D> setIntersectObjects() {
        List<Rectangle2D> rectangle2DList = new ArrayList<>();

        Collections.addAll(rectangle2DList, leftBorder, rightBorder, downBorder);
        return rectangle2DList;
    }
}
