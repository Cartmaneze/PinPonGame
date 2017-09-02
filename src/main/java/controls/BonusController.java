package controls;

import finals.Finals;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import models.*;
import view.Levels;

/**
 * Created by Никита on 13.08.2017.
 */
public class BonusController implements Runnable  {

    public BonusController(Ball ball, PlayerPon playerPon) {
        this.ball = ball;
        this.playerPon = playerPon;
    }

    Ball ball;
    PlayerPon playerPon;
    AbstractBonus bonus;
    boolean bonusExist = false;
    int previousBallDelNumber;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Finals.getmSecGameStep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (bonusExist) {
                double ponBonusDistance = Math.sqrt(((playerPon.getCoordX() - bonus.getxCoord()) * (playerPon.getCoordX() - bonus.getxCoord())) + ((playerPon.getCoordY() - bonus.getyCoord()) * (playerPon.getCoordY() - bonus.getyCoord())));

                if (ponBonusDistance <= Finals.getPonBonusTouchDistance()) {
                    if (bonus instanceof SpeedBonus) {
                        Finals.setGlobalSpeed(Finals.getGlobalSpeed() - 5);
                        changeBallColor(Finals.getGlobalSpeed());
                    } else if (bonus instanceof GoalBonus) {
                        goalUpdate(1);
                    }

                    bonusExist = false;
                    figureRemove(bonus.getBonusFigure());

                } else if (ball.getCoordX() < 450) {
                    double ballBonusDistance = Math.sqrt(((ball.getCoordX() - bonus.getxCoord()) * (ball.getCoordX() - bonus.getxCoord())) + ((ball.getCoordY() - bonus.getyCoord()) * (ball.getCoordY() - bonus.getyCoord())));
                    if (ballBonusDistance <= Finals.getBallBonusTouchDistance()) {
                        if (bonus instanceof SpeedBonus) {
                            Finals.setGlobalSpeed(Finals.getGlobalSpeed() - 10);
                            changeBallColor(Finals.getGlobalSpeed());
                        } else if (bonus instanceof GoalBonus) {
                            goalUpdate(3);
                        }

                        bonusExist = false;
                        figureRemove(bonus.getBonusFigure());
                        double distance = Finals.getBallBonusTouchDistance();
                        checkBallBonusKick(distance);
                    }
                }


            }

            int ballDelCount = ball.getDeleteBallCount();
            if (ballDelCount!=previousBallDelNumber && !bonusExist && ballDelCount % 20 == 0 && ballDelCount / 20 > 0) {
                previousBallDelNumber = ballDelCount;

                int randomX = (int) (Math.random() * 400) + 50;
                int randomY = (int) (Math.random() * 718) + 50;

                int bonusRandom = (int) (Math.random() * 10) + 1;

                if (bonusRandom <=5) {
                    bonus = new GoalBonus(randomX, randomY);
                    Circle circle = new Circle(bonus.getRadius());
                    circle.setLayoutX(bonus.getxCoord());
                    circle.setLayoutY(bonus.getyCoord());
                    circle.setFill(RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  red, white)"));
                    bonus.setBonusFigure(circle);
                } else if(bonusRandom > 5) {
                    bonus = new SpeedBonus(randomX, randomY);
                    Circle circle = new Circle(bonus.getRadius());
                    circle.setLayoutX(bonus.getxCoord());
                    circle.setLayoutY(bonus.getyCoord());
                    circle.setFill(RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  blue, white)"));
                    bonus.setBonusFigure(circle);
                }

                addBonusFigure(bonus.getBonusFigure());
                bonusExist = true;

            }
        }
    }

    public void goalUpdate(int i) {
        Levels.getGoalBlock().setGoalCount(i);

        Rectangle rectangle = new Rectangle(Levels.getGoalBlock().getxCoord(), Levels.getGoalBlock().getyCoord(), Levels.getGoalBlock().getWidth(), Levels.getGoalBlock().getHeight());
        if (Levels.getGoalBlock().getGoalCount() == 3) {
            rectangle.setFill(Color.BLACK);
        } else if (Levels.getGoalBlock().getGoalCount() == 2) {
            rectangle.setFill(Color.RED);
        } else if (Levels.getGoalBlock().getGoalCount() == 1) {
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.RED);
            rectangle.setStrokeWidth(3);
        }
        goalChange(Levels.getGoalBlock().getRectangleFigure(), rectangle);
        Levels.getGoalBlock().setRectangleFigure(rectangle);
    }

    public void checkBallBonusKick(double distance){
        double angleRad = 0;
        double angleDegrees = 0;

        double a = ball.getCoordX() - bonus.getxCoord();
        double b = ball.getCoordY() - bonus.getyCoord();

        if (a > 0 && b > 0) {
            angleRad = Math.acos(-a / distance);
            angleDegrees = angleRad * (180 / Math.PI) + 180;
        } else if (a <= 0 && b <= 0) {
            angleRad = Math.acos(a / distance);
            angleDegrees = angleRad * (180 / Math.PI);
        } else if (a > 0 && b <= 0) {
            angleRad = Math.acos(a / distance);
            angleDegrees = angleRad * (180 / Math.PI);
        } else if (a <= 0 && b > 0) {
            angleRad = Math.acos(-a / distance);
            angleDegrees = angleRad * (180 / Math.PI) + 180;
        }

        ball.setDegree(angleDegrees);
    }

    public void addBonusFigure(final Circle circle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getRoot().getChildren().addAll(circle);
            }
        });
    }

    public void figureRemove(final Circle circle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getRoot().getChildren().remove(circle);
            }
        });
    }

    public void changeBallColor(final double speed) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (speed >= 3 && speed < 4) {
                    Levels.getBallFigure().setFill(Color.valueOf("#0000ff"));
                } else if (speed >= 4 && speed < 5) {
                    Levels.getBallFigure().setFill(Color.valueOf("#3100ff"));
                } else if (speed >= 5 && speed < 6) {
                    Levels.getBallFigure().setFill(Color.valueOf("#5a00ff"));
                } else if (speed >= 6 && speed < 7) {
                    Levels.getBallFigure().setFill(Color.valueOf("#8000ff"));
                } else if (speed >= 7 && speed < 8) {
                    Levels.getBallFigure().setFill(Color.valueOf("#bc00ff"));
                } else if (speed >= 8 && speed < 9) {
                    Levels.getBallFigure().setFill(Color.valueOf("#f300ff"));
                } else if (speed >= 9 && speed < 10) {
                    Levels.getBallFigure().setFill(Color.valueOf("#ff00c8"));
                } else if (speed >= 10 && speed < 12) {
                    Levels.getBallFigure().setFill(Color.valueOf("#ff0064"));
                } else if (speed >= 12 && speed < 14) {
                    Levels.getBallFigure().setFill(Color.valueOf("#ff0027"));
                } else if (speed >= 14 && speed < 16) {
                    Levels.getBallFigure().setFill(Color.valueOf("#ff0000"));
                }
            }
        });
    }

    public void goalChange(final Rectangle rectangle, final Rectangle newRectangle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getRoot().getChildren().remove(rectangle);
                Levels.getRoot().getChildren().addAll(newRectangle);
            }
        });
    }
}
