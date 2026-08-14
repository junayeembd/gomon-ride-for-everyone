package com.gomon.ui.driver.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RideRequestCard extends JPanel {

    public RideRequestCard(
            String passengerName,
            String rating,
            String distance,
            String pickup,
            String drop,
            String fare,
            String payment) {

        setBackground(Color.WHITE);
        setOpaque(true);

        // ==========================================
        // CARD SIZE
        // ==========================================

        setPreferredSize(
                new Dimension(350, 380));

        setMinimumSize(
                new Dimension(350, 380));

        setMaximumSize(
                new Dimension(350, 380));

        setBorder(
                new EmptyBorder(
                        18,
                        18,
                        18,
                        18));

        setLayout(
                new BorderLayout());

        // ==========================================
        // TOP
        // ==========================================

        add(
                createTop(
                        passengerName,
                        rating,
                        distance),
                BorderLayout.NORTH);

        // ==========================================
        // CENTER
        // ==========================================

        add(
                createCenter(
                        pickup,
                        drop),
                BorderLayout.CENTER);

        // ==========================================
        // BOTTOM
        // ==========================================

        add(
                createBottom(
                        fare,
                        payment),
                BorderLayout.SOUTH);
    }

    // =========================================================
    // TOP SECTION
    // =========================================================

    private JPanel createTop(
            String name,
            String rating,
            String distance) {

        JPanel panel = new JPanel(
                new BorderLayout());

        panel.setOpaque(false);

        // -----------------------------------------------------
        // LEFT SIDE
        // -----------------------------------------------------

        JPanel left = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        12,
                        0));

        left.setOpaque(false);

        // Avatar
        JLabel avatar = new JLabel("👤");

        avatar.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        34));

        // Passenger information
        JPanel info = new JPanel();

        info.setOpaque(false);

        info.setLayout(
                new BoxLayout(
                        info,
                        BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(name);

        nameLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18));

        nameLabel.setForeground(
                new Color(
                        30,
                        30,
                        30));

        JLabel ratingLabel = new JLabel(
                "⭐ " + rating + " • Premium Rider");

        ratingLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        ratingLabel.setForeground(
                new Color(
                        115,
                        115,
                        115));

        info.add(nameLabel);

        info.add(
                Box.createVerticalStrut(4));

        info.add(ratingLabel);

        left.add(avatar);
        left.add(info);

        // -----------------------------------------------------
        // DISTANCE
        // -----------------------------------------------------

        JLabel distanceLabel = new JLabel(distance);

        distanceLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        distanceLabel.setOpaque(true);

        distanceLabel.setBackground(
                new Color(
                        232,
                        250,
                        240));

        distanceLabel.setForeground(
                new Color(
                        39,
                        174,
                        96));

        distanceLabel.setBorder(
                new EmptyBorder(
                        6,
                        12,
                        6,
                        12));

        panel.add(
                left,
                BorderLayout.WEST);

        panel.add(
                distanceLabel,
                BorderLayout.EAST);

        return panel;
    }

    // =========================================================
    // CENTER SECTION
    // =========================================================

    private JPanel createCenter(
            String pickup,
            String drop) {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setBorder(
                new EmptyBorder(
                        24,
                        5,
                        18,
                        5));

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS));

        // -----------------------------------------------------
        // PICKUP LABEL
        // -----------------------------------------------------

        JLabel pickupTitle = new JLabel("Pickup");

        pickupTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12));

        pickupTitle.setForeground(
                new Color(
                        120,
                        120,
                        120));

        pickupTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        JLabel pickupLabel = new JLabel(
                "🟢  " + pickup);

        pickupLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15));

        pickupLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        // -----------------------------------------------------
        // DROP LABEL
        // -----------------------------------------------------

        JLabel dropTitle = new JLabel("Drop");

        dropTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12));

        dropTitle.setForeground(
                new Color(
                        120,
                        120,
                        120));

        dropTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        JLabel dropLabel = new JLabel(
                "🔴  " + drop);

        dropLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15));

        dropLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        // -----------------------------------------------------
        // ADD
        // -----------------------------------------------------

        panel.add(pickupTitle);

        panel.add(
                Box.createVerticalStrut(5));

        panel.add(pickupLabel);

        panel.add(
                Box.createVerticalStrut(18));

        panel.add(dropTitle);

        panel.add(
                Box.createVerticalStrut(5));

        panel.add(dropLabel);

        return panel;
    }

    // =========================================================
    // BOTTOM SECTION
    // =========================================================

    private JPanel createBottom(
            String fare,
            String payment) {

        JPanel container = new JPanel(
                new BorderLayout());

        container.setOpaque(false);

        // -----------------------------------------------------
        // FARE + PAYMENT
        // -----------------------------------------------------

        JPanel info = new JPanel(
                new BorderLayout());

        info.setOpaque(false);

        JLabel fareLabel = new JLabel(
                "৳ " + fare);

        fareLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21));

        fareLabel.setForeground(
                new Color(
                        30,
                        30,
                        30));

        JLabel paymentLabel = new JLabel(payment);

        paymentLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13));

        paymentLabel.setForeground(
                new Color(
                        39,
                        174,
                        96));

        info.add(
                fareLabel,
                BorderLayout.WEST);

        info.add(
                paymentLabel,
                BorderLayout.EAST);

        // -----------------------------------------------------
        // BUTTONS
        // -----------------------------------------------------

        JPanel buttonPanel = new JPanel(
                new GridLayout(
                        1,
                        2,
                        12,
                        0));

        buttonPanel.setOpaque(false);

        JButton accept = new JButton("Accept");

        accept.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13));

        accept.setBackground(
                new Color(
                        34,
                        197,
                        94));

        accept.setForeground(
                Color.WHITE);

        accept.setFocusPainted(false);

        accept.setBorderPainted(false);

        accept.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        JButton view = new JButton("View");

        view.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13));

        view.setFocusPainted(false);

        view.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        buttonPanel.add(accept);
        buttonPanel.add(view);

        // -----------------------------------------------------
        // FINAL
        // -----------------------------------------------------

        container.add(
                info,
                BorderLayout.NORTH);

        container.add(
                Box.createVerticalStrut(14),
                BorderLayout.CENTER);

        container.add(
                buttonPanel,
                BorderLayout.SOUTH);

        return container;
    }
}