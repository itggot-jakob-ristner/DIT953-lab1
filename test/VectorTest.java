import org.junit.jupiter.api.Test;
import model.utilities.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorTest {
    @Test
    void canInitializeDefaultVector() {
        Vector v = new Vector();
        assertEquals(v.getX(), 0);
        assertEquals(v.getY(), 0);
    }

    @Test
    void canInitializeVector() {
        Vector v = new Vector(1, 2);
        assertEquals(v.getX(), 1);
        assertEquals(v.getY(), 2);
    }

    @Test
    void canAddVectors() {
        Vector v1 = new Vector(1, 2);
        Vector v2 = new Vector(2, 2);
        v1.add(v2);
        assertEquals(v1.getX(), 3);
        assertEquals(v1.getY(), 4);
    }

    @Test
    void canAddToVector() {
        Vector v = new Vector(1, 2);
        v.addX(3);
        v.addY(4);
        assertEquals(v.getX(), 4);
        assertEquals(v.getY(), 6);
    }

    @Test
    void canSetCoordinates() {
        Vector v = new Vector(1, 2);
        v.setX(3);
        v.setY(4);
        assertEquals(v.getX(), 3);
        assertEquals(v.getY(), 4);
    }
}
