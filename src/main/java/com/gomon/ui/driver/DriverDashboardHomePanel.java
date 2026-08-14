package com.gomon.ui.driver;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.driver.panels.DashboardPanel;

public class DriverDashboardHomePanel extends JPanel {

    public DriverDashboardHomePanel() {

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
                        5,
                        20,
                        25,
                        20));

        DashboardPanel dashboard = new DashboardPanel();

        add(
                dashboard,
                BorderLayout.CENTER);
    }
}