package models;

import javafx.scene.shape.Circle;

/**
 * Created by Никита on 24.08.2017.
 */
public abstract class AbstractBonus {
    double radius;
    int xCoord;
    int yCoord;
    Circle bonusFigure;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public Circle getBonusFigure() {
        return bonusFigure;
    }

    public void setBonusFigure(Circle bonusFigure) {
        this.bonusFigure = bonusFigure;
    }
}
