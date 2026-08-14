package com.gomon.ui.driver;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.model.User;
import com.gomon.session.SessionManager;
import com.gomon.ui.components.AvatarButton;

public class DriverHeaderPanel extends JPanel {

    private JLabel dateLabel;
    private JLabel timeLabel;

    private static final Color TEXT = new Color(30, 30, 30);
    private static final Color MUTED = new Color(120, 120, 120);

    public DriverHeaderPanel() {

        setOpaque(false);

        // IMPORTANT
        setPreferredSize(new Dimension(0, 160));
        setMinimumSize(new Dimension(0, 160));

        setLayout(new BorderLayout());

        setBorder(
                new EmptyBorder(
                        20,
                        25,
                        15,
                        25));

        add(
                createHeaderCard(),
                BorderLayout.CENTER);

        startClock();
    }

    // =========================================================
    // HEADER CARD
    // =========================================================

    private JPanel createHeaderCard() {

        JPanel card = new JPanel(new BorderLayout());

        card.setBackground(Color.WHITE);

        card.setBorder(
                new EmptyBorder(
                        20,
                        30,
                        20,
                        30));

        card.add(
                createGreetingPanel(),
                BorderLayout.WEST);

        card.add(
                createProfilePanel(),
                BorderLayout.EAST);

        return card;
    }

    // =========================================================
    // GREETING
    // =========================================================

    private JPanel createGreetingPanel() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS));

        String firstName = "Driver";

        User user = SessionManager.getCurrentUser();

        if (user != null
                && user.getFullName() != null
                && !user.getFullName().isBlank()) {

            firstName = getFirstName(
                    user.getFullName());
        }

        JLabel hello = new JLabel(
                "Hello, " + firstName);

        hello.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        34));

        hello.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "Ready to accept rides and earn more today.");

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16));

        subtitle.setForeground(MUTED);

        panel.add(hello);

        panel.add(
                Box.createVerticalStrut(8));

        panel.add(subtitle);

        return panel;
    }

    // =========================================================
    // PROFILE AREA
    // =========================================================

    private JPanel createProfilePanel() {

        JPanel panel = new JPanel(
                new GridBagLayout());

        panel.setOpaque(false);

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;

        c.anchor = GridBagConstraints.CENTER;

        // -----------------------------------------------------
        // NOTIFICATION
        // -----------------------------------------------------

        JPanel notification = createNotificationButton();

        c.gridx = 0;

        c.insets = new Insets(
                0,
                0,
                0,
                25);

        panel.add(
                notification,
                c);

        // -----------------------------------------------------
        // USER
        // -----------------------------------------------------

        User user = SessionManager.getCurrentUser();

        String fullName = getFullName(user);

        // -----------------------------------------------------
        // AVATAR
        // -----------------------------------------------------

        AvatarButton avatar = new AvatarButton(fullName);

        avatar.setPreferredSize(
                new Dimension(54, 54));

        avatar.setMinimumSize(
                new Dimension(54, 54));

        avatar.setMaximumSize(
                new Dimension(54, 54));

        c.gridx = 1;

        c.insets = new Insets(
                0,
                0,
                0,
                15);

        panel.add(
                avatar,
                c);

        // -----------------------------------------------------
        // DRIVER INFO
        // -----------------------------------------------------

        JPanel info = createDriverInfo(
                fullName);

        c.gridx = 2;

        c.insets = new Insets(
                0,
                0,
                0,
                25);

        panel.add(
                info,
                c);

        // -----------------------------------------------------
        // DATE TIME
        // -----------------------------------------------------

        JPanel dateTime = createDateTimePanel();

        c.gridx = 3;

        c.insets = new Insets(
                0,
                0,
                0,
                0);

        panel.add(
                dateTime,
                c);

        // -----------------------------------------------------
        // PROFILE MENU
        // -----------------------------------------------------

        JPopupMenu profileMenu = createProfileMenu();

        avatar.addActionListener(e -> {

            profileMenu.show(
                    avatar,
                    avatar.getWidth()
                            - profileMenu
                                    .getPreferredSize().width,
                    avatar.getHeight() + 5);
        });

        return panel;
    }

    // =========================================================
    // NOTIFICATION
    // =========================================================

    private JPanel createNotificationButton() {

        JPanel panel = new JPanel(null);

        panel.setOpaque(false);

        panel.setPreferredSize(
                new Dimension(40, 40));

        JLabel bell = new JLabel(
                "🔔",
                SwingConstants.CENTER);

        bell.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        22));

        bell.setBounds(
                0,
                3,
                32,
                32);

        JLabel badge = new JLabel(
                "3",
                SwingConstants.CENTER);

        badge.setOpaque(true);

        badge.setBackground(
                new Color(
                        255,
                        59,
                        48));

        badge.setForeground(Color.WHITE);

        badge.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        9));

        badge.setBounds(
                22,
                0,
                15,
                15);

        panel.add(bell);
        panel.add(badge);

        return panel;
    }

    // =========================================================
    // DRIVER INFORMATION
    // =========================================================

    private JPanel createDriverInfo(
            String fullName) {

        JPanel info = new JPanel();

        info.setOpaque(false);

        info.setLayout(
                new BoxLayout(
                        info,
                        BoxLayout.Y_AXIS));

        info.setPreferredSize(
                new Dimension(
                        175,
                        82));

        info.setMinimumSize(
                new Dimension(
                        175,
                        82));

        // -----------------------------------------------------
        // NAME
        // -----------------------------------------------------

        JLabel name = new JLabel(fullName);

        name.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20));

        name.setForeground(TEXT);

        name.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        // -----------------------------------------------------
        // RATING
        // -----------------------------------------------------

        JPanel rating = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        4,
                        0));

        rating.setOpaque(false);

        rating.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        JLabel star = new JLabel("★");

        star.setForeground(
                new Color(
                        255,
                        180,
                        0));

        star.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14));

        JLabel ratingValue = new JLabel("4.8");

        ratingValue.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14));

        ratingValue.setForeground(TEXT);

        JLabel divider = new JLabel("|");

        divider.setForeground(
                new Color(
                        185,
                        185,
                        185));

        JLabel verified = new JLabel(
                "Verified Driver");

        verified.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        verified.setForeground(
                new Color(
                        105,
                        105,
                        105));

        rating.add(star);
        rating.add(ratingValue);
        rating.add(divider);
        rating.add(verified);

        // -----------------------------------------------------
        // ONLINE
        // -----------------------------------------------------

        JPanel online = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        5,
                        0));

        online.setOpaque(false);

        online.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        JLabel dot = new JLabel("●");

        dot.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        dot.setForeground(
                new Color(
                        0,
                        180,
                        80));

        JLabel onlineText = new JLabel("Online");

        onlineText.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15));

        onlineText.setForeground(
                new Color(
                        0,
                        160,
                        70));

        online.add(dot);
        online.add(onlineText);

        // -----------------------------------------------------
        // ADD COMPONENTS
        // -----------------------------------------------------

        info.add(name);

        info.add(
                Box.createVerticalStrut(3));

        info.add(rating);

        info.add(
                Box.createVerticalStrut(3));

        info.add(online);

        return info;
    }

    // =========================================================
    // DATE + TIME
    // =========================================================

    private JPanel createDateTimePanel() {

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS));

        panel.setPreferredSize(
                new Dimension(
                        110,
                        65));

        panel.setMinimumSize(
                new Dimension(
                        110,
                        65));

        dateLabel = new JLabel();

        dateLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15));

        dateLabel.setForeground(
                new Color(
                        65,
                        65,
                        65));

        dateLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        timeLabel = new JLabel();

        timeLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        timeLabel.setForeground(
                new Color(
                        0,
                        165,
                        75));

        timeLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT);

        panel.add(dateLabel);

        panel.add(
                Box.createVerticalStrut(5));

        panel.add(timeLabel);

        return panel;
    }

    // =========================================================
    // LIVE CLOCK
    // =========================================================

    private void startClock() {

        updateClock();

        Timer timer = new Timer(
                1000,
                e -> updateClock());

        timer.start();
    }

    private void updateClock() {

        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");

        SimpleDateFormat timeFormat = new SimpleDateFormat(
                "hh:mm:ss a");

        if (dateLabel != null) {

            dateLabel.setText(
                    dateFormat.format(now));
        }

        if (timeLabel != null) {

            timeLabel.setText(
                    "● "
                            + timeFormat.format(now));
        }
    }

    // =========================================================
    // PROFILE MENU
    // =========================================================

    private JPopupMenu createProfileMenu() {

        JPopupMenu menu = new JPopupMenu();

        menu.setBackground(Color.WHITE);

        menu.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                145,
                                165,
                                215)));

        menu.add(
                createMenuItem(
                        "View Profile"));

        menu.add(
                createMenuItem(
                        "Update Profile"));

        menu.add(
                createMenuItem(
                        "Change Password"));

        menu.add(
                createMenuItem(
                        "Settings"));

        menu.addSeparator();

        JMenuItem logout = createMenuItem(
                "Logout");

        menu.add(logout);

        logout.addActionListener(
                e -> logout());

        return menu;
    }

    // =========================================================
    // MENU ITEM
    // =========================================================

    private JMenuItem createMenuItem(
            String text) {

        JMenuItem item = new JMenuItem(text);

        item.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14));

        item.setForeground(
                new Color(
                        35,
                        35,
                        35));

        item.setBackground(Color.WHITE);

        item.setOpaque(true);

        item.setPreferredSize(
                new Dimension(
                        175,
                        32));

        item.setBorder(
                new EmptyBorder(
                        4,
                        8,
                        4,
                        8));

        return item;
    }

    // =========================================================
    // LOGOUT
    // =========================================================

    private void logout() {

        int result = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION);

        if (result != JOptionPane.YES_OPTION) {

            return;
        }

        SessionManager.logout();

        Window window = SwingUtilities
                .getWindowAncestor(this);

        if (window != null) {

            window.dispose();
        }

        SwingUtilities.invokeLater(
                () -> new com.gomon.ui.auth.LoginPage());
    }

    // =========================================================
    // HELPERS
    // =========================================================

    private String getFullName(User user) {

        if (user != null
                && user.getFullName() != null
                && !user.getFullName().isBlank()) {

            return user.getFullName().trim();
        }

        return "Driver";
    }

    private String getFirstName(
            String fullName) {

        String value = fullName.trim();

        int space = value.indexOf(' ');

        if (space > 0) {

            return value.substring(
                    0,
                    space);
        }

        return value;
    }
}