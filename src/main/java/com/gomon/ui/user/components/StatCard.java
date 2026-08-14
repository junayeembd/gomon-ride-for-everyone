package com.gomon.ui.user.components;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class StatCard extends ShadowCard {

    private final Color hoverColor = new Color(245, 247, 255);
    private final Color normalColor = Color.WHITE;

    public StatCard(
            Color color,
            String icon,
            String title,
            String value,
            String footer) {

        setLayout(new BorderLayout());
        setCardColor(normalColor);

        JPanel root = new JPanel(new BorderLayout(15, 0));
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(18, 18, 18, 18));

        // =====================================
        // Left Icon
        // =====================================

        JPanel iconContainer = new JPanel(new GridBagLayout());
        iconContainer.setOpaque(false);

        JPanel iconPanel = new JPanel(new GridBagLayout());
        iconPanel.setBackground(color);
        iconPanel.setPreferredSize(new Dimension(58, 58));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        iconLabel.setForeground(Color.WHITE);

        iconPanel.add(iconLabel);
        iconContainer.add(iconPanel);

        // =====================================
        // Right Text
        // =====================================

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        titleLabel.setForeground(new Color(120, 120, 120));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        valueLabel.setForeground(new Color(35, 35, 35));

        JLabel footerLabel = new JLabel(footer);
        footerLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));

        if (footer.contains("▲")) {
            footerLabel.setForeground(new Color(34, 197, 94));
        } else if (footer.contains("▼")) {
            footerLabel.setForeground(new Color(239, 68, 68));
        } else {
            footerLabel.setForeground(new Color(98, 71, 255));
        }

        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(6));
        textPanel.add(valueLabel);
        textPanel.add(Box.createVerticalStrut(6));
        textPanel.add(footerLabel);

        root.add(iconContainer, BorderLayout.WEST);
        root.add(textPanel, BorderLayout.CENTER);

        add(root, BorderLayout.CENTER);

        // =====================================
        // Hover
        // =====================================

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MouseAdapter hover = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setCardColor(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCardColor(normalColor);
            }
        };

        addMouseListener(hover);
        root.addMouseListener(hover);
    }
}