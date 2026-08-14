package com.gomon.app;

import javax.swing.SwingUtilities;
import com.gomon.ui.auth.LoginPage;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPage();
        });
    }
} 