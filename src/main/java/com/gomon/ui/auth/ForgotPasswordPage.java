package com.gomon.ui.auth;

import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.ShadowPanel;
import com.gomon.ui.components.ScrollablePanel;
import com.gomon.ui.components.LabeledField;
import com.gomon.ui.components.RoundedButton;
import com.gomon.service.AuthenticationService;
import java.awt.*;
import javax.swing.*;

public class ForgotPasswordPage extends JFrame {

    private LabeledField emailPhoneField;
    private RoundedButton sendOtpButton;
    private JButton backButton;
    private final AuthenticationService authService = new AuthenticationService();

    public ForgotPasswordPage() {
        initialize();
    }

    private void initialize() {

        setTitle("Forgot Password");

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));

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
        card.setBorder(BorderFactory.createEmptyBorder(30, 35, 30, 35));

        parent.add(card);
        parent.add(Box.createVerticalStrut(25));

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));

        Image image = logoIcon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);

        JLabel logo = new JLabel(new ImageIcon(image));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(logo);
        card.add(Box.createVerticalStrut(15));

        JLabel title = new JLabel("FORGOT PASSWORD");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(0, 150, 136));

        card.add(title);
        card.add(Box.createVerticalStrut(15));

        JLabel subtitle = new JLabel("Enter your email or phone number");

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(Color.GRAY);

        card.add(subtitle);
        card.add(Box.createVerticalStrut(30));

        emailPhoneField = new LabeledField("Email or Phone", "Enter your email or phone");

        card.add(emailPhoneField);
        card.add(Box.createVerticalStrut(25));

        sendOtpButton = new RoundedButton("SEND OTP");
        sendOtpButton.setMaximumSize(new Dimension(380, 45));
        sendOtpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sendOtpButton.addActionListener(e -> sendOTP());

        card.add(sendOtpButton);
        card.add(Box.createVerticalStrut(20));

        backButton = new JButton("← Back to Login");
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setForeground(new Color(0, 150, 136));
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            dispose();
            new LoginPage();

        });
        addHoverEffect(backButton);

        card.add(backButton);
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
                button.setForeground(new Color(0, 150, 136));
            }
        });
    }

    private void sendOTP() {

        String input = emailPhoneField.getText().trim();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email or phone number.", "Validation",
                    JOptionPane.WARNING_MESSAGE);
            emailPhoneField.getTextField().requestFocus();
            return;
        }

        boolean isEmail = input.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        boolean isPhone = input.matches("^01\\d{9}$");
        if (!authService.accountExists(input)) {

            JOptionPane.showMessageDialog(
                    this,
                    "No account found with this Email or Phone Number.",
                    "Account Not Found",
                    JOptionPane.ERROR_MESSAGE);

            emailPhoneField.getTextField().requestFocus();

            return;
        }

        if (!isEmail && !isPhone) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email or 11-digit phone number.", "Validation",
                    JOptionPane.WARNING_MESSAGE);
            emailPhoneField.getTextField().requestFocus();
            return;
        }

        boolean sent = authService.sendOTP(input);

        if (sent) {

            JOptionPane.showMessageDialog(
                    this,
                    "OTP sent successfully.");

            dispose();

            new OTPVerificationPage(input);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to send OTP.",
                    "Email Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }
}