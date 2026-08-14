package com.gomon.ui.driver;

import java.awt.*;
import javax.swing.*;

public class DriverDashboard extends JFrame {

    private DriverSidebarPanel sidebar;
    private DriverHeaderPanel header;
    private DriverDashboardHomePanel dashboard;

    public DriverDashboard() {

        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Driver Dashboard Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void initialize() {

        setTitle("GOMON - Driver Dashboard");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(new Dimension(1400, 850));

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // -----------------------------------------
        // Sidebar
        // -----------------------------------------

        sidebar = new DriverSidebarPanel();

        add(sidebar, BorderLayout.WEST);

        // -----------------------------------------
        // Main Panel
        // -----------------------------------------

        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.setBackground(new Color(245, 247, 252));

        // -----------------------------------------
        // Header
        // -----------------------------------------

        header = new DriverHeaderPanel();

        mainPanel.add(header, BorderLayout.NORTH);

        // -----------------------------------------
        // Dashboard
        // -----------------------------------------

        dashboard = new DriverDashboardHomePanel();

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
        SwingUtilities.invokeLater(() -> {
            scroll.getVerticalScrollBar().setValue(0);
            scroll.revalidate();
            scroll.repaint();
        });

        add(mainPanel, BorderLayout.CENTER);

    }

}