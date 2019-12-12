package controller;

import controller.panels.CarPushPopPanel;
import controller.panels.ControlPanel;
import controller.panels.GasAmount;
import controller.panels.GasPanel;
import model.Model;

import javax.swing.*;

public class Controller {
    private final Model model;

    private final JPanel carPushPopPanel;
    private final JPanel controlPanel;
    private final JPanel gasPanel;

    public Controller(Model model) {
        this.model = model;
        GasAmount gasAmount = new GasAmount();
        controlPanel = new ControlPanel(gasAmount, model);
        gasPanel = new GasPanel(gasAmount, model);
        carPushPopPanel = new CarPushPopPanel(model);
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public JPanel getGasPanel() {
        return gasPanel;
    }

    public JPanel getCarPushPopPanel() {
        return carPushPopPanel;
    }
}
