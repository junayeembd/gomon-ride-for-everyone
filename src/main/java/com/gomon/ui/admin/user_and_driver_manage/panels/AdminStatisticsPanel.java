package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import com.gomon.ui.admin.user_and_driver_manage.components.AdminStatCard;

public class AdminStatisticsPanel extends JPanel {

    public AdminStatisticsPanel() {

        setOpaque(false);

        setLayout(
                new GridLayout(
                        1,
                        5,
                        14,
                        0
                )
        );

        setPreferredSize(
                new Dimension(
                        0,
                        125
                )
        );

        setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        125
                )
        );

        // =========================================
        // TOTAL USERS
        // =========================================

        add(
                new AdminStatCard(
                        "👥",
                        "Total Users",
                        "12,430",
                        "↑ 8.5% This Month",
                        new Color(98, 71, 255)
                )
        );

        // =========================================
        // ACTIVE USERS
        // =========================================

        add(
                new AdminStatCard(
                        "🟢",
                        "Active Users",
                        "9,120",
                        "↑ 6.3% This Month",
                        new Color(39, 174, 96)
                )
        );

        // =========================================
        // TOTAL DRIVERS
        // =========================================

        add(
                new AdminStatCard(
                        "🚗",
                        "Total Drivers",
                        "1,532",
                        "↑ 7.2% This Month",
                        new Color(52, 152, 219)
                )
        );

        // =========================================
        // PENDING VERIFICATION
        // =========================================

        add(
                new AdminStatCard(
                        "⏳",
                        "Pending Verification",
                        "82",
                        "↓ 3.4% This Month",
                        new Color(241, 196, 15)
                )
        );

        // =========================================
        // BLOCKED ACCOUNTS
        // =========================================

        add(
                new AdminStatCard(
                        "🚫",
                        "Blocked Accounts",
                        "45",
                        "↓ 12.7% This Month",
                        new Color(231, 76, 60)
                )
        );
    }
}