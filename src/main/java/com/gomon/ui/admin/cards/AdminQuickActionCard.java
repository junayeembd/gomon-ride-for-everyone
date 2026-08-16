package com.gomon.ui.admin.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminQuickActionCard extends JPanel {

    private final JButton actionButton;

    public AdminQuickActionCard(
            String title,
            String description,
            String buttonText,
            Runnable action) {

        setPreferredSize(new Dimension(280, 105));
        setBackground(Color.WHITE);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(230, 232, 238)),
                BorderFactory.createEmptyBorder(
                        15, 17, 15, 17)));

        setLayout(new BorderLayout(12, 0));

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 14));

        titleLabel.setForeground(
                new Color(35, 35, 50));

        JLabel descriptionLabel = new JLabel(description);

        descriptionLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 11));

        descriptionLabel.setForeground(
                new Color(120, 120, 135));

        JPanel textPanel = new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(
                new javax.swing.BoxLayout(
                        textPanel,
                        javax.swing.BoxLayout.Y_AXIS));

        textPanel.add(titleLabel);
        textPanel.add(javax.swing.Box.createVerticalStrut(5));
        textPanel.add(descriptionLabel);

        actionButton = new JButton(buttonText);

        actionButton.setFocusPainted(false);
        actionButton.setForeground(Color.WHITE);
        actionButton.setBackground(
                new Color(98, 71, 255));

        actionButton.setFont(
                new Font("Segoe UI", Font.BOLD, 11));

        actionButton.setBorder(
                BorderFactory.createEmptyBorder(
                        8, 12, 8, 12));

        actionButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR));

        actionButton.addActionListener(
                e -> action.run());

        add(textPanel, BorderLayout.CENTER);
        add(actionButton, BorderLayout.EAST);
    }
}