package com.gomon.ui.superadmin;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SuperAdminHeaderPanel extends JPanel {

        private static final Color TEXT = new Color(28, 31, 40);

        private static final Color MUTED = new Color(120, 125, 135);

        private static final Color PURPLE = new Color(98, 71, 255);

        private static final Color BORDER = new Color(225, 228, 235);

        public SuperAdminHeaderPanel() {

                setOpaque(false);

                setLayout(
                                new BorderLayout());

                setPreferredSize(
                                new Dimension(
                                                0,
                                                118));

                add(
                                createWelcomePanel(),
                                BorderLayout.WEST);

                add(
                                createRightPanel(),
                                BorderLayout.EAST);
        }

        // =========================================================
        // WELCOME
        // =========================================================

        private JPanel createWelcomePanel() {

                JPanel panel = new JPanel();

                panel.setOpaque(false);

                panel.setLayout(
                                new BoxLayout(
                                                panel,
                                                BoxLayout.Y_AXIS));

                JLabel title = new JLabel(
                                "Welcome, Super Admin!");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                29));

                title.setForeground(
                                TEXT);

                JLabel subtitle = new JLabel(
                                "Here's what's happening in GOMON today.");

                subtitle.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                14));

                subtitle.setForeground(
                                MUTED);

                panel.add(title);

                panel.add(
                                Box.createVerticalStrut(6));

                panel.add(subtitle);

                return panel;
        }

        // =========================================================
        // RIGHT
        // =========================================================

        private JPanel createRightPanel() {

                JPanel panel = new JPanel(
                                new FlowLayout(
                                                FlowLayout.RIGHT,
                                                12,
                                                0));

                panel.setOpaque(false);

                panel.add(
                                createSearchPanel());

                panel.add(
                                createWalletPanel());

                panel.add(
                                createNotificationButton());

                panel.add(
                                createProfileButton());

                return panel;
        }

        // =========================================================
        // SEARCH
        // =========================================================

        private JPanel createSearchPanel() {

                JPanel panel = new JPanel(
                                new BorderLayout(
                                                8,
                                                0));

                panel.setBackground(
                                Color.WHITE);

                panel.setPreferredSize(
                                new Dimension(
                                                300,
                                                46));

                panel.setBorder(
                                BorderFactory.createCompoundBorder(
                                                BorderFactory.createLineBorder(
                                                                BORDER),
                                                new EmptyBorder(
                                                                0,
                                                                12,
                                                                0,
                                                                12)));

                JLabel icon = new JLabel("⌕");

                icon.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                22));

                icon.setForeground(
                                new Color(
                                                120,
                                                125,
                                                135));

                JTextField search = new JTextField();

                search.setBorder(null);

                search.setOpaque(false);

                search.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                search.putClientProperty(
                                "JTextField.placeholderText",
                                "Search users, drivers, rides, locations...");

                panel.add(
                                icon,
                                BorderLayout.WEST);

                panel.add(
                                search,
                                BorderLayout.CENTER);

                return panel;
        }

        // =========================================================
        // WALLET
        // =========================================================

        private JPanel createWalletPanel() {

                JPanel wallet = new JPanel(
                                new BorderLayout(
                                                10,
                                                0));

                wallet.setBackground(
                                PURPLE);

                wallet.setPreferredSize(
                                new Dimension(
                                                190,
                                                58));

                wallet.setBorder(
                                new EmptyBorder(
                                                7,
                                                14,
                                                7,
                                                12));

                JPanel text = new JPanel();

                text.setOpaque(false);

                text.setLayout(
                                new BoxLayout(
                                                text,
                                                BoxLayout.Y_AXIS));

                JLabel title = new JLabel(
                                "System Wallet");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                11));

                title.setForeground(
                                new Color(
                                                225,
                                                220,
                                                255));

                JLabel balance = new JLabel(
                                "৳ 250,750.50");

                balance.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                17));

                balance.setForeground(
                                Color.WHITE);

                text.add(title);

                text.add(
                                Box.createVerticalStrut(2));

                text.add(balance);

                WalletIcon icon = new WalletIcon();

                wallet.add(
                                text,
                                BorderLayout.CENTER);

                wallet.add(
                                icon,
                                BorderLayout.EAST);

                return wallet;
        }

        // =========================================================
        // NOTIFICATION
        // =========================================================

        private JPanel createNotificationButton() {

                JPanel wrapper = new JPanel(
                                new BorderLayout());

                wrapper.setOpaque(false);

                wrapper.setPreferredSize(
                                new Dimension(
                                                48,
                                                52));

                NotificationButton bell = new NotificationButton();

                wrapper.add(
                                bell,
                                BorderLayout.CENTER);

                return wrapper;
        }

        // =========================================================
        // PROFILE
        // =========================================================

        private JPanel createProfileButton() {

                JPanel panel = new JPanel();

                panel.setOpaque(false);

                panel.setLayout(
                                new BoxLayout(
                                                panel,
                                                BoxLayout.X_AXIS));

                AvatarButton avatar = new AvatarButton();

                JPanel information = new JPanel();

                information.setOpaque(false);

                information.setLayout(
                                new BoxLayout(
                                                information,
                                                BoxLayout.Y_AXIS));

                JLabel name = new JLabel(
                                "Super Admin");

                name.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                14));

                name.setForeground(
                                TEXT);

                JLabel role = new JLabel(
                                "Super Administrator");

                role.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                11));

                role.setForeground(
                                MUTED);

                information.add(
                                name);

                information.add(
                                Box.createVerticalStrut(3));

                information.add(
                                role);

                JButton arrow = new JButton("⌄");

                arrow.setBorderPainted(false);

                arrow.setContentAreaFilled(false);

                arrow.setFocusPainted(false);

                arrow.setCursor(
                                Cursor.getPredefinedCursor(
                                                Cursor.HAND_CURSOR));

                arrow.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                16));

                avatar.addActionListener(
                                e -> showProfilePopup(
                                                avatar));

                arrow.addActionListener(
                                e -> showProfilePopup(
                                                arrow));

                panel.add(
                                avatar);

                panel.add(
                                Box.createHorizontalStrut(9));

                panel.add(
                                information);

                panel.add(
                                arrow);

                return panel;
        }

        // =========================================================
        // PROFILE POPUP
        // =========================================================

        private void showProfilePopup(
                        Component invoker) {

                JPopupMenu popup = new JPopupMenu();

                popup.setBorder(
                                BorderFactory.createLineBorder(
                                                new Color(
                                                                215,
                                                                218,
                                                                225)));

                popup.add(
                                createPopupItem(
                                                "View Profile"));

                popup.add(
                                createPopupItem(
                                                "Update Profile"));

                popup.add(
                                createPopupItem(
                                                "Change Password"));

                popup.addSeparator();

                popup.add(
                                createPopupItem(
                                                "Settings"));

                popup.addSeparator();

                JMenuItem logout = createPopupItem(
                                "Logout");

                logout.setForeground(
                                new Color(
                                                220,
                                                60,
                                                60));

                popup.add(
                                logout);

                popup.pack();

                popup.show(
                                invoker,
                                invoker.getWidth() - 170,
                                invoker.getHeight() + 7);
        }

        private JMenuItem createPopupItem(
                        String text) {

                JMenuItem item = new JMenuItem(
                                text);

                item.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                item.setBorder(
                                new EmptyBorder(
                                                8,
                                                12,
                                                8,
                                                12));

                return item;
        }

        // =========================================================
        // CUSTOM AVATAR
        // =========================================================

        private static class AvatarButton
                        extends JButton {

                public AvatarButton() {

                        setPreferredSize(
                                        new Dimension(
                                                        50,
                                                        50));

                        setMinimumSize(
                                        new Dimension(
                                                        50,
                                                        50));

                        setMaximumSize(
                                        new Dimension(
                                                        50,
                                                        50));

                        setBorderPainted(false);

                        setContentAreaFilled(false);

                        setFocusPainted(false);

                        setOpaque(false);

                        setCursor(
                                        Cursor.getPredefinedCursor(
                                                        Cursor.HAND_CURSOR));
                }

                @Override
                protected void paintComponent(
                                Graphics g) {

                        Graphics2D g2 = (Graphics2D) g.create();

                        g2.setRenderingHint(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);

                        g2.setColor(
                                        new Color(
                                                        42,
                                                        63,
                                                        92));

                        g2.fillOval(
                                        2,
                                        2,
                                        getWidth() - 4,
                                        getHeight() - 4);

                        g2.setColor(
                                        Color.WHITE);

                        g2.setFont(
                                        new Font(
                                                        "Segoe UI",
                                                        Font.BOLD,
                                                        14));

                        String text = "SA";

                        int width = g2.getFontMetrics()
                                        .stringWidth(text);

                        int x = (getWidth() - width) / 2;

                        int y = (getHeight() + 5) / 2;

                        g2.drawString(
                                        text,
                                        x,
                                        y);

                        g2.dispose();
                }
        }

        // =========================================================
        // NOTIFICATION ICON
        // =========================================================

        private static class NotificationButton
                        extends JButton {

                public NotificationButton() {

                        setPreferredSize(
                                        new Dimension(
                                                        48,
                                                        48));

                        setBorderPainted(false);

                        setContentAreaFilled(false);

                        setFocusPainted(false);

                        setOpaque(false);

                        setCursor(
                                        Cursor.getPredefinedCursor(
                                                        Cursor.HAND_CURSOR));
                }

                @Override
                protected void paintComponent(
                                Graphics g) {

                        Graphics2D g2 = (Graphics2D) g.create();

                        g2.setRenderingHint(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);

                        int cx = getWidth() / 2;

                        g2.setColor(
                                        new Color(
                                                        45,
                                                        45,
                                                        52));

                        g2.setStroke(
                                        new BasicStroke(
                                                        2f));

                        // bell body
                        g2.drawArc(
                                        cx - 9,
                                        11,
                                        18,
                                        21,
                                        0,
                                        180);

                        g2.drawLine(
                                        cx - 9,
                                        20,
                                        cx - 9,
                                        29);

                        g2.drawLine(
                                        cx + 9,
                                        20,
                                        cx + 9,
                                        29);

                        g2.drawLine(
                                        cx - 12,
                                        29,
                                        cx + 12,
                                        29);

                        g2.drawArc(
                                        cx - 3,
                                        27,
                                        6,
                                        6,
                                        0,
                                        -180);

                        // notification badge
                        g2.setColor(
                                        new Color(
                                                        239,
                                                        68,
                                                        68));

                        g2.fillOval(
                                        cx + 5,
                                        6,
                                        14,
                                        14);

                        g2.setColor(
                                        Color.WHITE);

                        g2.setFont(
                                        new Font(
                                                        "Segoe UI",
                                                        Font.BOLD,
                                                        9));

                        g2.drawString(
                                        "3",
                                        cx + 9,
                                        17);

                        g2.dispose();
                }
        }

        // =========================================================
        // WALLET ICON
        // =========================================================

        private static class WalletIcon
                        extends JPanel {

                public WalletIcon() {

                        setOpaque(false);

                        setPreferredSize(
                                        new Dimension(
                                                        32,
                                                        42));
                }

                @Override
                protected void paintComponent(
                                Graphics g) {

                        Graphics2D g2 = (Graphics2D) g.create();

                        g2.setRenderingHint(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);

                        int w = getWidth();
                        int h = getHeight();

                        g2.setColor(Color.WHITE);

                        g2.setStroke(
                                        new BasicStroke(
                                                        2f));

                        RoundRectangle2D wallet = new RoundRectangle2D.Double(
                                        3,
                                        10,
                                        w - 8,
                                        20,
                                        4,
                                        4);

                        g2.draw(wallet);

                        g2.drawRoundRect(
                                        10,
                                        15,
                                        w - 13,
                                        10,
                                        3,
                                        3);

                        g2.fillOval(
                                        w - 11,
                                        18,
                                        4,
                                        4);

                        g2.dispose();
                }
        }
}