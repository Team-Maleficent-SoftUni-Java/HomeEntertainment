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

    private static final Rectangle2D leftBorder = new Rectangle2D(0, 0, BRICK_SINGLE_VERTICAL
            .getWidth(), CANVAS_FAKE_HEIGHT + WALL_SHORT.getHeight());
    private static final Rectangle2D rightBorder = new Rectangle2D(GlobalVariables.getCanvas()
            .getWidth() - BRICK_SINGLE_VERTICAL.getWidth(), 0, BRICK_SINGLE_VERTICAL
            .getWidth(), CANVAS_FAKE_HEIGHT + 40);
    private static final Rectangle2D downBorder = new Rectangle2D(0, CANVAS_FAKE_HEIGHT - 10,
            GlobalVariables.getCanvas().getWidth(), BRICK_SINGLE_HORIZONTAL.getHeight());
    private static final Rectangle2D upperBorder = new Rectangle2D(0, 0, GlobalVariables.getCanvas().getWidth(),
            WALL_SHORT.getHeight());

    public IntersectsObjectLevel2() {

    }

    public static Rectangle2D getLeftBorder() {
        return leftBorder;
    }

    public static Rectangle2D getRightBorder() {
        return rightBorder;
    }

    public static Rectangle2D getDownBorder() {
        return downBorder;
    }

    public static Rectangle2D getUpperBorder() {
        return upperBorder;
    }
}