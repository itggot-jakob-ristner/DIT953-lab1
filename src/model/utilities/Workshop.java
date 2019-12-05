package model.utilities;


import model.vehicles.Vehicle;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * A workshop that can add and remove model.vehicles
 * @param <V> The type of vehicle that this Workshop accepts
 */
public class Workshop<V extends Vehicle> {

    private final int MAX_VEHICLES;
    private Queue<V> vehicles = new ArrayDeque<>();

    public Workshop(int max_vehicles) {
        MAX_VEHICLES = max_vehicles;
    }

    public boolean tryAddVehicle(V v) {
        if (vehicles.size() >= MAX_VEHICLES && !v.isBeingTransported()) {
            return false;
        }

        v.setBeingTransported(true);
        vehicles.add(v);
        return true;
    }

    public V tryRemoveVehicle() {
        V v = vehicles.poll();
        if (v != null) {
            v.setBeingTransported(false);
        }
        return v;
    }
}
