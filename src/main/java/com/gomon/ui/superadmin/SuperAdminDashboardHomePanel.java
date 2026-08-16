package com.gomon.ui.superadmin;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.superadmin.panels.SuperAdminOverviewPanel;

public class SuperAdminDashboardHomePanel extends JPanel {

    public SuperAdminDashboardHomePanel() {

        setOpaque(true);

        setBackground(
                new Color(
                        245,
                        247,
                        252));

        setLayout(
                new BorderLayout());

        setBorder(
                new EmptyBorder(
                        20,
                        25,
                        30,
                        25));

        add(
                new SuperAdminOverviewPanel(),
                BorderLayout.CENTER);
    }
}