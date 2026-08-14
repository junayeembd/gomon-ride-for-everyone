package com.gomon.ui.user.panels;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class SafetyPanel extends ShadowCard {

    public SafetyPanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel();
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(22, 22, 22, 22));
        root.setLayout(new BorderLayout(0, 20));

        // =========================================
        // Header
        // =========================================

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("🛡 Safety First, Always");

        title.setFont(new Font(
                "Segoe UI",
                Font.BOLD,
                24));

        JLabel description = new JLabel(
                "Stay protected with emergency assistance, trip sharing and trusted safety tools.");

        description.setFont(new Font(
                "Segoe UI",
                Font.PLAIN,
                13));

        description.setForeground(
                new Color(120, 120, 120));

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(description);

        // =========================================
        // Cards
        // =========================================

        JPanel cards = new JPanel(
                new GridLayout(
                        1,
                        5,
                        15,
                        0));

        cards.setOpaque(false);

        cards.add(createSafetyCard(
                "🚨",
                "Emergency",
                "Tap for Help",
                new Color(255, 235, 235),
                new Color(239, 68, 68)));

        cards.add(createSafetyCard(
                "📍",
                "Share Live Trip",
                "Share with Family",
                new Color(232, 245, 255),
                new Color(59, 130, 246)));

        cards.add(createSafetyCard(
                "🌙",
                "Night Safety",
                "Stay Protected",
                new Color(240, 235, 255),
                new Color(124, 58, 237)));

        cards.add(createSafetyCard(
                "👮",
                "Trusted Driver",
                "100% Verified",
                new Color(232, 255, 236),
                new Color(34, 197, 94)));

        cards.add(createSafetyCard(
                "☎",
                "Emergency Contact",
                "Add Contact",
                new Color(255, 243, 230),
                new Color(249, 115, 22)));

        root.add(header, BorderLayout.NORTH);
        root.add(cards, BorderLayout.CENTER);

        add(root, BorderLayout.CENTER);
    }
    // ========================================================
    // Safety Card
    // ========================================================

    private JPanel createSafetyCard(
            String icon,
            String title,
            String subtitle,
            Color bgColor,
            Color iconColor) {

        JPanel card = new JPanel();
        card.setOpaque(true);
        card.setBackground(Color.WHITE);
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(230, 235, 242), 1, true),
                new EmptyBorder(15, 15, 15, 15)));

        card.setLayout(new BorderLayout(0, 12));

        // --------------------------------------
        // Icon
        // --------------------------------------

        JPanel iconPanel = new JPanel(new GridBagLayout());
        iconPanel.setOpaque(false);

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));

        JPanel circle = new JPanel(new GridBagLayout());
        circle.setPreferredSize(new Dimension(55, 55));
        circle.setBackground(bgColor);

        circle.add(iconLabel);

        iconPanel.add(circle);

        // --------------------------------------
        // Text
        // --------------------------------------

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subLabel = new JLabel(subtitle);
        subLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subLabel.setForeground(new Color(120, 120, 120));
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        text.add(titleLabel);
        text.add(Box.createVerticalStrut(4));
        text.add(subLabel);

        // --------------------------------------

        card.add(iconPanel, BorderLayout.NORTH);
        card.add(text, BorderLayout.CENTER);

        // --------------------------------------
        // Hover
        // --------------------------------------

        card.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                card.setBackground(new Color(248, 250, 255));
                card.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                iconColor, 2, true),
                        new EmptyBorder(14, 14, 14, 14)));

            }

            @Override
            public void mouseExited(MouseEvent e) {

                card.setBackground(Color.WHITE);

                card.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(230, 235, 242), 1, true),
                        new EmptyBorder(15, 15, 15, 15)));

            }

        });

        return card;
    }

}