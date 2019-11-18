public class DiscreteFlatbed implements Flatbed {

    private boolean isDown = true;

    @Override
    public void raise() {
        isDown = false;
    }

    @Override
    public void lower() {
        isDown = true;
    }

    @Override
    public boolean isDown() {
        return isDown;
    }

    @Override
    public boolean isUp() {
        return !isDown;
    }


}
