package com.gomon.ui.admin.user_and_driver_manage.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class AdminActionCard extends ShadowCard {

    private final Color normalColor = Color.WHITE;
    private final Color hoverColor = new Color(248, 249, 255);

    public AdminActionCard(
            String icon,
            String title,
            String description,
            Color iconColor) {

        setLayout(new GridBagLayout());

        setCardColor(normalColor);

        setPreferredSize(
                new Dimension(0, 95)
        );

        setMinimumSize(
                new Dimension(130, 95)
        );

        setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        95
                )
        );

        setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );

        // =================================================
        // ROOT
        // =================================================

        JPanel root = new JPanel();

        root.setOpaque(false);

        root.setLayout(
                new BoxLayout(
                        root,
                        BoxLayout.X_AXIS
                )
        );

        root.setBorder(
                new EmptyBorder(
                        12,
                        12,
                        12,
                        12
                )
        );

        // =================================================
        // ICON
        // =================================================

        JPanel iconPanel =
                new JPanel(
                        new GridBagLayout()
                );

        iconPanel.setBackground(
                iconColor
        );

        iconPanel.setPreferredSize(
                new Dimension(
                        48,
                        48
                )
        );

        iconPanel.setMinimumSize(
                new Dimension(
                        48,
                        48
                )
        );

        iconPanel.setMaximumSize(
                new Dimension(
                        48,
                        48
                )
        );

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        21
                )
        );

        iconLabel.setForeground(
                Color.WHITE
        );

        iconPanel.add(
                iconLabel
        );

        // =================================================
        // TEXT PANEL
        // =================================================

        JPanel textPanel =
                new JPanel();

        textPanel.setOpaque(false);

        textPanel.setLayout(
                new BoxLayout(
                        textPanel,
                        BoxLayout.Y_AXIS
                )
        );

        textPanel.setBorder(
                new EmptyBorder(
                        0,
                        12,
                        0,
                        0
                )
        );

        // -------------------------------------------------
        // TITLE
        // -------------------------------------------------

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        titleLabel.setForeground(
                new Color(
                        35,
                        35,
                        45
                )
        );

        titleLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // -------------------------------------------------
        // DESCRIPTION
        // -------------------------------------------------

        JLabel descriptionLabel =
                new JLabel(
                        "<html>"
                        + description
                        + "</html>"
                );

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        descriptionLabel.setForeground(
                new Color(
                        125,
                        125,
                        135
                )
        );

        descriptionLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // =================================================
        // ADD TEXT
        // =================================================

        textPanel.add(
                titleLabel
        );

        textPanel.add(
                Box.createVerticalStrut(5)
        );

        textPanel.add(
                descriptionLabel
        );

        // =================================================
        // ROOT
        // =================================================

        root.add(
                iconPanel
        );

        root.add(
                textPanel
        );

        // =================================================
        // GRID BAG
        // =================================================

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.fill =
                GridBagConstraints.BOTH;

        gbc.insets =
                new Insets(
                        0,
                        0,
                        0,
                        0
                );

        add(
                root,
                gbc
        );

        // =================================================
        // HOVER EFFECT
        // =================================================

        MouseAdapter hover =
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e) {

                        setCardColor(
                                hoverColor
                        );
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e) {

                        setCardColor(
                                normalColor
                        );
                    }
                };

        addMouseListener(hover);
        root.addMouseListener(hover);
        iconPanel.addMouseListener(hover);
        textPanel.addMouseListener(hover);
    }
}