package com.gomon.utils;

import java.awt.Font;

public class FontManager {

    public static Font title() {
        return new Font("Segoe UI", Font.BOLD, 30);
    }

    public static Font heading() {
        return new Font("Segoe UI", Font.BOLD, 22);
    }

    public static Font normal() {
        return new Font("Segoe UI", Font.PLAIN, 16);
    }

    public static Font button() {
        return new Font("Segoe UI", Font.BOLD, 16);
    }

    public static Font small() {
        return new Font("Segoe UI", Font.PLAIN, 13);
    }
}