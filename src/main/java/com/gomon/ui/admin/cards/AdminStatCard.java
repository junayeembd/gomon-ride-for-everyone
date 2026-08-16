package com.gomon.ui.admin.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminStatCard extends JPanel {

    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = new Color(105, 105, 125);
    private static final Color VALUE_COLOR = new Color(30, 30, 45);

    public AdminStatCard(
            String title,
            String value,
            String subtitle) {

        setPreferredSize(new Dimension(230, 125));
        setBackground(CARD_COLOR);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(230, 232, 238)),
                BorderFactory.createEmptyBorder(
                        18, 20, 18, 20)));

        setLayout(new BorderLayout(0, 8));

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 13));

        titleLabel.setForeground(TITLE_COLOR);

        JLabel valueLabel = new JLabel(value);

        valueLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 27));

        valueLabel.setForeground(VALUE_COLOR);

        JLabel subtitleLabel = new JLabel(subtitle);

        subtitleLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 11));

        subtitleLabel.setForeground(
                new Color(145, 145, 160));

        JPanel top = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        0,
                        0));

        top.setOpaque(false);
        top.add(titleLabel);

        JPanel center = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        0,
                        0));

        center.setOpaque(false);
        center.add(valueLabel);

        JPanel bottom = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        0,
                        0));

        bottom.setOpaque(false);
        bottom.add(subtitleLabel);

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}