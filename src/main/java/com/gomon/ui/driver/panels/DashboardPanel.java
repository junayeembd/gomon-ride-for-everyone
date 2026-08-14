package com.gomon.ui.driver.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.driver.components.StatisticCard;

public class DashboardPanel extends JPanel {

        public DashboardPanel() {

                setOpaque(false);

                setLayout(
                                new BoxLayout(
                                                this,
                                                BoxLayout.Y_AXIS));

                setBorder(
                                new EmptyBorder(
                                                10,
                                                10,
                                                25,
                                                10));

                // =====================================================
                // STATISTICS
                // =====================================================

                JPanel statistics = createStatisticsSection();

                statistics.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(statistics);

                add(
                                Box.createVerticalStrut(20));

                // =====================================================
                // MIDDLE
                // =====================================================

                JPanel middle = createMiddleSection();

                middle.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(middle);

                add(
                                Box.createVerticalStrut(20));

                // =====================================================
                // SAFETY
                // =====================================================

                JPanel safety = new SafetyPanel();

                safety.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(safety);

                add(
                                Box.createVerticalStrut(20));
        }

        // =========================================================
        // STATISTICS SECTION
        // =========================================================

        private JPanel createStatisticsSection() {

                JPanel panel = new JPanel(
                                new GridLayout(
                                                1,
                                                4,
                                                16,
                                                0));

                panel.setOpaque(false);

                panel.setPreferredSize(
                                new Dimension(
                                                0,
                                                140));

                panel.setMinimumSize(
                                new Dimension(
                                                0,
                                                140));

                panel.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                140));

                // -----------------------------------------------------
                // TODAY'S RIDE
                // -----------------------------------------------------

                panel.add(
                                new StatisticCard(
                                                "🚖",
                                                "Today's Ride",
                                                "08",
                                                "Completed",
                                                new Color(
                                                                98,
                                                                71,
                                                                255)));

                // -----------------------------------------------------
                // EARNINGS
                // -----------------------------------------------------

                panel.add(
                                new StatisticCard(
                                                "💰",
                                                "Today's Earnings",
                                                "৳1950",
                                                "Today",
                                                new Color(
                                                                39,
                                                                174,
                                                                96)));

                // -----------------------------------------------------
                // ONLINE TIME
                // -----------------------------------------------------

                panel.add(
                                new StatisticCard(
                                                "🕒",
                                                "Online Time",
                                                "6h 15m",
                                                "Current Shift",
                                                new Color(
                                                                52,
                                                                152,
                                                                219)));

                // -----------------------------------------------------
                // RATING
                // -----------------------------------------------------

                panel.add(
                                new StatisticCard(
                                                "⭐",
                                                "Rating",
                                                "4.9",
                                                "245 Reviews",
                                                new Color(
                                                                241,
                                                                196,
                                                                15)));

                return panel;
        }

        // =========================================================
        // MIDDLE SECTION
        // =========================================================

        private JPanel createMiddleSection() {

                JPanel panel = new JPanel(
                                new BorderLayout(
                                                18,
                                                0));

                panel.setOpaque(false);
                panel.setPreferredSize(
                                new Dimension(
                                                0,
                                                625));

                panel.setMinimumSize(
                                new Dimension(
                                                0,
                                                625));

                // -----------------------------------------------------
                // MAP
                // -----------------------------------------------------

                RouteMapPanel map = new RouteMapPanel();

                panel.add(
                                map,
                                BorderLayout.CENTER);

                // -----------------------------------------------------
                // RIGHT SIDE
                // -----------------------------------------------------

                JPanel rightPanel = new JPanel();

                rightPanel.setOpaque(false);

                rightPanel.setLayout(
                                new BoxLayout(
                                                rightPanel,
                                                BoxLayout.Y_AXIS));

                rightPanel.setPreferredSize(
                                new Dimension(
                                                410,
                                                0));

                rightPanel.setMinimumSize(
                                new Dimension(
                                                410,
                                                0));

                rightPanel.setMaximumSize(
                                new Dimension(
                                                410,
                                                Integer.MAX_VALUE));

                // =====================================================
                // QUICK ACTIONS
                // =====================================================

                QuickActionsPanel quickActions = new QuickActionsPanel();

                quickActions.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                rightPanel.add(
                                quickActions);

                rightPanel.add(
                                Box.createVerticalStrut(10));

                // =====================================================
                // RIDE REQUEST
                // =====================================================

                RideRequestPanel request = new RideRequestPanel();

                request.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                rightPanel.add(
                                request);

                panel.add(
                                rightPanel,
                                BorderLayout.EAST);

                return panel;
        }
}