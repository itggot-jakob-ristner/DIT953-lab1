import org.junit.jupiter.api.Test;
import vehicles.CarTransportTruck;
import vehicles.Volvo240;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CarTransportTruckTest {

    @Test
    void canNotLoadVehicleWhenFlatbedIsDeactivated() {
        CarTransportTruck truck = new CarTransportTruck();
        truck.deActivateFlatbed();
        assertFalse(truck.tryLoad(new Volvo240()));
    }

    @Test
    void canNotLoadWhenFarAway() {
        CarTransportTruck truck = new CarTransportTruck();
        truck.activateFlatbed();
        Volvo240 v = new Volvo240();
        v.setPos(500, 500);
        assertFalse(truck.tryLoad(v));
    }

    @Test
    void canLoadVehicleWhenFlatbedIsActivated() {
        CarTransportTruck truck = new CarTransportTruck();
        truck.activateFlatbed();
        assertTrue(truck.tryLoad(new Volvo240()));
    }
}
