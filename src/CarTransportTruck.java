import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransportTruck extends MotorisedVehicle implements Flatbed {

    private final int MAX_VEHICLE_WEIGHT = 3000;
    private final int VEHICLE_SLOTS = 3;
    private List<MotorisedVehicle> cargo = new ArrayList<>();
    private Flatbed flatbed;

    public CarTransportTruck() {
        super(2, Color.yellow, 50, "Lång tradare", 12000);
        flatbed = new DiscreteFlatbed();
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public boolean tryAddVehicle(MotorisedVehicle vehicle) {
        if (cargo.size() < VEHICLE_SLOTS && vehicle.getWeight() < MAX_VEHICLE_WEIGHT) {
            cargo.add(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public void raiseFlatbed() {
        flatbed.raiseFlatbed();
    }

    @Override
    public void lowerFlatbed() {
        flatbed.lowerFlatbed();
    }

    @Override
    public boolean isDown() {
        return flatbed.isDown();
    }
}
