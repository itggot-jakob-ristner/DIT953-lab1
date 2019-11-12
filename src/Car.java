import java.awt.*;

/**
 * A representation of a real life car
 */
abstract class Car implements Movable{

    /**
     * Number of doors on the car
     */
    private int nrDoors;

    /**
     * Engine power of the car
     */
    private double enginePower;

    /**
     * The current speed of the car
     */
    private double currentSpeed;

    /**
     * Color of the car
     */
    private Color color;

    /**
     * The car model name
     */
    private String modelName;

    /**
     * Where the car is located in the world represented as a 2D vector
     */
    private Vector pos;

    /**
     * The direction of the car represented by an enum
     */
    private Direction direction = Direction.UP;

    /**
     * @param nrDoors Number of doors of the car
     * @param color The color of the car
     * @param enginePower The power of the engine in the car
     * @param modelName The name of the model
     */
    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        pos = new Vector();
        stopEngine();
    }

    /**
     * @return The number of doors of the car as an int
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * @return The power of the engine that is in the car as a double
     */
    protected double getEnginePower(){
        return enginePower;
    }

    /**
     * @return The current speed of the car as a double
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Returns the color of the car
     * @return The color of the car represented in a Color object
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets the color of the car to a new color
     * @param clr The new color of the car represented in a Color object
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Starts the engine of the car
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine of the car
     */
    private void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Increases the speed at which lobsters die
     * @param amount The amount, represented as a double, at which the speed of the car should be increased
     */
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the speed at which lobsters die
     * @param amount The amount, represented as a double, at which the speed of the car should be decreased
     */
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * Moves the car in the direction of which the car is represented to be currently in (by the direction variable)
     */
    @Override
    public void move() {
        switch (direction) {
            case UP:
                pos.addY(-currentSpeed);
                break;
            case DOWN:
                pos.addY(currentSpeed);
                break;
            case RIGHT:
                pos.addX(currentSpeed);
                break;
            case LEFT:
                pos.addX(-currentSpeed);
        }
    }

    /**
     * Turns the car left, relative to the direction of the car
     */
    @Override
    public void turnLeft() {
        direction = Direction.turnLeft(direction);
    }

    /**
     * Turns the car right, relative to the direction of the car
     */
    @Override
    public void turnRight() {
        direction = Direction.turnRight(direction);
    }


    /**
     * Gases the car
     * @param amount with the given amount
     */
    public void gas(double amount){
        incrementSpeed(Math.max(0, Math.min(1, amount)));
    }

    // TODO: fix todos
    // TODO fix this method according to lab pm
    // TODO: Add javadoc

    /**
     * Breaks the car
     * @param amount with the amount given
     */
    public void brake(double amount){
        decrementSpeed(Math.max(0, Math.min(1, amount)));
    }

    /**
     * Jag vet inte vad jag ska skriva här
     * @return Speed factor of the car
     */
    public abstract double speedFactor();

    /**
     * Returns the x coordinate of the car
     * @return the x-value of the vector that represents the position of the car
     */
    public double getX() {
        return pos.getX();
    }

    /**
     * Returns the y coordinate of the car
     * @return the y-value of the vector that represents the position of the car
     */
    public double getY() {
        return pos.getY();
    }

    /**
     * Returns the direction of the car at which it is headed, represented as an enum
     * @return the direction of the car represented as an enum
     */
    public Direction getDirection() {
        return direction;
    }
}
