package utilities;

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
        Direction[] directions = Direction.values();
        int directionNum = (direction.ordinal()+1) % directions.length;
        return directions[directionNum];
    }

    /**
     * Rotates the direction to the right
     * @param direction the input direction
     * @return a new direction which is the input direction rotated to the right
     */
    public static Direction turnRight(Direction direction) {
        Direction[] directions = Direction.values();
        int directionNum = (direction.ordinal() - 1 + directions.length) % directions.length;
        return directions[directionNum];
    }
}