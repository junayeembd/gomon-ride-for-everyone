package com.gomon.ui.user;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.user.panels.*;

public class DashboardHomePanel extends JPanel {

    private StatisticsPanel statisticsPanel;
    private WalletPanel walletPanel;
    private BookRidePanel bookRidePanel;
    private MapPanel mapPanel;
    private QuickActionPanel quickActionPanel;
    private RecentRidePanel recentRidePanel;
    private SafetyPanel safetyPanel;

    public DashboardHomePanel() {

        setBackground(new Color(245, 247, 252));
        setLayout(new BorderLayout());

        JPanel container = new JPanel(new BorderLayout());
        container.setOpaque(false);
        container.setBorder(new EmptyBorder(25, 25, 25, 25));

        // --------------------------------------------------
        // TOP SECTION
        // --------------------------------------------------

        JPanel topSection = new JPanel();
        topSection.setOpaque(false);
        topSection.setLayout(new BoxLayout(topSection, BoxLayout.Y_AXIS));

        topSection.add(createWelcomePanel());
        topSection.add(Box.createVerticalStrut(25));

        JPanel statisticsRow = new JPanel(new GridBagLayout());
        statisticsRow.setOpaque(false);

        GridBagConstraints s = new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridy = 0;
        s.weighty = 1;

        statisticsPanel = new StatisticsPanel();

        s.gridx = 0;
        s.weightx = 0.72;
        s.insets = new Insets(0, 0, 0, 15);

        statisticsRow.add(statisticsPanel, s);

        walletPanel = new WalletPanel();

        s.gridx = 1;
        s.weightx = 0.28;
        s.insets = new Insets(0, 0, 0, 0);

        statisticsRow.add(walletPanel, s);

        topSection.add(statisticsRow);

        container.add(topSection, BorderLayout.NORTH);

        // --------------------------------------------------
        // CENTER SECTION
        // --------------------------------------------------

        JPanel centerSection = new JPanel(new GridBagLayout());
        centerSection.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;
        c.weighty = 1;

        // ------------------------------------
        // Book Ride
        // ------------------------------------

        bookRidePanel = new BookRidePanel();

        c.gridx = 0;
        c.weightx = 0.28;
        c.insets = new Insets(0, 0, 0, 15);

        centerSection.add(bookRidePanel, c);

        // ------------------------------------
        // Live Map
        // ------------------------------------

        mapPanel = new MapPanel();

        c.gridx = 1;
        c.weightx = 0.47;
        c.insets = new Insets(0, 0, 0, 15);

        centerSection.add(mapPanel, c);

        // ------------------------------------
        // Right Side
        // ------------------------------------

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setOpaque(false);

        GridBagConstraints r = new GridBagConstraints();
        r.gridx = 0;
        r.fill = GridBagConstraints.BOTH;
        r.weightx = 1;

        // ------------------------------------
        // Quick Action
        // ------------------------------------

        quickActionPanel = new QuickActionPanel();

        r.gridy = 0;
        r.weighty = 0.40;
        r.insets = new Insets(0, 0, 15, 0);

        rightPanel.add(quickActionPanel, r);

        // ------------------------------------
        // Recent Ride
        // ------------------------------------

        recentRidePanel = new RecentRidePanel();

        r.gridy = 1;
        r.weighty = 0.60;
        r.insets = new Insets(0, 0, 0, 0);

        rightPanel.add(recentRidePanel, r);

        // ------------------------------------

        c.gridx = 2;
        c.weightx = 0.25;
        c.insets = new Insets(0, 0, 0, 0);

        centerSection.add(rightPanel, c);

        // ------------------------------------
        // Give the center area more height
        // ------------------------------------

        // centerSection.setPreferredSize(new Dimension(0, 560));

        container.add(centerSection, BorderLayout.CENTER);

        // --------------------------------------------------
        // SAFETY SECTION
        // --------------------------------------------------

        safetyPanel = new SafetyPanel();

        JPanel bottomSection = new JPanel(new BorderLayout());
        bottomSection.setOpaque(false);
        bottomSection.setBorder(new EmptyBorder(20, 0, 0, 0));

        bottomSection.add(safetyPanel, BorderLayout.CENTER);

        container.add(bottomSection, BorderLayout.SOUTH);

        // --------------------------------------------------
        // ADD CONTAINER
        // --------------------------------------------------

        add(container, BorderLayout.CENTER);
    }

    // --------------------------------------------------
    // Welcome Panel
    // --------------------------------------------------

    private JPanel createWelcomePanel() {

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel hello = new JLabel("Hello, Asif 👋");
        hello.setFont(new Font("Segoe UI", Font.BOLD, 34));
        hello.setForeground(new Color(35, 35, 35));

        JLabel subtitle = new JLabel(
                "Book rides, manage your wallet and travel safely with GOMON.");

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(new Color(120, 120, 120));

        left.add(hello);
        left.add(Box.createVerticalStrut(5));
        left.add(subtitle);

        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        JLabel date = new JLabel(
                java.time.LocalDate.now().toString());

        date.setFont(new Font("Segoe UI", Font.BOLD, 15));
        date.setForeground(new Color(90, 90, 90));

        JLabel status = new JLabel("🟢 Online");
        status.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        status.setForeground(new Color(34, 197, 94));

        right.add(date);
        right.add(Box.createVerticalStrut(5));
        right.add(status);

        panel.add(left, BorderLayout.WEST);
        panel.add(right, BorderLayout.EAST);

        return panel;
    }

    // --------------------------------------------------
    // Getters
    // --------------------------------------------------

    public StatisticsPanel getStatisticsPanel() {
        return statisticsPanel;
    }

    public WalletPanel getWalletPanel() {
        return walletPanel;
    }

    public BookRidePanel getBookRidePanel() {
        return bookRidePanel;
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }

    public QuickActionPanel getQuickActionPanel() {
        return quickActionPanel;
    }

    public RecentRidePanel getRecentRidePanel() {
        return recentRidePanel;
    }

    public SafetyPanel getSafetyPanel() {
        return safetyPanel;
    }

}