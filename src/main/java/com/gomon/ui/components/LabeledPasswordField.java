package com.gomon.ui.components;

import javax.swing.*;
import java.awt.*;

public class LabeledPasswordField extends JPanel {

    private final JLabel label;
    private final RoundedPasswordField passwordField;
    private final JButton eyeButton;

    private boolean visible = false;

    public LabeledPasswordField(String labelText, String placeholder) {

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setMaximumSize(new Dimension(380, 72));

        // Label
        label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(60, 60, 60));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(label);
        add(Box.createVerticalStrut(6));

        // Password Panel
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setOpaque(false);
        passwordPanel.setMaximumSize(new Dimension(380, 45));
        passwordPanel.setPreferredSize(new Dimension(380, 45));
        passwordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        passwordField = new RoundedPasswordField();
        passwordField.setPlaceholder(placeholder);

        eyeButton = new JButton("👁");
        eyeButton.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
        eyeButton.setBorder(null);
        eyeButton.setContentAreaFilled(false);
        eyeButton.setFocusPainted(false);
        eyeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eyeButton.setPreferredSize(new Dimension(55, 45));

        eyeButton.addActionListener(e -> togglePassword());

        passwordPanel.add(passwordField, BorderLayout.CENTER);
        passwordPanel.add(eyeButton, BorderLayout.EAST);

        add(passwordPanel);
    }

    private void togglePassword() {

        if (visible) {

            passwordField.setEchoChar('•');

            eyeButton.setText("👁");

        } else {

            passwordField.setEchoChar((char) 0);

            eyeButton.setText("🙈");

        }

        visible = !visible;

    }

    public String getPassword() {

        return new String(passwordField.getPassword());

    }

    public RoundedPasswordField getPasswordField() {

        return passwordField;

    }

    public void clear() {

        passwordField.setText("");

    }

    public JLabel getLabel() {

        return label;

    }

}