package controller.panels;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public ControlPanel(GasAmount gasAmount, Model model) {
        JButton startButton = new JButton("Start all cars");
        JButton stopButton = new JButton("Stop all cars");

        JButton gasButton = new JButton("Gas");
        JButton brakeButton = new JButton("Brake");
        JButton turboOnButton = new JButton("Turbo on");
        JButton turboOffButton = new JButton("Turbo off");
        JButton activateBedButton = new JButton("Activate Bed");
        JButton deactivateBedButton = new JButton("Deactivate Bed");

        setLayout(new GridLayout(2,4));
        add(gasButton, 0);
        add(turboOnButton, 1);
        add(activateBedButton, 2);
        add(startButton, 3);
        add(brakeButton, 4);
        add(turboOffButton, 5);
        add(deactivateBedButton, 6);
        add(stopButton, 7);
        setPreferredSize(new Dimension(((int) model.getWorldSize().getX()/2)+4, 200));
        setBackground(Color.CYAN);
        // This actionListener is for the gas button only
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gasAll(gasAmount.getAmount());
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brakeAll(gasAmount.getAmount());
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
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startAll();
            }
        });


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension((int) model.getWorldSize().getX()/5-15,200));
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopAll();
            }
        });
    }
}
