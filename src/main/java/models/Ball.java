package models;

import javafx.scene.shape.Circle;

/**
 * Created by Никита on 09.08.2017.
 */
public class Ball extends AbstractPhysicalModel {

    public Ball(Circle ballFigure) {
        this.ballFigure = ballFigure;
    }

    private Circle ballFigure;
    private double degree;
    private boolean frize;
    private int deleteBallCount;

    public Circle getBallFigure() {
        return ballFigure;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public boolean isFrize() {
        return frize;
    }

    public void setFrize(boolean frize) {
        this.frize = frize;
    }

    public int getDeleteBallCount() {
        return deleteBallCount;
    }

    public void setDeleteBallCount(int deleteBallCount) {
        this.deleteBallCount += deleteBallCount;
    }

    public void deleteBallCountToNol() {
        this.deleteBallCount = 0;
    }
}
