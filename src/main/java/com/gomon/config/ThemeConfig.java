package com.gomon.config;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class ThemeConfig {

    public static void setupTheme() {

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}