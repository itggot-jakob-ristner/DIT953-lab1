package vehicles;

import utilities.Vector;

public final class VehicleFactory {

    private VehicleFactory() { }

    public static Vehicle createSaab95(Vector position) {
        return new Saab95(position);
    }

    public static Vehicle createVolvo240(Vector position) {
        return new Volvo240(position);
    }

    public static Vehicle createScania(Vector position) {
        return new Scania(position);
    }
}
