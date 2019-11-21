package vehicles;

import behaviours.Transporter;
import vehicleparts.DiscreteFlatbed;

import java.awt.*;
import java.util.*;

/**
 * A class representing a truck that can transport other motorised vehicles
 */
public class CarTransportTruck extends TransportVehicle implements Transporter<MotorisedVehicle> {

    private Deque<MotorisedVehicle> cargo = new ArrayDeque<>();

    public CarTransportTruck() {
        super(2, Color.yellow, 50, "Lång tradare", 12000, new DiscreteFlatbed());
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Will try to load this CarTransportTruck with a MotorisedVehicle. Returns a boolean stating if it's successful
     * @param vehicle The vehicle to add
     * @return True if successful, false otherwise.
     */
    @Override
    public boolean tryLoad(MotorisedVehicle vehicle) {
        if (!isFlatbedActivated()) return false;
        if (pos.distanceTo(vehicle.pos) < getPickupRange()) {
            if (cargo.size() < getMaxCargoSlots() && vehicle.getWeight() < getMaxCargoWeight()) {
                if (vehicle.isBeingTransported) return false;
                vehicle.setBeingTransported(true);
                cargo.push(vehicle);
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the truck and updates the position of all vehicles in the cargo to be the same as this truck.
     */
    @Override
    public void move() {
        super.move();
        for (MotorisedVehicle v : cargo) {
            v.setPos(pos.getX(), pos.getY());
            v.setDirection(getDirection());
        }
    }

    /**
     * Tries to unload a Vehicle
     * @return The Vehicle at the top of the stack, or if the stack is emtpy, null
     */
    @Override
    public MotorisedVehicle tryUnload() {
        if (!isFlatbedActivated()) return null;
        if (cargo.size() == 0) return null;
        MotorisedVehicle v = cargo.pop();
        v.setPos(pos.getX(), pos.getY() - 1);
        v.setBeingTransported(false);
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
