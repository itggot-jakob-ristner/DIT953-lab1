package application;

import model.utilities.Vector;
import view.CanvasView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * A representation of an element that can be drawn on the screen
 */
public class ScreenElement {

    private BufferedImage image;
    private Vector size;

    public ScreenElement(String imagePath) throws IOException {
        this.image = ImageIO.read(CanvasView.class.getResourceAsStream(imagePath));
        this.size = new Vector(image.getWidth(), image.getHeight());
    }

    public BufferedImage getImage() {
        return image;
    }

    public Vector getSize() {
        return size;
    }
}
