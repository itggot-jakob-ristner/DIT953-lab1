package controller;

import model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private JPanel controlPanel;
    private JPanel gasPanel;
    private int gasAmount;

    public Controller(Model model) {
        this.model = model;

        gasPanel = new JPanel();
        JSpinner gasSpinner = new JSpinner();
        gasAmount = 0;
        JLabel gasLabel = new JLabel("Amount of gas");
        JButton startButton = new JButton("Start all cars");
        JButton stopButton = new JButton("Stop all cars");
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasAmount = (int) ((JSpinner)e.getSource()).getValue();






        controlPanel = new JPanel();

        JButton gasButton = new JButton("Gas");
        JButton brakeButton = new JButton("Brake");
        JButton turboOnButton = new JButton("Saab Turbo on");
        JButton turboOffButton = new JButton("Saab Turbo off");
        JButton activateBedButton = new JButton("Activate Bed");
        JButton deactivateBedButton = new JButton("Deactivate Bed");

        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(activateBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(deactivateBedButton, 5);
        controlPanel.setPreferredSize(new Dimension(((int) model.getWorldSize().getX()/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gasAll(gasAmount);
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brakeAll(gasAmount);
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOn();
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.turboOff();
            }
        });
        deactivateBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.deactivateBed();
            }
        });
        activateBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.activateBed();
            }
        });


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension((int) model.getWorldSize().getX()/5-15,200));
        controlPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startAll();
            }
        });


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension((int) model.getWorldSize().getX()/5-15,200));
        controlPanel.add(stopButton);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopAll();
            }
        });
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }

    public JPanel getGasPanel() {
        return gasPanel;
    }

}
