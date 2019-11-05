public class Vector {
    private double x;
    private double y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        x = 0;
        y = 0;
    }

    public void add(Vector vector) {
        x += vector.getX();
        y += vector.getY();
    }

    public void addY(double num) {
        y += num;
    }
    public void addX(double num) {
        x += num;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
