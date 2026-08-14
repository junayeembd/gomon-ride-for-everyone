package com.gomon.ui.auth;

import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.ScrollablePanel;
import com.gomon.ui.components.ShadowPanel;
import com.gomon.ui.components.OTPTextField;
import com.gomon.service.AuthenticationService;
import java.awt.*;
import javax.swing.*;

public class OTPVerificationPage extends JFrame {

    private OTPTextField[] otpFields;
    private RoundedButton verifyButton;
    private JButton resendButton;
    private JButton backButton;
    private JLabel timerLabel;
    private String userEmail;
    private final AuthenticationService authService = new AuthenticationService();

    private Timer timer;

    private int seconds = 120;

    public OTPVerificationPage(String email) {

        this.userEmail = email;

        initialize();

        startTimer();

    }

    private void initialize() {

        setTitle("OTP Verification");

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

        JLabel title = new JLabel("VERIFY OTP");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(0, 150, 136));

        card.add(title);
        card.add(Box.createVerticalStrut(8));

        JLabel subtitle = new JLabel("Enter the 6-digit verification code");

        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setForeground(Color.GRAY);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        card.add(subtitle);
        card.add(Box.createVerticalStrut(35));

        JPanel otpPanel = new JPanel();

        otpPanel.setOpaque(false);
        otpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        otpFields = new OTPTextField[6];

        for (int i = 0; i < 6; i++) {

            otpFields[i] = new OTPTextField();
            otpPanel.add(otpFields[i]);
        }

        for (int i = 0; i < otpFields.length; i++) {

            if (i > 0) {
                otpFields[i].setPreviousField(otpFields[i - 1]);
            }

            if (i < otpFields.length - 1) {
                otpFields[i].setNextField(otpFields[i + 1]);
            }
        }

        card.add(otpPanel);
        card.add(Box.createVerticalStrut(35));

        verifyButton = new RoundedButton("VERIFY OTP");
        verifyButton.setMaximumSize(new Dimension(380, 45));
        verifyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(verifyButton);

        timerLabel = new JLabel("Resend OTP in 120s");
        timerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        timerLabel.setForeground(Color.GRAY);
        timerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        card.add(Box.createVerticalStrut(15));
        card.add(timerLabel);
        card.add(Box.createVerticalStrut(20));

        resendButton = new JButton("Resend OTP");
        resendButton.setBorderPainted(false);
        resendButton.setContentAreaFilled(false);
        resendButton.setFocusPainted(false);
        resendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resendButton.setForeground(new Color(0, 150, 136));
        resendButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resendButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(resendButton);
        card.add(Box.createVerticalStrut(10));

        backButton = new JButton("← Back");
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setForeground(new Color(0, 150, 136));
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {

            dispose();
            new ForgotPasswordPage();

        });

        card.add(backButton);
        card.add(Box.createVerticalStrut(20));

        SwingUtilities.invokeLater(() -> otpFields[0].requestFieldFocus());

        verifyButton.addActionListener(e -> verifyOTP());

        resendButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(this, "OTP Sent Again!");

            startTimer();
            for (OTPTextField field : otpFields) {

                field.clearDigit();
                field.setNormal();

            }
            otpFields[0].requestFieldFocus();
        });
    }

    private void verifyOTP() {

        StringBuilder otp = new StringBuilder();

        for (OTPTextField field : otpFields) {

            if (!field.isFilled()) {

                field.setError();

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter the complete OTP.");

                field.requestFieldFocus();
                return;
            }

            otp.append(field.getDigit());
        }

        String enteredOTP = otp.toString();

        if (authService.verifyOTP(userEmail, enteredOTP)) {

            JOptionPane.showMessageDialog(
                    this,
                    "OTP Verified Successfully!");

            dispose();

            new ResetPasswordPage(userEmail);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid OTP!",
                    "Verification Failed",
                    JOptionPane.ERROR_MESSAGE);

            for (OTPTextField field : otpFields) {

                field.clearDigit();
                field.setNormal();

            }

            otpFields[0].requestFieldFocus();
        }
    }

    private void startTimer() {
        seconds = 120;
        resendButton.setEnabled(false);
        timerLabel.setText("Resend OTP in " + seconds + "s");
        timer = new Timer(1000, e -> {

            seconds--;
            timerLabel.setText("Resend OTP in " + seconds + "s");

            if (seconds <= 0) {
                timer.stop();
                timerLabel.setText("Didn't receive the code?");
                resendButton.setEnabled(true);
            }
        });
        timer.start();
    }
}