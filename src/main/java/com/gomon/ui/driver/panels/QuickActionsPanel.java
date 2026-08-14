package com.gomon.ui.driver.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;
import com.gomon.ui.driver.components.QuickActionCard;

public class QuickActionsPanel extends ShadowCard {

        public QuickActionsPanel() {

                setLayout(
                                new BorderLayout());

                setCardColor(
                                Color.WHITE);

                // =========================================
                // PANEL SIZE
                // =========================================

                setPreferredSize(
                                new Dimension(
                                                390,
                                                240));

                setMinimumSize(
                                new Dimension(
                                                390,
                                                240));

                setMaximumSize(
                                new Dimension(
                                                410,
                                                240));

                // =========================================
                // ROOT
                // =========================================

                JPanel root = new JPanel(
                                new BorderLayout());

                root.setOpaque(false);

                root.setBorder(
                                new EmptyBorder(
                                                18,
                                                18,
                                                18,
                                                18));

                // =========================================
                // TITLE
                // =========================================

                JLabel title = new JLabel(
                                "Quick Actions");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                20));

                title.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                root.add(
                                title,
                                BorderLayout.NORTH);

                // =========================================
                // GRID
                // =========================================

                JPanel grid = new JPanel(
                                new GridLayout(
                                                2,
                                                3,
                                                12,
                                                12));

                grid.setOpaque(false);

                grid.setBorder(
                                new EmptyBorder(
                                                10,
                                                0,
                                                0,
                                                0));

                // =========================================
                // ACTIONS
                // =========================================

                grid.add(
                                new QuickActionCard(
                                                "🚨",
                                                "Emergency",
                                                new Color(
                                                                231,
                                                                76,
                                                                60)));

                grid.add(
                                new QuickActionCard(
                                                "📞",
                                                "Call Rider",
                                                new Color(
                                                                39,
                                                                174,
                                                                96)));

                grid.add(
                                new QuickActionCard(
                                                "💬",
                                                "Chat",
                                                new Color(
                                                                155,
                                                                89,
                                                                182)));

                grid.add(
                                new QuickActionCard(
                                                "🧭",
                                                "Navigate",
                                                new Color(
                                                                52,
                                                                152,
                                                                219)));

                grid.add(
                                new QuickActionCard(
                                                "🚗",
                                                "Vehicle",
                                                new Color(
                                                                243,
                                                                156,
                                                                18)));

                grid.add(
                                new QuickActionCard(
                                                "🎧",
                                                "Support",
                                                new Color(
                                                                52,
                                                                73,
                                                                94)));

                root.add(
                                grid,
                                BorderLayout.CENTER);

                add(
                                root,
                                BorderLayout.CENTER);
        }
}