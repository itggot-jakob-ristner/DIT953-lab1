package model;

import model.event.EventListener;
import model.utilities.Vector;
import model.vehicles.Saab95;
import model.vehicles.Scania;
import model.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Vector WORLD_SIZE = new Vector(800, 800);
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<EventListener> listeners = new ArrayList<>();

    public void update() {
        // TODO update stuff

    }

    public void turboOn() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle v : vehicles) {
            if (v instanceof Saab95) {
                ((Saab95) v).setTurboOff();
            }
        }
    }

    public void deactivateBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Scania) {
                ((Scania) v).deActivateFlatbed();
                System.out.println(((Scania) v).isFlatbedDeactivated());
            }
        }
    }

    public void activateBed() {
        for (Vehicle v : vehicles) {
            if (v instanceof Scania) {
                ((Scania) v).activateFlatbed();
                System.out.println(((Scania) v).isFlatbedDeactivated());
            }
        }
    }

    public void startAll() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    public void stopAll() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }

    /** Calls the break method for each car once */
    public void brakeAll(double amount) {
        double brake = amount / 100;
        for (Vehicle v : vehicles) {
            v.brake(brake);
        }
    }

    /** Calls the gas method for each car once */
    public void gasAll(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            v.gas(gas);
        }
    }

    public void addEventListener(EventListener listener) {
        listeners.add(listener);
    }

    /**
     * @return the worlds size using a defensive copy
     */
    public Vector getWorldSize() {
        return new Vector(WORLD_SIZE);
    }
}
