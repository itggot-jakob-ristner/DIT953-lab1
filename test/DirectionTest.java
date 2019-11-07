import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void CanCreateDirection() {
        Direction d = Direction.UP;
        assertEquals(d, Direction.UP);
    }

    @Test
    void CanTurnLeft() {
        Direction d = Direction.UP;
        d = Direction.turnLeft(d);
        assertEquals(d, Direction.LEFT);
        d = Direction.turnLeft(d);
        assertEquals(d, Direction.DOWN);
        d = Direction.turnLeft(d);
        assertEquals(d, Direction.RIGHT);
        d = Direction.turnLeft(d);
        assertEquals(d, Direction.UP);
    }

    @Test
    void CanTurnRight() {
        Direction d = Direction.UP;
        d = Direction.turnRight(d);
        assertEquals(d, Direction.RIGHT);
        d = Direction.turnRight(d);
        assertEquals(d, Direction.DOWN);
        d = Direction.turnRight(d);
        assertEquals(d, Direction.LEFT);
        d = Direction.turnRight(d);
        assertEquals(d, Direction.UP);
    }
}
