package com.gomon.ui.superadmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class SuperAdminSidebarPanel extends JPanel {

        private static final Color SIDEBAR = new Color(18, 16, 70);

        private static final Color SELECTED = new Color(98, 71, 255);

        private static final Color HOVER = new Color(43, 39, 105);

        public SuperAdminSidebarPanel() {

                setPreferredSize(
                                new Dimension(268, 0));

                setMinimumSize(
                                new Dimension(268, 0));

                setMaximumSize(
                                new Dimension(268, Integer.MAX_VALUE));

                setBackground(SIDEBAR);

                setLayout(
                                new BorderLayout());

                // =====================================================
                // LOGO
                // =====================================================

                add(
                                createLogoPanel(),
                                BorderLayout.NORTH);

                // =====================================================
                // SCROLLABLE MENU
                // =====================================================

                JScrollPane menuScroll = createMenuScrollPane();

                add(
                                menuScroll,
                                BorderLayout.CENTER);

                // =====================================================
                // BOTTOM
                // =====================================================

                add(
                                createBottomPanel(),
                                BorderLayout.SOUTH);
        }

        // =========================================================
        // LOGO
        // =========================================================

        private JPanel createLogoPanel() {

                JPanel panel = new JPanel();

                panel.setOpaque(false);

                panel.setLayout(
                                new BoxLayout(
                                                panel,
                                                BoxLayout.Y_AXIS));

                panel.setBorder(
                                new EmptyBorder(
                                                22,
                                                20,
                                                18,
                                                20));

                JLabel title = new JLabel("GOMON");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                29));

                title.setForeground(Color.WHITE);

                title.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                JLabel subtitle = new JLabel("Ride For Everyone");

                subtitle.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                14));

                subtitle.setForeground(
                                new Color(
                                                205,
                                                205,
                                                220));

                subtitle.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                panel.add(title);

                panel.add(
                                Box.createVerticalStrut(5));

                panel.add(subtitle);

                return panel;
        }

        // =========================================================
        // SCROLL PANE
        // =========================================================

        private JScrollPane createMenuScrollPane() {

                JPanel menuContent = createMenuContent();

                JScrollPane scrollPane = new JScrollPane(
                                menuContent);

                scrollPane.setBorder(null);

                scrollPane.setBackground(
                                SIDEBAR);

                scrollPane.getViewport()
                                .setBackground(SIDEBAR);

                scrollPane.setHorizontalScrollBarPolicy(
                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                scrollPane.setVerticalScrollBarPolicy(
                                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

                scrollPane.getVerticalScrollBar()
                                .setUnitIncrement(14);

                scrollPane.getVerticalScrollBar()
                                .setPreferredSize(
                                                new Dimension(6, 0));

                return scrollPane;
        }

        // =========================================================
        // MENU CONTENT
        // =========================================================

        private JPanel createMenuContent() {

                JPanel menu = new JPanel();

                menu.setOpaque(false);

                menu.setLayout(
                                new BoxLayout(
                                                menu,
                                                BoxLayout.Y_AXIS));

                menu.setBorder(
                                new EmptyBorder(
                                                6,
                                                14,
                                                10,
                                                14));

                // =====================================================
                // MAIN
                // =====================================================

                addSection(
                                menu,
                                "MAIN");

                addMenu(
                                menu,
                                "▦",
                                "Dashboard",
                                true);

                // =====================================================
                // MANAGEMENT
                // =====================================================

                addSection(
                                menu,
                                "MANAGEMENT");

                addMenu(
                                menu,
                                "♛",
                                "Admins",
                                false);

                addMenu(
                                menu,
                                "●",
                                "Users",
                                false);

                addMenu(
                                menu,
                                "◉",
                                "Drivers",
                                false);

                addMenu(
                                menu,
                                "▣",
                                "Rides",
                                false);

                addMenu(
                                menu,
                                "▤",
                                "Vehicles",
                                false);

                // =====================================================
                // OPERATIONS
                // =====================================================

                addSection(
                                menu,
                                "OPERATIONS");

                addMenu(
                                menu,
                                "□",
                                "Bookings",
                                false);

                addMenu(
                                menu,
                                "▤",
                                "Payments",
                                false);

                addMenu(
                                menu,
                                "◉",
                                "Earnings",
                                false);

                addMenu(
                                menu,
                                "▣",
                                "Wallet & Transactions",
                                false);

                // =====================================================
                // SUPPORT & CONTROL
                // =====================================================

                addSection(
                                menu,
                                "SUPPORT & CONTROL");

                addMenu(
                                menu,
                                "□",
                                "Complaints",
                                false);

                addMenu(
                                menu,
                                "▥",
                                "Reports & Analytics",
                                false);

                addMenu(
                                menu,
                                "▤",
                                "System Logs",
                                false);

                addMenu(
                                menu,
                                "♙",
                                "Permissions",
                                false);

                addMenu(
                                menu,
                                "⚙",
                                "Settings",
                                false);

                return menu;
        }

        // =========================================================
        // ADD SECTION
        // =========================================================

        private void addSection(
                        JPanel parent,
                        String title) {

                JLabel label = new JLabel(title);

                label.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                10));

                label.setForeground(
                                new Color(
                                                150,
                                                150,
                                                180));

                label.setBorder(
                                new EmptyBorder(
                                                12,
                                                12,
                                                7,
                                                0));

                label.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                parent.add(label);
        }

        // =========================================================
        // ADD MENU BUTTON
        // =========================================================

        private void addMenu(
                        JPanel parent,
                        String icon,
                        String title,
                        boolean selected) {

                JButton button = createMenuButton(
                                icon,
                                title,
                                selected);

                parent.add(button);

                parent.add(
                                Box.createVerticalStrut(4));
        }

        // =========================================================
        // MENU BUTTON
        // =========================================================

        private JButton createMenuButton(
                        String icon,
                        String title,
                        boolean selected) {

                JButton button = new JButton();

                button.setLayout(
                                new BorderLayout());

                button.setPreferredSize(
                                new Dimension(
                                                238,
                                                42));

                button.setMinimumSize(
                                new Dimension(
                                                238,
                                                42));

                button.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                42));

                button.setFocusPainted(false);

                button.setBorderPainted(false);

                button.setOpaque(true);

                button.setCursor(
                                Cursor.getPredefinedCursor(
                                                Cursor.HAND_CURSOR));

                button.setBorder(
                                new EmptyBorder(
                                                0,
                                                12,
                                                0,
                                                10));

                button.setBackground(
                                selected
                                                ? SELECTED
                                                : SIDEBAR);

                JLabel iconLabel = new JLabel(icon);

                iconLabel.setPreferredSize(
                                new Dimension(
                                                28,
                                                42));

                iconLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                17));

                iconLabel.setForeground(
                                Color.WHITE);

                JLabel textLabel = new JLabel(title);

                textLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                selected
                                                                ? Font.BOLD
                                                                : Font.PLAIN,
                                                13));

                textLabel.setForeground(
                                Color.WHITE);

                button.add(
                                iconLabel,
                                BorderLayout.WEST);

                button.add(
                                textLabel,
                                BorderLayout.CENTER);

                button.addMouseListener(
                                new MouseAdapter() {

                                        @Override
                                        public void mouseEntered(
                                                        MouseEvent e) {

                                                if (!selected) {

                                                        button.setBackground(
                                                                        HOVER);
                                                }
                                        }

                                        @Override
                                        public void mouseExited(
                                                        MouseEvent e) {

                                                if (!selected) {

                                                        button.setBackground(
                                                                        SIDEBAR);
                                                }
                                        }
                                });

                return button;
        }

        // =========================================================
        // BOTTOM PANEL
        // =========================================================

        private JPanel createBottomPanel() {

                JPanel bottom = new JPanel();

                bottom.setOpaque(false);

                bottom.setLayout(
                                new BoxLayout(
                                                bottom,
                                                BoxLayout.Y_AXIS));

                bottom.setBorder(
                                new EmptyBorder(
                                                8,
                                                14,
                                                15,
                                                14));

                JButton systemSettings = createBottomButton(
                                "⚙",
                                "System Settings");

                bottom.add(
                                systemSettings);

                bottom.add(
                                Box.createVerticalStrut(5));

                JButton logout = createBottomButton(
                                "↪",
                                "Logout");

                logout.setForeground(
                                new Color(
                                                255,
                                                90,
                                                90));

                bottom.add(logout);

                return bottom;
        }

        // =========================================================
        // BOTTOM BUTTON
        // =========================================================

        private JButton createBottomButton(
                        String icon,
                        String title) {

                JButton button = new JButton(
                                icon + "   " + title);

                button.setPreferredSize(
                                new Dimension(
                                                238,
                                                40));

                button.setMinimumSize(
                                new Dimension(
                                                238,
                                                40));

                button.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                40));

                button.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                button.setHorizontalAlignment(
                                JButton.LEFT);

                button.setBorderPainted(false);

                button.setFocusPainted(false);

                button.setOpaque(true);

                button.setBackground(
                                SIDEBAR);

                button.setForeground(
                                Color.WHITE);

                button.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                button.addMouseListener(
                                new MouseAdapter() {

                                        @Override
                                        public void mouseEntered(
                                                        MouseEvent e) {

                                                button.setBackground(
                                                                HOVER);
                                        }

                                        @Override
                                        public void mouseExited(
                                                        MouseEvent e) {

                                                button.setBackground(
                                                                SIDEBAR);
                                        }
                                });

                return button;
        }
}