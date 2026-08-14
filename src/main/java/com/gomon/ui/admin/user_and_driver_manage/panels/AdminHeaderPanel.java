package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AdminHeaderPanel extends JPanel {

    private final Color TEXT_COLOR = new Color(35, 35, 45);
    private final Color SECONDARY_COLOR = new Color(120, 120, 130);
    private final Color PURPLE = new Color(98, 71, 255);

    public AdminHeaderPanel() {

        setOpaque(false);

        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(0, 120));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        // =================================================
        // LEFT SIDE
        // =================================================

        JPanel leftPanel = createWelcomePanel();

        add(
                leftPanel,
                BorderLayout.WEST
        );

        // =================================================
        // RIGHT SIDE
        // =================================================

        JPanel rightPanel = createTopRightPanel();

        add(
                rightPanel,
                BorderLayout.EAST
        );
    }

    // =====================================================
    // WELCOME PANEL
    // =====================================================

    private JPanel createWelcomePanel() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        // -----------------------------------------------
        // Greeting
        // -----------------------------------------------

        JLabel greeting =
                new JLabel("Hello, Admin 👋");

        greeting.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        greeting.setForeground(
                TEXT_COLOR
        );

        greeting.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // -----------------------------------------------
        // Description
        // -----------------------------------------------

        JLabel description =
                new JLabel(
                        "Manage the GOMON platform, monitor operations, "
                        + "and keep everything running smoothly."
                );

        description.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        description.setForeground(
                SECONDARY_COLOR
        );

        description.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // -----------------------------------------------
        // ADD
        // -----------------------------------------------

        panel.add(greeting);

        panel.add(
                Box.createVerticalStrut(8)
        );

        panel.add(description);

        return panel;
    }

    // =====================================================
    // TOP RIGHT
    // =====================================================

    private JPanel createTopRightPanel() {

        JPanel container = new JPanel();

        container.setOpaque(false);

        container.setLayout(
                new BoxLayout(
                        container,
                        BoxLayout.Y_AXIS
                )
        );

        // -----------------------------------------------
        // SEARCH
        // -----------------------------------------------

        JPanel searchPanel =
                createSearchPanel();

        searchPanel.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        container.add(
                searchPanel
        );

        container.add(
                Box.createVerticalStrut(15)
        );

        // -----------------------------------------------
        // PROFILE ROW
        // -----------------------------------------------

        JPanel profilePanel =
                createProfilePanel();

        profilePanel.setAlignmentX(
                Component.RIGHT_ALIGNMENT
        );

        container.add(
                profilePanel
        );

        return container;
    }

    // =====================================================
    // SEARCH PANEL
    // =====================================================

    private JPanel createSearchPanel() {

        JPanel panel = new JPanel(
                new BorderLayout(8, 0)
        );

        panel.setBackground(
                Color.WHITE
        );

        panel.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        225,
                                        235
                                )
                        ),

                        new EmptyBorder(
                                8,
                                12,
                                8,
                                12
                        )
                )
        );

        panel.setPreferredSize(
                new Dimension(
                        350,
                        42
                )
        );

        panel.setMaximumSize(
                new Dimension(
                        350,
                        42
                )
        );

        // -----------------------------------------------
        // Search Icon
        // -----------------------------------------------

        JLabel searchIcon =
                new JLabel("⌕");

        searchIcon.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        22
                )
        );

        searchIcon.setForeground(
                new Color(
                        130,
                        130,
                        140
                )
        );

        // -----------------------------------------------
        // Search Field
        // -----------------------------------------------

        JTextField searchField =
                new JTextField();

        searchField.setBorder(null);

        searchField.setOpaque(false);

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        searchField.setForeground(
                TEXT_COLOR
        );

        searchField.setToolTipText(
                "Search users, drivers, email or phone"
        );

        searchField.putClientProperty(
                "JTextField.placeholderText",
                "Search users, drivers, email or phone..."
        );

        panel.add(
                searchIcon,
                BorderLayout.WEST
        );

        panel.add(
                searchField,
                BorderLayout.CENTER
        );

        return panel;
    }

    // =====================================================
    // PROFILE PANEL
    // =====================================================

    private JPanel createProfilePanel() {

        JPanel panel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        12,
                        0
                )
        );

        panel.setOpaque(false);

        // -----------------------------------------------
        // Notification
        // -----------------------------------------------

        JButton notification =
                new JButton("🔔");

        notification.setFocusPainted(false);
        notification.setBorderPainted(false);
        notification.setContentAreaFilled(false);

        notification.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        19
                )
        );

        notification.setCursor(
                new java.awt.Cursor(
                        java.awt.Cursor.HAND_CURSOR
                )
        );

        // -----------------------------------------------
        // Avatar
        // -----------------------------------------------

        JLabel avatar =
                new JLabel(
                        "A",
                        SwingConstants.CENTER
                );

        avatar.setOpaque(true);

        avatar.setBackground(
                PURPLE
        );

        avatar.setForeground(
                Color.WHITE
        );

        avatar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        avatar.setPreferredSize(
                new Dimension(
                        40,
                        40
                )
        );

        // -----------------------------------------------
        // Admin Info
        // -----------------------------------------------

        JPanel info =
                new JPanel();

        info.setOpaque(false);

        info.setLayout(
                new BoxLayout(
                        info,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel name =
                new JLabel("Admin");

        name.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        name.setForeground(
                TEXT_COLOR
        );

        JLabel role =
                new JLabel("Administrator");

        role.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        role.setForeground(
                SECONDARY_COLOR
        );

        info.add(name);

        info.add(
                Box.createVerticalStrut(3)
        );

        info.add(role);

        // -----------------------------------------------
        // ADD
        // -----------------------------------------------

        panel.add(notification);

        panel.add(avatar);

        panel.add(info);

        return panel;
    }
}