package com.gomon.ui.user;

import java.awt.*;
import javax.swing.*;

public class UserDashboard extends JFrame {

    private SidebarPanel sidebar;
    private HeaderPanel header;
    private DashboardHomePanel dashboard;

    public UserDashboard() {

        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Dashboard Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void initialize() {

        setTitle("GOMON - Ride for Everyone");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(new Dimension(1400, 850));

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // -----------------------------------------
        // Sidebar
        // -----------------------------------------

        sidebar = new SidebarPanel();

        add(sidebar, BorderLayout.WEST);

        // -----------------------------------------
        // Main
        // -----------------------------------------

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.setBackground(new Color(245, 247, 252));

        // -----------------------------------------
        // Header
        // -----------------------------------------

        header = new HeaderPanel();

        mainPanel.add(header, BorderLayout.NORTH);

        // -----------------------------------------
        // Dashboard
        // -----------------------------------------

        dashboard = new DashboardHomePanel();

        JScrollPane scroll = new JScrollPane(dashboard);

        scroll.setBorder(null);

        scroll.getViewport().setBackground(new Color(245, 247, 252));

        scroll.getVerticalScrollBar().setUnitIncrement(18);

        scroll.getHorizontalScrollBar().setUnitIncrement(18);

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        mainPanel.add(scroll, BorderLayout.CENTER);

        // -----------------------------------------

        add(mainPanel, BorderLayout.CENTER);

    }

}