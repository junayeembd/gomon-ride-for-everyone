package com.gomon.ui.superadmin.charts;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class RevenueChart extends JPanel {

        public RevenueChart() {

                setOpaque(false);

                DefaultCategoryDataset dataset = new DefaultCategoryDataset();

                dataset.addValue(
                                185000,
                                "Revenue",
                                "14 May");

                dataset.addValue(
                                235000,
                                "Revenue",
                                "15 May");

                dataset.addValue(
                                265000,
                                "Revenue",
                                "16 May");

                dataset.addValue(
                                305000,
                                "Revenue",
                                "17 May");

                dataset.addValue(
                                350000,
                                "Revenue",
                                "19 May");

                dataset.addValue(
                                315000,
                                "Revenue",
                                "20 May");

                JFreeChart chart = ChartFactory.createBarChart(
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

                NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

                rangeAxis.setStandardTickUnits(
                                NumberAxis.createIntegerTickUnits());

                BarRenderer renderer = new BarRenderer();

                renderer.setDrawBarOutline(false);

                renderer.setSeriesPaint(
                                0,
                                new Color(
                                                98,
                                                71,
                                                255));

                renderer.setMaximumBarWidth(
                                0.10);

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
                                new BorderLayout());

                add(
                                chartPanel,
                                BorderLayout.CENTER);
        }
}