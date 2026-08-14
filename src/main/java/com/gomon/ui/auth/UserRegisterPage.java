package com.gomon.ui.auth;

import com.gomon.model.User;
import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.ScrollablePanel;
import com.gomon.ui.components.ShadowPanel;
import com.gomon.ui.components.LabeledField;
import com.gomon.ui.components.LabeledPasswordField;
import com.gomon.service.AuthenticationService;
import java.awt.*;
import javax.swing.*;

public class UserRegisterPage extends JFrame {

        private LabeledField fullNameField;
        private LabeledField usernameField;
        private LabeledField emailField;
        private LabeledField phoneField;
        private LabeledField addressField;
        private JCheckBox termsCheckBox;
        private RoundedButton registerButton;
        private LabeledPasswordField passwordField;
        private LabeledPasswordField confirmPasswordField;
        private final AuthenticationService authService = new AuthenticationService();

        public UserRegisterPage() {

                initialize();

        }

        private void initialize() {

                setTitle("Passenger Registration");

                ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));

                setIconImage(icon.getImage());
                setSize(1500, 900);
                setLocationRelativeTo(null);
                setResizable(true);
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
                card.setBorder(BorderFactory.createEmptyBorder(25, 35, 25, 35));

                parent.add(card);
                parent.add(Box.createVerticalStrut(25));

                ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));

                Image image = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
                JLabel logo = new JLabel(new ImageIcon(image));
                logo.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.add(logo);
                card.add(Box.createVerticalStrut(15));

                JLabel title = new JLabel("CREATE ACCOUNT");
                title.setAlignmentX(Component.CENTER_ALIGNMENT);
                title.setFont(new Font("Segoe UI", Font.BOLD, 28));
                title.setForeground(new Color(0, 150, 136));

                card.add(title);
                card.add(Box.createVerticalStrut(8));

                JLabel subtitle = new JLabel("Create your passenger account");

                subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
                subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
                subtitle.setForeground(Color.GRAY);

                card.add(subtitle);
                card.add(Box.createVerticalStrut(30));

                fullNameField = new LabeledField("Full Name", "Enter your full name");

                card.add(fullNameField);
                card.add(Box.createVerticalStrut(15));

                usernameField = new LabeledField("Username", "Choose a username");

                card.add(usernameField);
                card.add(Box.createVerticalStrut(15));

                emailField = new LabeledField("Email", "Enter your email");

                card.add(emailField);
                card.add(Box.createVerticalStrut(20));

                phoneField = new LabeledField("Phone Number", "01XXXXXXXXX");
                card.add(phoneField);
                card.add(Box.createVerticalStrut(20));

                addressField = new LabeledField("Address", "Enter your address");

                card.add(addressField);
                card.add(Box.createVerticalStrut(20));

                passwordField = new LabeledPasswordField("Password", "Enter your password");

                card.add(passwordField);
                card.add(Box.createVerticalStrut(20));

                confirmPasswordField = new LabeledPasswordField("Confirm Password",
                                "Re-enter your password");

                card.add(confirmPasswordField);
                card.add(Box.createVerticalStrut(20));

                termsCheckBox = new JCheckBox("I agree to the Terms & Conditions");

                termsCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                termsCheckBox.setBackground(Color.WHITE);
                termsCheckBox.setFocusPainted(false);
                termsCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.add(termsCheckBox);
                card.add(Box.createVerticalStrut(20));

                registerButton = new RoundedButton("CREATE ACCOUNT");
                registerButton.setMaximumSize(new Dimension(380, 45));
                registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                card.add(registerButton);
                registerButton.addActionListener(e -> register());

                card.add(Box.createVerticalStrut(20));

                JButton backButton = new JButton("← Back to Login");

                backButton.setBorderPainted(false);
                backButton.setContentAreaFilled(false);
                backButton.setFocusPainted(false);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                backButton.setForeground(new Color(0, 150, 136));
                backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
                backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                backButton.addActionListener(e -> {
                        dispose();
                        new RegisterSelectionPage();
                });

                card.add(backButton);
                parent.add(Box.createVerticalStrut(25));
        }

        private void register() {

                String fullName = fullNameField.getText().trim();
                String username = usernameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();

                String password = passwordField.getPassword();
                String confirmPassword = confirmPasswordField.getPassword();

                if (fullName.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter your full name.");
                        fullNameField.getTextField().requestFocus();
                        return;
                }

                if (username.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter username.");
                        usernameField.getTextField().requestFocus();
                        return;
                }

                if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter email.");
                        emailField.getTextField().requestFocus();
                        return;
                }
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                        JOptionPane.showMessageDialog(this,
                                        "Please enter a valid email address.");
                        emailField.getTextField().requestFocus();
                        return;
                }

                if (phone.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter phone number.");
                        phoneField.getTextField().requestFocus();
                        return;
                }

                if (!phone.matches("^01\\d{9}$")) {
                        JOptionPane.showMessageDialog(this,
                                        "Enter a valid 11-digit Bangladeshi phone number.");
                        phoneField.getTextField().requestFocus();
                        return;
                }

                if (address.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter address.");
                        addressField.getTextField().requestFocus();
                        return;
                }

                if (password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter password.");
                        passwordField.getPasswordField().requestFocus();
                        return;
                }

                if (confirmPassword.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please confirm your password.");
                        confirmPasswordField.getPasswordField().requestFocus();
                        return;
                }

                if (!password.equals(confirmPassword)) {
                        JOptionPane.showMessageDialog(this,
                                        "Passwords do not match.");
                        confirmPasswordField.getPasswordField().requestFocus();
                        return;
                }
                if (password.length() < 8) {
                        JOptionPane.showMessageDialog(this,
                                        "Password must be at least 8 characters.");
                        passwordField.getPasswordField().requestFocus();
                        return;
                }

                if (!termsCheckBox.isSelected()) {
                        JOptionPane.showMessageDialog(this,
                                        "Please accept the Terms & Conditions.");
                        return;
                }

                try {

                        User user = new User();

                        user.setFullName(fullName);
                        user.setUsername(username);
                        user.setEmail(email);
                        user.setPhone(phone);
                        user.setAddress(address);
                        user.setPassword(password);

                        authService.registerUser(user);

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Registration Successful!");

                        dispose();
                        new LoginPage();

                } catch (IllegalArgumentException ex) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        ex.getMessage(),
                                        "Registration Failed",
                                        JOptionPane.WARNING_MESSAGE);

                } catch (Exception ex) {

                        JOptionPane.showMessageDialog(
                                        this,
                                        "Something went wrong.\nPlease try again.",
                                        "System Error",
                                        JOptionPane.ERROR_MESSAGE);

                        ex.printStackTrace();
                }
        }
}