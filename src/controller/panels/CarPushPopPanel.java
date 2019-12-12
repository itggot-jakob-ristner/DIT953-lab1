package controller.panels;

import model.Model;
import model.utilities.Vector;
import model.vehicles.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarPushPopPanel extends JPanel {
    public CarPushPopPanel(Model model) {
        JButton addButton = new JButton("Add Vehicle");
        JButton removeButton = new JButton("Remove Vehicle");

        add(addButton);
        add(removeButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.addVehicle(VehicleFactory.createRandomVehicle());
                } catch (Model.TooManyVehiclesException ex) {}
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    model.removeVehicle();
                } catch (Model.NoVehiclesException ex) {}
            }
        });
    }
}
