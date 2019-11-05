public enum Direction {
    UP, RIGHT, LEFT, DOWN;
    public static Direction turnLeft(Direction direction) {
        switch (direction) {
            case UP:
                return Direction.LEFT;
            case LEFT:
                return Direction.DOWN;
            case DOWN:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.UP;
        }
        return null;
    }
}