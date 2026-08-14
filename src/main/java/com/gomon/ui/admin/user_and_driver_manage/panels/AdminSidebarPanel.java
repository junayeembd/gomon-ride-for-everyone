package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminSidebarPanel extends JPanel {

    // =========================================
    // COLORS
    // =========================================

    private static final Color SIDEBAR_COLOR =
            new Color(18, 16, 70);

    private static final Color SELECTED_COLOR =
            new Color(59, 111, 235);

    private static final Color HOVER_COLOR =
            new Color(45, 42, 105);

    private static final Color WHITE =
            Color.WHITE;

    // =========================================
    // MENU BUTTONS
    // =========================================

    private JButton dashboardButton;
    private JButton usersButton;
    private JButton driversButton;
    private JButton userVerificationButton;
    private JButton driverVerificationButton;
    private JButton blockedAccountsButton;

    public AdminSidebarPanel() {

        setPreferredSize(new Dimension(205, 0));
        setMinimumSize(new Dimension(205, 0));
        setMaximumSize(new Dimension(205, Integer.MAX_VALUE));

        setBackground(SIDEBAR_COLOR);

        setLayout(new BorderLayout());

        // =====================================
        // TOP
        // =====================================

        add(
                createLogoPanel(),
                BorderLayout.NORTH
        );

        // =====================================
        // CENTER MENU
        // =====================================

        add(
                createMenuPanel(),
                BorderLayout.CENTER
        );

        // =====================================
        // BOTTOM
        // =====================================

        add(
                createBottomPanel(),
                BorderLayout.SOUTH
        );
    }

    // =================================================
    // LOGO PANEL
    // =================================================

    private JPanel createLogoPanel() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                new EmptyBorder(25,15,20,15)
        );

        // -----------------------------------------
        // GOMON
        // -----------------------------------------

        JLabel logo = new JLabel("GOMON");

        logo.setForeground(WHITE);

        logo.setFont(
                new Font("Segoe UI",Font.BOLD, 26)
        );

        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // -----------------------------------------
        // SUBTITLE
        // -----------------------------------------

        JLabel subtitle =
                new JLabel("Ride For Everyone");

        subtitle.setForeground(
                new Color(205, 205, 220)
        );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(logo);

        panel.add(
                Box.createVerticalStrut(5)
        );

        panel.add(subtitle);

        return panel;
    }

    // =================================================
    // MENU PANEL
    // =================================================

    private JPanel createMenuPanel() {

        JPanel menu = new JPanel();

        menu.setOpaque(false);

        menu.setLayout(
                new BoxLayout(
                        menu,
                        BoxLayout.Y_AXIS
                )
        );

        menu.setBorder(
                new EmptyBorder(
                        15,
                        12,
                        10,
                        12
                )
        );

        // =========================================
        // DASHBOARD
        // =========================================

        dashboardButton = createMenuButton(
                        "Dashboard"
                );

        // =========================================
        // USERS
        // =========================================

        usersButton =
                createMenuButton(
                        "Users"
                );

        // =========================================
        // DRIVERS
        // =========================================

        driversButton =
                createMenuButton(
                        "Drivers"
                );

        // =========================================
        // USER VERIFICATION
        // =========================================

        userVerificationButton =
                createMenuButton(
                        "Users Verification"
                );

        // =========================================
        // DRIVER VERIFICATION
        // =========================================

        driverVerificationButton =
                createMenuButton(
                        "Drivers Verification"
                );

        // =========================================
        // BLOCKED ACCOUNTS
        // =========================================

        blockedAccountsButton =
                createMenuButton(
                        "Blocked Accounts"
                );

        // =========================================
        // DEFAULT SELECTED
        // =========================================

        setSelectedButton(
                dashboardButton
        );

        // =========================================
        // ADD BUTTONS
        // =========================================

        menu.add(dashboardButton);

        menu.add(
                Box.createVerticalStrut(5)
        );

        menu.add(usersButton);

        menu.add(
                Box.createVerticalStrut(5)
        );

        menu.add(driversButton);

        menu.add(
                Box.createVerticalStrut(5)
        );

        menu.add(userVerificationButton);

        menu.add(
                Box.createVerticalStrut(5)
        );

        menu.add(driverVerificationButton);

        menu.add(
                Box.createVerticalStrut(5)
        );

        menu.add(blockedAccountsButton);

        // Push Help section downward
        menu.add(
                Box.createVerticalGlue()
        );

        return menu;
    }

    // =================================================
    // CREATE MENU BUTTON
    // =================================================

    private JButton createMenuButton(String text) {

        JButton button =
                new JButton(text);

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setContentAreaFilled(false);

        button.setOpaque(true);

        button.setBackground(
                SIDEBAR_COLOR
        );

        button.setForeground(
                WHITE
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setBorder(
                new EmptyBorder(
                        12,
                        20,
                        12,
                        10
                )
        );

        button.setPreferredSize(
                new Dimension(
                        180,
                        45
                )
        );

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );

        // =====================================
        // HOVER
        // =====================================

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e) {

                        if (button != dashboardButton) {

                            button.setBackground(
                                    HOVER_COLOR
                            );
                        }
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e) {

                        if (button != dashboardButton) {

                            button.setBackground(
                                    SIDEBAR_COLOR
                            );
                        }
                    }
                }
        );

        // =====================================
        // CLICK
        // =====================================

        button.addActionListener(e -> {

            setSelectedButton(button);

            // Navigation will be connected later.
        });

        return button;
    }

    // =================================================
    // SELECT MENU BUTTON
    // =================================================

    private void setSelectedButton(
            JButton selectedButton) {

        JButton[] buttons = {

                dashboardButton,
                usersButton,
                driversButton,
                userVerificationButton,
                driverVerificationButton,
                blockedAccountsButton
        };

        for (JButton button : buttons) {

            if (button == null) {
                continue;
            }

            if (button == selectedButton) {

                button.setBackground(
                        SELECTED_COLOR
                );

                button.setForeground(
                        Color.WHITE
                );

                button.setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                15
                        )
                );

            } else {

                button.setBackground(
                        SIDEBAR_COLOR
                );

                button.setForeground(
                        Color.WHITE
                );

                button.setFont(
                        new Font(
                                "Segoe UI",
                                Font.PLAIN,
                                15
                        )
                );
            }
        }
    }

    // =================================================
    // BOTTOM PANEL
    // =================================================

    private JPanel createBottomPanel() {

        JPanel bottom =
                new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
                new BoxLayout(
                        bottom,
                        BoxLayout.Y_AXIS
                )
        );

        bottom.setBorder(
                new EmptyBorder(
                        10,
                        12,
                        20,
                        12
                )
        );

        // =========================================
        // HELP CARD
        // =========================================

        JPanel helpCard =
                createHelpCard();

        bottom.add(helpCard);

        bottom.add(
                Box.createVerticalStrut(15)
        );

        // =========================================
        // LOGOUT
        // =========================================

        JButton logout =
                createBottomButton(
                        "Logout"
                );

        bottom.add(logout);

        return bottom;
    }

    // =================================================
    // HELP CARD
    // =================================================

    private JPanel createHelpCard() {

        JPanel card =
                new JPanel();

        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        225,
                                        235
                                )
                        ),

                        new EmptyBorder(
                                12,
                                12,
                                12,
                                12
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // -----------------------------------------
        // TITLE
        // -----------------------------------------

        JLabel title =
                new JLabel(
                        "Need Help?"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        title.setForeground(
                new Color(
                        35,
                        35,
                        45
                )
        );

        // -----------------------------------------
        // TEXT
        // -----------------------------------------

        JLabel text =
                new JLabel(
                        "<html>"
                        + "Our support team is here<br>"
                        + "for you."
                        + "</html>"
                );

        text.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        text.setForeground(
                new Color(
                        80,
                        80,
                        90
                )
        );

        // -----------------------------------------
        // CONTACT BUTTON
        // -----------------------------------------

        JButton contact =
                new JButton(
                        "Contact Support"
                );

        contact.setFocusPainted(false);

        contact.setBorderPainted(false);

        contact.setBackground(
                SELECTED_COLOR
        );

        contact.setForeground(
                Color.WHITE
        );

        contact.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        contact.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );

        contact.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        contact.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        // =========================================
        // ADD
        // =========================================

        card.add(title);

        card.add(
                Box.createVerticalStrut(5)
        );

        card.add(text);

        card.add(
                Box.createVerticalStrut(10)
        );

        card.add(contact);

        return card;
    }

    // =================================================
    // LOGOUT BUTTON
    // =================================================

    private JButton createBottomButton(
            String text) {

        JButton button =
                new JButton(text);

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setContentAreaFilled(false);

        button.setOpaque(true);

        button.setBackground(
                SIDEBAR_COLOR
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        button.setPreferredSize(
                new Dimension(
                        180,
                        42
                )
        );

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        button.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                HOVER_COLOR
                        );
                    }

                    @Override
                    public void mouseExited(
                            java.awt.event.MouseEvent e) {

                        button.setBackground(
                                SIDEBAR_COLOR
                        );
                    }
                }
        );

        return button;
    }
}