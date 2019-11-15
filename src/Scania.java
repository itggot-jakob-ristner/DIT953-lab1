import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends MotorisedVehicle implements Raisable{

    private final Flatbed flatbed;

    public Scania() {
        super(2, Color.blue, 100, "Scania", 6000);
        flatbed = new Flatbed(5);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void raiseFlatbed() {
        if (getCurrentSpeed() > 0) return;
        flatbed.raiseFlatbed();
    }

    @Override
    public void lowerFlatbed() {
        flatbed.lowerFlatbed();
    }

    @Override
    public void startEngine() {
        if (!flatbed.isDown()) return;
        super.startEngine();
    }

    @Override
    public double getAngle() {
        return flatbed.getAngle();
    }


    @Override
    public boolean isDown() {
        return flatbed.isDown();
    }
}
