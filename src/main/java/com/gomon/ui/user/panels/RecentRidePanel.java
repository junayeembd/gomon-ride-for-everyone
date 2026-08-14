package com.gomon.ui.user.panels;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class RecentRidePanel extends ShadowCard {

        public RecentRidePanel() {

                setLayout(new BorderLayout());
                setCardColor(Color.WHITE);

                JPanel root = new JPanel(new BorderLayout(0, 15));
                root.setOpaque(false);
                root.setBorder(new EmptyBorder(20, 20, 20, 20));

                // ----------------------------------
                // Header
                // ----------------------------------

                JPanel header = new JPanel(new BorderLayout());
                header.setOpaque(false);

                JLabel title = new JLabel("Recent Rides");
                title.setFont(new Font("Segoe UI", Font.BOLD, 20));

                JLabel viewAll = new JLabel("View All");
                viewAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                viewAll.setForeground(new Color(98, 71, 255));
                viewAll.setFont(new Font("Segoe UI", Font.BOLD, 12));

                header.add(title, BorderLayout.WEST);
                header.add(viewAll, BorderLayout.EAST);

                // ----------------------------------
                // Ride List
                // ----------------------------------

                JPanel list = new JPanel();
                list.setOpaque(false);
                list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

                list.add(createRide(
                                "🚕",
                                "Dhanmondi → Gulshan",
                                "Today • 10:35 AM",
                                "Completed",
                                "৳180",
                                new Color(34, 197, 94)));

                list.add(Box.createVerticalStrut(5));

                list.add(createRide(
                                "🚗",
                                "Mirpur → Uttara",
                                "Yesterday • 6:10 PM",
                                "Ongoing",
                                "৳320",
                                new Color(59, 130, 246)));

                list.add(Box.createVerticalStrut(5));

                list.add(createRide(
                                "🛺",
                                "Farmgate → Motijheel",
                                "2 Days Ago",
                                "Cancelled",
                                "৳140",
                                new Color(249, 115, 22)));

                root.add(header, BorderLayout.NORTH);
                root.add(list, BorderLayout.CENTER);

                add(root, BorderLayout.CENTER);
        }

        // =========================================================
        // Ride Card
        // =========================================================

        private JPanel createRide(
                        String icon,
                        String route,
                        String time,
                        String status,
                        String fare,
                        Color fareColor) {

                JPanel panel = new JPanel(new BorderLayout(15, 0));
                panel.setBackground(new Color(247, 249, 252));
                panel.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(230, 235, 242), 1, true),
                                new EmptyBorder(12, 15, 12, 15)));

                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                // =========================================
                // Icon
                // =========================================

                JLabel iconLabel = new JLabel(icon);
                iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 26));

                // =========================================
                // Center
                // =========================================

                JPanel center = new JPanel();
                center.setOpaque(false);
                center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

                JLabel routeLabel = new JLabel(route);
                routeLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

                JLabel timeLabel = new JLabel(time);
                timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                timeLabel.setForeground(new Color(120, 120, 120));

                JLabel statusLabel = new JLabel();
                statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));

                switch (status.toLowerCase()) {

                        case "completed":
                                statusLabel.setText("Completed");
                                statusLabel.setForeground(new Color(34, 197, 94));
                                break;

                        case "ongoing":
                                statusLabel.setText("Ongoing");
                                statusLabel.setForeground(new Color(59, 130, 246));
                                break;

                        case "cancelled":
                                statusLabel.setText("Cancelled");
                                statusLabel.setForeground(new Color(239, 68, 68));
                                break;

                        case "scheduled":
                                statusLabel.setText("Scheduled");
                                statusLabel.setForeground(new Color(249, 115, 22));
                                break;

                        default:
                                statusLabel.setText(status);
                                statusLabel.setForeground(Color.GRAY);
                }

                center.add(routeLabel);
                center.add(Box.createVerticalStrut(3));
                center.add(timeLabel);
                center.add(Box.createVerticalStrut(3));
                center.add(statusLabel);

                // =========================================
                // Fare
                // =========================================

                JLabel fareLabel = new JLabel(fare);
                fareLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
                fareLabel.setForeground(fareColor);

                // =========================================
                // Hover Effect
                // =========================================

                panel.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseEntered(MouseEvent e) {

                                panel.setBackground(new Color(240, 244, 255));

                                panel.setBorder(BorderFactory.createCompoundBorder(
                                                BorderFactory.createLineBorder(
                                                                new Color(98, 71, 255), 2, true),
                                                new EmptyBorder(11, 14, 11, 14)));

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                                panel.setBackground(new Color(247, 249, 252));

                                panel.setBorder(BorderFactory.createCompoundBorder(
                                                BorderFactory.createLineBorder(
                                                                new Color(230, 235, 242), 1, true),
                                                new EmptyBorder(12, 15, 12, 15)));

                        }

                });

                panel.add(iconLabel, BorderLayout.WEST);
                panel.add(center, BorderLayout.CENTER);
                panel.add(fareLabel, BorderLayout.EAST);

                return panel;
        }
}