package model.utilities;

public final class CollisionDetector {

    private CollisionDetector() { }


    public static boolean isOutside(Vector pos, Vector size, Vector worldSize) {
        if (pos.getX() < 0 || pos.getY() < 0) {
            return true;
        }
        if (pos.getX() + size.getX() > worldSize.getX() || pos.getY() + size.getY() > worldSize.getY()) {
            return true;
        }
        return false;
    }
}
