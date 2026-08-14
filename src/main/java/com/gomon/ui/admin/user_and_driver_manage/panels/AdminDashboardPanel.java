package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminDashboardPanel extends JPanel {

    public AdminDashboardPanel() {

        setOpaque(false);

        setLayout(
                new BoxLayout(
                        this,
                        BoxLayout.Y_AXIS
                )
        );

        setBorder(
                new EmptyBorder(
                        25,
                        25,
                        30,
                        25
                )
        );

        // =========================================
        // HEADER
        // =========================================

        add(
                new AdminHeaderPanel()
        );

        add(
                Box.createVerticalStrut(22)
        );

        // =========================================
        // STATISTICS
        // =========================================

        add(
                new AdminStatisticsPanel()
        );

        add(
                Box.createVerticalStrut(22)
        );

        // =========================================
        // CHART SECTION
        // =========================================

        add(
                createChartSection()
        );

        add(
                Box.createVerticalStrut(22)
        );

        // =========================================
        // BOTTOM SECTION
        // =========================================

        add(
                createBottomSection()
        );

    }

    // =================================================
    // CHART SECTION
    // =================================================

    private JPanel createChartSection() {

        JPanel section = new JPanel(
                new GridLayout(
                        1,
                        2,
                        18,
                        0
                )
        );

        section.setOpaque(false);

        section.setPreferredSize(
                new Dimension(
                        0,
                        330
                )
        );

        section.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        330
                )
        );

        // -----------------------------------------
        // USER REGISTRATION
        // -----------------------------------------

        section.add(
                new UserRegistrationPanel()
        );

        // -----------------------------------------
        // USERS VS DRIVERS
        // -----------------------------------------

        section.add(
                new UsersVSDriversPanel()
        );

        return section;
    }

    // =================================================
    // BOTTOM SECTION
    // =================================================

    private JPanel createBottomSection() {

        JPanel section = new JPanel(
                new GridLayout(
                        1,
                        2,
                        18,
                        0
                )
        );

        section.setOpaque(false);

        section.setPreferredSize(
                new Dimension(
                        0,
                        350
                )
        );

        section.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        350
                )
        );

        // -----------------------------------------
        // DRIVER VERIFICATION
        // -----------------------------------------

        section.add(
                new DriverVerificationPanel()
        );

        // -----------------------------------------
        // RIGHT SIDE
        // -----------------------------------------

        section.add(
                createRightBottomSection()
        );

        return section;
    }

    // =================================================
    // RIGHT BOTTOM
    // =================================================

    private JPanel createRightBottomSection() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        // -----------------------------------------
        // QUICK ACTIONS
        // -----------------------------------------

        AdminQuickActionsPanel quickActions =
                new AdminQuickActionsPanel();

        quickActions.setAlignmentX(
                LEFT_ALIGNMENT
        );

        panel.add(
                quickActions
        );

        panel.add(
                Box.createVerticalStrut(15)
        );

        // -----------------------------------------
        // SAFETY / NOTICE
        // -----------------------------------------

        AdminSafetyPanel safety =
                new AdminSafetyPanel();

        safety.setAlignmentX(
                LEFT_ALIGNMENT
        );

        panel.add(
                safety
        );

        return panel;
    }
}