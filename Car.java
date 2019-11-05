import java.awt.*;

abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vector pos;
    private Direction direction = Direction.UP;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        pos = new Vector();
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    private double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    private void stopEngine(){
        currentSpeed = 0;
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

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

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }



    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public abstract double speedFactor();

}
