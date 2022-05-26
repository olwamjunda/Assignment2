package assignment2;

import javax.swing.*;

import org.checkerframework.common.value.qual.ArrayLen;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ComputerLab extends JFrame {
    private JLabel lblIpAddress = new JLabel("IP Address");
    private JTextField txtIpAddress = new JTextField();
    private JLabel lblValue = new JLabel("Value");
    private JTextField txtValue = new JTextField();
    private JButton btnAdd = new JButton("+");
    private JButton btnShow = new JButton("Show Computers");
    private JButton btnClear = new JButton("Clear");
    private JButton btnExit = new JButton("Exit App");
    private ArrayList<String> ipAddresses = new ArrayList<>();
    private ArrayList<Double> values = new ArrayList<>();

    public ComputerLab() {
        super("Computer Lap App");
        setDefaultCloseOperation(3);
        setLayout(new GridLayout(4, 2, 7, 5));
        add(lblIpAddress);
        add(txtIpAddress);
        add(lblValue);
        add(txtValue);
        add(btnAdd);
        add(btnShow);
        add(btnClear);
        add(btnExit);
        btnAdd.addActionListener(
                e -> {
                    try {
                        ipAddresses.add(txtIpAddress.getText());
                        values.add(Double.valueOf(txtValue.getText()));
                        JOptionPane.showMessageDialog(null, "Computer Insterted");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Inputs");
                    }
                });
        btnShow.addActionListener(
                e -> {
                    showComputers(ipAddresses, values);
                });
        btnClear.addActionListener(
                e -> {
                    txtIpAddress.setText("");
                    txtValue.setText("");
                });
        btnExit.addActionListener(
                e -> {
                    System.exit(0);
                });
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void showComputers(ArrayList<String> ips, ArrayList<Double> v) {
        List computerIps = new List();
        // JPanel pnlShow = new JPanel(new GridLayout(ips.size(), 2, 7, 5));

        for (int i = 0; i < ips.size(); i++) {
            computerIps.add(ips.get(i) + "   " + "$" + v.get(i));
        }

        // pnlShow.add(computerIps);

        JOptionPane.showMessageDialog(null, computerIps, "Computers", 1);

    }
}
