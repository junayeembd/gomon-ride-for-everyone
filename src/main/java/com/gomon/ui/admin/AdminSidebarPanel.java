package com.gomon.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.gomon.ui.admin.panels.UserManagementPanel;
import com.gomon.ui.admin.panels.DriverManagementPanel;

public class AdminSidebarPanel extends JPanel {

        private static final Color SIDEBAR_COLOR = new Color(20, 18, 70);
        private static final Color ACTIVE_COLOR = new Color(98, 71, 255);
        private static final Color TEXT_COLOR = Color.WHITE;
        private static final Color MUTED_COLOR = new Color(170, 170, 200);

        private final AdminDashboard dashboard;

        public AdminSidebarPanel(AdminDashboard dashboard) {

                this.dashboard = dashboard;

                setPreferredSize(new Dimension(280, 0));
                setBackground(SIDEBAR_COLOR);
                setLayout(new BorderLayout());

                add(createBrandSection(), BorderLayout.NORTH);
                add(createMenuSection(), BorderLayout.CENTER);
                add(createLogoutSection(), BorderLayout.SOUTH);
        }

        // =====================================================
        // BRAND
        // =====================================================

        private JPanel createBrandSection() {

                JPanel panel = new JPanel();

                panel.setBackground(SIDEBAR_COLOR);
                panel.setLayout(new GridLayout(2, 1));
                panel.setBorder(
                                BorderFactory.createEmptyBorder(28, 25, 25, 20));

                JLabel logo = new JLabel("GOMON");
                logo.setForeground(Color.WHITE);
                logo.setFont(new Font("Segoe UI", Font.BOLD, 30));

                JLabel subtitle = new JLabel("Ride for Everyone");
                subtitle.setForeground(new Color(190, 190, 215));
                subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                panel.add(logo);
                panel.add(subtitle);

                return panel;
        }

        // =====================================================
        // MENU
        // =====================================================

        private JPanel createMenuSection() {

                JPanel menu = new JPanel();

                menu.setOpaque(false);
                menu.setLayout(new GridLayout(0, 1, 0, 4));
                menu.setBorder(
                                BorderFactory.createEmptyBorder(10, 15, 10, 15));

                addSectionTitle(menu, "MAIN");

                menu.add(createMenuButton(
                                "Dashboard",
                                true,
                                dashboard::showDashboard));

                addSectionTitle(menu, "MANAGEMENT");

                menu.add(createMenuButton(
                                "Users",
                                false,
                                () -> dashboard.showPanel(
                                                new UserManagementPanel())));

                menu.add(createMenuButton(
                                "Drivers",
                                false,
                                () -> dashboard.showPanel(
                                                new DriverManagementPanel())));

                menu.add(createMenuButton(
                                "Rides",
                                false,
                                () -> openPlaceholder("Ride Management")));

                menu.add(createMenuButton(
                                "Vehicles",
                                false,
                                () -> openPlaceholder("Vehicle Management")));

                addSectionTitle(menu, "OPERATIONS");

                menu.add(createMenuButton(
                                "Bookings",
                                false,
                                () -> openPlaceholder("Bookings")));

                menu.add(createMenuButton(
                                "Ride Monitoring",
                                false,
                                () -> openPlaceholder("Ride Monitoring")));

                addSectionTitle(menu, "FINANCE");

                menu.add(createMenuButton(
                                "Payments",
                                false,
                                () -> openPlaceholder("Payments")));

                menu.add(createMenuButton(
                                "Earnings",
                                false,
                                () -> openPlaceholder("Earnings")));

                menu.add(createMenuButton(
                                "Wallet & Transactions",
                                false,
                                () -> openPlaceholder("Wallet & Transactions")));

                addSectionTitle(menu, "SUPPORT & CONTROL");

                menu.add(createMenuButton(
                                "User Support",
                                false,
                                () -> openPlaceholder("User Support")));

                menu.add(createMenuButton(
                                "Driver Support",
                                false,
                                () -> openPlaceholder("Driver Support")));

                menu.add(createMenuButton(
                                "Complaints",
                                false,
                                () -> openPlaceholder("Complaint Center")));

                menu.add(createMenuButton(
                                "Fraud Center",
                                false,
                                () -> openPlaceholder("Fraud Center")));

                menu.add(createMenuButton(
                                "Security Center",
                                false,
                                () -> openPlaceholder("Security Center")));

                addSectionTitle(menu, "REPORTS");

                menu.add(createMenuButton(
                                "Reports",
                                false,
                                () -> openPlaceholder("Reports")));

                menu.add(createMenuButton(
                                "Analytics",
                                false,
                                () -> openPlaceholder("Analytics")));

                addSectionTitle(menu, "SYSTEM");

                menu.add(createMenuButton(
                                "System Settings",
                                false,
                                () -> openPlaceholder("System Settings")));

                menu.add(createMenuButton(
                                "Maintenance",
                                false,
                                () -> openPlaceholder("Maintenance")));

                return menu;
        }

        // =====================================================
        // SECTION TITLE
        // =====================================================

        private void addSectionTitle(JPanel parent, String title) {

                JLabel label = new JLabel(title);

                label.setForeground(MUTED_COLOR);
                label.setFont(
                                new Font("Segoe UI", Font.BOLD, 11));

                label.setBorder(
                                BorderFactory.createEmptyBorder(
                                                14, 12, 4, 0));

                parent.add(label);
        }

        // =====================================================
        // MENU BUTTON
        // =====================================================

        private JButton createMenuButton(
                        String text,
                        boolean active,
                        Runnable action) {

                JButton button = new JButton(text);

                button.setHorizontalAlignment(JButton.LEFT);
                button.setFont(
                                new Font("Segoe UI", Font.PLAIN, 14));

                button.setForeground(TEXT_COLOR);

                button.setBackground(
                                active ? ACTIVE_COLOR : SIDEBAR_COLOR);

                button.setBorder(
                                BorderFactory.createEmptyBorder(
                                                12, 15, 12, 10));

                button.setFocusPainted(false);
                button.setContentAreaFilled(true);
                button.setOpaque(true);

                button.setCursor(
                                new Cursor(Cursor.HAND_CURSOR));

                button.addActionListener(e -> action.run());

                return button;
        }

        // =====================================================
        // LOGOUT
        // =====================================================

        private JPanel createLogoutSection() {

                JPanel panel = new JPanel(new BorderLayout());

                panel.setBackground(SIDEBAR_COLOR);
                panel.setBorder(
                                BorderFactory.createEmptyBorder(
                                                10, 15, 20, 15));

                JButton logout = new JButton("Logout");

                logout.setHorizontalAlignment(JButton.LEFT);
                logout.setForeground(new Color(255, 70, 70));
                logout.setBackground(SIDEBAR_COLOR);
                logout.setFont(
                                new Font("Segoe UI", Font.BOLD, 14));

                logout.setBorder(
                                BorderFactory.createEmptyBorder(
                                                12, 15, 12, 10));

                logout.setFocusPainted(false);
                logout.setCursor(
                                new Cursor(Cursor.HAND_CURSOR));

                panel.add(logout);

                return panel;
        }

        // =====================================================
        // TEMPORARY
        // =====================================================

        private void openPlaceholder(String title) {

                JPanel panel = new JPanel(new BorderLayout());

                panel.setBackground(
                                new Color(245, 247, 251));

                JLabel label = new JLabel(
                                title,
                                JLabel.CENTER);

                label.setFont(
                                new Font("Segoe UI", Font.BOLD, 28));

                label.setForeground(
                                new Color(35, 35, 50));

                panel.add(label, BorderLayout.CENTER);

                dashboard.showPanel(panel);
        }
}