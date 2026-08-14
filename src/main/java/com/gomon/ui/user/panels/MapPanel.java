package com.gomon.ui.user.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class MapPanel extends ShadowCard {

    private JPanel mapContainer;

    public MapPanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel(new BorderLayout(0, 15));
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(20, 20, 20, 20));

        // -------------------------
        // Header
        // -------------------------

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JLabel title = new JLabel("Live Ride Map");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel status = new JLabel("● Online");
        status.setFont(new Font("Segoe UI", Font.BOLD, 13));
        status.setForeground(new Color(34, 197, 94));

        header.add(title, BorderLayout.WEST);
        header.add(status, BorderLayout.EAST);

        // -------------------------
        // Map Area
        // -------------------------

        mapContainer = new JPanel(new BorderLayout());
        mapContainer.setBackground(new Color(238, 241, 247));
        mapContainer.setBorder(BorderFactory.createLineBorder(
                new Color(220, 225, 230)));

        JPanel center = new JPanel();
        center.setOpaque(false);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JLabel icon = new JLabel("🗺");
        icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 70));
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel text = new JLabel("Interactive Map");
        text.setFont(new Font("Segoe UI", Font.BOLD, 20));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel sub = new JLabel("OpenStreetMap / Google Map will appear here");
        sub.setForeground(new Color(120, 120, 120));
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        sub.setAlignmentX(Component.CENTER_ALIGNMENT);

        center.add(Box.createVerticalGlue());
        center.add(icon);
        center.add(Box.createVerticalStrut(15));
        center.add(text);
        center.add(Box.createVerticalStrut(8));
        center.add(sub);
        center.add(Box.createVerticalGlue());

        mapContainer.add(center, BorderLayout.CENTER);

        // -------------------------
        // Bottom
        // -------------------------

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        bottom.setOpaque(false);

        JLabel location = new JLabel("📍 Current Location : Dhaka");

        location.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        bottom.add(location);

        // -------------------------

        root.add(header, BorderLayout.NORTH);
        root.add(mapContainer, BorderLayout.CENTER);
        root.add(bottom, BorderLayout.SOUTH);

        add(root, BorderLayout.CENTER);
    }

    public JPanel getMapContainer() {
        return mapContainer;
    }
}