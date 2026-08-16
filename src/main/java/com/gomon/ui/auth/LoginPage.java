package com.gomon.ui.auth;

import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.LabeledPasswordField;
import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.LabeledField;
import com.gomon.ui.components.ShadowPanel;
import com.gomon.model.User;
import com.gomon.service.AuthenticationService;
import com.gomon.session.SessionManager;
import com.gomon.ui.user.UserDashboard;
import com.gomon.ui.driver.DriverDashboard;
import com.gomon.ui.superadmin.SuperAdminDashboard;

import java.awt.*;
import javax.swing.*;

public class LoginPage extends JFrame {

    private LabeledField usernameField;
    private LabeledPasswordField passwordField;

    private JButton loginButton;
    private JButton registerButton;
    private JButton forgotButton;
    private JCheckBox rememberMe;
    private final AuthenticationService authService = new AuthenticationService();

    public LoginPage() {
        initialize();

    }

    private void initialize() {
        setTitle("GOMON - Ride For Everyone");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));

        setIconImage(icon.getImage());
        setSize(1500, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        GradientPanel background = new GradientPanel();
        background.setLayout(null);
        setContentPane(background);
        createLoginCard(background);
        getRootPane().setDefaultButton(loginButton);
        setVisible(true);
    }

    private void createLoginCard(JPanel parent) {

        ShadowPanel card = new ShadowPanel();
        card.setBounds(460, 30, 480, 780);
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        createLogoSection(card);
        createWelcomeSection(card);
        createLoginForm(card);
        parent.add(card);

    }

    private void createLogoSection(JPanel card) {

        card.add(Box.createVerticalStrut(35));

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));
        Image image = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(image));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(logo);
        card.add(Box.createVerticalStrut(6));

        JLabel subtitle = new JLabel("Ride For Everyone");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(subtitle);
        card.add(Box.createVerticalStrut(18));

    }

    private void createWelcomeSection(JPanel card) {

        JLabel welcome = new JLabel("Welcome Back");
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 28));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setForeground(new Color(40, 40, 40));

        card.add(welcome);
        card.add(Box.createVerticalStrut(8));

        JLabel info = new JLabel("Sign in to continue your journey");
        info.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        info.setForeground(Color.GRAY);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(info);
        card.add(Box.createVerticalStrut(30));

    }

    private void createLoginForm(JPanel card) {

        usernameField = new LabeledField("Username or Email ", "Enter username or Email");
        card.add(usernameField);
        card.add(Box.createVerticalStrut(20));

        passwordField = new LabeledPasswordField("Password", "Enter your password");

        card.add(passwordField);
        card.add(Box.createVerticalStrut(20));

        JPanel optionPanel = new JPanel(new BorderLayout());
        optionPanel.setOpaque(false);
        optionPanel.setMaximumSize(new Dimension(350, 25));
        rememberMe = new JCheckBox("Remember Me");
        rememberMe.setOpaque(false);
        rememberMe.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        forgotButton = new JButton("Forgot Password?");
        forgotButton.setBorderPainted(false);
        forgotButton.setContentAreaFilled(false);
        forgotButton.setFocusPainted(false);
        forgotButton.setForeground(new Color(255, 167, 38));
        forgotButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        optionPanel.add(rememberMe, BorderLayout.WEST);
        optionPanel.add(forgotButton, BorderLayout.EAST);

        card.add(optionPanel);
        card.add(Box.createVerticalStrut(25));

        loginButton = new RoundedButton("LOGIN");
        loginButton.setMaximumSize(new Dimension(380, 52));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(loginButton);
        card.add(Box.createVerticalStrut(30));

        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(350, 1));

        card.add(separator);
        card.add(Box.createVerticalStrut(25));

        JLabel accountText = new JLabel("Don't have an account?");
        accountText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        accountText.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(accountText);
        card.add(Box.createVerticalStrut(8));

        registerButton = new JButton("Create Account");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setForeground(new Color(255, 167, 38));
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerButton.addActionListener(e -> {
            dispose();
            new RegisterSelectionPage();

        });
        forgotButton.addActionListener(e -> {
            dispose();
            new ForgotPasswordPage();
        });
        loginButton.addActionListener(e -> {
            login();
        });
        addHoverEffect(registerButton);
        addHoverEffect(forgotButton);

        card.add(registerButton);
        card.add(Box.createVerticalStrut(25));
    }

    private void addHoverEffect(JButton button) {

        button.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setForeground(new Color(247, 139, 17));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setForeground(new Color(255, 167, 38));
            }

        });
    }

    private void login() {

        String username = usernameField.getText().trim();
        String password = passwordField.getPassword();

        if (username.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter Username or Email ", "Validation",
                    JOptionPane.WARNING_MESSAGE);
            usernameField.getTextField().requestFocus();

            return;
        }

        if (password.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter Password.", "Validation", JOptionPane.WARNING_MESSAGE);
            passwordField.getPasswordField().requestFocus();

            return;
        }
        User user = authService.login(username, password);

        if (user == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }
        SessionManager.setCurrentUser(user);

        JOptionPane.showMessageDialog(
                this,
                "Welcome " + user.getFullName());

        dispose();

        switch (user.getRole()) {

            case "USER":
                UserDashboard dashboard = new UserDashboard();
                dashboard.setVisible(true);
                break;

            case "DRIVER":
                DriverDashboard dridashboard = new DriverDashboard();
                dridashboard.setVisible(true);
                break;

            case "ADMIN":
                JOptionPane.showMessageDialog(this,
                        "Admin Dashboard");
                break;

            case "SUPER_ADMIN":
                SuperAdminDashboard sudashboard = new SuperAdminDashboard();
                sudashboard.setVisible(true);
                break;

            default:
                JOptionPane.showMessageDialog(
                        this,
                        "Unknown user role.");
        }
    }

}