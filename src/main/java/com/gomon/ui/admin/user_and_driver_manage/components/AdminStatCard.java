package com.gomon.ui.admin.user_and_driver_manage.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class AdminStatCard extends ShadowCard {

    private final Color normalColor = Color.WHITE;
    private final Color hoverColor = new Color(248, 249, 255);

    public AdminStatCard(
            String icon,
            String title,
            String value,
            String footer,
            Color iconColor) {

        setLayout(new GridBagLayout());

        setCardColor(normalColor);

        setPreferredSize(new Dimension(0, 125));
        setMinimumSize(new Dimension(180, 125));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 125));

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
                        16,
                        16,
                        16,
                        16
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
                        54,
                        54
                )
        );

        iconPanel.setMinimumSize(
                new Dimension(
                        54,
                        54
                )
        );

        iconPanel.setMaximumSize(
                new Dimension(
                        54,
                        54
                )
        );

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        22
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
                        14,
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
                        Font.PLAIN,
                        12
                )
        );

        titleLabel.setForeground(
                new Color(
                        120,
                        120,
                        130
                )
        );

        // -------------------------------------------------
        // VALUE
        // -------------------------------------------------

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        valueLabel.setForeground(
                new Color(
                        30,
                        30,
                        40
                )
        );

        // -------------------------------------------------
        // FOOTER
        // -------------------------------------------------

        JLabel footerLabel =
                new JLabel(footer);

        footerLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        if (footer.contains("↑")) {

            footerLabel.setForeground(
                    new Color(
                            34,
                            197,
                            94
                    )
            );

        } else if (footer.contains("↓")) {

            footerLabel.setForeground(
                    new Color(
                            239,
                            68,
                            68
                    )
            );

        } else {

            footerLabel.setForeground(
                    new Color(
                            98,
                            71,
                            255
                    )
            );
        }

        // =================================================
        // ADD TEXT
        // =================================================

        textPanel.add(
                titleLabel
        );

        textPanel.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        textPanel.add(
                valueLabel
        );

        textPanel.add(
                javax.swing.Box.createVerticalStrut(5)
        );

        textPanel.add(
                footerLabel
        );

        // =================================================
        // ROOT ADD
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