package com.gomon.ui.driver.components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class StatisticCard extends ShadowCard {

    private final Color normalColor = Color.WHITE;
    private final Color hoverColor = new Color(247, 248, 252);

    public StatisticCard(
            String icon,
            String title,
            String value,
            String footer,
            Color iconColor) {

        setLayout(new BorderLayout());
        setCardColor(normalColor);

        setPreferredSize(new Dimension(0, 125));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 125));
        setMinimumSize(new Dimension(220, 125));

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel root = new JPanel(new BorderLayout(16, 0));
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(18, 18, 18, 18));

        //=========================================
        // Icon
        //=========================================

        JPanel iconContainer = new JPanel(new GridBagLayout());
        iconContainer.setOpaque(false);

        JPanel iconPanel = new JPanel(new GridBagLayout());

        iconPanel.setBackground(iconColor);
        iconPanel.setPreferredSize(new Dimension(58, 58));
        iconPanel.setMaximumSize(new Dimension(58, 58));

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setForeground(Color.WHITE);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));

        iconPanel.add(iconLabel);

        iconContainer.add(iconPanel);

        //=========================================
        // Text
        //=========================================

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        titleLabel.setForeground(new Color(120,120,120));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        valueLabel.setForeground(new Color(30,30,30));

        JLabel footerLabel = new JLabel(footer);
        footerLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        if(title.contains("Rating")){

            footerLabel.setForeground(new Color(98,71,255));

        }else if(title.contains("Ride")){

            footerLabel.setForeground(new Color(98,71,255));

        }else if(title.contains("Earnings")){

            footerLabel.setForeground(new Color(39,174,96));

        }else{

            footerLabel.setForeground(new Color(52,152,219));

        }

        text.add(titleLabel);
        text.add(Box.createVerticalStrut(8));
        text.add(valueLabel);
        text.add(Box.createVerticalStrut(8));
        text.add(footerLabel);

        //=========================================

        root.add(iconContainer, BorderLayout.WEST);
        root.add(text, BorderLayout.CENTER);

        add(root, BorderLayout.CENTER);

        //=========================================
        // Hover
        //=========================================

        MouseAdapter hover = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                setCardColor(hoverColor);

            }

            @Override
            public void mouseExited(MouseEvent e) {

                setCardColor(normalColor);

            }

        };

        addMouseListener(hover);
        root.addMouseListener(hover);

    }

}