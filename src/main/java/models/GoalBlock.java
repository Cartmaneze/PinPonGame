package models;

/**
 * Created by Никита on 23.08.2017.
 */
public class GoalBlock extends AbstractBlock {
    public GoalBlock(int x, int y, int width, int height) {
        this.xCoord = x;
        this.yCoord = y;
        this.width = width;
        this.height = height;
        this.goalCount = 3;
    }

    private long timeGoal = System.currentTimeMillis();
    private int goalCount;

    public int getGoalCount() {
        return goalCount;
    }

    public void setGoalCount(int count) {
        if (count < 0) {
            long newTime = System.currentTimeMillis();
            if ((newTime - timeGoal) > 600) {
                timeGoal = newTime;
                this.goalCount += count;
            }
        } else {
            if ((goalCount + count) > 3) {
                this.goalCount = 3;
            } else {
                this.goalCount += count;
            }
        }
    }

    public void setGoalCountAfterNewLevel(int count) {
        this.goalCount = count;
    }
}
