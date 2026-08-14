package com.gomon.ui.auth;

import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.ScrollablePanel;
import com.gomon.ui.components.ShadowPanel;
import com.gomon.ui.components.LabeledField;
import com.gomon.ui.components.LabeledPasswordField;
import com.gomon.model.Driver;
import com.gomon.service.AuthenticationService;
import java.awt.*;
import javax.swing.*;

public class DriverRegisterPage extends JFrame {

    private LabeledField fullNameField;
    private LabeledField usernameField;
    private LabeledField emailField;
    private LabeledField phoneField;
    private LabeledField addressField;
    private JCheckBox termsCheckBox;
    private RoundedButton registerButton;
    private LabeledPasswordField passwordField;
    private LabeledPasswordField confirmPasswordField;
    private LabeledField nidField;
    private LabeledField licenseField;
    private LabeledField vehicleNumberField;

    private JComboBox<String> vehicleTypeCombo;
    private JComboBox<String> workTimeCombo;
    private final AuthenticationService authService = new AuthenticationService();

    public DriverRegisterPage() {

        initialize();

    }

    private void initialize() {

        setTitle("Driver Registration");

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

        JLabel subtitle = new JLabel("Create your driver account");

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
        card.add(Box.createVerticalStrut(15));

        addressField = new LabeledField("Address", "Enter your address");

        card.add(addressField);
        card.add(Box.createVerticalStrut(15));

        nidField = new LabeledField("NID Number", "Enter your NID number");

        card.add(nidField);
        card.add(Box.createVerticalStrut(20));

        licenseField = new LabeledField("Driving License Number", "Enter your driving license number");

        card.add(licenseField);
        card.add(Box.createVerticalStrut(15));

        JLabel vehicleTypeLabel = new JLabel("Vehicle Type");
        vehicleTypeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        vehicleTypeLabel.setForeground(new Color(60, 60, 60));
        vehicleTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(vehicleTypeLabel);
        card.add(Box.createVerticalStrut(6));

        String[] vehicleTypes = {
                "Select Vehicle",
                "Bike",
                "Car",
                "CNG",
                "Auto Rickshaw",
                "Microbus",
                "Pickup Truck"
        };

        vehicleTypeCombo = new JComboBox<>(vehicleTypes);
        vehicleTypeCombo.setMaximumSize(new Dimension(380, 45));
        vehicleTypeCombo.setPreferredSize(new Dimension(380, 45));
        vehicleTypeCombo.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(vehicleTypeCombo);
        card.add(Box.createVerticalStrut(15));

        vehicleNumberField = new LabeledField("Vehicle Number", "Dhaka Metro-GA-11-1234");

        card.add(vehicleNumberField);
        card.add(Box.createVerticalStrut(15));

        JLabel workTimeLabel = new JLabel("Work Time");
        workTimeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        workTimeLabel.setForeground(new Color(60, 60, 60));
        workTimeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(workTimeLabel);
        card.add(Box.createVerticalStrut(6));

        String[] workTimes = {
                "Select Work Time",
                "Full Time",
                "Part Time",
                "Morning Shift",
                "Evening Shift",
                "Night Shift"
        };

        workTimeCombo = new JComboBox<>(workTimes);
        workTimeCombo.setMaximumSize(new Dimension(380, 45));
        workTimeCombo.setPreferredSize(new Dimension(380, 45));
        workTimeCombo.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(workTimeCombo);
        card.add(Box.createVerticalStrut(15));
        passwordField = new LabeledPasswordField("Password", "Enter your password");

        card.add(passwordField);
        card.add(Box.createVerticalStrut(20));

        confirmPasswordField = new LabeledPasswordField("Confirm Password", "Re-enter your password");

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

        String nid = nidField.getText().trim();
        String license = licenseField.getText().trim();
        String vehicleNumber = vehicleNumberField.getText().trim();

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
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
            emailField.getTextField().requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter phone number.");
            phoneField.getTextField().requestFocus();
            return;
        }

        if (!phone.matches("^01\\d{9}$")) {
            JOptionPane.showMessageDialog(this, "Enter a valid 11-digit Bangladeshi phone number.");
            phoneField.getTextField().requestFocus();
            return;
        }

        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address.");
            addressField.getTextField().requestFocus();
            return;
        }
        if (nid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your NID number.");
            nidField.getTextField().requestFocus();
            return;
        }
        if (license.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your driving license number.");
            licenseField.getTextField().requestFocus();
            return;
        }
        if (vehicleTypeCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a vehicle type.");
            vehicleTypeCombo.requestFocus();
            return;
        }
        if (vehicleNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your vehicle number.");
            vehicleNumberField.getTextField().requestFocus();
            return;
        }
        if (workTimeCombo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select your work time.");
            workTimeCombo.requestFocus();
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
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            confirmPasswordField.getPasswordField().requestFocus();
            return;
        }
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters.");
            passwordField.getPasswordField().requestFocus();
            return;
        }

        if (!termsCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please accept the Terms & Conditions.");
            return;
        }

        try {

            Driver driver = new Driver();

            driver.setFullName(fullName);
            driver.setUsername(username);
            driver.setEmail(email);
            driver.setPhone(phone);
            driver.setAddress(address);
            driver.setPassword(password);

            driver.setNid(nid);
            driver.setDrivingLicense(license);
            driver.setVehicleType(
                    vehicleTypeCombo.getSelectedItem().toString());
            driver.setVehicleNumber(vehicleNumber);
            driver.setWorkTime(
                    workTimeCombo.getSelectedItem().toString());

            authService.registerDriver(driver);

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