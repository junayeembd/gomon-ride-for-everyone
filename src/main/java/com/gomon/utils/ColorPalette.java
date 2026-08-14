package com.gomon.utils;

import java.awt.Color;

public class ColorPalette {

    // Primary Colors
    public static final Color PRIMARY = new Color(0, 150, 136);
    public static final Color PRIMARY_DARK = new Color(0, 121, 107);
    public static final Color PRIMARY_LIGHT = new Color(178, 223, 219);

    // Secondary
    public static final Color SECONDARY = new Color(33, 150, 243);

    // Background
    public static final Color BACKGROUND = new Color(245, 247, 250);
    public static final Color CARD = Color.WHITE;

    // Text
    public static final Color TEXT_PRIMARY = new Color(33, 33, 33);
    public static final Color TEXT_SECONDARY = new Color(117, 117, 117);

    // Status
    public static final Color SUCCESS = new Color(46, 204, 113);
    public static final Color WARNING = new Color(241, 196, 15);
    public static final Color ERROR = new Color(231, 76, 60);

    // Button
    public static final Color BUTTON = PRIMARY;
    public static final Color BUTTON_HOVER = PRIMARY_DARK;

    private ColorPalette() {
    }
}