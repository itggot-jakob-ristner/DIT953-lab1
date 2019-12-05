package model.utilities;

/**
 * An enum representing the direction of something
 */
public enum Direction {
    UP, LEFT, DOWN, RIGHT;

    /**
     * Rotates the direction to the left
     * @param direction the input direction
     * @return a new direction which is the input direction rotated to the left
     */
    public static Direction turnLeft(Direction direction) {
        return turnByAmount(direction, 1);
    }

    /**
     * Rotates the direction to the right
     * @param direction the input direction
     * @return a new direction which is the input direction rotated to the right
     */
    public static Direction turnRight(Direction direction) {
        return turnByAmount(direction, 3);
    }

    public static Direction invertDirection(Direction direction) {
        return turnByAmount(direction, 2);
    }

    private static Direction turnByAmount(Direction current, int amount) {
        Direction[] directions = Direction.values();
        int directionNum = (current.ordinal() + amount) % directions.length;
        return directions[directionNum];
    }
}