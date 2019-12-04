package utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages all screen elements with a map
 */
public final class ScreenElementsManager {

    private ScreenElementsManager() { }

    private static final Map<Class, ScreenElement> screenElements = new HashMap<>();

    public static void addElement(Class objectClass, ScreenElement screenElement) {
        screenElements.put(objectClass, screenElement);
    }

    public static ScreenElement getScreenElement(Class objectClass) {

        ScreenElement s = screenElements.get(objectClass);

        if (s == null) {
            throw new IllegalArgumentException("No screen element exists for " + objectClass.getName());
        }
        return s;
    }
}
