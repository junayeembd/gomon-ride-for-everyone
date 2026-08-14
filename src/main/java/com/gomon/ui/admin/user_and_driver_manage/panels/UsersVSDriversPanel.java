package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class UsersVSDriversPanel extends ShadowCard {

    public UsersVSDriversPanel() {

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

        JPanel header = new JPanel(
                new BorderLayout()
        );

        header.setOpaque(false);

        // -----------------------------------------------
        // TITLE
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
                new JLabel("Users vs Drivers");

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
                        "Platform growth comparison"
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
        // PERIOD
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
        // HEADER ADD
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
                new ComparisonChart();

        root.add(
                chart,
                BorderLayout.CENTER
        );

        // =================================================
        // LEGEND
        // =================================================

        JPanel legend =
                createLegend();

        root.add(
                legend,
                BorderLayout.SOUTH
        );

        add(
                root,
                BorderLayout.CENTER
        );
    }

    // =====================================================
    // LEGEND
    // =====================================================

    private JPanel createLegend() {

        JPanel legend =
                new JPanel();

        legend.setOpaque(false);

        legend.setLayout(
                new BoxLayout(
                        legend,
                        BoxLayout.X_AXIS
                )
        );

        // -----------------------------------------------
        // USERS
        // -----------------------------------------------

        JPanel usersDot =
                createDot(
                        new Color(
                                98,
                                71,
                                255
                        )
                );

        JLabel users =
                new JLabel("Users");

        users.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        users.setForeground(
                new Color(
                        90,
                        90,
                        100
                )
        );

        // -----------------------------------------------
        // DRIVERS
        // -----------------------------------------------

        JPanel driversDot =
                createDot(
                        new Color(
                                39,
                                174,
                                96
                        )
                );

        JLabel drivers =
                new JLabel("Drivers");

        drivers.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        drivers.setForeground(
                new Color(
                        90,
                        90,
                        100
                )
        );

        legend.add(usersDot);

        legend.add(
                Box.createHorizontalStrut(6)
        );

        legend.add(users);

        legend.add(
                Box.createHorizontalStrut(25)
        );

        legend.add(driversDot);

        legend.add(
                Box.createHorizontalStrut(6)
        );

        legend.add(drivers);

        return legend;
    }

    // =====================================================
    // DOT
    // =====================================================

    private JPanel createDot(Color color) {

        JPanel dot =
                new JPanel();

        dot.setBackground(color);

        dot.setPreferredSize(
                new Dimension(
                        9,
                        9
                )
        );

        dot.setMaximumSize(
                new Dimension(
                        9,
                        9
                )
        );

        return dot;
    }

    // =====================================================
    // CHART
    // =====================================================

    private static class ComparisonChart
            extends JPanel {

        // -----------------------------------------------
        // PLACEHOLDER DATA
        // -----------------------------------------------

        private final int[] users = {
                650,
                720,
                810,
                900,
                980,
                1080,
                1190,
                1280,
                1390,
                1510,
                1620,
                1740
        };

        private final int[] drivers = {
                90,
                110,
                125,
                145,
                165,
                190,
                220,
                245,
                275,
                310,
                345,
                380
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

        public ComparisonChart() {

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

            int maxValue = 2000;

            // =================================================
            // GRID
            // =================================================

            g2.setStroke(
                    new BasicStroke(1f)
            );

            g2.setColor(
                    new Color(
                            235,
                            235,
                            240
                    )
            );

            int gridLines = 4;

            for (int i = 0;
                 i <= gridLines;
                 i++) {

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
                        maxValue
                        - (maxValue * i)
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
                        6,
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

            // =================================================
            // USERS LINE
            // =================================================

            drawLine(
                    g2,
                    users,
                    new Color(
                            98,
                            71,
                            255
                    ),
                    left,
                    top,
                    chartWidth,
                    chartHeight,
                    maxValue
            );

            // =================================================
            // DRIVERS LINE
            // =================================================

            drawLine(
                    g2,
                    drivers,
                    new Color(
                            39,
                            174,
                            96
                    ),
                    left,
                    top,
                    chartWidth,
                    chartHeight,
                    maxValue
            );

            // =================================================
            // X LABELS
            // =================================================

            g2.setFont(
                    new Font(
                            "Segoe UI",
                            Font.PLAIN,
                            10
                    )
            );

            for (int i = 0;
                 i < labels.length;
                 i++) {

                int x =
                        (int) (
                                left
                                + (double) i
                                / (labels.length - 1)
                                * chartWidth
                        );

                g2.setColor(
                        new Color(
                                120,
                                120,
                                130
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

        // =====================================================
        // DRAW LINE
        // =====================================================

        private void drawLine(
                Graphics2D g2,
                int[] data,
                Color color,
                int left,
                int top,
                int chartWidth,
                int chartHeight,
                int maxValue) {

            g2.setColor(color);

            g2.setStroke(
                    new BasicStroke(
                            3f,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    )
            );

            java.awt.geom.Path2D path =
                    new java.awt.geom.Path2D.Double();

            for (int i = 0;
                 i < data.length;
                 i++) {

                double x =
                        left
                        + (double) i
                        / (data.length - 1)
                        * chartWidth;

                double y =
                        top
                        + chartHeight
                        - (double) data[i]
                        / maxValue
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

            g2.draw(path);

            // ---------------------------------------------
            // POINTS
            // ---------------------------------------------

            for (int i = 0;
                 i < data.length;
                 i++) {

                int x =
                        (int) (
                                left
                                + (double) i
                                / (data.length - 1)
                                * chartWidth
                        );

                int y =
                        (int) (
                                top
                                + chartHeight
                                - (double) data[i]
                                / maxValue
                                * chartHeight
                        );

                g2.setColor(Color.WHITE);

                g2.fillOval(
                        x - 5,
                        y - 5,
                        10,
                        10
                );

                g2.setColor(color);

                g2.fillOval(
                        x - 4,
                        y - 4,
                        8,
                        8
                );
            }
        }
    }
}