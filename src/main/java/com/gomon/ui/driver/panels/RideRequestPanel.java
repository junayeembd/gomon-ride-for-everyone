package com.gomon.ui.driver.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class RideRequestPanel extends ShadowCard {

        public RideRequestPanel() {

                setLayout(new BorderLayout());
                setCardColor(Color.WHITE);

                // =====================================================
                // CARD SIZE
                // =====================================================

                setPreferredSize(
                                new Dimension(390, 365));

                setMinimumSize(
                                new Dimension(390, 365));

                setMaximumSize(
                                new Dimension(390, 365));

                // =====================================================
                // ROOT
                // =====================================================

                JPanel root = new JPanel();

                root.setOpaque(false);

                root.setLayout(
                                new BoxLayout(
                                                root,
                                                BoxLayout.Y_AXIS));

                root.setBorder(
                                new EmptyBorder(
                                                18,
                                                18,
                                                18,
                                                18));

                // =====================================================
                // TITLE
                // =====================================================

                JLabel title = new JLabel("New Ride Request");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                20));

                title.setForeground(
                                new Color(35, 35, 35));

                title.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                root.add(title);

                root.add(
                                Box.createVerticalStrut(16));

                // =====================================================
                // RIDER
                // =====================================================

                JPanel rider = new JPanel(
                                new BorderLayout(12, 0));

                rider.setOpaque(false);

                rider.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                rider.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                62));

                // Avatar
                JLabel avatar = new JLabel(
                                "R",
                                SwingConstants.CENTER);

                avatar.setPreferredSize(
                                new Dimension(
                                                58,
                                                58));

                avatar.setMinimumSize(
                                new Dimension(
                                                58,
                                                58));

                avatar.setMaximumSize(
                                new Dimension(
                                                58,
                                                58));

                avatar.setOpaque(true);

                avatar.setBackground(
                                new Color(
                                                98,
                                                71,
                                                255));

                avatar.setForeground(
                                Color.WHITE);

                avatar.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                22));

                rider.add(
                                avatar,
                                BorderLayout.WEST);

                // Rider information
                JPanel riderInfo = new JPanel();

                riderInfo.setOpaque(false);

                riderInfo.setLayout(
                                new BoxLayout(
                                                riderInfo,
                                                BoxLayout.Y_AXIS));

                JLabel name = new JLabel(
                                "Rahim Ahmed");

                name.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                17));

                name.setForeground(
                                new Color(
                                                30,
                                                30,
                                                30));

                JLabel rating = new JLabel(
                                "⭐ 4.9 • Premium Rider");

                rating.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                rating.setForeground(
                                new Color(
                                                110,
                                                110,
                                                110));

                riderInfo.add(name);

                riderInfo.add(
                                Box.createVerticalStrut(5));

                riderInfo.add(rating);

                rider.add(
                                riderInfo,
                                BorderLayout.CENTER);

                root.add(rider);

                root.add(
                                Box.createVerticalStrut(14));

                // =====================================================
                // RIDE DETAILS
                // =====================================================

                root.add(
                                createRow(
                                                "📍 Pickup",
                                                "Mirpur DOHS"));

                root.add(
                                Box.createVerticalStrut(7));

                root.add(
                                createRow(
                                                "🏁 Drop",
                                                "Banani"));

                root.add(
                                Box.createVerticalStrut(7));

                root.add(
                                createRow(
                                                "💰 Fare",
                                                "৳240"));

                root.add(
                                Box.createVerticalStrut(7));

                root.add(
                                createRow(
                                                "🚗 Ride",
                                                "Car"));

                root.add(
                                Box.createVerticalStrut(7));

                root.add(
                                createRow(
                                                "⏱ ETA",
                                                "18 min"));

                // Push buttons down
                root.add(
                                Box.createVerticalGlue());

                // =====================================================
                // BUTTONS
                // =====================================================

                JPanel buttons = new JPanel(
                                new GridLayout(
                                                1,
                                                2,
                                                12,
                                                0));

                buttons.setOpaque(false);

                buttons.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                buttons.setPreferredSize(
                                new Dimension(
                                                350,
                                                44));

                buttons.setMinimumSize(
                                new Dimension(
                                                350,
                                                44));

                buttons.setMaximumSize(
                                new Dimension(
                                                350,
                                                44));

                // Accept
                JButton accept = new JButton("Accept");

                accept.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                13));

                accept.setBackground(
                                new Color(
                                                34,
                                                197,
                                                94));

                accept.setForeground(
                                Color.WHITE);

                accept.setFocusPainted(false);

                accept.setBorderPainted(false);

                accept.setCursor(
                                Cursor.getPredefinedCursor(
                                                Cursor.HAND_CURSOR));

                // View
                JButton view = new JButton("View");

                view.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                13));

                view.setFocusPainted(false);

                view.setCursor(
                                Cursor.getPredefinedCursor(
                                                Cursor.HAND_CURSOR));

                buttons.add(accept);
                buttons.add(view);

                root.add(
                                Box.createVerticalStrut(8));

                root.add(buttons);

                // =====================================================
                // ADD ROOT
                // =====================================================

                add(
                                root,
                                BorderLayout.CENTER);
        }

        // =========================================================
        // DETAIL ROW
        // =========================================================

        private JPanel createRow(
                        String left,
                        String right) {

                JPanel row = new JPanel(
                                new BorderLayout());

                row.setOpaque(false);

                row.setAlignmentX(
                                Component.LEFT_ALIGNMENT);

                row.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                24));

                JLabel leftLabel = new JLabel(left);

                leftLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                leftLabel.setForeground(
                                new Color(
                                                120,
                                                120,
                                                120));

                JLabel rightLabel = new JLabel(right);

                rightLabel.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                14));

                rightLabel.setForeground(
                                new Color(
                                                35,
                                                35,
                                                35));

                row.add(
                                leftLabel,
                                BorderLayout.WEST);

                row.add(
                                rightLabel,
                                BorderLayout.EAST);

                return row;
        }
}