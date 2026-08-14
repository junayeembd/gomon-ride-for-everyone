package com.gomon.ui.admin.user_and_driver_manage ;

import java.awt.*;
import javax.swing.*;
import com.gomon.ui.admin.user_and_driver_manage.panels.AdminDashboardPanel;
import com.gomon.ui.admin.user_and_driver_manage.panels.AdminSidebarPanel;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        // =========================================
        // FRAME
        // =========================================

        setTitle("GOMON - Admin Dashboard");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMinimumSize(new Dimension(1100, 700));

        setSize(1400, 850);

        setLocationRelativeTo(null);

        // =========================================
        // MAIN PANEL
        // =========================================

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.setBackground(new Color(245, 247, 252));

        // =========================================
        // SIDEBAR
        // =========================================

        AdminSidebarPanel sidebar = new AdminSidebarPanel();

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        // =========================================
        // DASHBOARD CONTENT
        // =========================================

        AdminDashboardPanel dashboardPanel =
                new AdminDashboardPanel();

        // =========================================
        // SCROLL PANE
        // =========================================

        JScrollPane scrollPane =
                new JScrollPane(dashboardPanel);

        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        scrollPane.setBackground(
                new Color(245, 247, 252)
        );

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =========================================
        // FRAME CONTENT
        // =========================================

        setContentPane(mainPanel);

        // =========================================
        // SHOW
        // =========================================

        setVisible(true);
    }

    // =============================================
    // MAIN METHOD
    // =============================================

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {

                javax.swing.UIManager.setLookAndFeel(
                        javax.swing.UIManager
                                .getSystemLookAndFeelClassName()
                );

            } catch (Exception e) {

                e.printStackTrace();
            }

            new AdminDashboard();
        });
    }
}