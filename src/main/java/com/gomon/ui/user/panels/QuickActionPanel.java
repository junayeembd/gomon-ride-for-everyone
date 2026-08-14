package com.gomon.ui.user.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class QuickActionPanel extends ShadowCard {

    public QuickActionPanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel(new BorderLayout(0, 15));
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(20, 20, 20, 20));

        // -----------------------
        // Title
        // -----------------------

        JLabel title = new JLabel("Quick Actions");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));

        // -----------------------
        // Grid
        // -----------------------

        JPanel grid = new JPanel(new GridLayout(2, 3, 15, 15));
        grid.setOpaque(false);
        grid.setBorder(new EmptyBorder(5, 0, 5, 0));

        grid.add(createActionCard("🚕", "Book Ride"));
        grid.add(createActionCard("🕒", "History"));
        grid.add(createActionCard("💳", "Wallet"));
        grid.add(createActionCard("🆘", "SOS"));
        grid.add(createActionCard("💬", "Messages"));
        grid.add(createActionCard("👤", "Profile"));

        root.add(title, BorderLayout.NORTH);
        root.add(grid, BorderLayout.CENTER);

        add(root, BorderLayout.CENTER);
    }

    // ------------------------------------------------

    private JPanel createActionCard(String icon, String text) {

        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(new Color(247, 249, 252));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));

        JLabel textLabel = new JLabel(text);
        textLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        textLabel.setForeground(new Color(60, 60, 60));

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        content.add(Box.createVerticalGlue());
        content.add(iconLabel);
        content.add(Box.createVerticalStrut(8));
        content.add(textLabel);
        content.add(Box.createVerticalGlue());

        card.add(content, BorderLayout.CENTER);

        card.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                card.setBackground(new Color(236, 244, 255));

                card.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(98, 71, 255), 2, true),
                        new EmptyBorder(11, 9, 11, 9)));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                card.setBackground(new Color(247, 249, 252));

                card.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(230, 235, 242), 1, true),
                        new EmptyBorder(12, 10, 12, 10)));
            }
        });

        return card;
    }
}