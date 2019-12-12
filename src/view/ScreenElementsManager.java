package view;

import view.CanvasView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages all screen elements with a map
 */
public final class ScreenElementsManager {

    private ScreenElementsManager() { }

    private static final Map<Class, BufferedImage> images = new HashMap<>();

    public static void addElement(Class objectClass, BufferedImage image) {
        images.put(objectClass, image);
    }

    public static void addElement(Class objectClass, String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(CanvasView.class.getResourceAsStream(imagePath));
        } catch (IOException e) {
            System.out.println("Image " + imagePath + " does not exist");
            e.printStackTrace();
        }
        images.put(objectClass, image);
    }

    public static BufferedImage getScreenElement(Class objectClass) {

        BufferedImage s = images.get(objectClass);

        if (s == null) {
            throw new IllegalArgumentException("No screen element exists for " + objectClass.getName());
        }
        return s;
    }
}
