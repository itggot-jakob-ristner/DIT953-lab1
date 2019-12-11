package view;

import application.ScreenElement;
import application.ScreenElementsManager;
import model.Model;
import model.utilities.Vector;
import model.vehicles.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class CanvasView extends JPanel {

    private List<Vehicle> motorisedVehicles;


    // Initializes the panel and reads the images
    public CanvasView(Model model) {
        Vector worldSize = model.getWorldSize();

        this.motorisedVehicles = model.getVehicles();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension((int) worldSize.getX(), (int) worldSize.getY()));
        this.setBackground(Color.green);

        String root = "/pics/";

        Vehicle volvo = VehicleFactory.createVolvo240();
        Vehicle saab = VehicleFactory.createSaab95();
        Vehicle scania = VehicleFactory.createScania();
        ScreenElementsManager.addElement(volvo.getClass(), root + "Volvo240.jpg");
        ScreenElementsManager.addElement(saab.getClass(), root + "Saab95.jpg");
        ScreenElementsManager.addElement(scania.getClass(), root + "Scania.jpg");
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : motorisedVehicles) {
            int x = (int) v.getPos().getX();
            int y = (int) v.getPos().getY();
            BufferedImage image = ScreenElementsManager.getScreenElement(v.getClass());
            g.drawImage(image, x, y, null);
        }
    }
}
