package model.vehicleparts;

public class DiscreteFlatbed implements Flatbed {

    private boolean isDeactivated = true;

    @Override
    public void activate() {
        isDeactivated = false;
    }

    @Override
    public void deActivate() {
        isDeactivated = true;
    }

    @Override
    public boolean isDeactivated() {
        return isDeactivated;
    }

    @Override
    public boolean isActivated() {
        return !isDeactivated;
    }


}
