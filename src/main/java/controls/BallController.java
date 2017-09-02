package controls;

import finals.Finals;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import managers.BlockManager;
import models.*;
import view.Field;
import view.Levels;

/**
 * Created by Никита on 09.08.2017.
 */
public class BallController implements Runnable {

    public BallController(Ball ball, PlayerPon playerPon) {
        this.ball = ball;
        this.playerPon = playerPon;
    }

    Ball ball;
    PlayerPon playerPon;

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(Finals.getmSecGameStep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ball.setCoordX(ball.getBallFigure().getLayoutX());
            ball.setCoordY(ball.getBallFigure().getLayoutY());

            double ballPlayerDistance;
            if (ball.getCoordX() > 450) {
                ballPlayerDistance = Double.MAX_VALUE;
            } else {
                ballPlayerDistance = Math.sqrt(((ball.getCoordX() - playerPon.getCoordX()) * (ball.getCoordX() - playerPon.getCoordX())) + ((ball.getCoordY() - playerPon.getCoordY()) * (ball.getCoordY() - playerPon.getCoordY())));
            }

            if (ballPlayerDistance <= Finals.getBallPonTouchDistance()) {
                double distance = Finals.getBallPonTouchDistance();
                checkPonKick(playerPon, distance);
            }

            if (ball.getCoordX() <= ball.getBallFigure().getRadius() || ball.getCoordX() >= Field.windowSizeX - ball.getBallFigure().getRadius() || ball.getCoordY() <= ball.getBallFigure().getRadius() || ball.getCoordY() >= Field.windowSizeY - ball.getBallFigure().getRadius()) {
                checkFrameKick();
            }

            if (!ball.isFrize()) {
                for (AbstractBlock block : BlockManager.blocks) {
                    double xLeft = ball.getCoordX() + ball.getBallFigure().getRadius() - block.getxCoord();
                    double xRight = (block.getxCoord() + block.getWidth()) - (ball.getCoordX() - ball.getBallFigure().getRadius());

                    if (xLeft >= 0 && xRight >= 0) {
                        double yUp = ball.getCoordY() + ball.getBallFigure().getRadius() - block.getyCoord();
                        double yDown = (block.getyCoord() + block.getHeight()) - (ball.getCoordY() - ball.getBallFigure().getRadius());

                        if (yUp >= 0 && yDown >= 0) {
                            checkBlockKick(xLeft, xRight, yUp, yDown);

                            if (block instanceof SimpleBlock) {
                                figureRemove(block.getRectangleFigure());
                                Finals.setGlobalSpeed(Finals.getGlobalSpeed() + 0.3);
                                changeBallColor(Finals.getGlobalSpeed());
                                BlockManager.blocksToDelete.add(block);
                                ball.setDeleteBallCount(1);
                            } else if (block instanceof DoubleBlock) {
                                if (((DoubleBlock) block).getKickCount() > 0) {
                                    Rectangle rectangle = new Rectangle(block.getxCoord(), block.getyCoord(), block.getWidth(), block.getHeight());
                                    rectangle.setFill(RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  red, yellow, red)"));
                                    rectangle.setStroke(Color.DARKRED);
                                    rectangle.setStrokeMiterLimit(5);
                                    goalChange(block.getRectangleFigure(), rectangle);
                                    block.setRectangleFigure(rectangle);
                                    ((DoubleBlock) block).setKickCount(-1);
                                } else {
                                    figureRemove(block.getRectangleFigure());
                                    Finals.setGlobalSpeed(Finals.getGlobalSpeed() + 0.3);
                                    changeBallColor(Finals.getGlobalSpeed());
                                    BlockManager.blocksToDelete.add(block);
                                    ball.setDeleteBallCount(1);
                                }
                            } else if (block instanceof GoalBlock) {
                                if (((GoalBlock) block).getGoalCount() == 3) {
                                    Rectangle rectangle = new Rectangle(block.getxCoord(), block.getyCoord(), block.getWidth(), block.getHeight());
                                    rectangle.setFill(Color.DARKRED);
                                    goalChange(block.getRectangleFigure(), rectangle);
                                    block.setRectangleFigure(rectangle);
                                    ((GoalBlock) block).setGoalCount(-1);
                                } else if (((GoalBlock) block).getGoalCount() == 2) {
                                    Rectangle rectangle = new Rectangle(block.getxCoord(), block.getyCoord(), block.getWidth(), block.getHeight());
                                    rectangle.setFill(Color.RED);
                                    goalChange(block.getRectangleFigure(), rectangle);
                                    block.setRectangleFigure(rectangle);
                                    ((GoalBlock) block).setGoalCount(-1);
                                } else if (((GoalBlock) block).getGoalCount() == 1) {
                                    Rectangle rectangle = new Rectangle(block.getxCoord(), block.getyCoord(), block.getWidth(), block.getHeight());
                                    rectangle.setFill(Color.WHITE);
                                    rectangle.setStroke(Color.RED);
                                    rectangle.setStrokeWidth(3);
                                    goalChange(block.getRectangleFigure(), rectangle);
                                    block.setRectangleFigure(rectangle);
                                    ((GoalBlock) block).setGoalCount(-1);
                                } else {
                                    loseWin("lose");
                                }
                            }

                            labelUpdate(ball.getDeleteBallCount(), Levels.getBestScoreCounter().getText());
                        }
                    }
                }
                for (AbstractBlock block : BlockManager.blocksToDelete) {
                    BlockManager.blocks.remove(block);
                }
                BlockManager.blocksToDelete.clear();

                if ((BlockManager.blocks.size() - BlockManager.countOfStones -1) <= 0) {
                    loseWin("win");
                }
            }

            ballMove();
        }
    }

    public void loseWin(String s) {
        if (s.equals("win")) {
            Levels.goalBlockNumber = Levels.getGoalBlock().getGoalCount();
            rootClear();
            nextLevel();
            changeBallColor(Finals.getGlobalSpeed());
            ball.setFrize(true);
        } else {
            Levels.goalBlockNumber = -1;
            labelToNol();
            rootClear();
            nextLevel();
            Finals.setGlobalSpeed(Finals.getMinBallSpeed());
            changeBallColor(Finals.getGlobalSpeed());
            ball.setFrize(true);
            ball.deleteBallCountToNol();
        }
    }

    public void ballMove() {
        if (!ball.isFrize()) {
            if (ball.getDegree() >= 0 && ball.getDegree() < 90) {
                goRightUp(ball.getDegree());
            } else if (ball.getDegree() >= 90 && ball.getDegree() < 180) {
                goLeftUp(ball.getDegree() - 90);
            } else if (ball.getDegree() >= 180 && ball.getDegree() < 270) {
                goLeftDown(ball.getDegree() - 180);
            } else if (ball.getDegree() >= 270 && ball.getDegree() <= 360) {
                goRightDown(ball.getDegree() - 270);
            }
        }
    }

    public void checkPonKick(PlayerPon pon, double distance) {

        if (ball.isFrize()) {
            ball.setFrize(false);
        }

        double angleRad = 0;
        double angleDegrees = 0;

        double a = ball.getCoordX() - pon.getCoordX();
        double b = ball.getCoordY() - pon.getCoordY();

        if (a >= 0 && b >= 0) {
            angleRad = Math.acos(-a / distance);
            angleDegrees = angleRad * (180 / Math.PI) + 180;
        } else if (a <= 0 && b <= 0) {
            angleRad = Math.acos(a / distance);
            angleDegrees = angleRad * (180 / Math.PI);
        } else if (a >= 0 && b <= 0) {
            angleRad = Math.acos(a / distance);
            angleDegrees = angleRad * (180 / Math.PI);
        } else if (a <= 0 && b >= 0) {
            angleRad = Math.acos(-a / distance);
            angleDegrees = angleRad * (180 / Math.PI) + 180;
        }

        ball.setDegree(angleDegrees);
    }

    public void checkBlockKick(double xLeft, double xRight, double yUp, double yDown) {
        if (ball.getDegree() >= 180 && ball.getDegree() < 270) {
            if (xRight > yUp) {
                ball.setDegree(360 - ball.getDegree());
            } else {
                ball.setDegree(360 - ball.getDegree() + 180);
            }
        } else if (ball.getDegree() >= 90 && ball.getDegree() < 180) {
            if (xRight > yDown) {
                ball.setDegree(180 - ball.getDegree() + 180);
            } else {
                ball.setDegree(180 - ball.getDegree());
            }
        } else if (ball.getDegree() >= 270 && ball.getDegree() <= 360) {
            if (xLeft > yUp) {
                ball.setDegree(360 - ball.getDegree());
            } else {
                ball.setDegree(360 - ball.getDegree() + 180);
            }
        } else if (ball.getDegree() >= 0 && ball.getDegree() < 90) {
            if (xLeft > yDown) {
                ball.setDegree(360 - ball.getDegree());
            } else {
                ball.setDegree(180 - ball.getDegree());
            }
        }
    }

    public void checkFrameKick() {
        if (ball.getDegree() >= 180 && ball.getDegree() < 270) {
            if (ball.getCoordX() <= ball.getBallFigure().getRadius()) {
                ball.setDegree(360 - ball.getDegree() + 180);
            } else if(ball.getCoordY() >= Field.windowSizeY - ball.getBallFigure().getRadius()) {
                ball.setDegree(360 - ball.getDegree());
            }
        } else if (ball.getDegree() >= 90 && ball.getDegree() < 180) {
            if (ball.getCoordX() <= ball.getBallFigure().getRadius()) {
                ball.setDegree(180 - ball.getDegree());
            } else if(ball.getCoordY() <= ball.getBallFigure().getRadius()) {
                ball.setDegree(180 - ball.getDegree() + 180);
            }
        } else if (ball.getDegree() >= 270 && ball.getDegree() <= 360) {
            if (ball.getCoordX() >= Field.windowSizeX - ball.getBallFigure().getRadius()) {
                ball.setDegree(360 - ball.getDegree() + 180);
            } else if (ball.getCoordY() >= Field.windowSizeY - ball.getBallFigure().getRadius()) {
                ball.setDegree(360 - ball.getDegree());
            }
        } else if (ball.getDegree() >= 0 && ball.getDegree() < 90) {
            if (ball.getCoordY() <= ball.getBallFigure().getRadius()) {
                ball.setDegree(360 - ball.getDegree());
            } else if(ball.getCoordX() > Field.windowSizeX - ball.getBallFigure().getRadius()) {
                ball.setDegree(180 - ball.getDegree());
            }
        }

        double changeDegreeNotStack = ball.getDegree();

        if ((changeDegreeNotStack > 0.5 && changeDegreeNotStack < 89.5) || (changeDegreeNotStack > 90.5 && changeDegreeNotStack < 179.5) || (changeDegreeNotStack > 180.5 && changeDegreeNotStack < 269.5) || (changeDegreeNotStack > 270.5 && changeDegreeNotStack < 359.5)) {
            ball.setDegree(ball.getDegree() + 0.5);
        }
    }

    public void goRightUp(final double degree) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ball.getBallFigure().setLayoutX(ball.getBallFigure().getLayoutX() + (Finals.getGlobalSpeed() * Math.cos(Math.toRadians(degree))));
                ball.getBallFigure().setLayoutY(ball.getBallFigure().getLayoutY() - (Finals.getGlobalSpeed() * Math.sin(Math.toRadians(degree))));
            }
        });
    }

    public void goRightDown(final double degree) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ball.getBallFigure().setLayoutX(ball.getBallFigure().getLayoutX() + (Finals.getGlobalSpeed() * Math.sin(Math.toRadians(degree))));
                ball.getBallFigure().setLayoutY(ball.getBallFigure().getLayoutY() + (Finals.getGlobalSpeed() * Math.cos(Math.toRadians(degree))));
            }
        });
    }

    public void goLeftUp(final double degree) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ball.getBallFigure().setLayoutX(ball.getBallFigure().getLayoutX() - (Finals.getGlobalSpeed() * Math.sin(Math.toRadians(degree))));
                ball.getBallFigure().setLayoutY(ball.getBallFigure().getLayoutY() - (Finals.getGlobalSpeed() * Math.cos(Math.toRadians(degree))));
            }
        });
    }

    public void goLeftDown(final double degree) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ball.getBallFigure().setLayoutX(ball.getBallFigure().getLayoutX() - (Finals.getGlobalSpeed() * Math.cos(Math.toRadians(degree))));
                ball.getBallFigure().setLayoutY(ball.getBallFigure().getLayoutY() + (Finals.getGlobalSpeed() * Math.sin(Math.toRadians(degree))));
            }
        });
    }

    public void figureRemove(final Rectangle rectangle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getRoot().getChildren().remove(rectangle);
            }
        });
    }

    public void cirleAdd(final Circle circle) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getRoot().getChildren().addAll(circle);
            }
        });
    }

    public void labelUpdate(final int count, final String maxCount) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                int maxIntCount = 0;
                if (!maxCount.isEmpty()) {
                    maxIntCount = Integer.parseInt(maxCount);
                } else {
                    maxIntCount = 0;
                    Levels.getBestScoreCounter().setText(String.valueOf("0"));
                }

                Levels.getGameScoreCounter().setText(String.valueOf(count));
                if (maxIntCount < count) {
                    Levels.getBestScoreCounter().setText(String.valueOf(count));
                }
            }
        });
    }

    public void labelToNol() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getGameScoreCounter().setText(String.valueOf("0"));
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

    public void nextLevel() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.init();
            }
        });
    }

    public void rootClear() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Levels.getRoot().getChildren().clear();
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
}
