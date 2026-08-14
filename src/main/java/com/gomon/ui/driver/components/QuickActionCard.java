package com.gomon.ui.driver.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class QuickActionCard extends ShadowCard {

        private final Color normalColor = Color.WHITE;
        private final Color hoverColor = new Color(245, 247, 255);

        public QuickActionCard(
                        String icon,
                        String title,
                        Color iconColor) {

                setLayout(new BorderLayout());

                setCardColor(normalColor);

                setCursor(
                                Cursor.getPredefinedCursor(
                                                Cursor.HAND_CURSOR));

                // =========================================
                // CARD SIZE
                // =========================================

                setPreferredSize(
                                new Dimension(112, 100));

                setMinimumSize(
                                new Dimension(100, 95));

                setMaximumSize(
                                new Dimension(140, 110));

                // =========================================
                // CONTENT
                // =========================================

                JPanel content = new JPanel(
                                new BorderLayout());

                content.setOpaque(false);

                content.setBorder(
                                new EmptyBorder(
                                                8, 8, 8, 8));

                // =========================================
                // ICON
                // =========================================

                JPanel iconPanel = new JPanel(
                                new GridBagLayout());

                iconPanel.setOpaque(false);

                iconPanel.setPreferredSize(
                                new Dimension(50, 50));

                JLabel iconLabel = new JLabel(icon);

                iconLabel.setHorizontalAlignment(
                                SwingConstants.CENTER);

                iconLabel.setVerticalAlignment(
                                SwingConstants.CENTER);

                iconLabel.setFont(
                                new Font(
                                                "Segoe UI Emoji",
                                                Font.PLAIN,
                                                22));

                iconLabel.setForeground(
                                iconColor);

                iconPanel.add(iconLabel);

                // =========================================
                // TITLE
                // =========================================

                JLabel titleLabel = new JLabel(
                                title,
                                SwingConstants.CENTER);

                titleLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                12));

                titleLabel.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                titleLabel.setBorder(
                                new EmptyBorder(
                                                4, 2, 2, 2));

                // =========================================
                // ADD
                // =========================================

                content.add(
                                iconPanel,
                                BorderLayout.CENTER);

                content.add(
                                titleLabel,
                                BorderLayout.SOUTH);

                add(
                                content,
                                BorderLayout.CENTER);

                // =========================================
                // HOVER
                // =========================================

                MouseAdapter hover = new MouseAdapter() {

                        @Override
                        public void mouseEntered(
                                        MouseEvent e) {

                                setCardColor(
                                                hoverColor);
                        }

                        @Override
                        public void mouseExited(
                                        MouseEvent e) {

                                setCardColor(
                                                normalColor);
                        }
                };

                addMouseListener(hover);
                content.addMouseListener(hover);
                iconPanel.addMouseListener(hover);
                iconLabel.addMouseListener(hover);
                titleLabel.addMouseListener(hover);
        }
}