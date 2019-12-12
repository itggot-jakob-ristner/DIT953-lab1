/*
package application;

import model.utilities.CollisionDetector;
import model.utilities.Vector;
import model.vehicles.Saab95;
import model.vehicles.Scania;
import model.vehicles.Vehicle;
import model.vehicles.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

*/
/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 *//*


public class CarController {
    public static final Vector WORLD_SIZE = new Vector(800, 800);
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    List<Vehicle> cars = new ArrayList<>();

    //methods:


    public CarController() {
        cars.add(VehicleFactory.createVolvo240(new Vector(0, 0)));
        cars.add(VehicleFactory.createSaab95(new Vector(0, 100)));
        cars.add(VehicleFactory.createScania(new Vector(0, 200)));

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", this, WORLD_SIZE, cars);

        // Start the timer
        timer.start();
    }

    public void turboOn() {
        for (Vehicle c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle c : cars) {
            if (c instanceof Saab95) {
                ((Saab95) c).setTurboOff();
            }
        }
    }

    public void deactivateBed() {
        for (Vehicle c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).deActivateFlatbed();
                System.out.println(((Scania) c).isFlatbedDeactivated());
            }
        }
    }

    public void activateBed() {
        for (Vehicle c : cars) {
            if (c instanceof Scania) {
                ((Scania) c).activateFlatbed();
                System.out.println(((Scania) c).isFlatbedDeactivated());
            }
        }
    }

    */
/* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * *//*

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle v : cars) {
                v.move();

                */
/*if (CollisionDetector.isOutside(v.getPos(), ScreenElementsManager.getScreenElement(v.getClass()).getSize(), WORLD_SIZE)) {
                    v.invertDirection();
                }*//*


                frame.repaint();
            }
        }
    }

    void startAll() {
        for (Vehicle v : cars) {
            v.startEngine();
        }
    }

    void stopAll() {
        for (Vehicle v : cars) {
            v.stopEngine();
        }
    }

    */
/** Calls the break method for each car once *//*

    void brakeAll(double amount) {
        double brake = amount / 100;
        for (Vehicle v : cars) {
            v.brake(brake);
        }
    }

    */
/** Calls the gas method for each car once *//*

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle v : cars) {
            v.gas(gas);
        }
    }
}
*/
