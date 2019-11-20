import org.junit.jupiter.api.Test;
import vehicles.Volvo240;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Volvo240Test {
    @Test
    void canInitializeVolvo240() {
        Volvo240 v = new Volvo240();
        assertEquals(v.getNrDoors(), 4);
        assertEquals(v.getEnginePower(), 100);
        assertEquals(v.getCurrentSpeed(), 0);
        v.speedFactor();
    }
}
