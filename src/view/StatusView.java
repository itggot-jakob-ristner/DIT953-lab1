package view;

import model.Model;
import model.vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;

public class StatusView extends JPanel {

    private Model model;

    private JLabel statusLabel;


    public StatusView(Model model) {
        this.model = model;

        this.statusLabel = new JLabel();
        this.add(statusLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        updateStatusLabel();
        super.paintComponent(g);
    }

    private void updateStatusLabel() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        for (Vehicle v : model.getVehicles()) {
            sb.append(v).append( ": ").append(v.getSpeed()).append("<br>");
        }
        sb.append("</html>");
        statusLabel.setText(sb.toString());
    }
}
