package models;

/**
 * Created by Никита on 23.08.2017.
 */
public class DoubleBlock extends AbstractBlock {
    public DoubleBlock(int x, int y, int width, int height) {
        this.xCoord = x;
        this.yCoord = y;
        this.width = width;
        this.height = height;
    }

    private long timeKick = System.currentTimeMillis();
    private int kickCount = 1;

    public int getKickCount() {
        return kickCount;
    }

    public void setKickCount(int count) {
        long newTime = System.currentTimeMillis();
        if ((newTime - timeKick) > 200) {
            timeKick = newTime;
            this.kickCount += count;
        }
    }
}
