package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class AdminSafetyPanel extends ShadowCard {

    private final Color PURPLE = new Color(98, 71, 255);

    public AdminSafetyPanel() {

        setLayout(new BorderLayout());

        setCardColor(Color.WHITE);

        setPreferredSize(
                new Dimension(0, 150)
        );

        setMinimumSize(
                new Dimension(300, 150)
        );

        setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        150
                )
        );

        // =========================================
        // ROOT
        // =========================================

        JPanel root =
                new JPanel(new BorderLayout());

        root.setOpaque(false);

        root.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );

        // =========================================
        // LEFT CONTENT
        // =========================================

        JPanel content =
                new JPanel();

        content.setOpaque(false);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        // =========================================
        // TITLE
        // =========================================

        JLabel title =
                new JLabel(
                        "Keep your platform safe!"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );

        title.setForeground(
                new Color(
                        35,
                        35,
                        45
                )
        );

        title.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // =========================================
        // DESCRIPTION
        // =========================================

        JLabel description =
                new JLabel(
                        "<html>"
                        + "Verify driver documents and monitor "
                        + "suspicious activities regularly."
                        + "</html>"
                );

        description.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        description.setForeground(
                new Color(
                        120,
                        120,
                        130
                )
        );

        description.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // =========================================
        // ADD
        // =========================================

        content.add(title);

        content.add(
                Box.createVerticalStrut(7)
        );

        content.add(description);

        root.add(
                content,
                BorderLayout.CENTER
        );

        // =========================================
        // ACTION BUTTON
        // =========================================

        JButton button =
                new JButton(
                        "Review Now"
                );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setBackground(
                PURPLE
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        button.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setPreferredSize(
                new Dimension(
                        105,
                        38
                )
        );

        button.setMaximumSize(
                new Dimension(
                        105,
                        38
                )
        );

        root.add(
                button,
                BorderLayout.EAST
        );

        // =========================================
        // BORDER
        // =========================================

        setBorder(
                BorderFactory.createEmptyBorder()
        );

        add(
                root,
                BorderLayout.CENTER
        );
    }
}