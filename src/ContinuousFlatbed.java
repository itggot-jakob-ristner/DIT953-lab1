public class ContinuousFlatbed implements Flatbed {

    /**
     * The highest possible flatbed angle
     */
    public static final double MAX_ANGLE = 70;

    /**
     * The lowest possible flatbed angle
     */
    public static final double MIN_ANGLE = 0;

    /**
     * The speed at which the flatbed changes angle
     */
    public final double ANGLE_SPEED;

    /**
     * The current angle of the flatbed
     */
    private double angle = 0;

    public ContinuousFlatbed(double angleSpeed) {
        this.ANGLE_SPEED = angleSpeed;
    }

    @Override
    public void raise() {
        angle = Math.min(angle + ANGLE_SPEED, MAX_ANGLE);
    }

    @Override
    public void lower() {
        angle = Math.max(angle + ANGLE_SPEED, MIN_ANGLE);
    }

    @Override
    public boolean isDown() {
        return angle == MIN_ANGLE;
    }

    @Override
    public boolean isUp() {
        return angle == MAX_ANGLE;
    }
}
