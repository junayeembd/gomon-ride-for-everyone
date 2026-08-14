package com.gomon.ui.components;

import javax.swing.*;
import java.awt.*;

public class LabeledField extends JPanel {

    private final JLabel label;
    private final RoundedTextField textField;

    public LabeledField(String labelText, String placeholder) {

        setOpaque(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setAlignmentX(Component.CENTER_ALIGNMENT);

        setMaximumSize(new Dimension(380, 70));

        // Label
        label = new JLabel(labelText);

        label.setFont(new Font("Segoe UI", Font.BOLD, 14));

        label.setForeground(new Color(60, 60, 60));

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(label);

        add(Box.createVerticalStrut(6));

        // Text Field
        textField = new RoundedTextField();

        textField.setPlaceholder(placeholder);

        textField.setMaximumSize(new Dimension(380, 45));

        textField.setPreferredSize(new Dimension(380, 45));

        textField.setAlignmentX(Component.LEFT_ALIGNMENT);

        add(textField);
    }

    // ===========================
    // Getter
    // ===========================

    public RoundedTextField getTextField() {
        return textField;
    }

    public String getText() {
        return textField.getText().trim();
    }

    public void setText(String text) {
        textField.setText(text);
    }

    public void clear() {
        textField.setText("");
    }

    public JLabel getLabel() {
        return label;
    }
}