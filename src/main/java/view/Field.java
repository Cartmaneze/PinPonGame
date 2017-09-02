package view;

import controls.BallController;
import controls.BonusController;
import controls.PlayerController;
import finals.Finals;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import managers.BlockManager;
import models.Ball;
import models.PlayerPon;

/**
 * Created by Никита on 07.08.2017.
 */
public class Field extends Application {

    public Circle playerPonFigure;
    public Circle ballFigure;
    public Label bestScoreCounter;
    public Label gameScoreCounter;

    public static double windowSizeX = 1024;
    public static double windowSizeY = 768;

    Group root;

    @Override
    public void start(Stage primaryStage) {
        bestScoreCounter = new Label();
        gameScoreCounter = new Label();

        playerPonFigure = new Circle(40.0f, Color.DARKGREEN);
        playerPonFigure.setCursor(Cursor.HAND);

        ballFigure = new Circle(8.0f, Color.BLUE);

        Finals.setBallPonTouchDistance(ballFigure.getRadius() + playerPonFigure.getRadius());
        Finals.setBallBonusTouchDistance(ballFigure.getRadius() + Finals.getBonusRadius());
        Finals.setPonBonusTouchDistance(playerPonFigure.getRadius() + Finals.getBonusRadius());

        root = new Group();
        Levels.setRoot(root);
        Levels.setBallFigure(ballFigure);
        Levels.setPlayerPonFigure(playerPonFigure);
        Levels.setGameScoreCounter(gameScoreCounter);
        Levels.setBestEndGameLabel(bestScoreCounter);

        BlockManager.root = Levels.getRoot();

        Levels.init();

        PlayerPon playerPon = new PlayerPon(playerPonFigure);
        PlayerController playerController = new PlayerController(playerPon);
        Thread playerThread = new Thread(playerController);
        playerThread.start();

        Ball ball = new Ball(ballFigure);
        ball.setFrize(true);
        BallController ballController = new BallController(ball, playerPon);
        Thread ballThread = new Thread(ballController);
        ballThread.start();

        BonusController bonusController = new BonusController(ball, playerPon);
        Thread bonusThread = new Thread(bonusController);
        bonusThread.start();

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, Field.windowSizeX, Field.windowSizeY));

        primaryStage.setTitle("Pin Pon");
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
                Platform.exit();
            }
        });
    }
}
