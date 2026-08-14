package com.gomon.ui.components;

import javax.swing.*;
import java.awt.*;

public class ScrollablePanel extends JPanel {

    private final JScrollPane scrollPane;
    private final JPanel contentPanel;

    public ScrollablePanel() {

        setLayout(new BorderLayout());

        setOpaque(false);

        contentPanel = new JPanel();
        contentPanel.setOpaque(false);

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        contentPanel.setBorder(
                BorderFactory.createEmptyBorder(25, 25, 25, 25));

        scrollPane = new JScrollPane(contentPanel);

        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        scrollPane.getVerticalScrollBar().setUnitIncrement(20);

        add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void addContent(JComponent component) {

        component.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(component);

    }

    public void addGap(int height) {

        contentPanel.add(Box.createVerticalStrut(height));
    }

    public void refresh() {

        contentPanel.revalidate();

        contentPanel.repaint();

    }

}