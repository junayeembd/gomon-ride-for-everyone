package com.gomon.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminHeaderPanel extends JPanel {

    private static final Color BACKGROUND = new Color(245, 247, 251);

    public AdminHeaderPanel(AdminDashboard dashboard) {

        setBackground(BACKGROUND);
        setPreferredSize(new Dimension(0, 105));

        setBorder(
                BorderFactory.createEmptyBorder(
                        20, 28, 15, 28));

        setLayout(new BorderLayout());

        // =========================
        // LEFT
        // =========================

        JPanel left = new JPanel();

        left.setOpaque(false);
        left.setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Welcome, Admin!");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26));

        title.setForeground(
                new Color(25, 25, 40));

        JLabel subtitle = new JLabel(
                "Here's what's happening in GOMON today.");

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        subtitle.setForeground(
                new Color(120, 120, 140));

        JPanel text = new JPanel();

        text.setOpaque(false);
        text.setLayout(
                new javax.swing.BoxLayout(
                        text,
                        javax.swing.BoxLayout.Y_AXIS));

        text.add(title);
        text.add(subtitle);

        left.add(text, BorderLayout.CENTER);

        add(left, BorderLayout.WEST);

        // =========================
        // RIGHT
        // =========================

        JPanel right = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        12,
                        8));

        right.setOpaque(false);

        JButton notification = new JButton("🔔");

        notification.setPreferredSize(
                new Dimension(45, 40));

        notification.setFocusPainted(false);

        JLabel adminName = new JLabel("Admin");

        adminName.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14));

        JLabel role = new JLabel("Administrator");

        role.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11));

        JPanel profileText = new JPanel();

        profileText.setOpaque(false);

        profileText.setLayout(
                new javax.swing.BoxLayout(
                        profileText,
                        javax.swing.BoxLayout.Y_AXIS));

        profileText.add(adminName);
        profileText.add(role);

        JButton profile = new JButton("●");

        profile.setPreferredSize(
                new Dimension(42, 42));

        profile.setFocusPainted(false);

        right.add(notification);
        right.add(profileText);
        right.add(profile);

        add(right, BorderLayout.EAST);
    }
}