package behaviours;

public interface Transporter<T extends Transportable> {

    boolean tryLoad(T t);

    T tryUnload();

    int getMaxCargoWeight();

    int getMaxCargoSlots();

    double getPickupRange();
}
