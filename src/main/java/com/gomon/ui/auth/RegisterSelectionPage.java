package com.gomon.ui.auth;

import com.gomon.ui.components.GradientPanel;
import com.gomon.ui.components.SelectionCard;
import com.gomon.ui.components.ShadowPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterSelectionPage extends JFrame {

    public RegisterSelectionPage() {
        initialize();
    }

    private void initialize() {

        setTitle("Join GOMON");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));

        setIconImage(icon.getImage());
        setSize(1500, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradientPanel background = new GradientPanel();
        background.setLayout(null);

        setContentPane(background);
        createMainCard(background);
        setVisible(true);
    }

    private void createMainCard(JPanel parent) {

        ShadowPanel card = new ShadowPanel();

        card.setBounds(460, 30, 480, 780);
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        parent.add(card);
        card.add(Box.createVerticalStrut(25));

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/logo/logo.png"));
        Image image = logoIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);

        JLabel logo = new JLabel(new ImageIcon(image));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(logo);
        card.add(Box.createVerticalStrut(15));

        JLabel title = new JLabel("JOIN GOMON");

        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(0, 150, 136));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(title);
        card.add(Box.createVerticalStrut(8));

        JLabel subtitle = new JLabel("Choose your role to continue");

        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(subtitle);
        card.add(Box.createVerticalStrut(30));

        SelectionCard passengerCard = new SelectionCard("👤", "Passenger", "Book rides safely with GOMON");

        passengerCard.setAlignmentX(Component.CENTER_ALIGNMENT);
        passengerCard.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new UserRegisterPage();
            }
        });

        card.add(passengerCard);
        card.add(Box.createVerticalStrut(18));

        SelectionCard driverCard = new SelectionCard("🚖", "Driver", "Earn money by giving rides");

        driverCard.setAlignmentX(Component.CENTER_ALIGNMENT);
        driverCard.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new DriverRegisterPage();
            }
        });

        card.add(driverCard);
        card.add(Box.createVerticalStrut(30));

        JButton backButton = new JButton("← Back to Login");

        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setForeground(new Color(0, 150, 136));
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            dispose();
            new LoginPage();
        });

        backButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                backButton.setForeground(new Color(33, 150, 243));
            }

            @Override
            public void mouseExited(MouseEvent e) {

                backButton.setForeground(new Color(0, 150, 136));
            }

        });

        card.add(backButton);
    }
}