package com.gomon.ui.driver.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PerformanceCard extends JPanel {

    public PerformanceCard() {

        setBackground(Color.WHITE);
        setOpaque(true);

        setPreferredSize(new Dimension(420, 220));

        setBorder(new EmptyBorder(20,20,20,20));

        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);
        add(createBody(), BorderLayout.CENTER);

    }

    //-------------------------------------------------------

    private JPanel createHeader() {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setOpaque(false);

        JLabel title = new JLabel("Today's Performance");

        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        panel.add(title, BorderLayout.WEST);

        return panel;

    }

    //-------------------------------------------------------

    private JPanel createBody() {

        JPanel panel = new JPanel(new GridLayout(2,2,15,15));

        panel.setOpaque(false);

        panel.setBorder(new EmptyBorder(20,0,0,0));

        panel.add(createItem("🚖","Completed Ride","08"));
        panel.add(createItem("❌","Cancelled","01"));
        panel.add(createItem("📈","Acceptance","98%"));
        panel.add(createItem("⚡","Response","15 sec"));

        return panel;

    }

    //-------------------------------------------------------

    private JPanel createItem(String icon,
                              String title,
                              String value){

        JPanel card = new JPanel();

        card.setBackground(new Color(245,247,252));

        card.setBorder(new EmptyBorder(15,15,15,15));

        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));

        JLabel iconLabel = new JLabel(icon);

        iconLabel.setFont(new Font("Segoe UI Emoji",Font.PLAIN,24));

        JLabel valueLabel = new JLabel(value);

        valueLabel.setFont(new Font("Segoe UI",Font.BOLD,24));

        valueLabel.setForeground(new Color(45,45,45));

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));

        titleLabel.setForeground(Color.GRAY);

        card.add(iconLabel);
        card.add(Box.createVerticalStrut(10));
        card.add(valueLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(titleLabel);

        return card;

    }

}