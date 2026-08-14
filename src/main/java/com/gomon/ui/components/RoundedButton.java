package com.gomon.ui.components;

import com.gomon.utils.ColorPalette;
import com.gomon.utils.FontManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);

        setFont(FontManager.button());

        setForeground(Color.WHITE);

        setBackground(ColorPalette.BUTTON);

        setFocusPainted(false);

        setBorder(new EmptyBorder(12, 25, 12, 25));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {

    }
}