package com.gomon.ui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectionCard extends JPanel {

    private final JLabel iconLabel;
    private final JLabel titleLabel;
    private final JLabel descriptionLabel;

    public SelectionCard(String icon, String title, String description) {

        setLayout(new BorderLayout(15, 10));

        setOpaque(true);

        setBackground(Color.WHITE);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 2, true),
                new EmptyBorder(18, 20, 18, 20)));

        setMaximumSize(new Dimension(420, 110));

        setPreferredSize(new Dimension(420, 110));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // ================ Left Icon ===================

        iconLabel = new JLabel(icon);

        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 38));

        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);

        iconLabel.setPreferredSize(new Dimension(70, 70));

        add(iconLabel, BorderLayout.WEST);

        // ================ Center ===================

        JPanel textPanel = new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel(title);

        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        titleLabel.setForeground(new Color(40, 40, 40));

        descriptionLabel = new JLabel(description);

        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        descriptionLabel.setForeground(Color.GRAY);

        textPanel.add(titleLabel);

        textPanel.add(Box.createVerticalStrut(5));

        textPanel.add(descriptionLabel);

        add(textPanel, BorderLayout.CENTER);

        // ================ Right Arrow ===================

        JLabel arrow = new JLabel("➜");

        arrow.setFont(new Font("Segoe UI", Font.BOLD, 24));

        arrow.setForeground(new Color(0, 150, 136));

        add(arrow, BorderLayout.EAST);

        // ================ Hover ===================

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setBackground(new Color(235, 250, 247));

                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(0, 150, 136), 2, true),
                        new EmptyBorder(18, 20, 18, 20)));

            }

            @Override
            public void mouseExited(MouseEvent e) {

                setBackground(Color.WHITE);

                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220), 2, true),
                        new EmptyBorder(18, 20, 18, 20)));

            }

        });

    }

}