import org.junit.jupiter.api.Test;
import vehicles.Scania;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScaniaTest {
    @Test
    void canNotIncreaseAngleWhileMoving() {
        Scania s = new Scania();
        s.startEngine();
        s.activateFlatbed();
        assertTrue(s.isFlatbedDeactivated());
    }
}
