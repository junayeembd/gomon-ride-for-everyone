package com.gomon.ui.driver.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SafetyCard extends JPanel {

    public SafetyCard() {

        setBackground(Color.WHITE);
        setOpaque(true);

        setPreferredSize(new Dimension(420,180));

        setBorder(new EmptyBorder(20,20,20,20));

        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createBody(), BorderLayout.CENTER);

    }

    //--------------------------------------------------

    private JPanel createHeader() {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setOpaque(false);

        JLabel title = new JLabel("Safety First");

        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        panel.add(title, BorderLayout.WEST);

        return panel;
    }

    //--------------------------------------------------

    private JPanel createBody() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setBorder(new EmptyBorder(15,0,0,0));

        panel.setLayout(new GridLayout(4,1,0,12));

        panel.add(createItem("🆘", "Emergency SOS"));
        panel.add(createItem("📍", "Share Live Trip"));
        panel.add(createItem("🛡", "Safe Driving Tips"));
        panel.add(createItem("📞", "Emergency Contact"));

        return panel;
    }

    //--------------------------------------------------

    private JPanel createItem(String icon, String text) {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,0));

        panel.setOpaque(false);

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN,20));

        JLabel textLabel = new JLabel(text);
        textLabel.setFont(new Font("Segoe UI", Font.PLAIN,15));

        panel.add(iconLabel);
        panel.add(textLabel);

        return panel;
    }

}