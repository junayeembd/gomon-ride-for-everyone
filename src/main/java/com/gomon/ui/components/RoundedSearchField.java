package com.gomon.ui.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoundedSearchField extends JTextField {

    private final String placeholder;

    public RoundedSearchField(String placeholder) {

        this.placeholder = placeholder;

        setOpaque(false);

        setBorder(new EmptyBorder(10, 45, 10, 15));

        setFont(new Font("Segoe UI", Font.PLAIN, 15));

        setPreferredSize(new Dimension(350, 45));

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.WHITE);

        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                25,
                25);

        super.paintComponent(g);

        if (getText().isEmpty() && !isFocusOwner()) {

            g2.setColor(Color.GRAY);

            g2.drawString(
                    "🔍 " + placeholder,
                    18,
                    28);

        }

        g2.dispose();

    }

}