package com.gomon.ui.user.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.user.components.StatCard;

public class StatisticsPanel extends JPanel {

        public StatisticsPanel() {

                setOpaque(false);

                setBorder(new EmptyBorder(0, 0, 0, 0));

                setLayout(new GridLayout(1, 3, 12, 0));

                add(new StatCard(
                                new Color(95, 70, 255),
                                "🚗",
                                "Total Rides",
                                "24",
                                "This Month ▲12%"));

                add(new StatCard(
                                new Color(30, 200, 100),
                                "💰",
                                "Total Spent",
                                "৳3,580",
                                "This Month ▼8%"));

                add(new StatCard(
                                new Color(255, 180, 0),
                                "⭐",
                                "Your Reward",
                                "1576",
                                "Earn More"));

        }
}