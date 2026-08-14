package com.gomon.ui.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.MenuButton;

public class SidebarPanel extends JPanel {

    private static final Color SIDEBAR_COLOR = new Color(18, 16, 70);
    private static final Color PURPLE_COLOR = new Color(98, 71, 255);

    public SidebarPanel() {

        setPreferredSize(new Dimension(268, 0));
        setBackground(SIDEBAR_COLOR);
        setLayout(new BorderLayout());

        // =========================
        // TOP - LOGO
        // =========================
        add(createLogoPanel(), BorderLayout.NORTH);

        // =========================
        // CENTER - MENU
        // =========================
        add(createScrollableMenu(), BorderLayout.CENTER);

        // =========================
        // BOTTOM - INVITE & EARN
        // =========================
        add(createBottomPanel(), BorderLayout.SOUTH);
    }

    // =========================================================
    // LOGO PANEL
    // =========================================================

    private JPanel createLogoPanel() {

        JPanel panel = new JPanel();
        panel.setOpaque(false);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(
                new EmptyBorder(25, 20, 20, 20));

        JLabel title = new JLabel("GOMON");

        title.setFont(
                new Font("Segoe UI", Font.BOLD, 30));

        title.setForeground(Color.WHITE);

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subTitle = new JLabel("Ride For Everyone");

        subTitle.setFont(
                new Font("Segoe UI", Font.PLAIN, 15));

        subTitle.setForeground(
                new Color(210, 210, 210));

        subTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        panel.add(title);

        panel.add(
                Box.createVerticalStrut(5));

        panel.add(subTitle);

        return panel;
    }

    // =========================================================
    // SCROLLABLE MENU
    // =========================================================

    private JScrollPane createScrollableMenu() {

        JPanel menu = createMenuPanel();

        JScrollPane scrollPane = new JScrollPane(menu);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder());

        scrollPane.setBackground(SIDEBAR_COLOR);

        scrollPane.getViewport().setBackground(
                SIDEBAR_COLOR);

        // Vertical scroll only
        scrollPane.setVerticalScrollBarPolicy(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Make scrollbar background match sidebar
        scrollPane.getVerticalScrollBar().setBackground(
                SIDEBAR_COLOR);

        return scrollPane;
    }

    // =========================================================
    // MENU PANEL
    // =========================================================

    private JPanel createMenuPanel() {

        JPanel menu = new JPanel();

        menu.setOpaque(false);

        menu.setLayout(
                new BoxLayout(menu, BoxLayout.Y_AXIS));

        menu.setBorder(
                new EmptyBorder(10, 15, 10, 15));

        // =========================
        // MENU BUTTONS
        // =========================

        MenuButton dashboard = new MenuButton("Dashboard", null);

        MenuButton booking = new MenuButton("Book Ride", null);

        MenuButton myBooking = new MenuButton("My Booking", null);

        MenuButton history = new MenuButton("Ride History", null);

        MenuButton wallet = new MenuButton("Wallet & Payment", null);

        MenuButton favorites = new MenuButton("Favorites", null);

        MenuButton rewards = new MenuButton("Rewards", null);

        MenuButton safetyCenter = new MenuButton("Safety Center", null);

        MenuButton helpAndSupport = new MenuButton("Help & Support", null);

        MenuButton settings = new MenuButton("Settings", null);

        MenuButton logout = new MenuButton("Logout", null);

        // =========================
        // DEFAULT SELECTED
        // =========================

        dashboard.setSelectedMenu(true);

        // =========================
        // ADD MENU ITEMS
        // =========================

        addMenuItem(menu, dashboard);

        addMenuItem(menu, booking);

        addMenuItem(menu, myBooking);

        addMenuItem(menu, history);

        addMenuItem(menu, wallet);

        addMenuItem(menu, favorites);

        addMenuItem(menu, rewards);

        addMenuItem(menu, safetyCenter);

        addMenuItem(menu, helpAndSupport);

        addMenuItem(menu, settings);

        // Small separator before Logout
        menu.add(
                Box.createVerticalStrut(12));

        addMenuItem(menu, logout);

        return menu;
    }

    // =========================================================
    // ADD MENU ITEM
    // =========================================================

    private void addMenuItem(
            JPanel menu,
            MenuButton button) {

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT);

        menu.add(button);

        menu.add(
                Box.createVerticalStrut(8));
    }

    // =========================================================
    // BOTTOM PANEL - INVITE & EARN
    // =========================================================

    private JPanel createBottomPanel() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BorderLayout());

        panel.setBorder(
                new EmptyBorder(10, 15, 20, 15));

        // =========================
        // INVITE CARD
        // =========================

        JPanel card = new JPanel();

        card.setBackground(
                PURPLE_COLOR);

        card.setPreferredSize(
                new Dimension(238, 130));

        card.setMaximumSize(
                new Dimension(238, 130));

        card.setLayout(
                new BorderLayout());

        JLabel invite = new JLabel(
                "Invite & Earn",
                SwingConstants.CENTER);

        invite.setForeground(
                Color.WHITE);

        invite.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18));

        card.add(
                invite,
                BorderLayout.CENTER);

        panel.add(
                card,
                BorderLayout.CENTER);

        return panel;
    }
}