package model.vehicles;

import model.utilities.Vector;

import java.awt.*;

/**
 * The class for the Car model.vehicles.Saab95
 */
public class Saab95 extends MotorisedVehicle {

    /**
     * Boolean variable representing if turbo is enabled
     */
    private boolean turboOn;

    /**
     * The constructor for model.vehicles.Saab95
     */
    public Saab95() {
        this(new Vector());
    }

    public Saab95(Vector pos) {
        super(2, Color.red, 125, "model.vehicles.Saab95", 1000, pos);
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
