package behaviours;

import utilities.Direction;
import utilities.Vector;

/**
 * An interface that defines how anything that is moveable should move
 */
public interface Movable {
    /**
     * Abstract method to move the object
     * Defines how the movalbe should move
     */
    void move();

    /**
     * Abstract method to turn the object left
     * All moveable should be able to turn left
     */
    void turnLeft();

    /**
     * Abstract method to turn the object right
     * All movalbe should be able to turn right
     */
    void turnRight();



    void invertDirection();

    Vector getPos();
}