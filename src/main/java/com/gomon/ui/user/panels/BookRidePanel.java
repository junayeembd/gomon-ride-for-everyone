package com.gomon.ui.user.panels;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.RoundedButton;
import com.gomon.ui.components.ShadowCard;
import com.gomon.ui.components.Dashboard.DashboardTextField;

public class BookRidePanel extends ShadowCard {

    private DashboardTextField pickupField;
    private DashboardTextField destinationField;

    private JComboBox<String> vehicleBox;

    private JLabel fareValue;
    private JLabel timeValue;

    private JRadioButton rideNowRadio;
    private JRadioButton scheduleRadio;

    private ButtonGroup rideGroup;

    private RoundedButton bookButton;

    public BookRidePanel() {

        setLayout(new BorderLayout());
        setCardColor(Color.WHITE);

        JPanel root = new JPanel(new BorderLayout());
        root.setOpaque(false);
        root.setBorder(new EmptyBorder(20, 20, 20, 20));

        // ------------------------------------
        // Header
        // ------------------------------------

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Book a Ride");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel subtitle = new JLabel(
                "Quick ride booking from dashboard");

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(new Color(120, 120, 120));

        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(4));
        header.add(subtitle);

        // ------------------------------------
        // Initialize Components
        // ------------------------------------

        pickupField = new DashboardTextField();
        pickupField.setPlaceholder("Enter pickup location");

        destinationField = new DashboardTextField();
        destinationField.setPlaceholder("Enter destination");

        vehicleBox = new JComboBox<>(new String[] {
                "Bike",
                "Car",
                "CNG",
                "Auto",
                "Microbus"
        });

        vehicleBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        fareValue = new JLabel("৳180");
        fareValue.setFont(new Font("Segoe UI", Font.BOLD, 18));
        fareValue.setForeground(new Color(0, 150, 136));

        timeValue = new JLabel("12 Minutes");
        timeValue.setFont(new Font("Segoe UI", Font.BOLD, 16));

        rideNowRadio = new JRadioButton("Ride Now");
        scheduleRadio = new JRadioButton("Schedule Ride");

        rideNowRadio.setOpaque(false);
        scheduleRadio.setOpaque(false);

        rideNowRadio.setSelected(true);

        rideGroup = new ButtonGroup();
        rideGroup.add(rideNowRadio);
        rideGroup.add(scheduleRadio);

        bookButton = new RoundedButton("Book Ride");

        // ------------------------------------
        // Fix Component Size
        // ------------------------------------

        configureField(pickupField);
        configureField(destinationField);
        configureField(vehicleBox);

        bookButton.setPreferredSize(new Dimension(200, 45));
        bookButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        // ------------------------------------
        // Layout
        // ------------------------------------

        root.add(header, BorderLayout.NORTH);
        root.add(createFormPanel(), BorderLayout.CENTER);

        add(root, BorderLayout.CENTER);
    }

    private JPanel createFormPanel() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(0, 0, 12, 0);

        // ====================================
        // Pickup
        // ====================================

        gbc.gridy = 0;

        JLabel pickupLabel = new JLabel("Pickup Location");
        pickupLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panel.add(pickupLabel, gbc);

        gbc.gridy++;

        panel.add(pickupField, gbc);

        // ====================================
        // Destination
        // ====================================

        gbc.gridy++;

        JLabel destinationLabel = new JLabel("Destination");
        destinationLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panel.add(destinationLabel, gbc);

        gbc.gridy++;

        panel.add(destinationField, gbc);

        // ====================================
        // Vehicle
        // ====================================

        gbc.gridy++;

        JLabel vehicleLabel = new JLabel("Vehicle Type");
        vehicleLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panel.add(vehicleLabel, gbc);

        gbc.gridy++;

        panel.add(vehicleBox, gbc);

        // ====================================
        // Fare & Time
        // ====================================

        gbc.gridy++;

        JPanel infoPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        infoPanel.setOpaque(false);

        JPanel fareCard = new JPanel();
        fareCard.setOpaque(true);
        fareCard.setBackground(new Color(245, 247, 252));
        fareCard.setBorder(new EmptyBorder(10, 12, 10, 12));
        fareCard.setLayout(new BoxLayout(fareCard, BoxLayout.Y_AXIS));

        JLabel fareTitle = new JLabel("Estimated Fare");
        fareTitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        fareTitle.setForeground(new Color(120, 120, 120));

        fareCard.add(fareTitle);
        fareCard.add(Box.createVerticalStrut(5));
        fareCard.add(fareValue);

        JPanel timeCard = new JPanel();
        timeCard.setOpaque(true);
        timeCard.setBackground(new Color(245, 247, 252));
        timeCard.setBorder(new EmptyBorder(10, 12, 10, 12));
        timeCard.setLayout(new BoxLayout(timeCard, BoxLayout.Y_AXIS));

        JLabel timeTitle = new JLabel("Estimated Time");
        timeTitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        timeTitle.setForeground(new Color(120, 120, 120));

        timeCard.add(timeTitle);
        timeCard.add(Box.createVerticalStrut(5));
        timeCard.add(timeValue);

        infoPanel.add(fareCard);
        infoPanel.add(timeCard);

        panel.add(infoPanel, gbc);

        // ====================================
        // Ride Type
        // ====================================

        gbc.gridy++;

        JLabel rideTypeLabel = new JLabel("Ride Type");
        rideTypeLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        panel.add(rideTypeLabel, gbc);

        gbc.gridy++;

        JPanel ridePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        ridePanel.setOpaque(false);

        ridePanel.add(rideNowRadio);
        ridePanel.add(scheduleRadio);

        panel.add(ridePanel, gbc);

        // ====================================
        // Push Button to Bottom
        // ====================================

        gbc.gridy++;
        gbc.weighty = 100;
        gbc.fill = GridBagConstraints.BOTH;

        panel.add(Box.createGlue(), gbc);
        gbc.gridy++;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 0, 0, 0);

        pickupField.setColumns(20);
        destinationField.setColumns(20);
        panel.add(bookButton, gbc);

        return panel;
    }
    // ====================================
    // Component Size Helper
    // ====================================

    private void configureField(JComponent component) {

        component.setPreferredSize(new Dimension(100, 42));

        component.setMinimumSize(new Dimension(100, 42));

        component.setMaximumSize(new Dimension(Short.MAX_VALUE, 42));
    }

    // ====================================
    // Update Methods
    // ====================================

    public void setEstimatedFare(String fare) {
        fareValue.setText(fare);
    }

    public void setEstimatedTime(String time) {
        timeValue.setText(time);
    }

    // ====================================
    // Getters
    // ====================================

    public DashboardTextField getPickupField() {
        return pickupField;
    }

    public DashboardTextField getDestinationField() {
        return destinationField;
    }

    public JComboBox<String> getVehicleBox() {
        return vehicleBox;
    }

    public RoundedButton getBookButton() {
        return bookButton;
    }

    public JRadioButton getRideNowRadio() {
        return rideNowRadio;
    }

    public JRadioButton getScheduleRadio() {
        return scheduleRadio;
    }
}