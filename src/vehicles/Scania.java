package vehicles;

import vehicleparts.ContinuousFlatbed;

import java.awt.*;

/**
 * A class representing a vehicles.Scania truck
 */
public class Scania extends TransportVehicle {

    public Scania() {
        super(2, Color.blue, 100, "vehicles.Scania", 6000, new ContinuousFlatbed(5));
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
