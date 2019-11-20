import org.junit.jupiter.api.Test;
import utilities.Direction;
import vehicles.Saab95;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Saab95Test {
    @Test
    void canInitializeSaab95() {
        Saab95 s = new Saab95();
        assertEquals(s.getNrDoors(), 2);
        assertEquals(s.getEnginePower(), 125);
        assertEquals(s.getCurrentSpeed(), 0);
    }

    @Test
    void canChangeColor() {
        Saab95 s = new Saab95();
        s.setColor(Color.black);
        assertEquals(s.getColor(), Color.black);
    }

    @Test
    void canChangeSpeed() {
        Saab95 s = new Saab95();
        s.startEngine();
        double startSpeed = s.getCurrentSpeed();
        s.gas(0.5);
        double gasSpeed = s.getCurrentSpeed();
        s.brake(0.5);
        double breakSpeed = s.getCurrentSpeed();
        assertEquals(startSpeed, 0.1);
        assertTrue(startSpeed < gasSpeed);
        assertTrue(gasSpeed > breakSpeed);
    }

    @Test
    void canMove() {
        Saab95 s = new Saab95();
        double x = s.getX();
        double y = s.getY();
        assertEquals(s.getDirection(), Direction.UP);
        s.startEngine();
        s.move();
        assertTrue(s.getY() < y);
        s.turnLeft();
        s.move();
        assertTrue(s.getX() < x);
        s.turnRight();
        s.turnRight();
        s.move();
        s.move();
        assertTrue(s.getX() > x);
        s.turnRight();
        s.move();
        s.move();
        assertTrue(s.getY() > y);
    }

    @Test
    void canChangeTurbo() {
        Saab95 s = new Saab95();
        s.setTurboOff();
        double noTurboSpeedFactor = s.speedFactor();
        s.setTurboOn();
        double turboSpeedFactor = s.speedFactor();
        assertTrue(turboSpeedFactor > noTurboSpeedFactor);
    }
}
