package vehicles;

import behaviours.Movable;
import behaviours.Transportable;

public interface Vehicle extends Movable, Transportable {
    void startEngine();
    void stopEngine();
    void gas(double amount);
    void brake(double amount);
    double speedFactor();
}
