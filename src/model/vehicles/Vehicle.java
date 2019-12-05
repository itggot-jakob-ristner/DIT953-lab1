package model.vehicles;

import model.behaviours.Movable;
import model.behaviours.Transportable;

public interface Vehicle extends Movable, Transportable {
    void startEngine();
    void stopEngine();
    void gas(double amount);
    void brake(double amount);
    double speedFactor();
}
