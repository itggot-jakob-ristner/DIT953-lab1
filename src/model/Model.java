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

    void startAll() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    void stopAll() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }

    /** Calls the break method for each car once */
    void brakeAll(double amount) {
        double brake = amount / 100;
        for (Vehicle v : vehicles) {
            v.brake(brake);
        }
    }

    /** Calls the gas method for each car once */
    void gasAll(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : vehicles) {
            v.gas(gas);
        }
    }

    void addEventListener(EventListener eventListener) {
    }

}
