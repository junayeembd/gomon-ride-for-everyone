package com.gomon.ui.admin.panels;

import com.gomon.database.DatabaseConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserManagementPanel extends JPanel {

    private final Color BACKGROUND = new Color(245, 247, 251);
    private final Color CARD = Color.WHITE;
    private final Color TEXT = new Color(35, 35, 50);
    private final Color MUTED = new Color(110, 110, 125);
    private final Color PURPLE = new Color(98, 71, 255);
    private final Color GREEN = new Color(39, 174, 96);
    private final Color RED = new Color(231, 76, 60);

    private JTable userTable;
    private DefaultTableModel tableModel;

    private JTextField searchField;
    private JComboBox<String> statusFilter;

    private JLabel totalUsersLabel;
    private JLabel activeUsersLabel;
    private JLabel suspendedUsersLabel;

    public UserManagementPanel() {

        setBackground(BACKGROUND);
        setLayout(new BorderLayout());

        add(createMainContent(), BorderLayout.CENTER);

        loadUsers();
    }

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private JPanel createMainContent() {

        JPanel main = new JPanel(new BorderLayout());

        main.setBackground(BACKGROUND);
        main.setBorder(
                new EmptyBorder(25, 28, 25, 28));

        JPanel content = new JPanel();

        content.setBackground(BACKGROUND);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS));

        content.add(createHeader());

        content.add(Box.createVerticalStrut(22));

        content.add(createStatistics());

        content.add(Box.createVerticalStrut(22));

        content.add(createSearchBar());

        content.add(Box.createVerticalStrut(15));

        content.add(createTableCard());

        JScrollPane scroll = new JScrollPane(content);

        scroll.setBorder(null);

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.getVerticalScrollBar()
                .setUnitIncrement(18);

        main.add(scroll, BorderLayout.CENTER);

        return main;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private JPanel createHeader() {

        JPanel panel = new JPanel(
                new BorderLayout());

        panel.setOpaque(false);

        JLabel title = new JLabel(
                "User Management");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27));

        title.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "View, search and manage all GOMON passenger accounts.");

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        subtitle.setForeground(MUTED);

        JPanel text = new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS));

        text.add(title);

        text.add(
                Box.createVerticalStrut(5));

        text.add(subtitle);

        panel.add(
                text,
                BorderLayout.WEST);

        return panel;
    }

    // =========================================================
    // STATISTICS
    // =========================================================

    private JPanel createStatistics() {

        JPanel panel = new JPanel(
                new GridLayout(
                        1,
                        3,
                        16,
                        0));

        panel.setOpaque(false);

        totalUsersLabel = new JLabel("0");

        activeUsersLabel = new JLabel("0");

        suspendedUsersLabel = new JLabel("0");

        panel.add(
                createStatCard(
                        "Total Users",
                        totalUsersLabel,
                        "All registered passengers"));

        panel.add(
                createStatCard(
                        "Active Users",
                        activeUsersLabel,
                        "Currently active accounts"));

        panel.add(
                createStatCard(
                        "Suspended Users",
                        suspendedUsersLabel,
                        "Restricted accounts"));

        return panel;
    }

    private JPanel createStatCard(
            String title,
            JLabel value,
            String subtitle) {

        JPanel card = new JPanel(
                new BorderLayout());

        card.setBackground(CARD);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(230, 232, 238)),
                        new EmptyBorder(
                                17,
                                20,
                                17,
                                20)));

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        titleLabel.setForeground(MUTED);

        value.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27));

        value.setForeground(TEXT);

        JLabel sub = new JLabel(subtitle);

        sub.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11));

        sub.setForeground(
                new Color(145, 145, 160));

        JPanel center = new JPanel();

        center.setOpaque(false);

        center.setLayout(
                new BoxLayout(
                        center,
                        BoxLayout.Y_AXIS));

        center.add(titleLabel);

        center.add(
                Box.createVerticalStrut(6));

        center.add(value);

        center.add(
                Box.createVerticalStrut(4));

        center.add(sub);

        card.add(
                center,
                BorderLayout.CENTER);

        return card;
    }

    // =========================================================
    // SEARCH / FILTER
    // =========================================================

    private JPanel createSearchBar() {

        JPanel card = new JPanel(
                new BorderLayout(
                        15,
                        0));

        card.setBackground(CARD);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(230, 232, 238)),
                        new EmptyBorder(
                                13,
                                15,
                                13,
                                15)));

        JPanel left = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        8,
                        0));

        left.setOpaque(false);

        searchField = new JTextField();

        searchField.setPreferredSize(
                new Dimension(
                        320,
                        38));

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        searchField.setToolTipText(
                "Search name, username, email or phone");

        JButton searchButton = createButton(
                "Search",
                PURPLE);

        searchButton.addActionListener(
                e -> loadUsers());

        JButton refreshButton = createButton(
                "Refresh",
                new Color(90, 95, 110));

        refreshButton.addActionListener(
                e -> {

                    searchField.setText("");

                    statusFilter.setSelectedIndex(0);

                    loadUsers();
                });

        left.add(searchField);

        left.add(searchButton);

        left.add(refreshButton);

        JPanel right = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        5,
                        0));

        right.setOpaque(false);

        JLabel filterLabel = new JLabel("Status:");

        filterLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        statusFilter = new JComboBox<>(
                new String[] {
                        "All",
                        "active",
                        "suspended"
                });

        statusFilter.setPreferredSize(
                new Dimension(
                        130,
                        38));

        statusFilter.addActionListener(
                e -> {

                    if (statusFilter != null) {

                        loadUsers();
                    }
                });

        right.add(filterLabel);

        right.add(statusFilter);

        card.add(
                left,
                BorderLayout.WEST);

        card.add(
                right,
                BorderLayout.EAST);

        return card;
    }

    // =========================================================
    // TABLE CARD
    // =========================================================

    private JPanel createTableCard() {

        JPanel card = new JPanel(
                new BorderLayout());

        card.setBackground(CARD);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(230, 232, 238)),
                        new EmptyBorder(
                                15,
                                15,
                                15,
                                15)));

        String[] columns = {
                "ID",
                "Name",
                "Username",
                "Email",
                "Phone",
                "Status",
                "Actions"
        };

        tableModel = new DefaultTableModel(
                columns,
                0) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return column == 6;
            }

            @Override
            public Class<?> getColumnClass(
                    int column) {

                if (column == 0) {

                    return Integer.class;
                }

                return String.class;
            }
        };

        userTable = new JTable(tableModel);

        userTable.setRowHeight(52);

        userTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        userTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                12));

        userTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                0,
                                42));

        userTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        userTable.setShowGrid(false);

        userTable.setIntercellSpacing(
                new Dimension(0, 1));

        // Column widths

        userTable.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(50);

        userTable.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(150);

        userTable.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(120);

        userTable.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(220);

        userTable.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(120);

        userTable.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(100);

        userTable.getColumnModel()
                .getColumn(6)
                .setPreferredWidth(210);

        // Status renderer

        userTable.getColumnModel()
                .getColumn(5)
                .setCellRenderer(
                        new StatusRenderer());

        // Action renderer

        userTable.getColumnModel()
                .getColumn(6)
                .setCellRenderer(
                        new ActionRenderer());

        userTable.getColumnModel()
                .getColumn(6)
                .setCellEditor(
                        new ActionEditor(
                                new JCheckBox()));

        JScrollPane tableScroll = new JScrollPane(
                userTable);

        tableScroll.setBorder(null);

        tableScroll.setPreferredSize(
                new Dimension(
                        0,
                        450));

        card.add(
                tableScroll,
                BorderLayout.CENTER);

        return card;
    }

    // =========================================================
    // LOAD USERS
    // =========================================================

    private void loadUsers() {

        if (tableModel == null) {

            return;
        }

        tableModel.setRowCount(0);

        String search = searchField == null
                ? ""
                : searchField
                        .getText()
                        .trim();

        String status = statusFilter == null
                ? "All"
                : (String) statusFilter
                        .getSelectedItem();

        int total = 0;

        int active = 0;

        int suspended = 0;

        StringBuilder sql = new StringBuilder(
                """
                        SELECT id, name, username,
                               email, phone, status
                        FROM accounts
                        WHERE role='user'
                        """);

        if (!search.isEmpty()) {

            sql.append(
                    """
                            AND (
                                name LIKE ?
                                OR username LIKE ?
                                OR email LIKE ?
                                OR phone LIKE ?
                            )
                            """);
        }

        if (!"All".equals(status)) {

            sql.append(
                    " AND status=? ");
        }

        sql.append(
                " ORDER BY id DESC");

        try (
                Connection con = DatabaseConnection
                        .getConnection();

                PreparedStatement ps = con.prepareStatement(
                        sql.toString())) {

            int index = 1;

            if (!search.isEmpty()) {

                String keyword = "%" + search + "%";

                ps.setString(
                        index++,
                        keyword);

                ps.setString(
                        index++,
                        keyword);

                ps.setString(
                        index++,
                        keyword);

                ps.setString(
                        index++,
                        keyword);
            }

            if (!"All".equals(status)) {

                ps.setString(
                        index,
                        status);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");

                String name = safe(rs.getString("name"));

                String username = safe(rs.getString("username"));

                String email = safe(rs.getString("email"));

                String phone = safe(rs.getString("phone"));

                String accountStatus = safe(rs.getString("status"));

                tableModel.addRow(
                        new Object[] {
                                id,
                                name,
                                username,
                                email,
                                phone,
                                accountStatus,
                                "Actions"
                        });

                total++;

                if ("active".equalsIgnoreCase(
                        accountStatus)) {

                    active++;

                } else if ("suspended".equalsIgnoreCase(
                        accountStatus)) {

                    suspended++;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load users.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        totalUsersLabel.setText(
                String.valueOf(total));

        activeUsersLabel.setText(
                String.valueOf(active));

        suspendedUsersLabel.setText(
                String.valueOf(suspended));
    }

    // =========================================================
    // VIEW USER
    // =========================================================

    private void viewUser(int userId) {

        String sql = """
                SELECT id,name,username,email,
                       phone,address,status
                FROM accounts
                WHERE id=? AND role='user'
                """;

        try (
                Connection con = DatabaseConnection
                        .getConnection();

                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {

                JOptionPane.showMessageDialog(
                        this,
                        "User not found.",
                        "Not Found",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            JPanel panel = new JPanel();

            panel.setLayout(
                    new GridLayout(
                            0,
                            2,
                            10,
                            10));

            panel.setBorder(
                    new EmptyBorder(
                            15,
                            15,
                            15,
                            15));

            addInfo(
                    panel,
                    "ID",
                    String.valueOf(
                            rs.getInt("id")));

            addInfo(
                    panel,
                    "Name",
                    rs.getString("name"));

            addInfo(
                    panel,
                    "Username",
                    rs.getString("username"));

            addInfo(
                    panel,
                    "Email",
                    rs.getString("email"));

            addInfo(
                    panel,
                    "Phone",
                    rs.getString("phone"));

            addInfo(
                    panel,
                    "Address",
                    rs.getString("address"));

            addInfo(
                    panel,
                    "Status",
                    rs.getString("status"));

            JOptionPane.showMessageDialog(
                    this,
                    panel,
                    "User Details",
                    JOptionPane.PLAIN_MESSAGE);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Could not load user details.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addInfo(
            JPanel panel,
            String label,
            String value) {

        JLabel l = new JLabel(
                label + ":");

        l.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        JLabel v = new JLabel(
                safe(value));

        v.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12));

        panel.add(l);
        panel.add(v);
    }

    // =========================================================
    // SUSPEND / ACTIVATE
    // =========================================================

    private void toggleUserStatus(
            int userId,
            String currentStatus) {

        String newStatus = "suspended".equalsIgnoreCase(
                currentStatus)
                        ? "active"
                        : "suspended";

        String message = newStatus.equals("suspended")
                ? "Suspend this user?"
                : "Activate this user?";

        int confirm = JOptionPane.showConfirmDialog(
                this,
                message,
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {

            return;
        }

        String sql = "UPDATE accounts SET status=? "
                + "WHERE id=? AND role='user'";

        try (
                Connection con = DatabaseConnection
                        .getConnection();

                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(
                    1,
                    newStatus);

            ps.setInt(
                    2,
                    userId);

            int updated = ps.executeUpdate();

            if (updated > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "User status updated successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                loadUsers();
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to update user status.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =========================================================
    // DELETE
    // =========================================================

    private void deleteUser(int userId) {

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this user?\n"
                        + "This action cannot be undone.",
                "Delete User",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm != JOptionPane.YES_OPTION) {

            return;
        }

        String sql = "DELETE FROM accounts "
                + "WHERE id=? AND role='user'";

        try (
                Connection con = DatabaseConnection
                        .getConnection();

                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(
                    1,
                    userId);

            int deleted = ps.executeUpdate();

            if (deleted > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "User deleted successfully.",
                        "Deleted",
                        JOptionPane.INFORMATION_MESSAGE);

                loadUsers();
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Could not delete user.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =========================================================
    // BUTTON
    // =========================================================

    private JButton createButton(
            String text,
            Color color) {

        JButton button = new JButton(text);

        button.setPreferredSize(
                new Dimension(
                        95,
                        38));

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        14,
                        8,
                        14));

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR));

        return button;
    }

    private String safe(String value) {

        return value == null
                ? ""
                : value;
    }

    // =========================================================
    // STATUS RENDERER
    // =========================================================

    private class StatusRenderer
            extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean selected,
                boolean focused,
                int row,
                int column) {

            JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table,
                    value,
                    selected,
                    focused,
                    row,
                    column);

            label.setHorizontalAlignment(
                    JLabel.CENTER);

            label.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            11));

            if ("active".equalsIgnoreCase(
                    String.valueOf(value))) {

                label.setForeground(GREEN);

            } else {

                label.setForeground(RED);
            }

            return label;
        }
    }

    // =========================================================
    // ACTION RENDERER
    // =========================================================

    private class ActionRenderer
            extends JPanel
            implements TableCellRenderer {

        private final JButton view = createSmallButton(
                "View",
                PURPLE);

        private final JButton status = createSmallButton(
                "Status",
                GREEN);

        private final JButton delete = createSmallButton(
                "Delete",
                RED);

        public ActionRenderer() {

            setOpaque(true);

            setLayout(
                    new FlowLayout(
                            FlowLayout.CENTER,
                            4,
                            7));

            add(view);
            add(status);
            add(delete);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean selected,
                boolean focused,
                int row,
                int column) {

            setBackground(
                    selected
                            ? table
                                    .getSelectionBackground()
                            : Color.WHITE);

            return this;
        }
    }

    // =========================================================
    // ACTION EDITOR
    // =========================================================

    private class ActionEditor
            extends DefaultCellEditor {

        private final JPanel panel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        4,
                        7));

        private final JButton view = createSmallButton(
                "View",
                PURPLE);

        private final JButton status = createSmallButton(
                "Status",
                GREEN);

        private final JButton delete = createSmallButton(
                "Delete",
                RED);

        public ActionEditor(
                JCheckBox checkBox) {

            super(checkBox);

            panel.setBackground(Color.WHITE);

            panel.add(view);
            panel.add(status);
            panel.add(delete);

            view.addActionListener(
                    this::viewAction);

            status.addActionListener(
                    this::statusAction);

            delete.addActionListener(
                    this::deleteAction);
        }

        private void viewAction(
                ActionEvent e) {

            int row = userTable.getEditingRow();

            if (row >= 0) {

                int id = (int) tableModel
                        .getValueAt(
                                row,
                                0);

                stopCellEditing();

                viewUser(id);
            }
        }

        private void statusAction(
                ActionEvent e) {

            int row = userTable.getEditingRow();

            if (row >= 0) {

                int id = (int) tableModel
                        .getValueAt(
                                row,
                                0);

                String status = String.valueOf(
                        tableModel
                                .getValueAt(
                                        row,
                                        5));

                stopCellEditing();

                toggleUserStatus(
                        id,
                        status);
            }
        }

        private void deleteAction(
                ActionEvent e) {

            int row = userTable.getEditingRow();

            if (row >= 0) {

                int id = (int) tableModel
                        .getValueAt(
                                row,
                                0);

                stopCellEditing();

                deleteUser(id);
            }
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table,
                Object value,
                boolean selected,
                int row,
                int column) {

            return panel;
        }

        @Override
        public Object getCellEditorValue() {

            return "Actions";
        }
    }

    // =========================================================
    // SMALL BUTTON
    // =========================================================

    private JButton createSmallButton(
            String text,
            Color color) {

        JButton button = new JButton(text);

        button.setPreferredSize(
                new Dimension(
                        62,
                        28));

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        10));

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        return button;
    }
}