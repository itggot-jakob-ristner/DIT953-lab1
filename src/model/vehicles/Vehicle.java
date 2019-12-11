package model.vehicles;

import model.behaviours.Movable;
import model.behaviours.Transportable;
import model.utilities.Vector;

public interface Vehicle extends Movable, Transportable {
    void startEngine();
    void stopEngine();
    void gas(double amount);
    void brake(double amount);
    double speedFactor();
    double getSpeed();
    Vector getSize();
}
