package controls;

import finals.Finals;
import models.PlayerPon;

/**
 * Created by Никита on 07.08.2017.
 */
public class PlayerController implements Runnable {

    public PlayerController(PlayerPon playerPon) {
        this.playerPon = playerPon;
    }

    PlayerPon playerPon;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Finals.getmSecGameStep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            playerPon.setCoordX(playerPon.getPlayerPonFigure().getLayoutX());
            playerPon.setCoordY(playerPon.getPlayerPonFigure().getLayoutY());
        }
    }
}
