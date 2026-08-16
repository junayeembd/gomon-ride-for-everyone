package com.gomon.ui.superadmin.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Cursor;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;
import com.gomon.ui.superadmin.SuperAdminHeaderPanel;
import com.gomon.ui.superadmin.charts.RevenueChart;
import com.gomon.ui.superadmin.charts.RidesOverviewChart;
import com.gomon.ui.superadmin.charts.UserRoleChart;

public class SuperAdminOverviewPanel extends JPanel {

        public SuperAdminOverviewPanel() {

                setOpaque(false);

                setLayout(
                                new BoxLayout(
                                                this,
                                                BoxLayout.Y_AXIS));

                // =====================================================
                // HEADER
                // =====================================================

                SuperAdminHeaderPanel header = new SuperAdminHeaderPanel();

                header.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(header);

                add(
                                Box.createVerticalStrut(18));

                // =====================================================
                // STATISTICS
                // =====================================================

                JPanel statistics = createStatistics();

                statistics.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(statistics);

                add(
                                Box.createVerticalStrut(18));

                // =====================================================
                // CHARTS
                // =====================================================

                JPanel charts = createChartsSection();

                charts.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(charts);

                add(
                                Box.createVerticalStrut(18));

                // =====================================================
                // LOWER SECTION
                // =====================================================

                JPanel lower = createLowerSection();

                lower.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(lower);

                add(
                                Box.createVerticalStrut(18));

                // =====================================================
                // QUICK ACTIONS
                // =====================================================

                JPanel quickActions = createQuickActions();

                quickActions.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                add(quickActions);
        }

        // =========================================================
        // STATISTICS
        // =========================================================

        private JPanel createStatistics() {

                JPanel panel = new JPanel(
                                new GridLayout(
                                                1,
                                                5,
                                                12,
                                                0));

                panel.setOpaque(false);

                panel.setPreferredSize(
                                new Dimension(
                                                0,
                                                120));

                panel.setMinimumSize(
                                new Dimension(
                                                0,
                                                120));

                panel.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                120));

                // -----------------------------------------------------
                // TOTAL USERS
                // -----------------------------------------------------

                panel.add(
                                createStatCard(
                                                "👥",
                                                "Total Users",
                                                "12,458",
                                                "↑ 325 this week",
                                                new Color(
                                                                98,
                                                                71,
                                                                255)));

                // -----------------------------------------------------
                // TOTAL DRIVERS
                // -----------------------------------------------------

                panel.add(
                                createStatCard(
                                                "●",
                                                "Total Drivers",
                                                "3,245",
                                                "↑ 120 this week",
                                                new Color(
                                                                52,
                                                                115,
                                                                225)));

                // -----------------------------------------------------
                // TOTAL RIDES
                // -----------------------------------------------------

                panel.add(
                                createStatCard(
                                                "🚗",
                                                "Total Rides",
                                                "24,568",
                                                "↑ 620 this week",
                                                new Color(
                                                                39,
                                                                174,
                                                                96)));

                // -----------------------------------------------------
                // TOTAL EARNINGS
                // -----------------------------------------------------

                panel.add(
                                createStatCard(
                                                "৳",
                                                "Total Earnings",
                                                "৳ 8,562,450",
                                                "↑ 12.6% this week",
                                                new Color(
                                                                241,
                                                                175,
                                                                35)));

                // -----------------------------------------------------
                // TOTAL COMPLAINTS
                // -----------------------------------------------------

                panel.add(
                                createStatCard(
                                                "!",
                                                "Total Complaints",
                                                "156",
                                                "↓ 18 this week",
                                                new Color(
                                                                231,
                                                                76,
                                                                60)));

                return panel;
        }

        // =========================================================
        // STAT CARD
        // =========================================================

        private JPanel createStatCard(
                        String icon,
                        String title,
                        String value,
                        String trend,
                        Color iconColor) {

                ShadowCard card = new ShadowCard();

                card.setCardColor(
                                Color.WHITE);

                card.setLayout(
                                new BorderLayout());

                JPanel root = new JPanel();

                root.setOpaque(false);

                root.setLayout(
                                new BoxLayout(
                                                root,
                                                BoxLayout.X_AXIS));

                root.setBorder(
                                new EmptyBorder(
                                                14,
                                                14,
                                                14,
                                                14));

                // -----------------------------------------------------
                // ICON
                // -----------------------------------------------------

                JPanel iconPanel = new JPanel(
                                new java.awt.GridBagLayout());

                iconPanel.setBackground(
                                iconColor);

                iconPanel.setPreferredSize(
                                new Dimension(
                                                54,
                                                54));

                iconPanel.setMinimumSize(
                                new Dimension(
                                                54,
                                                54));

                iconPanel.setMaximumSize(
                                new Dimension(
                                                54,
                                                54));

                JLabel iconLabel = new JLabel(
                                icon);

                iconLabel.setFont(
                                new Font(
                                                "Segoe UI Emoji",
                                                Font.BOLD,
                                                21));

                iconLabel.setForeground(
                                Color.WHITE);

                iconPanel.add(
                                iconLabel);

                // -----------------------------------------------------
                // INFO
                // -----------------------------------------------------

                JPanel info = new JPanel();

                info.setOpaque(false);

                info.setLayout(
                                new BoxLayout(
                                                info,
                                                BoxLayout.Y_AXIS));

                info.setBorder(
                                new EmptyBorder(
                                                0,
                                                12,
                                                0,
                                                0));

                JLabel titleLabel = new JLabel(
                                title);

                titleLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                12));

                titleLabel.setForeground(
                                new Color(
                                                120,
                                                120,
                                                130));

                JLabel valueLabel = new JLabel(
                                value);

                valueLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                20));

                valueLabel.setForeground(
                                new Color(
                                                30,
                                                30,
                                                40));

                JLabel trendLabel = new JLabel(
                                trend);

                trendLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                10));

                trendLabel.setForeground(
                                trend.contains("↓")
                                                ? new Color(
                                                                231,
                                                                76,
                                                                60)
                                                : new Color(
                                                                34,
                                                                197,
                                                                94));

                info.add(
                                titleLabel);

                info.add(
                                Box.createVerticalStrut(3));

                info.add(
                                valueLabel);

                info.add(
                                Box.createVerticalStrut(3));

                info.add(
                                trendLabel);

                root.add(
                                iconPanel);

                root.add(
                                info);

                card.add(
                                root,
                                BorderLayout.CENTER);

                return card;
        }

        // =========================================================
        // CHART SECTION
        // =========================================================

        private JPanel createChartsSection() {

                JPanel section = new JPanel(
                                new GridLayout(
                                                1,
                                                2,
                                                18,
                                                0));

                section.setOpaque(false);

                section.setPreferredSize(
                                new Dimension(
                                                0,
                                                330));

                section.setMinimumSize(
                                new Dimension(
                                                0,
                                                330));

                section.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                330));

                section.add(
                                createRidesOverviewCard());

                section.add(
                                createUserRoleCard());

                return section;
        }

        // =========================================================
        // RIDES OVERVIEW
        // =========================================================

        private JPanel createRidesOverviewCard() {

                ShadowCard card = new ShadowCard();

                card.setCardColor(
                                Color.WHITE);

                card.setLayout(
                                new BorderLayout());

                JPanel root = new JPanel(
                                new BorderLayout());

                root.setOpaque(false);

                root.setBorder(
                                new EmptyBorder(
                                                16,
                                                16,
                                                12,
                                                16));

                JLabel title = new JLabel(
                                "Rides Overview");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                title.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                root.add(
                                title,
                                BorderLayout.NORTH);

                RidesOverviewChart chart = new RidesOverviewChart();

                chart.setOpaque(false);

                root.add(
                                chart,
                                BorderLayout.CENTER);

                card.add(
                                root,
                                BorderLayout.CENTER);

                return card;
        }

        // =========================================================
        // USER ROLE
        // =========================================================

        private JPanel createUserRoleCard() {

                ShadowCard card = new ShadowCard();

                card.setCardColor(
                                Color.WHITE);

                card.setLayout(
                                new BorderLayout());

                JPanel root = new JPanel(
                                new BorderLayout());

                root.setOpaque(false);

                root.setBorder(
                                new EmptyBorder(
                                                16,
                                                16,
                                                12,
                                                16));

                JLabel title = new JLabel(
                                "User Role Distribution");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                title.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                root.add(
                                title,
                                BorderLayout.NORTH);

                UserRoleChart chart = new UserRoleChart();

                chart.setOpaque(false);

                root.add(
                                chart,
                                BorderLayout.CENTER);

                card.add(
                                root,
                                BorderLayout.CENTER);

                return card;
        }

        // =========================================================
        // LOWER SECTION
        // =========================================================

        private JPanel createLowerSection() {

                JPanel section = new JPanel(
                                new GridLayout(
                                                1,
                                                2,
                                                18,
                                                0));

                section.setOpaque(false);

                section.setPreferredSize(
                                new Dimension(
                                                0,
                                                285));

                section.setMinimumSize(
                                new Dimension(
                                                0,
                                                285));

                section.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                285));

                section.add(
                                createPendingActions());

                section.add(
                                createRevenueOverview());

                return section;
        }

        // =========================================================
        // PENDING ACTIONS
        // =========================================================

        private JPanel createPendingActions() {

                ShadowCard card = new ShadowCard();

                card.setCardColor(
                                Color.WHITE);

                card.setLayout(
                                new BorderLayout());

                JPanel root = new JPanel(
                                new BorderLayout());

                root.setOpaque(false);

                root.setBorder(
                                new EmptyBorder(
                                                16,
                                                16,
                                                16,
                                                16));

                JLabel title = new JLabel(
                                "Pending Actions");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                root.add(
                                title,
                                BorderLayout.NORTH);

                JPanel grid = new JPanel(
                                new GridLayout(
                                                2,
                                                2,
                                                12,
                                                12));

                grid.setOpaque(false);

                grid.add(
                                createPendingCard(
                                                "Driver Verification",
                                                "12",
                                                "Pending",
                                                new Color(
                                                                241,
                                                                196,
                                                                15)));

                grid.add(
                                createPendingCard(
                                                "Admin Requests",
                                                "3",
                                                "Pending",
                                                new Color(
                                                                52,
                                                                152,
                                                                219)));

                grid.add(
                                createPendingCard(
                                                "Complaints",
                                                "8",
                                                "Unresolved",
                                                new Color(
                                                                231,
                                                                76,
                                                                60)));

                grid.add(
                                createPendingCard(
                                                "Refund Requests",
                                                "5",
                                                "Pending",
                                                new Color(
                                                                39,
                                                                174,
                                                                96)));

                root.add(
                                grid,
                                BorderLayout.CENTER);

                card.add(
                                root,
                                BorderLayout.CENTER);

                return card;
        }

        // =========================================================
        // PENDING CARD
        // =========================================================

        private JPanel createPendingCard(
                        String title,
                        String value,
                        String status,
                        Color color) {

                JPanel card = new JPanel();

                card.setBackground(
                                new Color(
                                                248,
                                                249,
                                                252));

                card.setBorder(
                                new EmptyBorder(
                                                10,
                                                12,
                                                10,
                                                12));

                card.setLayout(
                                new BoxLayout(
                                                card,
                                                BoxLayout.Y_AXIS));

                JLabel titleLabel = new JLabel(
                                title);

                titleLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                12));

                titleLabel.setForeground(
                                new Color(
                                                100,
                                                100,
                                                110));

                JLabel valueLabel = new JLabel(
                                value);

                valueLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                21));

                valueLabel.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                JLabel statusLabel = new JLabel(
                                status);

                statusLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                10));

                statusLabel.setForeground(
                                color);

                card.add(
                                titleLabel);

                card.add(
                                Box.createVerticalStrut(3));

                card.add(
                                valueLabel);

                card.add(
                                Box.createVerticalStrut(3));

                card.add(
                                statusLabel);

                return card;
        }

        // =========================================================
        // REVENUE
        // =========================================================

        private JPanel createRevenueOverview() {

                ShadowCard card = new ShadowCard();

                card.setCardColor(
                                Color.WHITE);

                card.setLayout(
                                new BorderLayout());

                JPanel root = new JPanel(
                                new BorderLayout());

                root.setOpaque(false);

                root.setBorder(
                                new EmptyBorder(
                                                16,
                                                16,
                                                12,
                                                16));

                JLabel title = new JLabel(
                                "Revenue Overview");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                title.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                root.add(
                                title,
                                BorderLayout.NORTH);

                RevenueChart chart = new RevenueChart();

                chart.setOpaque(false);

                root.add(
                                chart,
                                BorderLayout.CENTER);

                card.add(
                                root,
                                BorderLayout.CENTER);

                return card;
        }

        // =========================================================
        // QUICK ACTIONS
        // =========================================================

        private JPanel createQuickActions() {

                JPanel panel = new JPanel(
                                new GridLayout(
                                                1,
                                                6,
                                                14,
                                                0));

                panel.setOpaque(false);

                panel.setPreferredSize(
                                new Dimension(
                                                0,
                                                105));

                panel.setMinimumSize(
                                new Dimension(
                                                0,
                                                105));

                panel.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                105));

                panel.add(
                                createAction(
                                                "♛",
                                                "Create Admin",
                                                "Add new admin",
                                                new Color(98, 71, 255)));

                panel.add(
                                createAction(
                                                "♙",
                                                "Manage Permissions",
                                                "Role & permission",
                                                new Color(52, 115, 225)));

                panel.add(
                                createAction(
                                                "▤",
                                                "System Logs",
                                                "View system logs",
                                                new Color(39, 174, 96)));

                panel.add(
                                createAction(
                                                "▥",
                                                "Generate Reports",
                                                "Analytics & reports",
                                                new Color(241, 175, 35)));

                panel.add(
                                createAction(
                                                "☁",
                                                "Backup Database",
                                                "Backup & restore",
                                                new Color(231, 76, 60)));

                panel.add(
                                createAction(
                                                "◉",
                                                "Support Center",
                                                "Go to support",
                                                new Color(120, 70, 210)));

                return panel;
        }

        // =========================================================
        // QUICK ACTION CARD
        // =========================================================

        private JPanel createAction(
                        String icon,
                        String title,
                        String subtitle,
                        Color accentColor) {

                ShadowCard card = new ShadowCard();

                card.setCardColor(Color.WHITE);

                card.setLayout(
                                new BorderLayout(8, 0));

                card.setBorder(
                                new EmptyBorder(
                                                10,
                                                10,
                                                10,
                                                8));

                JPanel iconPanel = new JPanel(
                                new java.awt.GridBagLayout());

                iconPanel.setBackground(
                                accentColor);

                iconPanel.setPreferredSize(
                                new Dimension(50, 54));

                iconPanel.setMinimumSize(
                                new Dimension(50, 54));

                iconPanel.setMaximumSize(
                                new Dimension(50, 54));

                JLabel iconLabel = new JLabel(
                                icon,
                                JLabel.CENTER);

                iconLabel.setForeground(
                                Color.WHITE);

                iconLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                iconPanel.add(iconLabel);

                JPanel text = new JPanel();

                text.setOpaque(false);

                text.setLayout(
                                new BoxLayout(
                                                text,
                                                BoxLayout.Y_AXIS));

                JLabel titleLabel = new JLabel(title);

                titleLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                12));

                titleLabel.setForeground(
                                new Color(
                                                30,
                                                30,
                                                40));

                JLabel subtitleLabel = new JLabel(subtitle);

                subtitleLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                9));

                subtitleLabel.setForeground(
                                new Color(
                                                125,
                                                125,
                                                135));

                text.add(titleLabel);

                text.add(
                                Box.createVerticalStrut(3));

                text.add(subtitleLabel);

                JLabel arrow = new JLabel(
                                "›");

                arrow.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                arrow.setForeground(
                                new Color(
                                                185,
                                                185,
                                                195));

                card.add(
                                iconPanel,
                                BorderLayout.WEST);

                card.add(
                                text,
                                BorderLayout.CENTER);

                card.add(
                                arrow,
                                BorderLayout.EAST);

                card.setCursor(
                                Cursor.getPredefinedCursor(
                                                Cursor.HAND_CURSOR));

                return card;
        }
}