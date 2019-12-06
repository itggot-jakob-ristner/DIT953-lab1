package model.vehicles;

import model.utilities.Vector;
import model.vehicleparts.ContinuousFlatbed;

import java.awt.*;

/**
 * A class representing a model.vehicles.Scania truck
 */
public class Scania extends TransportVehicle {

    public Scania() {
        this(new Vector());
    }

    public Scania(Vector pos) {
        super(2, Color.blue, 100, "Scania", 6000, new ContinuousFlatbed(5), pos);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
