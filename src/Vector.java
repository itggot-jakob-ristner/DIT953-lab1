/**
 * A 2d vector represented by doubles
 */
public class Vector {
    /**
     * the x coordinate of the vector
     */
    private double x;

    /**
     * the y coordinate of the vector
     */
    private double y;

    /**
     * The constructor for the vector
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor without parameters for Vector
     */
    public Vector() {
        x = 0;
        y = 0;
    }

    /**
     * Adds another vector to this
     * @param vector the other vector to add
     */
    public void add(Vector vector) {
        x += vector.getX();
        y += vector.getY();
    }

    /**
     * Adds a number to the Y coordinate
     * @param num the number to add
     */
    public void addY(double num) {
        y += num;
    }

    /**
     * Adds a number to the X coordinate
     * @param num the number to add
     */
    public void addX(double num) {
        x += num;
    }

    /**
     * Getter for the x coordinate
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for the y coordinate
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for the x coordinate
     * @param x the new x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter for the y coordinate
     * @param y the new y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }
}
