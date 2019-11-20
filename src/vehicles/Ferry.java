package vehicles;

import behaviours.Transporter;
import vehicleparts.DiscreteFlatbed;
import vehicleparts.Flatbed;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Ferry extends TransportVehicle implements Transporter<MotorisedVehicle> {

    private Queue<MotorisedVehicle> cargo = new ArrayDeque<>();

    public Ferry() {
        super(1, Color.white, 50, "Stena", 1000000, new DiscreteFlatbed());
    }

    public void move() {
        super.move();
        for (MotorisedVehicle v : cargo) {
            v.setPos(pos.getX(), pos.getY());
        }
    }

    @Override
    public boolean tryLoad(MotorisedVehicle vehicle) {
        if (!isFlatbedActivated()) return false;
        if (pos.distanceTo(vehicle.pos) < getPickupRange()) {
            if (cargo.size() < getMaxCargoSlots() && vehicle.getWeight() < getMaxCargoWeight()) {
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
