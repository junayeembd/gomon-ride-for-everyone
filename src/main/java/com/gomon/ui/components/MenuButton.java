package com.gomon.ui.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuButton extends JButton {

    private boolean selected = false;

    private final Color NORMAL = new Color(18, 16, 70);
    private final Color HOVER = new Color(76, 54, 220);
    private final Color SELECTED = new Color(98, 71, 255);

    public MenuButton(String text, Icon icon) {

        super(text, icon);

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setFocusPainted(false);
        setRolloverEnabled(true);

        setPreferredSize(new Dimension(220, 50));
        setMaximumSize(new Dimension(220, 50));

        setForeground(Color.WHITE);

        setFont(new Font("Segoe UI", Font.BOLD, 15));

        setHorizontalAlignment(SwingConstants.LEFT);

        setIconTextGap(15);

        setBorder(new EmptyBorder(14, 22, 14, 22));

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                if (!selected) {
                    setBackground(HOVER);
                    setOpaque(true);
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (!selected) {
                    setOpaque(false);
                    setBackground(NORMAL);
                }

            }

        });

    }

    public void setSelectedMenu(boolean value) {

        selected = value;

        if (selected) {

            setOpaque(true);
            setBackground(SELECTED);

        } else {

            setOpaque(false);
            setBackground(NORMAL);

        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (selected) {

            g2.setColor(SELECTED);

            g2.fillRoundRect(
                    6,
                    2,
                    getWidth() - 12,
                    getHeight() - 4,
                    18,
                    18);

            g2.setColor(Color.WHITE);

            g2.fillRoundRect(
                    0,
                    10,
                    5,
                    getHeight() - 20,
                    10,
                    10);

        } else if (getModel().isRollover()) {

            g2.setColor(HOVER);

            g2.fillRoundRect(
                    6,
                    2,
                    getWidth() - 12,
                    getHeight() - 4,
                    18,
                    18);
        }

        g2.dispose();

        super.paintComponent(g);
    }

}