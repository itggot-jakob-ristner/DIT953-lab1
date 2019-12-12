package model;

import model.event.Event;
import model.event.EventListener;
import model.utilities.CollisionDetector;
import model.utilities.Vector;
import model.vehicles.Saab95;
import model.vehicles.Scania;
import model.vehicles.Vehicle;
import model.vehicles.VehicleFactory;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Vector WORLD_SIZE = new Vector(800, 800);
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<EventListener> listeners = new ArrayList<>();

    public Model() {
        vehicles.add(VehicleFactory.createVolvo240(new Vector(0, 0)));
        vehicles.add(VehicleFactory.createSaab95(new Vector(0, 100)));
        vehicles.add(VehicleFactory.createScania(new Vector(0, 200)));
    }

    public void update() {
        for (Vehicle v : vehicles) {
            v.move();
            if (CollisionDetector.isOutside(v.getPos(), v.getSize(), WORLD_SIZE)) {
                v.invertDirection();
            }
        }
        for (EventListener l : listeners) {
            l.onEvent(Event.REPAINT);
        }
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
