package com.gomon.ui.driver.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class SafetyPanel extends ShadowCard {

    public SafetyPanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel(new BorderLayout());
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(18, 18, 18, 18));

        //-------------------------------------------------
        // Header
        //-------------------------------------------------

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JLabel title = new JLabel("Safety First, Always");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(new Color(35, 35, 35));

        JLabel subtitle = new JLabel("Your safety tools are always one tap away.");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(new Color(120, 120, 120));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        text.add(title);
        text.add(Box.createVerticalStrut(5));
        text.add(subtitle);

        header.add(text, BorderLayout.WEST);

        root.add(header, BorderLayout.NORTH);

        //-------------------------------------------------
        // Features
        //-------------------------------------------------

        JPanel grid = new JPanel(new GridLayout(1, 4, 15, 0));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(20, 0, 0, 0));

        grid.add(createSafetyItem(
                "🆘",
                "Emergency",
                "24/7 Assistance"));

        grid.add(createSafetyItem(
                "📍",
                "Share Trip",
                "Live Location"));

        grid.add(createSafetyItem(
                "👨‍👩‍👧",
                "Trusted Contact",
                "Notify Family"));

        grid.add(createSafetyItem(
                "🌙",
                "Night Safety",
                "Extra Protection"));

        root.add(grid, BorderLayout.CENTER);

        add(root, BorderLayout.CENTER);

    }

    //====================================================

    private JPanel createSafetyItem(
            String icon,
            String title,
            String subtitle) {

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titleLabel.setForeground(new Color(35, 35, 35));

        JLabel subLabel = new JLabel(subtitle);
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subLabel.setForeground(new Color(130, 130, 130));

        panel.add(iconLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(subLabel);

        return panel;
    }

}