package models;

import finals.Finals;

/**
 * Created by Никита on 24.08.2017.
 */
public class GoalBonus extends AbstractBonus {
    public GoalBonus(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
        this.radius = Finals.getBonusRadius();
    }
}
