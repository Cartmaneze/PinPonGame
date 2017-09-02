package models;

import javafx.scene.shape.Circle;

/**
 * Created by Никита on 07.08.2017.
 */
public class PlayerPon extends AbstractPon {

    public PlayerPon(Circle playerPonFigure) {
        this.playerPonFigure = playerPonFigure;
    }

    private Circle playerPonFigure;
    private double speed;

    public Circle getPlayerPonFigure() {
        return playerPonFigure;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
