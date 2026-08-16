package com.gomon.ui.superadmin.charts;

import java.awt.Color;
import java.awt.BasicStroke;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class RidesOverviewChart extends JPanel {

        public RidesOverviewChart() {

                setOpaque(false);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                int[] completed = {
                                5200,
                                6100,
                                6400,
                                5300,
                                6200,
                                6900,
                                8000
                };

                int[] ongoing = {
                                1900,
                                2700,
                                2500,
                                2000,
                                2300,
                                2500,
                                2800
                };

                int[] cancelled = {
                                300,
                                500,
                                600,
                                400,
                                350,
                                500,
                                450
                };

                String[] days = {
                                "14 May",
                                "15 May",
                                "16 May",
                                "17 May",
                                "18 May",
                                "19 May",
                                "20 May"
                };

                for (int i = 0; i < days.length; i++) {

                        dataset.addValue(
                                        completed[i],
                                        "Completed",
                                        days[i]);

                        dataset.addValue(
                                        ongoing[i],
                                        "Ongoing",
                                        days[i]);

                        dataset.addValue(
                                        cancelled[i],
                                        "Cancelled",
                                        days[i]);
                }

                JFreeChart chart = ChartFactory.createLineChart(
                                null,
                                null,
                                null,
                                dataset);

                chart.setBackgroundPaint(
                                Color.WHITE);

                CategoryPlot plot = chart.getCategoryPlot();

                plot.setBackgroundPaint(
                                Color.WHITE);

                plot.setOutlineVisible(false);

                plot.setRangeGridlinePaint(
                                new Color(
                                                232,
                                                234,
                                                240));

                plot.setDomainGridlinesVisible(false);

                CategoryAxis domainAxis = plot.getDomainAxis();

                domainAxis.setTickLabelFont(
                                new java.awt.Font(
                                                "Segoe UI",
                                                java.awt.Font.PLAIN,
                                                10));

                NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

                rangeAxis.setStandardTickUnits(
                                NumberAxis.createIntegerTickUnits());

                LineAndShapeRenderer renderer = new LineAndShapeRenderer();

                renderer.setDefaultShapesVisible(true);

                renderer.setDefaultLinesVisible(true);

                renderer.setSeriesPaint(
                                0,
                                new Color(
                                                98,
                                                71,
                                                255));

                renderer.setSeriesPaint(
                                1,
                                new Color(
                                                39,
                                                174,
                                                96));

                renderer.setSeriesPaint(
                                2,
                                new Color(
                                                231,
                                                76,
                                                60));

                renderer.setSeriesStroke(
                                0,
                                new BasicStroke(2.5f));

                renderer.setSeriesStroke(
                                1,
                                new BasicStroke(2.5f));

                renderer.setSeriesStroke(
                                2,
                                new BasicStroke(2.5f));

                plot.setRenderer(renderer);

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

                setLayout(
                                new java.awt.BorderLayout());

                add(
                                chartPanel,
                                java.awt.BorderLayout.CENTER);
        }
}