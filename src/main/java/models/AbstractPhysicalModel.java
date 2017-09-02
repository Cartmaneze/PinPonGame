package models;

/**
 * Created by Никита on 09.08.2017.
 */
public abstract class AbstractPhysicalModel {
    private double coordX;
    private double coordY;
    private double speed;
    private double aceleration;
    private double weight;

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAceleration() {
        return aceleration;
    }

    public void setAceleration(double aceleration) {
        this.aceleration = aceleration;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
