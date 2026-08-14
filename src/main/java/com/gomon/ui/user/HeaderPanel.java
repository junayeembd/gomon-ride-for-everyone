package com.gomon.ui.user;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.gomon.ui.components.AvatarButton;
import com.gomon.ui.components.NotificationButton;
import com.gomon.ui.components.RoundedSearchField;

public class HeaderPanel extends JPanel {

    public HeaderPanel() {

        setPreferredSize(new Dimension(0, 85));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(20, 0));
        setBorder(new EmptyBorder(15, 25, 15, 25));

        add(createSearchPanel(), BorderLayout.CENTER);
        add(createProfilePanel(), BorderLayout.EAST);
    }

    private JPanel createSearchPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        RoundedSearchField search = new RoundedSearchField("Search for destinations, places...");

        panel.add(search);

        return panel;
    }

    private JPanel createProfilePanel() {

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 18, 0));

        NotificationButton notification = new NotificationButton();

        AvatarButton avatar = new AvatarButton("A");

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        JLabel name = new JLabel("Asif Ahmed");
        name.setFont(new Font("Segoe UI", Font.BOLD, 17));

        JLabel premium = new JLabel("Premium User 👑");
        premium.setForeground(new Color(255, 170, 0));
        premium.setFont(new Font("Segoe UI", Font.PLAIN, 13));

        info.add(name);
        info.add(premium);

        JPopupMenu profileMenu = new JPopupMenu();

        JMenuItem view = new JMenuItem("View Profile");
        JMenuItem update = new JMenuItem("Update Profile");
        JMenuItem password = new JMenuItem("Change Password");
        JMenuItem settings = new JMenuItem("Settings");
        JMenuItem logout = new JMenuItem("Logout");

        profileMenu.add(view);
        profileMenu.add(update);
        profileMenu.add(password);
        profileMenu.add(settings);
        profileMenu.addSeparator();
        profileMenu.add(logout);

        panel.add(notification);
        panel.add(avatar);
        panel.add(info);
        avatar.addActionListener(e -> {

            profileMenu.show(
                    avatar,
                    0,
                    avatar.getHeight());

        });
        return panel;
    }
}