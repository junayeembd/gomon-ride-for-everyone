package com.gomon.ui.components.Dashboard;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DashboardTextField extends JTextField {

    private int radius = 18;
    private String placeholder = "";

    public DashboardTextField() {

        setOpaque(false);

        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        setForeground(new Color(40, 40, 40));

        setCaretColor(new Color(0, 150, 136));

        setBorder(new EmptyBorder(0, 15, 0, 15));

        setPreferredSize(new Dimension(100, 42));
        setMinimumSize(new Dimension(100, 42));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (isEnabled()) {
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(new Color(245, 245, 245));
        }

        g2.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius);

        super.paintComponent(g);

        if (getText().isEmpty() && !isFocusOwner()) {

            g2.setColor(new Color(170, 170, 170));

            FontMetrics fm = g2.getFontMetrics();

            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(placeholder, 15, y);
        }

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (isFocusOwner()) {
            g2.setColor(new Color(0, 150, 136));
        } else {
            g2.setColor(new Color(220, 225, 230));
        }

        g2.draw(new RoundRectangle2D.Double(
                0.5,
                0.5,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius));

        g2.dispose();
    }
}