package com.gomon.ui.components;

import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gp = new GradientPaint(

                0, 0, new Color(245, 250, 245),

                getWidth(), getHeight(),

                new Color(220, 240, 220)

        );

        g2.setPaint(gp);

        g2.fillRect(0, 0, getWidth(), getHeight());

    }

}