package com.gomon.ui.superadmin.charts;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

public class UserRoleChart extends JPanel {

        public UserRoleChart() {

                setOpaque(false);

                DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

                dataset.setValue(
                                "Users",
                                12458);

                dataset.setValue(
                                "Drivers",
                                3245);

                dataset.setValue(
                                "Admins",
                                237);

                // =====================================================
                // DONUT
                // =====================================================

                JFreeChart chart = ChartFactory.createRingChart(
                                null,
                                dataset,
                                true,
                                false,
                                false);

                chart.setBackgroundPaint(
                                Color.WHITE);

                RingPlot plot = (RingPlot) chart.getPlot();

                plot.setBackgroundPaint(
                                Color.WHITE);

                plot.setOutlineVisible(false);

                plot.setShadowPaint(null);

                // IMPORTANT:
                // remove outside connecting lines
                plot.setLabelGenerator(null);

                plot.setLabelLinkPaint(
                                Color.WHITE);

                plot.setSectionPaint(
                                "Users",
                                new Color(
                                                98,
                                                71,
                                                255));

                plot.setSectionPaint(
                                "Drivers",
                                new Color(
                                                52,
                                                115,
                                                225));

                plot.setSectionPaint(
                                "Admins",
                                new Color(
                                                39,
                                                174,
                                                96));

                plot.setStartAngle(
                                90);

                plot.setSectionDepth(
                                0.28);

                chart.getLegend()
                                .setItemFont(
                                                new Font(
                                                                "Segoe UI",
                                                                Font.PLAIN,
                                                                11));

                ChartPanel chartPanel = new ChartPanel(
                                chart,
                                true,
                                true,
                                false,
                                false,
                                false);

                chartPanel.setBorder(null);

                chartPanel.setBackground(
                                Color.WHITE);

                chartPanel.setMouseWheelEnabled(false);

                chartPanel.setDomainZoomable(false);

                chartPanel.setRangeZoomable(false);

                setLayout(
                                new java.awt.BorderLayout());

                add(
                                chartPanel,
                                java.awt.BorderLayout.CENTER);
        }
}