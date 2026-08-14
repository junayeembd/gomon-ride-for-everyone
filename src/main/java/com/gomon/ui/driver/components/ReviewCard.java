package com.gomon.ui.driver.components;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReviewCard extends JPanel {

    public ReviewCard(String customer,
                      String rating,
                      String review) {

        setBackground(Color.WHITE);
        setOpaque(true);

        setBorder(new EmptyBorder(15,15,15,15));

        setPreferredSize(new Dimension(420,120));

        setLayout(new BorderLayout(15,0));

        add(createAvatar(customer), BorderLayout.WEST);
        add(createContent(customer, rating, review), BorderLayout.CENTER);

    }

    //--------------------------------------------------------

    private JLabel createAvatar(String customer){

        String letter = customer.substring(0,1).toUpperCase();

        JLabel avatar = new JLabel(letter,SwingConstants.CENTER);

        avatar.setPreferredSize(new Dimension(55,55));

        avatar.setOpaque(true);

        avatar.setBackground(new Color(98,71,255));

        avatar.setForeground(Color.WHITE);

        avatar.setFont(new Font("Segoe UI",Font.BOLD,22));

        return avatar;

    }

    //--------------------------------------------------------

    private JPanel createContent(String customer,
                                 String rating,
                                 String review){

        JPanel panel = new JPanel();

        panel.setOpaque(false);

        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel name = new JLabel(customer);

        name.setFont(new Font("Segoe UI",Font.BOLD,16));

        JLabel star = new JLabel("⭐ " + rating);

        star.setForeground(new Color(241,196,15));

        JLabel text = new JLabel("<html><body style='width:260px'>" +
                review +
                "</body></html>");

        text.setForeground(Color.GRAY);

        panel.add(name);
        panel.add(Box.createVerticalStrut(5));
        panel.add(star);
        panel.add(Box.createVerticalStrut(8));
        panel.add(text);

        return panel;

    }

}