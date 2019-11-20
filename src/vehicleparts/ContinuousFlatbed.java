package vehicleparts;

public class ContinuousFlatbed implements Flatbed {

    /**
     * The highest possible flatbed angle
     */
    public static final double ACTIVATION_ANGLE = 70;

    /**
     * The lowest possible flatbed angle
     */
    public static final double DEACTIVATION_ANGLE = 0;

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
    public void activate() {
        angle = Math.min(angle + ANGLE_SPEED, ACTIVATION_ANGLE);
    }

    @Override
    public void deActivate() {
        angle = Math.max(angle + ANGLE_SPEED, DEACTIVATION_ANGLE);
    }

    @Override
    public boolean isDeactivated() {
        return angle == DEACTIVATION_ANGLE;
    }

    @Override
    public boolean isActivated() {
        return angle == ACTIVATION_ANGLE;
    }
}
