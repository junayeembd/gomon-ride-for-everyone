package com.gomon.ui.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class RoundedComboBox<E> extends JComboBox<E> {

    public RoundedComboBox() {

        setOpaque(false);

        setBackground(Color.WHITE);

        setForeground(new Color(40, 40, 40));

        setFont(new Font("Segoe UI", Font.PLAIN, 14));

        setBorder(new EmptyBorder(8, 14, 8, 14));

        setFocusable(false);

        setRenderer(new RoundedRenderer());

        setUI(new RoundedUI());

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
                getWidth() - 1,
                getHeight() - 1,
                20,
                20);

        super.paintComponent(g);

        g2.dispose();

    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(210, 210, 210));

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                20,
                20);

        g2.dispose();

    }

    private static class RoundedRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(
                JList<?> list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list,
                    value,
                    index,
                    isSelected,
                    cellHasFocus);

            label.setBorder(new EmptyBorder(8, 12, 8, 12));

            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            if (isSelected) {

                label.setBackground(new Color(235, 240, 255));

            } else {

                label.setBackground(Color.WHITE);

            }

            return label;

        }

    }

    private static class RoundedUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {

            JButton button = new JButton("▼");

            button.setBorder(BorderFactory.createEmptyBorder());

            button.setContentAreaFilled(false);

            button.setFocusable(false);

            button.setFont(new Font("Segoe UI", Font.PLAIN, 11));

            return button;

        }

    }

}