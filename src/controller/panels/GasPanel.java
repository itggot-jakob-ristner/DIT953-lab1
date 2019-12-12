package controller.panels;

import model.Model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GasPanel extends JPanel {
    public GasPanel(GasAmount gasAmount, Model model) {
        JSpinner gasSpinner = new JSpinner();
        JLabel gasLabel = new JLabel("Amount of gas");
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount.setAmount((int) ((JSpinner)e.getSource()).getValue());
            }
        });
        setLayout(new BorderLayout());
        add(gasLabel, BorderLayout.PAGE_START);
        add(gasSpinner, BorderLayout.PAGE_END);
    }
}
