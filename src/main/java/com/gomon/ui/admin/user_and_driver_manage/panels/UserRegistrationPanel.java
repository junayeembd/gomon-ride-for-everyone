package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class UserRegistrationPanel extends ShadowCard {

    public UserRegistrationPanel() {

        setLayout(new BorderLayout());

        setCardColor(Color.WHITE);

        setPreferredSize(new Dimension(0, 330));
        setMinimumSize(new Dimension(400, 330));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 330));

        // =================================================
        // ROOT
        // =================================================

        JPanel root = new JPanel(new BorderLayout());

        root.setOpaque(false);

        root.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );

        // =================================================
        // HEADER
        // =================================================

        JPanel header = new JPanel(new BorderLayout());

        header.setOpaque(false);

        // -----------------------------------------------
        // LEFT TITLE
        // -----------------------------------------------

        JPanel titlePanel = new JPanel();

        titlePanel.setOpaque(false);

        titlePanel.setLayout(
                new BoxLayout(
                        titlePanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "User Registration Overview"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        title.setForeground(
                new Color(
                        35,
                        35,
                        45
                )
        );

        JLabel subtitle =
                new JLabel(
                        "New user registrations"
                );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        subtitle.setForeground(
                new Color(
                        130,
                        130,
                        140
                )
        );

        titlePanel.add(title);

        titlePanel.add(
                Box.createVerticalStrut(4)
        );

        titlePanel.add(subtitle);

        // -----------------------------------------------
        // RIGHT DROPDOWN
        // -----------------------------------------------

        JComboBox<String> period =
                new JComboBox<>(
                        new String[] {
                                "This Month",
                                "Last Month",
                                "Last 3 Months"
                        }
                );

        period.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        period.setPreferredSize(
                new Dimension(
                        120,
                        32
                )
        );

        period.setFocusable(false);

        // -----------------------------------------------
        // ADD HEADER
        // -----------------------------------------------

        header.add(
                titlePanel,
                BorderLayout.WEST
        );

        header.add(
                period,
                BorderLayout.EAST
        );

        root.add(
                header,
                BorderLayout.NORTH
        );

        // =================================================
        // CHART
        // =================================================

        JPanel chart =
                new RegistrationChart();

        root.add(
                chart,
                BorderLayout.CENTER
        );

        // =================================================
        // TOTAL
        // =================================================

        JPanel totalPanel =
                new JPanel(
                        new BorderLayout()
                );

        totalPanel.setOpaque(false);

        JLabel totalText =
                new JLabel(
                        "Total Registrations"
                );

        totalText.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        totalText.setForeground(
                new Color(
                        125,
                        125,
                        135
                )
        );

        JLabel totalValue =
                new JLabel(
                        "2,430"
                );

        totalValue.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        totalValue.setForeground(
                new Color(
                        98,
                        71,
                        255
                )
        );

        totalPanel.add(
                totalText,
                BorderLayout.WEST
        );

        totalPanel.add(
                totalValue,
                BorderLayout.EAST
        );

        root.add(
                totalPanel,
                BorderLayout.SOUTH
        );

        add(
                root,
                BorderLayout.CENTER
        );
    }

    // =====================================================
    // CHART
    // =====================================================

    private static class RegistrationChart
            extends JPanel {

        private final int[] values = {
                180,
                230,
                210,
                320,
                280,
                390,
                350,
                430,
                400,
                520,
                470,
                580
        };

        private final String[] labels = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
        };

        public RegistrationChart() {

            setOpaque(false);

            setPreferredSize(
                    new Dimension(
                            500,
                            220
                    )
            );
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            int width = getWidth();
            int height = getHeight();

            int left = 45;
            int right = 15;
            int top = 15;
            int bottom = 30;

            int chartWidth =
                    width - left - right;

            int chartHeight =
                    height - top - bottom;

            // =========================================
            // GRID
            // =========================================

            g2.setStroke(
                    new BasicStroke(
                            1f
                    )
            );

            g2.setColor(
                    new Color(
                            235,
                            235,
                            240
                    )
            );

            int gridLines = 4;

            for (int i = 0; i <= gridLines; i++) {

                int y =
                        top
                        + (chartHeight * i)
                        / gridLines;

                g2.drawLine(
                        left,
                        y,
                        width - right,
                        y
                );

                int value =
                        600
                        - (600 * i)
                        / gridLines;

                g2.setColor(
                        new Color(
                                135,
                                135,
                                145
                        )
                );

                g2.setFont(
                        new Font(
                                "Segoe UI",
                                Font.PLAIN,
                                10
                        )
                );

                g2.drawString(
                        String.valueOf(value),
                        8,
                        y + 4
                );

                g2.setColor(
                        new Color(
                                235,
                                235,
                                240
                        )
                );
            }

            // =========================================
            // LINE
            // =========================================

            Path2D path =
                    new Path2D.Double();

            for (int i = 0;
                 i < values.length;
                 i++) {

                double x =
                        left
                        + (double) i
                        / (values.length - 1)
                        * chartWidth;

                double y =
                        top
                        + chartHeight
                        - (double) values[i]
                        / 600
                        * chartHeight;

                if (i == 0) {

                    path.moveTo(
                            x,
                            y
                    );

                } else {

                    path.lineTo(
                            x,
                            y
                    );
                }
            }

            g2.setColor(
                    new Color(
                            98,
                            71,
                            255
                    )
            );

            g2.setStroke(
                    new BasicStroke(
                            3f,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    )
            );

            g2.draw(path);

            // =========================================
            // POINTS
            // =========================================

            for (int i = 0;
                 i < values.length;
                 i++) {

                int x =
                        (int) (
                                left
                                + (double) i
                                / (values.length - 1)
                                * chartWidth
                        );

                int y =
                        (int) (
                                top
                                + chartHeight
                                - (double) values[i]
                                / 600
                                * chartHeight
                        );

                g2.setColor(Color.WHITE);

                g2.fillOval(
                        x - 5,
                        y - 5,
                        10,
                        10
                );

                g2.setColor(
                        new Color(
                                98,
                                71,
                                255
                        )
                );

                g2.fillOval(
                        x - 4,
                        y - 4,
                        8,
                        8
                );

                // =====================================
                // LABEL
                // =====================================

                g2.setColor(
                        new Color(
                                120,
                                120,
                                130
                        )
                );

                g2.setFont(
                        new Font(
                                "Segoe UI",
                                Font.PLAIN,
                                10
                        )
                );

                String label =
                        labels[i];

                int labelWidth =
                        g2.getFontMetrics()
                                .stringWidth(label);

                g2.drawString(
                        label,
                        x - labelWidth / 2,
                        height - 8
                );
            }

            g2.dispose();
        }
    }
}