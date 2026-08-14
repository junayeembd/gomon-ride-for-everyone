package com.gomon.ui.components;

import java.awt.*;
import javax.swing.*;

public class NotificationButton extends JButton {

    private int notificationCount;

    public NotificationButton() {
        this(0);
    }

    public NotificationButton(int count) {

        this.notificationCount = count;

        setPreferredSize(new Dimension(50, 50));
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setNotificationCount(int count) {
        this.notificationCount = count;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2.setColor(Color.WHITE);
        g2.fillOval(2, 2, getWidth() - 4, getHeight() - 4);

        // Bell Icon
        g2.setColor(new Color(60, 60, 60));
        g2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        g2.drawString("🔔", 15, 30);

        // Notification Badge
        if (notificationCount > 0) {

            g2.setColor(new Color(234, 67, 53));
            g2.fillOval(getWidth() - 20, 5, 16, 16);

            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Segoe UI", Font.BOLD, 10));

            String txt = notificationCount > 99 ? "99+" : String.valueOf(notificationCount);

            FontMetrics fm = g2.getFontMetrics();

            int x = getWidth() - 20 + (16 - fm.stringWidth(txt)) / 2;
            int y = 17;

            g2.drawString(txt, x, y);

        }

        g2.dispose();

    }

}