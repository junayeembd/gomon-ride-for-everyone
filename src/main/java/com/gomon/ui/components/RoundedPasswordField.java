package com.gomon.ui.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedPasswordField extends JPasswordField {

    private String placeholder = "";

    public RoundedPasswordField() {
        this(20);
    }

    public RoundedPasswordField(int columns) {

        super(columns);

        setFont(new Font("Segoe UI", Font.PLAIN, 16));
        setBorder(new EmptyBorder(10, 15, 10, 15));
        setOpaque(false);
        setForeground(new Color(33, 33, 33));
        setCaretColor(new Color(0, 150, 136));
        setBackground(Color.WHITE);

        addFocusListener(new java.awt.event.FocusAdapter() {

            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                repaint();
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                repaint();
            }

        });

    }

    public void setPlaceholder(String placeholder) {

        this.placeholder = placeholder;

        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        super.paintComponent(g);

        if (getPassword().length == 0 && !isFocusOwner()) {

            Graphics2D g3 = (Graphics2D) g.create();

            g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g3.setColor(new Color(170, 170, 170));

            g3.setFont(getFont());

            Insets insets = getInsets();

            FontMetrics fm = g3.getFontMetrics();

            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g3.drawString(placeholder, insets.left, y);

            g3.dispose();

        }

        g2.dispose();

    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (isFocusOwner()) {
            g2.setColor(new Color(0, 150, 136));
        } else {
            g2.setColor(new Color(210, 210, 210));
        }

        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        g2.dispose();

    }

}