package com.gomon.ui.driver.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DriverStatusCard extends JPanel {

    private JLabel statusLabel;
    private JToggleButton toggle;

    public DriverStatusCard() {

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(250,90));

        setBorder(new EmptyBorder(15,15,15,15));

        setLayout(new BorderLayout());

        //--------------------------------

        JPanel left = new JPanel();

        left.setOpaque(false);

        left.setLayout(new BoxLayout(left,BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Driver Status");

        title.setFont(new Font("Segoe UI",Font.BOLD,16));

        statusLabel = new JLabel("🟢 ONLINE");

        statusLabel.setForeground(new Color(39,174,96));

        statusLabel.setFont(new Font("Segoe UI",Font.BOLD,15));

        left.add(title);
        left.add(Box.createVerticalStrut(5));
        left.add(statusLabel);

        //--------------------------------

        toggle = new JToggleButton("ON");

        toggle.setFocusPainted(false);

        toggle.setBackground(new Color(39,174,96));

        toggle.setForeground(Color.WHITE);

        toggle.addActionListener(e->{

            if(toggle.isSelected()){

                toggle.setText("ON");

                toggle.setBackground(new Color(39,174,96));

                statusLabel.setText("🟢 ONLINE");

                statusLabel.setForeground(new Color(39,174,96));

            }else{

                toggle.setText("OFF");

                toggle.setBackground(Color.GRAY);

                statusLabel.setText("🔴 OFFLINE");

                statusLabel.setForeground(Color.RED);

            }

        });

        toggle.setSelected(true);

        add(left,BorderLayout.WEST);

        add(toggle,BorderLayout.EAST);

    }

}