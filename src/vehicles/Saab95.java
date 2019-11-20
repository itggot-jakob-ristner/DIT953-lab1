package vehicles;

import java.awt.*;

/**
 * The class for the Car vehicles.Saab95
 */
public class Saab95 extends MotorisedVehicle {

    /**
     * Boolean variable representing if turbo is enabled
     */
    private boolean turboOn;

    /**
     * The constructor for vehicles.Saab95
     */
    public Saab95() {
        super(2, Color.red, 125, "vehicles.Saab95", 1000);
	    turboOn = false;
    }

    /**
     * Method that enabled the turbo variable
     */
    public void setTurboOn() {
	    turboOn = true;
    }

    /**
     * Method that disables the turbo variable
     */
    public void setTurboOff() {
	    turboOn = false;
    }

    /**
     * Method that calculates and returns the speedFactor of the car.
     * @return the speedFactor of the car.
     */
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }



}
