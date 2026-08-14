package com.gomon.ui.auth;

import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.LabeledPasswordField;
import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.ScrollablePanel;
import com.gomon.ui.components.ShadowPanel;
import com.gomon.service.AuthenticationService;

import java.awt.*;
import javax.swing.*;

public class ResetPasswordPage extends JFrame {

        private LabeledPasswordField newPasswordField;
        private LabeledPasswordField confirmPasswordField;
        private RoundedButton resetButton;
        private JButton backButton;
        private final AuthenticationService authService = new AuthenticationService();
        private String email;

        public ResetPasswordPage(String email) {

                this.email = email;

                initialize();

        }

        private void initialize() {

                setTitle("Reset Password");

                ImageIcon icon = new ImageIcon(
                                getClass().getResource("/images/logo/logo.png"));

                setIconImage(icon.getImage());

                setSize(1500, 900);

                setLocationRelativeTo(null);

                setResizable(false);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                GradientPanel background = new GradientPanel();

                background.setLayout(new BorderLayout());

                ScrollablePanel scrollPane = new ScrollablePanel();

                background.add(scrollPane, BorderLayout.CENTER);

                setContentPane(background);

                createMainCard(scrollPane.getContentPanel());

                setVisible(true);

        }

        private void createMainCard(JPanel parent) {

                ShadowPanel card = new ShadowPanel();

                card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

                card.setBackground(Color.WHITE);

                card.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.setBorder(BorderFactory.createEmptyBorder(
                                30, 35, 30, 35));

                parent.add(card);

                parent.add(Box.createVerticalStrut(25));

                ImageIcon logoIcon = new ImageIcon(getClass().getResource(
                                "/images/logo/logo.png"));

                Image image = logoIcon.getImage().getScaledInstance(
                                110,
                                110,
                                Image.SCALE_SMOOTH);

                JLabel logo = new JLabel(new ImageIcon(image));

                logo.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.add(logo);

                card.add(Box.createVerticalStrut(15));

                JLabel title = new JLabel("RESET PASSWORD");

                title.setAlignmentX(Component.CENTER_ALIGNMENT);

                title.setFont(new Font(
                                "Segoe UI",
                                Font.BOLD,
                                28));

                title.setForeground(new Color(0, 150, 136));

                card.add(title);

                card.add(Box.createVerticalStrut(8));

                JLabel subtitle = new JLabel(
                                "Create your new password");

                subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

                subtitle.setForeground(Color.GRAY);

                subtitle.setFont(new Font(
                                "Segoe UI",
                                Font.PLAIN,
                                15));

                card.add(subtitle);

                card.add(Box.createVerticalStrut(35));

                newPasswordField = new LabeledPasswordField(
                                "New Password",
                                "Enter new password");

                card.add(newPasswordField);

                card.add(Box.createVerticalStrut(18));

                confirmPasswordField = new LabeledPasswordField(
                                "Confirm Password",
                                "Confirm new password");

                card.add(confirmPasswordField);

                card.add(Box.createVerticalStrut(35));

                resetButton = new RoundedButton("RESET PASSWORD");

                resetButton.setMaximumSize(
                                new Dimension(380, 45));

                resetButton.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                card.add(resetButton);

                card.add(Box.createVerticalStrut(15));

                backButton = new JButton("← Back to Login");

                backButton.setBorderPainted(false);

                backButton.setContentAreaFilled(false);

                backButton.setFocusPainted(false);

                backButton.setCursor(
                                new Cursor(Cursor.HAND_CURSOR));

                backButton.setForeground(
                                new Color(0, 150, 136));

                backButton.setFont(
                                new Font(
                                                "Segoe UI",
                                                Font.BOLD,
                                                14));

                backButton.setAlignmentX(
                                Component.CENTER_ALIGNMENT);

                card.add(backButton);

                card.add(Box.createVerticalStrut(20));

                resetButton.addActionListener(
                                e -> resetPassword());

                backButton.addActionListener(e -> {

                        dispose();

                        new LoginPage();

                });

        }

        private void resetPassword() {

                String newPassword = newPasswordField.getPassword().trim();

                String confirmPassword = confirmPasswordField.getPassword().trim();

                // Empty Validation

                if (newPassword.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Please enter your new password.",
                                        "Validation",
                                        JOptionPane.WARNING_MESSAGE);

                        newPasswordField.getPasswordField().requestFocus();

                        return;
                }

                if (confirmPassword.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Please confirm your password.",
                                        "Validation",
                                        JOptionPane.WARNING_MESSAGE);

                        confirmPasswordField.getPasswordField().requestFocus();

                        return;
                }

                // Password Length

                if (newPassword.length() < 8) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Password must be at least 8 characters.",
                                        "Weak Password",
                                        JOptionPane.WARNING_MESSAGE);

                        newPasswordField.clear();

                        confirmPasswordField.clear();

                        newPasswordField.getPasswordField().requestFocus();

                        return;
                }

                // Match Check

                if (!newPassword.equals(confirmPassword)) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Passwords do not match.",
                                        "Validation",
                                        JOptionPane.ERROR_MESSAGE);

                        confirmPasswordField.clear();

                        confirmPasswordField.getPasswordField().requestFocus();

                        return;
                }

                boolean success = authService.resetPassword(
                                email,
                                newPassword);

                if (success) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Password Reset Successfully!");

                        dispose();

                        new LoginPage();

                } else {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Password Reset Failed!");

                }

        }
}