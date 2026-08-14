package com.gomon.ui.components;

import java.awt.*;
import javax.swing.*;

public class AvatarButton extends JButton {

    public AvatarButton(String name) {

        setText(getInitials(name));

        setPreferredSize(new Dimension(45, 45));

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);

        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 16));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private String getInitials(String name) {

        if (name == null || name.isBlank())
            return "G";

        String[] p = name.trim().split("\\s+");

        if (p.length == 1)
            return p[0].substring(0, 1).toUpperCase();

        return (p[0].substring(0, 1) + p[1].substring(0, 1)).toUpperCase();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(98, 71, 255));

        g2.fillOval(0, 0, getWidth() - 1, getHeight() - 1);

        super.paintComponent(g);

        g2.dispose();
    }

}