package view;

import model.Model;
import model.event.Event;
import model.event.EventListener;

import javax.swing.*;

public class View extends JFrame implements EventListener {

    private CanvasView canvas;

    public View(Model model) {
        this.canvas = new CanvasView(model);
    }

    @Override
    public void onEvent(Event e) {
        if (e == Event.REPAINT) {
            this.repaint();
        }
    }
}
