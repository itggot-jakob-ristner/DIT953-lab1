public class DiscreteFlatbed implements Flatbed {

    private boolean isDown = true;

    @Override
    public void raiseFlatbed() {
        isDown = false;
    }

    @Override
    public void lowerFlatbed() {
        isDown = true;
    }

    @Override
    public boolean isDown() {
        return isDown;
    }
}
