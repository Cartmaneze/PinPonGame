package view;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.RadialGradient;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import managers.BlockManager;
import models.*;

import java.util.ArrayList;

/**
 * Created by Никита on 21.08.2017.
 */
public class Levels {
    private static double orgSceneX, orgSceneY;
    private static double orgTranslateX, orgTranslateY;

    private static Group root;
    private static Circle playerPonFigure;
    private static Circle ballFigure;
    private static GoalBlock goalBlock;
    private static Label bestScoreCounter;
    private static Label gameScoreCounter;
    public static int goalBlockNumber = -1;

    public static void init() {
        root.getChildren().addAll(playerPonFigure, ballFigure, gameScoreCounter, bestScoreCounter);

        bestScoreCounter.setLayoutX(0);
        bestScoreCounter.setLayoutY(0);

        gameScoreCounter.setLayoutX(0);
        gameScoreCounter.setLayoutY(20);

        playerPonFigure.setLayoutX(170);
        playerPonFigure.setLayoutY(350);
        playerPonFigure.setOnMousePressed(circleOnMousePressedEventHandler);
        playerPonFigure.setOnMouseDragged(circleOnMouseDraggedEventHandler);

        ballFigure.setLayoutX(350);
        ballFigure.setLayoutY(350);

        if (goalBlock == null) {
            goalBlock = new GoalBlock(0, 200, 25, 350);
            goalBlockNumber = -1;
        } else {
            if (goalBlockNumber != -1) {
                goalBlock.setGoalCountAfterNewLevel(goalBlockNumber);
            } else {
                goalBlock.setGoalCountAfterNewLevel(3);
            }
        }

        ArrayList<AbstractBlock> blocks = BlockManager.initBlocks();
        BlockManager.blocks.add(goalBlock);
        for (AbstractBlock block : blocks) {
            Rectangle rectangle = new Rectangle(block.getxCoord(), block.getyCoord(), block.getWidth(), block.getHeight());
            block.setRectangleFigure(rectangle);
            if (block instanceof SimpleBlock) {
                rectangle.setFill(RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  red, yellow, red)"));
                rectangle.setStroke(Color.DARKRED);
                rectangle.setStrokeMiterLimit(5);
            } else if (block instanceof StoneBlock) {
                rectangle.setFill(RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  white, green)"));
                rectangle.setStroke(Color.DARKGREEN);
                rectangle.setStrokeMiterLimit(5);
            } else if (block instanceof GoalBlock) {
                if (((GoalBlock) block).getGoalCount() == 3) {
                    rectangle.setFill(Color.BLACK);
                } else if (((GoalBlock) block).getGoalCount() == 2) {
                    rectangle.setFill(Color.DARKRED);
                } else if (((GoalBlock) block).getGoalCount() == 1) {
                    rectangle.setFill(Color.RED);
                } else if (((GoalBlock) block).getGoalCount() == 0) {
                    rectangle.setFill(Color.WHITE);
                    rectangle.setStroke(Color.RED);
                    rectangle.setStrokeWidth(3);
                }
            } else if (block instanceof DoubleBlock) {
                rectangle.setFill(RadialGradient.valueOf("radial-gradient(center 50% 50%, radius 50%,  blue, yellow, blue)"));
                rectangle.setStroke(Color.DARKBLUE);
                rectangle.setStrokeMiterLimit(5);
            }

            rectangle.setVisible(true);
            root.getChildren().addAll(rectangle);
        }

        BlockManager.root = root;
    }

    static EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle)(t.getSource())).getLayoutX();
                    orgTranslateY = ((Circle)(t.getSource())).getLayoutY();
                }
            };

    static EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    if (newTranslateX > 1.5*playerPonFigure.getRadius() && newTranslateX < 400) {
                        ((Circle)(t.getSource())).setLayoutX(newTranslateX);
                    }
                    if (newTranslateY > playerPonFigure.getRadius() && newTranslateY < Field.windowSizeY - playerPonFigure.getRadius() + 10) {
                        ((Circle)(t.getSource())).setLayoutY(newTranslateY);
                    }
                }
            };

    public static Circle getPlayerPonFigure() {
        return playerPonFigure;
    }

    public static void setPlayerPonFigure(Circle playerPonFigure) {
        Levels.playerPonFigure = playerPonFigure;
    }

    public static Circle getBallFigure() {
        return ballFigure;
    }

    public static void setBallFigure(Circle ballFigure) {
        Levels.ballFigure = ballFigure;
    }

    public static Group getRoot() {
        return root;
    }

    public static void setRoot(Group root) {
        Levels.root = root;
    }

    public static GoalBlock getGoalBlock() {
        return goalBlock;
    }

    public static void setGoalBlock(GoalBlock goalBlock) {
        Levels.goalBlock = goalBlock;
    }

    public static Label getGameScoreCounter() {
        return gameScoreCounter;
    }

    public static void setGameScoreCounter(Label gameScoreCounter) {
        Levels.gameScoreCounter = gameScoreCounter;
    }

    public static Label getBestScoreCounter() {
        return bestScoreCounter;
    }

    public static void setBestEndGameLabel(Label bestScoreCounter) {
        Levels.bestScoreCounter = bestScoreCounter;
    }


}
