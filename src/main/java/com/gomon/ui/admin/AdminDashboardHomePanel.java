package com.gomon.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.gomon.ui.admin.cards.AdminQuickActionCard;
import com.gomon.ui.admin.cards.AdminStatCard;

public class AdminDashboardHomePanel extends JPanel {

    private static final Color BACKGROUND = new Color(245, 247, 251);

    private static final Color TEXT = new Color(30, 30, 45);

    private static final Color MUTED = new Color(110, 110, 125);

    private final AdminDashboard dashboard;

    public AdminDashboardHomePanel(
            AdminDashboard dashboard) {

        this.dashboard = dashboard;

        setBackground(BACKGROUND);
        setLayout(new BorderLayout());

        add(createScrollableContent(),
                BorderLayout.CENTER);
    }

    // =====================================================
    // SCROLLABLE CONTENT
    // =====================================================

    private JScrollPane createScrollableContent() {

        JPanel content = new JPanel();

        content.setBackground(BACKGROUND);

        content.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 28, 30, 28));

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS));

        // HEADER
        content.add(createPageTitle());

        content.add(Box.createVerticalStrut(22));

        // STAT CARDS
        content.add(createStatsSection());

        content.add(Box.createVerticalStrut(28));

        // QUICK ACTIONS
        content.add(createSectionTitle(
                "Quick Actions",
                "Frequently used admin operations"));

        content.add(Box.createVerticalStrut(12));

        content.add(createQuickActions());

        content.add(Box.createVerticalStrut(28));

        // ACTIVITY
        content.add(createSectionTitle(
                "Recent Activity",
                "Latest activity across GOMON"));

        content.add(Box.createVerticalStrut(12));

        content.add(createActivityPanel());

        JScrollPane scrollPane = new JScrollPane(content);

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(18);

        scrollPane.setBackground(BACKGROUND);

        return scrollPane;
    }

    // =====================================================
    // PAGE TITLE
    // =====================================================

    private JPanel createPageTitle() {

        JPanel panel = new JPanel(
                new BorderLayout());

        panel.setOpaque(false);

        JLabel title = new JLabel("Admin Dashboard");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26));

        title.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "Monitor and manage GOMON operations from one place.");

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        subtitle.setForeground(MUTED);

        JPanel text = new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS));

        text.add(title);
        text.add(Box.createVerticalStrut(5));
        text.add(subtitle);

        panel.add(text, BorderLayout.WEST);

        return panel;
    }

    // =====================================================
    // STAT CARDS
    // =====================================================

    private JPanel createStatsSection() {

        JPanel wrapper = new JPanel(
                new BorderLayout());

        wrapper.setOpaque(false);

        JPanel cards = new JPanel(
                new GridLayout(
                        1,
                        4,
                        16,
                        0));

        cards.setOpaque(false);

        /*
         * Temporary general admin cards.
         *
         * Later these values will come
         * from the database.
         */

        cards.add(new AdminStatCard(
                "Total Users",
                "2,450",
                "+12% this month"));

        cards.add(new AdminStatCard(
                "Total Drivers",
                "684",
                "+8% this month"));

        cards.add(new AdminStatCard(
                "Active Rides",
                "128",
                "Currently ongoing"));

        cards.add(new AdminStatCard(
                "Today's Earnings",
                "৳84,650",
                "+14% from yesterday"));

        wrapper.add(cards);

        return wrapper;
    }

    // =====================================================
    // SECTION TITLE
    // =====================================================

    private JPanel createSectionTitle(
            String title,
            String subtitle) {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setOpaque(false);

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18));

        titleLabel.setForeground(TEXT);

        JLabel subtitleLabel = new JLabel(subtitle);

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12));

        subtitleLabel.setForeground(MUTED);

        JPanel text = new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS));

        text.add(titleLabel);
        text.add(Box.createVerticalStrut(3));
        text.add(subtitleLabel);

        panel.add(text, BorderLayout.WEST);

        return panel;
    }

    // =====================================================
    // QUICK ACTIONS
    // =====================================================

    private JPanel createQuickActions() {

        JPanel panel = new JPanel(
                new GridLayout(
                        1,
                        3,
                        16,
                        0));

        panel.setOpaque(false);

        panel.add(
                new AdminQuickActionCard(
                        "Manage Users",
                        "View and manage user accounts",
                        "Open",
                        () -> openPage(
                                "User Management")));

        panel.add(
                new AdminQuickActionCard(
                        "Manage Drivers",
                        "Verify and manage drivers",
                        "Open",
                        () -> openPage(
                                "Driver Management")));

        panel.add(
                new AdminQuickActionCard(
                        "Monitor Rides",
                        "Monitor active rides",
                        "Open",
                        () -> openPage(
                                "Ride Monitoring")));

        return panel;
    }

    // =====================================================
    // ACTIVITY PANEL
    // =====================================================

    private JPanel createActivityPanel() {

        JPanel panel = new JPanel(
                new BorderLayout());

        panel.setBackground(Color.WHITE);

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(230, 232, 238)),
                        BorderFactory.createEmptyBorder(
                                18, 20, 18, 20)));

        JPanel activities = new JPanel();

        activities.setOpaque(false);

        activities.setLayout(
                new BoxLayout(
                        activities,
                        BoxLayout.Y_AXIS));

        addActivity(
                activities,
                "New driver registration",
                "Driver verification request received",
                "2 min ago");

        addActivity(
                activities,
                "Ride completed",
                "Ride #GMN-10245 completed successfully",
                "8 min ago");

        addActivity(
                activities,
                "Payment received",
                "Digital payment received",
                "15 min ago");

        addActivity(
                activities,
                "Support request",
                "New customer support ticket opened",
                "24 min ago");

        panel.add(activities,
                BorderLayout.CENTER);

        return panel;
    }

    // =====================================================
    // ACTIVITY ITEM
    // =====================================================

    private void addActivity(
            JPanel parent,
            String title,
            String description,
            String time) {

        JPanel item = new JPanel(new BorderLayout());

        item.setOpaque(false);

        item.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 0, 10, 0));

        JPanel text = new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13));

        titleLabel.setForeground(TEXT);

        JLabel descLabel = new JLabel(description);

        descLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11));

        descLabel.setForeground(MUTED);

        text.add(titleLabel);
        text.add(Box.createVerticalStrut(3));
        text.add(descLabel);

        JLabel timeLabel = new JLabel(time);

        timeLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11));

        timeLabel.setForeground(
                new Color(145, 145, 160));

        item.add(text,
                BorderLayout.CENTER);

        item.add(timeLabel,
                BorderLayout.EAST);

        parent.add(item);
    }

    // =====================================================
    // OPEN PAGE
    // =====================================================

    private void openPage(String title) {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setBackground(BACKGROUND);

        JLabel label = new JLabel(
                title,
                JLabel.CENTER);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        label.setForeground(TEXT);

        panel.add(
                label,
                BorderLayout.CENTER);

        dashboard.showPanel(panel);
    }
}