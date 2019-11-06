public enum Direction {
    UP, LEFT, DOWN, RIGHT;
    public static Direction turnLeft(Direction direction) {
        Direction[] directions = Direction.values();
        int directionNum = (direction.ordinal()+1) % directions.length;
        return directions[directionNum];
    }

    public static Direction turnRight(Direction direction) {
        Direction[] directions = Direction.values();
        int directionNum = (direction.ordinal() - 1) % directions.length;
        return directions[directionNum];
    }
}