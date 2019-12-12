package view;

import controller.Controller;
import model.Model;
import model.event.Event;
import model.event.EventListener;
import model.utilities.Vector;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View extends JFrame implements EventListener {

    private CanvasView canvas;
    private StatusView status;

    List<JPanel> components;

    public View(Model model, Controller controller) {
        this.canvas = new CanvasView(model);
        this.status = new StatusView(model);

        initializeFrame("CarSim 1.0", model.getWorldSize(), controller);
        model.addEventListener(this);
    }

    private void initializeFrame(String title, Vector size, Controller controller) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension((int) size.getX(), (int) size.getY()));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(canvas);
        this.add(controller.getGasPanel());
        this.add(controller.getControlPanel());
        this.add(status);



        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void onEvent(Event e) {
        if (e == Event.REPAINT) {
            repaintComponents();
        }
    }

    private void repaintComponents() {
        canvas.repaint();
        status.repaint();
    }

    private void addComponent(JPanel component) {

    }

}
