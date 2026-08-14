package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.admin.user_and_driver_manage.components.AdminActionCard;
import com.gomon.ui.components.ShadowCard;

public class AdminQuickActionsPanel extends ShadowCard {

        public AdminQuickActionsPanel() {

                setLayout(new BorderLayout());

                setCardColor(Color.WHITE);

                setPreferredSize(
                                new Dimension(0, 180));

                setMinimumSize(
                                new Dimension(300, 180));

                setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                180));

                // =================================================
                // ROOT
                // =================================================

                JPanel root = new JPanel(new BorderLayout());

                root.setOpaque(false);

                root.setBorder(
                                new EmptyBorder(
                                                18,
                                                20,
                                                18,
                                                20));

                // =================================================
                // HEADER
                // =================================================

                JPanel header = new JPanel(
                                new BorderLayout());

                header.setOpaque(false);

                JLabel title = new JLabel("Quick Actions");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                title.setForeground(
                                new Color(
                                                35,
                                                35,
                                                45));

                JLabel subtitle = new JLabel(
                                "Manage users and drivers quickly");

                subtitle.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                12));

                subtitle.setForeground(
                                new Color(
                                                130,
                                                130,
                                                140));

                JPanel titlePanel = new JPanel();

                titlePanel.setOpaque(false);

                titlePanel.setLayout(
                                new BoxLayout(
                                                titlePanel,
                                                BoxLayout.Y_AXIS));

                titlePanel.add(title);

                titlePanel.add(
                                Box.createVerticalStrut(4));

                titlePanel.add(subtitle);

                header.add(
                                titlePanel,
                                BorderLayout.WEST);

                root.add(
                                header,
                                BorderLayout.NORTH);

                // =================================================
                // ACTION CARDS
                // =================================================

                JPanel actions = new JPanel(
                                new GridLayout(
                                                1,
                                                2,
                                                12,
                                                0));

                actions.setOpaque(false);

                actions.setBorder(
                                new EmptyBorder(
                                                15,
                                                0,
                                                0,
                                                0));

                // -----------------------------------------------
                // ADD USER
                // -----------------------------------------------

                AdminActionCard addUser = new AdminActionCard(
                                "👤",
                                "Add New User",
                                "Create a new user account",
                                new Color(
                                                98,
                                                71,
                                                255));

                // -----------------------------------------------
                // ADD DRIVER
                // -----------------------------------------------

                AdminActionCard addDriver = new AdminActionCard(
                                "🚗",
                                "Add New Driver",
                                "Register a new driver",
                                new Color(
                                                39,
                                                174,
                                                96));

                actions.add(addUser);

                actions.add(addDriver);

                root.add(
                                actions,
                                BorderLayout.CENTER);

                add(
                                root,
                                BorderLayout.CENTER);
        }
}