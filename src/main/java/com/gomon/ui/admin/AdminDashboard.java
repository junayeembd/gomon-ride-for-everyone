package com.gomon.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AdminDashboard extends JFrame {

    private static final Color BACKGROUND = new Color(245, 247, 251);

    private final JPanel contentPanel;
    private final AdminSidebarPanel sidebarPanel;
    private final AdminHeaderPanel headerPanel;

    public AdminDashboard() {

        setTitle("GOMON - Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1200, 750));
        setSize(1500, 900);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND);

        // =========================
        // SIDEBAR
        // =========================

        sidebarPanel = new AdminSidebarPanel(this);
        mainPanel.add(sidebarPanel, BorderLayout.WEST);

        // =========================
        // RIGHT SIDE
        // =========================

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);

        headerPanel = new AdminHeaderPanel(this);
        rightPanel.add(headerPanel, BorderLayout.NORTH);

        // =========================
        // CONTENT
        // =========================

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(BACKGROUND);

        showDashboard();

        rightPanel.add(contentPanel, BorderLayout.CENTER);

        mainPanel.add(rightPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public void showDashboard() {

        contentPanel.removeAll();

        AdminDashboardHomePanel dashboard = new AdminDashboardHomePanel(this);

        contentPanel.add(dashboard, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public void showPanel(JPanel panel) {

        contentPanel.removeAll();

        contentPanel.add(panel, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AdminDashboard dashboard = new AdminDashboard();

            dashboard.setVisible(true);
        });
    }
}