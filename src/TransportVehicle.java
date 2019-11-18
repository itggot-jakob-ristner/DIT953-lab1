import java.awt.*;

public abstract class TransportVehicle extends MotorisedVehicle {
    protected Flatbed flatbed;
    public TransportVehicle(int nrDoors, Color color, double enginePower, String modelName, int weight, Flatbed flatbed) {
        super(nrDoors, color, enginePower, modelName, weight);
        this.flatbed = flatbed;
    }

    @Override
    public void startEngine() {
        if (!flatbed.isDown()) return;
        super.startEngine();
    }

    public void raise() {
        if (getCurrentSpeed() > 0) return;
        flatbed.raise();
    }

    public void lower() {
        flatbed.lower();
    }

    public boolean isDown() {
        return flatbed.isDown();
    }

    public boolean isUp() {
        return flatbed.isUp();
    }
}
