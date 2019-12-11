package view;

import controller.Controller;
import model.Model;
import model.event.Event;
import model.event.EventListener;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements EventListener {

    private CanvasView canvas;

    public View(Model model, Controller controller) {
        this.canvas = new CanvasView(model);
    }

    private void initializeFrame(String title, int width, int height) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(createStatusPanel());
    }



    private JPanel createStatusPanel() {
        new JLabel();
    }

    @Override
    public void onEvent(Event e) {
        if (e == Event.REPAINT) {
            this.repaint();
        }
    }
}
