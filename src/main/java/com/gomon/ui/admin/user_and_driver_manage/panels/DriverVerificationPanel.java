package com.gomon.ui.admin.user_and_driver_manage.panels;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.ShadowCard;

public class DriverVerificationPanel extends ShadowCard {

        public DriverVerificationPanel() {

                setLayout(new BorderLayout());

                setCardColor(Color.WHITE);

                setPreferredSize(
                                new Dimension(0, 350));

                setMinimumSize(
                                new Dimension(400, 350));

                setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                350));

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
                                                20));

                // =================================================
                // HEADER
                // =================================================

                JPanel header = new JPanel(
                                new BorderLayout());

                header.setOpaque(false);

                JLabel title = new JLabel(
                                "Driver Verification Status");

                title.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                18));

                title.setForeground(
                                new Color(
                                                35,
                                                35,
                                                45));

                JLabel subtitle = new JLabel(
                                "Current driver verification overview");

                subtitle.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                12));

                subtitle.setForeground(
                                new Color(
                                                130,
                                                130,
                                                140));

                JPanel titlePanel = new JPanel();

                titlePanel.setOpaque(false);

                titlePanel.setLayout(
                                new BoxLayout(
                                                titlePanel,
                                                BoxLayout.Y_AXIS));

                titlePanel.add(title);

                titlePanel.add(
                                Box.createVerticalStrut(4));

                titlePanel.add(subtitle);

                header.add(
                                titlePanel,
                                BorderLayout.WEST);

                root.add(
                                header,
                                BorderLayout.NORTH);

                // =================================================
                // CENTER
                // =================================================

                JPanel center = new JPanel(
                                new GridLayout(
                                                1,
                                                2,
                                                20,
                                                0));

                center.setOpaque(false);

                // -----------------------------------------------
                // DONUT CHART
                // -----------------------------------------------

                center.add(
                                createChartPanel());

                // -----------------------------------------------
                // STATUS LIST
                // -----------------------------------------------

                center.add(
                                createStatusPanel());

                root.add(
                                center,
                                BorderLayout.CENTER);

                add(
                                root,
                                BorderLayout.CENTER);
        }

        // =====================================================
        // CHART PANEL
        // =====================================================

        private JPanel createChartPanel() {

                JPanel panel = new JPanel(
                                new BorderLayout());

                panel.setOpaque(false);

                DonutChart chart = new DonutChart();

                panel.add(
                                chart,
                                BorderLayout.CENTER);

                return panel;
        }

        // =====================================================
        // STATUS PANEL
        // =====================================================

        private JPanel createStatusPanel() {

                JPanel panel = new JPanel();

                panel.setOpaque(false);

                panel.setLayout(
                                new BoxLayout(
                                                panel,
                                                BoxLayout.Y_AXIS));

                panel.setBorder(
                                new EmptyBorder(
                                                20,
                                                5,
                                                10,
                                                5));

                // -----------------------------------------------
                // APPROVED
                // -----------------------------------------------

                panel.add(
                                createStatusRow(
                                                new Color(
                                                                39,
                                                                174,
                                                                96),
                                                "Approved",
                                                "1,150"));

                panel.add(
                                Box.createVerticalStrut(14));

                // -----------------------------------------------
                // PENDING
                // -----------------------------------------------

                panel.add(
                                createStatusRow(
                                                new Color(
                                                                241,
                                                                196,
                                                                15),
                                                "Pending",
                                                "82"));

                panel.add(
                                Box.createVerticalStrut(14));

                // -----------------------------------------------
                // REJECTED
                // -----------------------------------------------

                panel.add(
                                createStatusRow(
                                                new Color(
                                                                231,
                                                                76,
                                                                60),
                                                "Rejected",
                                                "120"));

                panel.add(
                                Box.createVerticalStrut(14));

                // -----------------------------------------------
                // DOCUMENTS MISSING
                // -----------------------------------------------

                panel.add(
                                createStatusRow(
                                                new Color(
                                                                98,
                                                                71,
                                                                255),
                                                "Documents Missing",
                                                "180"));

                return panel;
        }

        // =====================================================
        // STATUS ROW
        // =====================================================

        private JPanel createStatusRow(
                        Color color,
                        String title,
                        String value) {

                JPanel row = new JPanel(
                                new BorderLayout(
                                                10,
                                                0));

                row.setOpaque(false);

                row.setMaximumSize(
                                new Dimension(
                                                Integer.MAX_VALUE,
                                                32));

                // -----------------------------------------------
                // DOT
                // -----------------------------------------------

                JPanel dot = new JPanel();

                dot.setBackground(color);

                dot.setPreferredSize(
                                new Dimension(
                                                10,
                                                10));

                dot.setMaximumSize(
                                new Dimension(
                                                10,
                                                10));

                // -----------------------------------------------
                // TITLE
                // -----------------------------------------------

                JLabel label = new JLabel(title);

                label.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.PLAIN,
                                                13));

                label.setForeground(
                                new Color(
                                                80,
                                                80,
                                                90));

                // -----------------------------------------------
                // VALUE
                // -----------------------------------------------

                JLabel number = new JLabel(value);

                number.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                14));

                number.setForeground(
                                new Color(
                                                35,
                                                35,
                                                45));

                row.add(
                                dot,
                                BorderLayout.WEST);

                row.add(
                                label,
                                BorderLayout.CENTER);

                row.add(
                                number,
                                BorderLayout.EAST);

                return row;
        }

        // =====================================================
        // DONUT CHART
        // =====================================================

        private static class DonutChart
                        extends JPanel {

                private final double approved = 1150;
                private final double pending = 82;
                private final double rejected = 120;
                private final double missing = 180;

                private final double total = approved
                                + pending
                                + rejected
                                + missing;

                public DonutChart() {

                        setOpaque(false);

                        setPreferredSize(
                                        new Dimension(
                                                        250,
                                                        230));
                }

                @Override
                protected void paintComponent(
                                Graphics g) {

                        super.paintComponent(g);

                        Graphics2D g2 = (Graphics2D) g.create();

                        g2.setRenderingHint(
                                        RenderingHints.KEY_ANTIALIASING,
                                        RenderingHints.VALUE_ANTIALIAS_ON);

                        int width = getWidth();
                        int height = getHeight();

                        int size = Math.min(
                                        width,
                                        height) - 35;

                        int x = (width - size) / 2;

                        int y = (height - size) / 2;

                        // =================================================
                        // BACKGROUND RING
                        // =================================================

                        g2.setColor(
                                        new Color(
                                                        240,
                                                        241,
                                                        246));

                        g2.setStroke(
                                        new BasicStroke(
                                                        24f,
                                                        BasicStroke.CAP_BUTT,
                                                        BasicStroke.JOIN_ROUND));

                        g2.drawArc(
                                        x,
                                        y,
                                        size,
                                        size,
                                        90,
                                        -360);

                        // =================================================
                        // APPROVED
                        // =================================================

                        double approvedAngle = approved / total * 360;

                        drawArc(
                                        g2,
                                        x,
                                        y,
                                        size,
                                        90,
                                        approvedAngle,
                                        new Color(
                                                        39,
                                                        174,
                                                        96));

                        // =================================================
                        // PENDING
                        // =================================================

                        double pendingAngle = pending / total * 360;

                        drawArc(
                                        g2,
                                        x,
                                        y,
                                        size,
                                        90 - approvedAngle,
                                        pendingAngle,
                                        new Color(
                                                        241,
                                                        196,
                                                        15));

                        // =================================================
                        // REJECTED
                        // =================================================

                        double rejectedAngle = rejected / total * 360;

                        drawArc(
                                        g2,
                                        x,
                                        y,
                                        size,
                                        90
                                                        - approvedAngle
                                                        - pendingAngle,
                                        rejectedAngle,
                                        new Color(
                                                        231,
                                                        76,
                                                        60));

                        // =================================================
                        // MISSING
                        // =================================================

                        double missingAngle = missing / total * 360;

                        drawArc(
                                        g2,
                                        x,
                                        y,
                                        size,
                                        90
                                                        - approvedAngle
                                                        - pendingAngle
                                                        - rejectedAngle,
                                        missingAngle,
                                        new Color(
                                                        98,
                                                        71,
                                                        255));

                        // =================================================
                        // CENTER TEXT
                        // =================================================

                        String totalText = "1,532";

                        String totalLabel = "Total Drivers";

                        g2.setFont(
                                        new Font(
                                                        "Segoe UI",
                                                        Font.BOLD,
                                                        23));

                        g2.setColor(
                                        new Color(
                                                        35,
                                                        35,
                                                        45));

                        int valueWidth = g2.getFontMetrics()
                                        .stringWidth(
                                                        totalText);

                        g2.drawString(
                                        totalText,
                                        width / 2
                                                        - valueWidth / 2,
                                        height / 2 + 3);

                        g2.setFont(
                                        new Font(
                                                        "Segoe UI",
                                                        Font.PLAIN,
                                                        11));

                        g2.setColor(
                                        new Color(
                                                        130,
                                                        130,
                                                        140));

                        int labelWidth = g2.getFontMetrics()
                                        .stringWidth(
                                                        totalLabel);

                        g2.drawString(
                                        totalLabel,
                                        width / 2
                                                        - labelWidth / 2,
                                        height / 2 + 21);

                        g2.dispose();
                }

                // =====================================================
                // DRAW ARC
                // =====================================================

                private void drawArc(
                                Graphics2D g2,
                                int x,
                                int y,
                                int size,
                                double startAngle,
                                double angle,
                                Color color) {

                        g2.setColor(color);

                        g2.setStroke(
                                        new BasicStroke(
                                                        24f,
                                                        BasicStroke.CAP_BUTT,
                                                        BasicStroke.JOIN_ROUND));

                        g2.draw(
                                        new Arc2D.Double(
                                                        x,
                                                        y,
                                                        size,
                                                        size,
                                                        startAngle,
                                                        -angle,
                                                        Arc2D.OPEN));
                }
        }
}