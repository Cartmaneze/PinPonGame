package models;

import javafx.scene.shape.Rectangle;

/**
 * Created by Никита on 15.08.2017.
 */
public abstract class AbstractBlock {
    int width;
    int height;
    int xCoord;
    int yCoord;
    Rectangle rectangleFigure;

    public Rectangle getRectangleFigure() {
        return rectangleFigure;
    }

    public void setRectangleFigure(Rectangle rectangleFigure) {
        this.rectangleFigure = rectangleFigure;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }
}
