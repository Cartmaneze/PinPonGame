package finals;

/**
 * Created by Никита on 10.08.2017.
 */
public class Finals {
    private static double ballPonTouchDistance;
    private static double ballBonusTouchDistance;
    private static double ponBonusTouchDistance;

    private final static double BONUS_RADIUS = 20;

    private static double globalSpeed = 3;

    private static long mSecGameStep = 16;

    private final static double MIN_BALL_SPEED = 3;
    private final static double MAX_BALL_SPEED = 15;

    public static double getMinBallSpeed() {
        return MIN_BALL_SPEED;
    }

    public static double getGlobalSpeed() {
        return globalSpeed;
    }

    public static double getBallPonTouchDistance() {
        return ballPonTouchDistance;
    }

    public static void setBallPonTouchDistance(double ballPonTouchDistance) {
        Finals.ballPonTouchDistance = ballPonTouchDistance;
    }

    public static void setGlobalSpeed(double globalSpeed) {
        if (globalSpeed <= MIN_BALL_SPEED) {
            Finals.globalSpeed = MIN_BALL_SPEED;
        } else if (globalSpeed <= MAX_BALL_SPEED) {
            Finals.globalSpeed = globalSpeed;
        }
    }

    public static long getmSecGameStep() {
        return mSecGameStep;
    }

    public static double getBonusRadius() {
        return BONUS_RADIUS;
    }

    public static double getPonBonusTouchDistance() {
        return ponBonusTouchDistance;
    }

    public static void setPonBonusTouchDistance(double ponBonusTouchDistance) {
        Finals.ponBonusTouchDistance = ponBonusTouchDistance;
    }

    public static double getBallBonusTouchDistance() {
        return ballBonusTouchDistance;
    }

    public static void setBallBonusTouchDistance(double ballBonusTouchDistance) {
        Finals.ballBonusTouchDistance = ballBonusTouchDistance;
    }


}
