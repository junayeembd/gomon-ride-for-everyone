package com.gomon.ui.user.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.ShadowCard;

public class WalletPanel extends ShadowCard {

    private RoundedButton addMoneyButton;

    public WalletPanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel(new BorderLayout(15, 0));
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(18, 18, 18, 18));

        // =====================================
        // Left Side
        // =====================================

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("GOMON Wallet");
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        title.setForeground(new Color(55, 55, 55));

        JLabel balance = new JLabel("৳ 1,250");
        balance.setFont(new Font("Segoe UI", Font.BOLD, 28));
        balance.setForeground(new Color(35, 35, 35));

        JLabel available = new JLabel("Available Balance");
        available.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        available.setForeground(new Color(120, 120, 120));

        addMoneyButton = new RoundedButton("+ Add Money");
        addMoneyButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addMoneyButton.setMaximumSize(new Dimension(160, 42));

        left.add(title);
        left.add(Box.createVerticalStrut(6));
        left.add(balance);
        left.add(Box.createVerticalStrut(4));
        left.add(available);
        left.add(Box.createVerticalGlue());
        left.add(addMoneyButton);

        // =====================================
        // Right Side
        // =====================================

        JPanel right = new JPanel(new GridBagLayout());
        right.setOpaque(false);

        JLabel walletIcon = new JLabel("💳");
        walletIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 46));

        right.add(walletIcon);

        root.add(left, BorderLayout.CENTER);
        root.add(right, BorderLayout.EAST);

        add(root, BorderLayout.CENTER);
    }

    public RoundedButton getAddMoneyButton() {
        return addMoneyButton;
    }
}