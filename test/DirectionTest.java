import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

class DirectionTest {

    @Test
    void canCreateDirection() {
        Direction d = Direction.UP;
        assertEquals(d, Direction.UP);
    }

    @Test
    void canTurnLeft() {
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
    void canTurnRight() {
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
