package vehicles;

import behaviours.Transporter;
import vehicleparts.DiscreteFlatbed;

import java.awt.*;
import java.util.*;

public class CarTransportTruck extends TransportVehicle implements Transporter<MotorisedVehicle> {

    private Deque<MotorisedVehicle> cargo = new ArrayDeque<>();

    public CarTransportTruck() {
        super(2, Color.yellow, 50, "Lång tradare", 12000, new DiscreteFlatbed());
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public boolean tryLoad(MotorisedVehicle vehicle) {
        if (!isFlatbedActivated()) return false;
        if (pos.distanceTo(vehicle.pos) < getPickupRange()) {
            if (cargo.size() < getMaxCargoSlots() && vehicle.getWeight() < getMaxCargoWeight()) {
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
    @Override
    public MotorisedVehicle tryUnload() {
        if (!isFlatbedActivated()) return null;
        if (cargo.size() == 0) return null;
        MotorisedVehicle v = cargo.pop();
        v.setPos(pos.getX(), pos.getY() - 1);
        return v;
    }

    @Override
    public int getMaxCargoWeight() {
        return 3000;
    }

    @Override
    public int getMaxCargoSlots() {
        return 3;
    }

    @Override
    public double getPickupRange() {
        return 5;
    }
}
