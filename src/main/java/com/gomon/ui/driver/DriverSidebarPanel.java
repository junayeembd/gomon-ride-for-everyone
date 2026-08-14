package com.gomon.ui.driver;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.MenuButton;

public class DriverSidebarPanel extends JPanel {

        // =========================================================
        // COLORS
        // =========================================================

        private static final Color SIDEBAR_COLOR = new Color(18, 16, 70);

        private static final Color REFER_COLOR = new Color(48, 38, 135);

        private static final Color ONLINE_BORDER = new Color(55, 75, 130);

        // =========================================================
        // CONSTRUCTOR
        // =========================================================

        public DriverSidebarPanel() {

                setPreferredSize(
                                new Dimension(268, 0));

                setMinimumSize(
                                new Dimension(268, 0));

                setBackground(
                                SIDEBAR_COLOR);

                setLayout(
                                new BorderLayout());

                // -----------------------------------------------------
                // TOP
                // -----------------------------------------------------

                add(
                                createLogoPanel(),
                                BorderLayout.NORTH);

                // -----------------------------------------------------
                // CENTER MENU
                // -----------------------------------------------------

                add(
                                createMenuPanel(),
                                BorderLayout.CENTER);

                // -----------------------------------------------------
                // BOTTOM
                // -----------------------------------------------------

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
                                                25,
                                                20,
                                                15,
                                                20));

                // -----------------------------------------------------
                // GOMON
                // -----------------------------------------------------

                JLabel title = new JLabel("GOMON");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                30));

                title.setForeground(
                                Color.WHITE);

                title.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                // -----------------------------------------------------
                // SUBTITLE
                // -----------------------------------------------------

                JLabel subtitle = new JLabel(
                                "Ride For Everyone");

                subtitle.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                15));

                subtitle.setForeground(
                                new Color(
                                                210,
                                                210,
                                                210));

                subtitle.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                panel.add(title);

                panel.add(
                                Box.createVerticalStrut(4));

                panel.add(subtitle);

                return panel;
        }

        // =========================================================
        // MENU
        // =========================================================

        private JPanel createMenuPanel() {

                JPanel menu = new JPanel();

                menu.setOpaque(false);

                menu.setLayout(
                                new BoxLayout(
                                                menu,
                                                BoxLayout.Y_AXIS));

                menu.setBorder(
                                new EmptyBorder(
                                                10,
                                                15,
                                                5,
                                                15));

                // =====================================================
                // MENU BUTTONS
                // =====================================================

                MenuButton dashboard = new MenuButton(
                                "Dashboard",
                                null);

                MenuButton rideRequests = new MenuButton(
                                "Ride Requests",
                                null);

                MenuButton activeRide = new MenuButton(
                                "Active Ride",
                                null);

                MenuButton rideHistory = new MenuButton(
                                "Ride History",
                                null);

                MenuButton earnings = new MenuButton(
                                "Earnings",
                                null);

                MenuButton ratings = new MenuButton(
                                "Ratings & Reviews",
                                null);

                MenuButton helpSupport = new MenuButton(
                                "Help & Support",
                                null);

                MenuButton settings = new MenuButton(
                                "Settings",
                                null);

                MenuButton logout = new MenuButton(
                                "Logout",
                                null);

                // =====================================================
                // DEFAULT SELECTED
                // =====================================================

                dashboard.setSelectedMenu(true);

                // =====================================================
                // ADD ITEMS
                // =====================================================

                addMenuItem(
                                menu,
                                dashboard);

                addMenuItem(
                                menu,
                                rideRequests);

                addMenuItem(
                                menu,
                                activeRide);

                addMenuItem(
                                menu,
                                rideHistory);

                addMenuItem(
                                menu,
                                earnings);

                addMenuItem(
                                menu,
                                ratings);

                addMenuItem(
                                menu,
                                helpSupport);

                addMenuItem(
                                menu,
                                settings);

                // -----------------------------------------------------
                // LOGOUT
                // -----------------------------------------------------

                menu.add(
                                Box.createVerticalStrut(4));

                logout.setForeground(
                                new Color(
                                                240,
                                                90,
                                                90));

                logout.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                menu.add(logout);

                return menu;
        }

        // =========================================================
        // ADD MENU ITEM
        // =========================================================

        private void addMenuItem(
                        JPanel menu,
                        MenuButton button) {

                button.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                menu.add(button);

                menu.add(
                                Box.createVerticalStrut(2));
        }

        // =========================================================
        // BOTTOM SECTION
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
                                                6,
                                                15,
                                                18,
                                                15));

                // =====================================================
                // GO ONLINE
                // =====================================================

                JPanel online = createOnlinePanel();

                online.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                bottom.add(
                                online);

                bottom.add(
                                Box.createVerticalStrut(8));

                // =====================================================
                // REFER & EARN
                // =====================================================

                JPanel refer = createReferCard();

                refer.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                bottom.add(
                                refer);

                return bottom;
        }

        // =========================================================
        // GO ONLINE PANEL
        // =========================================================

        private JPanel createOnlinePanel() {

                JPanel panel = new JPanel(
                                new BorderLayout());

                panel.setOpaque(false);

                panel.setPreferredSize(
                                new Dimension(
                                                238,
                                                56));

                panel.setMinimumSize(
                                new Dimension(
                                                238,
                                                56));

                panel.setMaximumSize(
                                new Dimension(
                                                238,
                                                56));

                panel.setBorder(
                                BorderFactory.createCompoundBorder(
                                                BorderFactory.createLineBorder(
                                                                ONLINE_BORDER,
                                                                1),
                                                new EmptyBorder(
                                                                0,
                                                                18,
                                                                0,
                                                                18)));

                // -----------------------------------------------------
                // ICON
                // -----------------------------------------------------

                JLabel icon = new JLabel("⏻");

                icon.setFont(
                                new Font(
                                                "Segoe UI Symbol",
                                                Font.BOLD,
                                                22));

                icon.setForeground(
                                new Color(
                                                0,
                                                235,
                                                150));

                // -----------------------------------------------------
                // TEXT
                // -----------------------------------------------------

                JLabel text = new JLabel(
                                "Go Online");

                text.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                15));

                text.setForeground(
                                Color.WHITE);

                panel.add(
                                icon,
                                BorderLayout.WEST);

                panel.add(
                                text,
                                BorderLayout.CENTER);

                // =====================================================
                // HOVER
                // =====================================================

                panel.addMouseListener(
                                new MouseAdapter() {

                                        @Override
                                        public void mouseEntered(
                                                        MouseEvent e) {

                                                panel.setBackground(
                                                                new Color(
                                                                                28,
                                                                                27,
                                                                                95));

                                                panel.setOpaque(true);
                                        }

                                        @Override
                                        public void mouseExited(
                                                        MouseEvent e) {

                                                panel.setOpaque(false);
                                                panel.repaint();
                                        }

                                        @Override
                                        public void mouseClicked(
                                                        MouseEvent e) {

                                                JOptionPane.showMessageDialog(
                                                                panel,
                                                                "Driver status changed to Online.",
                                                                "Driver Status",
                                                                JOptionPane.INFORMATION_MESSAGE);
                                        }
                                });

                return panel;
        }

        // =========================================================
        // REFER & EARN
        // =========================================================

        private JPanel createReferCard() {

                JPanel card = new JPanel();

                card.setBackground(
                                REFER_COLOR);

                card.setPreferredSize(
                                new Dimension(
                                                238,
                                                128));

                card.setMinimumSize(
                                new Dimension(
                                                238,
                                                128));

                card.setMaximumSize(
                                new Dimension(
                                                238,
                                                128));

                card.setBorder(
                                new EmptyBorder(
                                                12,
                                                13,
                                                10,
                                                13));

                card.setLayout(
                                new BoxLayout(
                                                card,
                                                BoxLayout.Y_AXIS));

                // -----------------------------------------------------
                // TITLE
                // -----------------------------------------------------

                JLabel title = new JLabel(
                                "Refer & Earn");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                17));

                title.setForeground(
                                Color.WHITE);

                title.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                // -----------------------------------------------------
                // DESCRIPTION
                // -----------------------------------------------------

                JLabel line1 = new JLabel(
                                "Refer a driver and earn");

                line1.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                11));

                line1.setForeground(
                                Color.WHITE);

                line1.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                JLabel line2 = new JLabel(
                                "৳300 for each signup!");

                line2.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                12));

                line2.setForeground(
                                Color.WHITE);

                line2.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                // -----------------------------------------------------
                // BUTTON
                // -----------------------------------------------------

                JButton referButton = new JButton(
                                "Refer Now");

                referButton.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                11));

                referButton.setForeground(
                                new Color(
                                                80,
                                                60,
                                                220));

                referButton.setBackground(
                                Color.WHITE);

                referButton.setFocusPainted(
                                false);

                referButton.setBorderPainted(
                                false);

                referButton.setCursor(
                                new Cursor(
                                                Cursor.HAND_CURSOR));

                referButton.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                referButton.setPreferredSize(
                                new Dimension(
                                                105,
                                                28));

                referButton.setMaximumSize(
                                new Dimension(
                                                105,
                                                28));

                // =====================================================
                // ADD
                // =====================================================

                card.add(title);

                card.add(
                                Box.createVerticalStrut(5));

                card.add(line1);

                card.add(line2);

                card.add(
                                Box.createVerticalGlue());

                card.add(
                                referButton);

                // =====================================================
                // HOVER
                // =====================================================

                referButton.addMouseListener(
                                new MouseAdapter() {

                                        @Override
                                        public void mouseEntered(
                                                        MouseEvent e) {

                                                referButton.setBackground(
                                                                new Color(
                                                                                242,
                                                                                242,
                                                                                255));
                                        }

                                        @Override
                                        public void mouseExited(
                                                        MouseEvent e) {

                                                referButton.setBackground(
                                                                Color.WHITE);
                                        }
                                });

                return card;
        }
}