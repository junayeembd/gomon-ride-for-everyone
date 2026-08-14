package com.gomon.ui.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ShadowCard extends JPanel {

    private int radius = 24;
    private int shadowSize = 8;

    private Color cardColor = Color.WHITE;
    private Color borderColor = new Color(232, 235, 240);
    private Color shadowColor = new Color(0, 0, 0, 18);

    public ShadowCard() {

        setOpaque(false);
        setLayout(new BorderLayout());

        /*
         * Reserve space for the shadow.
         * This prevents the content from being clipped.
         */
        setBorder(new EmptyBorder(0, 0, shadowSize, shadowSize));
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void setCardColor(Color color) {
        this.cardColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth() - shadowSize;
        int h = getHeight() - shadowSize;

        // Shadow

        g2.setColor(shadowColor);
        g2.fillRoundRect(
                4,
                4,
                w,
                h,
                radius,
                radius);

        // Card

        g2.setColor(cardColor);
        g2.fillRoundRect(
                0,
                0,
                w,
                h,
                radius,
                radius);

        // Border

        g2.setColor(borderColor);
        g2.drawRoundRect(
                0,
                0,
                w - 1,
                h - 1,
                radius,
                radius);

        g2.dispose();

        super.paintComponent(g);
    }
}