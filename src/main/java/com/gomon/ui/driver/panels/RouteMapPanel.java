package com.gomon.ui.driver.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class RouteMapPanel extends ShadowCard {

    public RouteMapPanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel(new BorderLayout(0, 18));
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(18,18,18,18));

        //-------------------------------------------------
        // Title
        //-------------------------------------------------

        JLabel title = new JLabel("Live Route Map");

        title.setFont(new Font("Segoe UI",Font.BOLD,20));

        root.add(title,BorderLayout.NORTH);

        //-------------------------------------------------
        // Map Area
        //-------------------------------------------------

        JPanel map = new JPanel(new BorderLayout());

        map.setPreferredSize(new Dimension(760,460));

        map.setBackground(new Color(242,245,250));

        map.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(225,225,225)),
                new EmptyBorder(10,10,10,10)));

        JLabel placeholder = new JLabel(
                "<html><center><h2>Google Map</h2><br>Route Preview</center></html>",
                SwingConstants.CENTER);

        placeholder.setFont(new Font("Segoe UI",Font.PLAIN,20));

        placeholder.setForeground(Color.GRAY);

        map.add(placeholder,BorderLayout.CENTER);

        root.add(map,BorderLayout.CENTER);

        //-------------------------------------------------
        // Bottom Details
        //-------------------------------------------------

        JPanel bottom = new JPanel(new GridLayout(1,5,10,0));

        bottom.setOpaque(false);

        bottom.add(createCard("📍","Pickup","Mirpur DOHS"));

        bottom.add(createCard("🏁","Drop","Banani"));

        bottom.add(createCard("💵","Payment","Cash"));

        bottom.add(createCard("📏","Distance","8.5 km"));

        bottom.add(createCard("⏱","ETA","18 min"));

        root.add(bottom,BorderLayout.SOUTH);

        add(root,BorderLayout.CENTER);

    }

    //---------------------------------------------------------

    private JPanel createCard(String icon,
                              String title,
                              String value){

        JPanel card=new JPanel();

        card.setBackground(new Color(248,249,252));

        card.setBorder(BorderFactory.createLineBorder(
                new Color(230,230,230)));

        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));

        card.setPreferredSize(new Dimension(120,85));

        card.setBorder(new EmptyBorder(12,12,12,12));

        JLabel iconLabel=new JLabel(icon);

        iconLabel.setFont(new Font("Segoe UI Emoji",Font.PLAIN,18));

        JLabel titleLabel=new JLabel(title);

        titleLabel.setForeground(Color.GRAY);

        titleLabel.setFont(new Font("Segoe UI",Font.PLAIN,12));

        JLabel valueLabel=new JLabel(value);

        valueLabel.setFont(new Font("Segoe UI",Font.BOLD,14));

        valueLabel.setForeground(new Color(35,35,35));

        card.add(iconLabel);

        card.add(Box.createVerticalStrut(6));

        card.add(titleLabel);

        card.add(Box.createVerticalStrut(5));

        card.add(valueLabel);

        return card;

    }

}