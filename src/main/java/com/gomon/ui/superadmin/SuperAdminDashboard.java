package com.gomon.ui.superadmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SuperAdminDashboard extends JFrame {

        public SuperAdminDashboard() {

                setTitle("GOMON - Super Admin Dashboard");

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                setMinimumSize(
                                new Dimension(1200, 700));

                setSize(
                                1500,
                                900);

                setLocationRelativeTo(null);

                // =====================================================
                // MAIN FRAME
                // =====================================================

                JPanel mainPanel = new JPanel(new BorderLayout());

                mainPanel.setBackground(
                                new Color(245, 247, 252));

                // =====================================================
                // SIDEBAR
                // =====================================================

                SuperAdminSidebarPanel sidebar = new SuperAdminSidebarPanel();

                mainPanel.add(
                                sidebar,
                                BorderLayout.WEST);

                // =====================================================
                // HOME CONTENT
                // =====================================================

                SuperAdminDashboardHomePanel homePanel = new SuperAdminDashboardHomePanel();

                JScrollPane contentScroll = new JScrollPane(homePanel);

                contentScroll.setBorder(null);

                contentScroll.setHorizontalScrollBarPolicy(
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                contentScroll.setVerticalScrollBarPolicy(
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

                contentScroll.getVerticalScrollBar()
                                .setUnitIncrement(18);

                contentScroll.setBackground(
                                new Color(245, 247, 252));

                mainPanel.add(
                                contentScroll,
                                BorderLayout.CENTER);

                setContentPane(mainPanel);

                setVisible(true);

                SwingUtilities.invokeLater(() -> {
                        contentScroll
                                        .getVerticalScrollBar()
                                        .setValue(0);
                });
        }

        public static void main(String[] args) {

                SwingUtilities.invokeLater(() -> {

                        try {

                                UIManager.setLookAndFeel(
                                                UIManager.getSystemLookAndFeelClassName());

                        } catch (Exception ignored) {
                        }

                        new SuperAdminDashboard();
                });
        }
}