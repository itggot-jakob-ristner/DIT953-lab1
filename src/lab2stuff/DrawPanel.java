package lab2stuff;

import utilities.ScreenElement;
import utilities.ScreenElementsManager;
import vehicles.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    List<Vehicle> motorisedVehicles;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> motorisedVehicles) {
        this.motorisedVehicles = motorisedVehicles;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            String root = "/pics/";

            ScreenElementsManager.addElement(Volvo240.class, new ScreenElement(root + "Volvo240.jpg"));
            ScreenElementsManager.addElement(Saab95.class, new ScreenElement(root + "Saab95.jpg"));
            ScreenElementsManager.addElement(Scania.class, new ScreenElement(root + "Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : motorisedVehicles) {
            int x = (int) v.getPos().getX();
            int y = (int) v.getPos().getY();
            g.drawImage(ScreenElementsManager.getScreenElement(v.getClass()).getImage(), x, y, null); // see javadoc for more info on the parameters
        }
    }
}
