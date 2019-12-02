package vehicles;

import behaviours.Transportable;
import behaviours.Transporter;
import com.sun.jdi.connect.Transport;
import utilities.Vector;
import vehicleparts.ContinuousFlatbed;

import java.awt.*;

/**
 * A class representing a vehicles.Scania truck
 */
public class Scania extends TransportVehicle {

    public Scania() {
        this(new Vector());
    }

    public Scania(Vector pos) {
        super(2, Color.blue, 100, "vehicles.Scania", 6000, new ContinuousFlatbed(5), pos);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
