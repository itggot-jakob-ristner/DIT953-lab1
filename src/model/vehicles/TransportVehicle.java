package model.vehicles;

import model.utilities.Vector;
import model.vehicleparts.Flatbed;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class TransportVehicle extends MotorisedVehicle {
    protected Flatbed flatbed;
    public TransportVehicle(int nrDoors, Color color, double enginePower, String modelName, int weight, Flatbed flatbed, Vector pos) {
        super(nrDoors, color, enginePower, modelName, weight, pos);
        this.flatbed = flatbed;
    }

    @Override
    public void startEngine() {
        if (!flatbed.isDeactivated()) return;
        super.startEngine();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 85);
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
