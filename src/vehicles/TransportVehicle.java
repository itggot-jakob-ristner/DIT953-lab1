package vehicles;

import vehicleparts.Flatbed;

import java.awt.*;

public abstract class TransportVehicle extends MotorisedVehicle {
    protected Flatbed flatbed;
    public TransportVehicle(int nrDoors, Color color, double enginePower, String modelName, int weight, Flatbed flatbed) {
        super(nrDoors, color, enginePower, modelName, weight);
        this.flatbed = flatbed;
    }

    @Override
    public void startEngine() {
        if (flatbed.isActivated()) return;
        super.startEngine();
    }

    public void activateFlatbed() {
        if (getCurrentSpeed() > 0) return;
        flatbed.activate();
    }

    public void deActivateFlatbed() {
        flatbed.deActivate();
    }

    public boolean isFlatbedDeactivated() {
        return flatbed.isDeactivated();
    }

    public boolean isFlatbedActivated() {
        return flatbed.isActivated();
    }
}
