package vehicles;

import vehicleparts.DiscreteFlatbed;

import java.awt.*;
import java.util.*;

public class CarTransportTruck extends TransportVehicle {

    private static final double PICKUP_RANGE = 5;
    private final int MAX_VEHICLE_WEIGHT = 3000;
    private final int VEHICLE_SLOTS = 3;
    private Deque<MotorisedVehicle> cargo = new LinkedList<>();

    public CarTransportTruck() {
        super(2, Color.yellow, 50, "Lång tradare", 12000, new DiscreteFlatbed());
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public boolean tryAddVehicle(MotorisedVehicle vehicle) {
        if (!isFlatbedActivated()) return false;
        if (pos.distanceTo(vehicle.pos) < PICKUP_RANGE) {
            if (cargo.size() < VEHICLE_SLOTS && vehicle.getWeight() < MAX_VEHICLE_WEIGHT) {
                cargo.push(vehicle);
                return true;
            }
        }
        return false;
    }

    @Override
    public void move() {
        super.move();
        for (MotorisedVehicle v : cargo) {
            v.setPos(pos.getX(), pos.getY());
        }
    }

    public MotorisedVehicle tryRemoveVehicle() {
        if (!isFlatbedActivated()) return null;
        if (cargo.size() == 0) return null;
        MotorisedVehicle v = cargo.pop();
        v.setPos(pos.getX(), pos.getY() - 1);
        return v;
    }
}
