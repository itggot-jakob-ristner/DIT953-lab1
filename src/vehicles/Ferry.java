package vehicles;

import behaviours.Transporter;
import utilities.Vector;
import vehicleparts.DiscreteFlatbed;
import vehicleparts.Flatbed;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class representing a Ferry, meaning a boat that can carry Motorised Vehicles
 */
public class Ferry extends TransportVehicle implements Transporter<MotorisedVehicle> {

    private Queue<MotorisedVehicle> cargo = new ArrayDeque<>();

    public Ferry() {
        this(new Vector());
    }

    public Ferry(Vector pos) {
        super(1, Color.white, 50, "Stena", 1000000, new DiscreteFlatbed(), pos);
    }

    @Override
    public void move() {
        super.move();
        for (MotorisedVehicle v : cargo) {
            v.setPos(pos.getX(), pos.getY());
            v.setDirection(getDirection());
        }
    }

    @Override
    public boolean tryLoad(MotorisedVehicle vehicle) {
        if (!isFlatbedActivated()) return false;
        if (pos.distanceTo(vehicle.pos) < getPickupRange()) {
            if (cargo.size() < getMaxCargoSlots() && vehicle.getWeight() < getMaxCargoWeight()) {
                if (vehicle.isBeingTransported) return false;
                vehicle.setBeingTransported(true);
                cargo.add(vehicle);
                return true;
            }
        }
        return false;
    }

    @Override
    public MotorisedVehicle tryUnload() {
        if (!isFlatbedActivated()) return null;
        if (cargo.size() == 0) return null;
        MotorisedVehicle v = cargo.remove();
        v.setPos(pos.getX(), pos.getY() - 10);
        v.setBeingTransported(false);
        return v;
    }

    @Override
    public int getMaxCargoWeight() {
        return 13000;
    }

    @Override
    public int getMaxCargoSlots() {
        return 100;
    }

    @Override
    public double getPickupRange() {
        return 20;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.001;
    }
}
