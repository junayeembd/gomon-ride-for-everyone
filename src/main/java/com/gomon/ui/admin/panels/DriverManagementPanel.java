package com.gomon.ui.admin.panels;

import com.gomon.database.DatabaseConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DriverManagementPanel extends JPanel {

    private static final Color BACKGROUND = new Color(245, 247, 251);

    private static final Color CARD = Color.WHITE;

    private static final Color TEXT = new Color(35, 35, 50);

    private static final Color MUTED = new Color(110, 110, 125);

    private static final Color PURPLE = new Color(98, 71, 255);

    private static final Color GREEN = new Color(39, 174, 96);

    private static final Color RED = new Color(231, 76, 60);

    private JTable driverTable;

    private DefaultTableModel tableModel;

    private JTextField searchField;

    private JComboBox<String> vehicleFilter;

    private JLabel totalDriversLabel;
    private JLabel onlineDriversLabel;
    private JLabel offlineDriversLabel;

    public DriverManagementPanel() {

        setBackground(BACKGROUND);

        setLayout(new BorderLayout());

        add(
                createContent(),
                BorderLayout.CENTER);

        loadDrivers();
    }

    // =====================================================
    // CONTENT
    // =====================================================

    private JPanel createContent() {

        JPanel main = new JPanel(new BorderLayout());

        main.setBackground(BACKGROUND);

        main.setBorder(
                new EmptyBorder(
                        25, 28, 25, 28));

        JPanel content = new JPanel();

        content.setBackground(BACKGROUND);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS));

        content.add(createHeader());

        content.add(
                Box.createVerticalStrut(22));

        content.add(createStatistics());

        content.add(
                Box.createVerticalStrut(22));

        content.add(createSearchBar());

        content.add(
                Box.createVerticalStrut(15));

        content.add(createTableCard());

        JScrollPane scroll = new JScrollPane(content);

        scroll.setBorder(null);

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.getVerticalScrollBar()
                .setUnitIncrement(18);

        main.add(
                scroll,
                BorderLayout.CENTER);

        return main;
    }

    // =====================================================
    // HEADER
    // =====================================================

    private JPanel createHeader() {

        JPanel panel = new JPanel(new BorderLayout());

        panel.setOpaque(false);

        JLabel title = new JLabel("Driver Management");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27));

        title.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "View, verify and manage all GOMON drivers.");

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

    // =====================================================
    // STATISTICS
    // =====================================================

    private JPanel createStatistics() {

        JPanel panel = new JPanel(
                new GridLayout(
                        1,
                        3,
                        16,
                        0));

        panel.setOpaque(false);

        totalDriversLabel = new JLabel("0");

        onlineDriversLabel = new JLabel("0");

        offlineDriversLabel = new JLabel("0");

        panel.add(
                createStatCard(
                        "Total Drivers",
                        totalDriversLabel,
                        "Registered drivers"));

        panel.add(
                createStatCard(
                        "Online Drivers",
                        onlineDriversLabel,
                        "Currently available"));

        panel.add(
                createStatCard(
                        "Offline Drivers",
                        offlineDriversLabel,
                        "Currently unavailable"));

        return panel;
    }

    private JPanel createStatCard(
            String title,
            JLabel value,
            String subtitle) {

        JPanel card = new JPanel(new BorderLayout());

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

        JLabel subtitleLabel = new JLabel(subtitle);

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11));

        subtitleLabel.setForeground(
                new Color(145, 145, 160));

        JPanel text = new JPanel();

        text.setOpaque(false);

        text.setLayout(
                new BoxLayout(
                        text,
                        BoxLayout.Y_AXIS));

        text.add(titleLabel);

        text.add(
                Box.createVerticalStrut(6));

        text.add(value);

        text.add(
                Box.createVerticalStrut(4));

        text.add(subtitleLabel);

        card.add(
                text,
                BorderLayout.CENTER);

        return card;
    }

    // =====================================================
    // SEARCH + FILTER
    // =====================================================

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
                        310,
                        38));

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13));

        searchField.setToolTipText(
                "Search driver name, username, phone or vehicle");

        JButton searchButton = createButton(
                "Search",
                PURPLE);

        searchButton.addActionListener(
                e -> loadDrivers());

        JButton refreshButton = createButton(
                "Refresh",
                new Color(90, 95, 110));

        refreshButton.addActionListener(
                e -> {

                    searchField.setText("");

                    vehicleFilter.setSelectedIndex(0);

                    loadDrivers();
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

        JLabel filterLabel = new JLabel("Vehicle:");

        filterLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        vehicleFilter = new JComboBox<>(
                new String[] {
                        "All",
                        "Bike",
                        "Car",
                        "CNG",
                        "Auto",
                        "Truck/Pickup"
                });

        vehicleFilter.setPreferredSize(
                new Dimension(
                        145,
                        38));

        vehicleFilter.addActionListener(
                e -> loadDrivers());

        right.add(filterLabel);

        right.add(vehicleFilter);

        card.add(
                left,
                BorderLayout.WEST);

        card.add(
                right,
                BorderLayout.EAST);

        return card;
    }

    // =====================================================
    // TABLE
    // =====================================================

    private JPanel createTableCard() {

        JPanel card = new JPanel(new BorderLayout());

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
                "Driver",
                "Username",
                "Phone",
                "Vehicle",
                "Vehicle No.",
                "Work Time",
                "Online",
                "Actions"
        };

        tableModel = new DefaultTableModel(
                columns,
                0) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return column == 8;
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

        driverTable = new JTable(tableModel);

        driverTable.setRowHeight(50);

        driverTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12));

        driverTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                12));

        driverTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(
                                0,
                                42));

        driverTable.setShowGrid(false);

        driverTable.setIntercellSpacing(
                new Dimension(0, 1));

        driverTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        int[] widths = {
                45,
                140,
                110,
                110,
                90,
                110,
                100,
                80,
                190
        };

        for (int i = 0; i < widths.length; i++) {

            driverTable
                    .getColumnModel()
                    .getColumn(i)
                    .setPreferredWidth(
                            widths[i]);
        }

        driverTable
                .getColumnModel()
                .getColumn(7)
                .setCellRenderer(
                        new OnlineRenderer());

        driverTable
                .getColumnModel()
                .getColumn(8)
                .setCellRenderer(
                        new ActionRenderer());

        driverTable
                .getColumnModel()
                .getColumn(8)
                .setCellEditor(
                        new ActionEditor(
                                new JCheckBox()));

        JScrollPane scroll = new JScrollPane(
                driverTable);

        scroll.setBorder(null);

        scroll.setPreferredSize(
                new Dimension(
                        0,
                        470));

        card.add(
                scroll,
                BorderLayout.CENTER);

        return card;
    }

    // =====================================================
    // LOAD DRIVERS
    // =====================================================

    private void loadDrivers() {

        if (tableModel == null) {

            return;
        }

        tableModel.setRowCount(0);

        String search = searchField == null
                ? ""
                : searchField
                        .getText()
                        .trim();

        String vehicle = vehicleFilter == null
                ? "All"
                : String.valueOf(
                        vehicleFilter
                                .getSelectedItem());

        StringBuilder sql = new StringBuilder(
                """
                        SELECT
                            d.id,
                            a.name,
                            a.username,
                            a.phone,
                            d.vehicle_type,
                            d.vehicle_number,
                            d.work_time,
                            d.online_status
                        FROM driver_info d
                        INNER JOIN accounts a
                            ON d.account_id = a.id
                        WHERE a.role='driver'
                        """);

        if (!search.isEmpty()) {

            sql.append(
                    """
                            AND (
                                a.name LIKE ?
                                OR a.username LIKE ?
                                OR a.phone LIKE ?
                                OR d.vehicle_number LIKE ?
                            )
                            """);
        }

        if (!"All".equals(vehicle)) {

            sql.append(
                    " AND d.vehicle_type=? ");
        }

        sql.append(
                " ORDER BY d.id DESC");

        int total = 0;
        int online = 0;
        int offline = 0;

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

            if (!"All".equals(vehicle)) {

                ps.setString(
                        index,
                        vehicle);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");

                String name = safe(rs.getString("name"));

                String username = safe(rs.getString("username"));

                String phone = safe(rs.getString("phone"));

                String vehicleType = safe(
                        rs.getString(
                                "vehicle_type"));

                String vehicleNumber = safe(
                        rs.getString(
                                "vehicle_number"));

                String workTime = safe(
                        rs.getString(
                                "work_time"));

                String onlineStatus = safe(
                        rs.getString(
                                "online_status"));

                tableModel.addRow(
                        new Object[] {
                                id,
                                name,
                                username,
                                phone,
                                vehicleType,
                                vehicleNumber,
                                workTime,
                                onlineStatus,
                                "Actions"
                        });

                total++;

                if ("online".equalsIgnoreCase(
                        onlineStatus)) {

                    online++;

                } else {

                    offline++;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load drivers.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        totalDriversLabel.setText(
                String.valueOf(total));

        onlineDriversLabel.setText(
                String.valueOf(online));

        offlineDriversLabel.setText(
                String.valueOf(offline));
    }

    // =====================================================
    // VIEW DRIVER
    // =====================================================

    private void viewDriver(int driverId) {

        String sql = """
                SELECT
                    d.id,
                    a.name,
                    a.username,
                    a.email,
                    a.phone,
                    a.address,
                    d.nid,
                    d.driving_license,
                    d.vehicle_type,
                    d.vehicle_number,
                    d.work_time,
                    d.online_status
                FROM driver_info d
                INNER JOIN accounts a
                    ON d.account_id=a.id
                WHERE d.id=?
                """;

        try (
                Connection con = DatabaseConnection
                        .getConnection();

                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, driverId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Driver not found.",
                        "Not Found",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            JPanel info = new JPanel(
                    new GridLayout(
                            0,
                            2,
                            12,
                            10));

            info.setBorder(
                    new EmptyBorder(
                            15,
                            15,
                            15,
                            15));

            addInfo(
                    info,
                    "Driver ID",
                    String.valueOf(
                            rs.getInt("id")));

            addInfo(
                    info,
                    "Name",
                    rs.getString("name"));

            addInfo(
                    info,
                    "Username",
                    rs.getString("username"));

            addInfo(
                    info,
                    "Email",
                    rs.getString("email"));

            addInfo(
                    info,
                    "Phone",
                    rs.getString("phone"));

            addInfo(
                    info,
                    "Address",
                    rs.getString("address"));

            addInfo(
                    info,
                    "NID",
                    rs.getString("nid"));

            addInfo(
                    info,
                    "Driving License",
                    rs.getString(
                            "driving_license"));

            addInfo(
                    info,
                    "Vehicle Type",
                    rs.getString(
                            "vehicle_type"));

            addInfo(
                    info,
                    "Vehicle Number",
                    rs.getString(
                            "vehicle_number"));

            addInfo(
                    info,
                    "Work Time",
                    rs.getString(
                            "work_time"));

            addInfo(
                    info,
                    "Online Status",
                    rs.getString(
                            "online_status"));

            JOptionPane.showMessageDialog(
                    this,
                    info,
                    "Driver Details",
                    JOptionPane.PLAIN_MESSAGE);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Could not load driver details.\n\n"
                            + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addInfo(
            JPanel panel,
            String label,
            String value) {

        JLabel l = new JLabel(label + ":");

        l.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12));

        JLabel v = new JLabel(safe(value));

        v.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12));

        panel.add(l);
        panel.add(v);
    }

    // =====================================================
    // ONLINE / OFFLINE
    // =====================================================

    private void toggleOnlineStatus(
            int driverId,
            String currentStatus) {

        String newStatus = "online".equalsIgnoreCase(
                currentStatus)
                        ? "offline"
                        : "online";

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Change driver status to "
                        + newStatus
                        + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {

            return;
        }

        String sql = """
                UPDATE driver_info
                SET online_status=?
                WHERE id=?
                """;

        try (
                Connection con = DatabaseConnection
                        .getConnection();

                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(
                    1,
                    newStatus);

            ps.setInt(
                    2,
                    driverId);

            if (ps.executeUpdate() > 0) {

                loadDrivers();
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to update driver status.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // DELETE DRIVER
    // =====================================================

    private void deleteDriver(int driverId) {

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete this driver?\n"
                        + "This action cannot be undone.",
                "Delete Driver",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm != JOptionPane.YES_OPTION) {

            return;
        }

        try (
                Connection con = DatabaseConnection
                        .getConnection()) {

            con.setAutoCommit(false);

            try {

                String accountQuery = """
                        SELECT account_id
                        FROM driver_info
                        WHERE id=?
                        """;

                int accountId = -1;

                try (
                        PreparedStatement ps = con.prepareStatement(
                                accountQuery)) {

                    ps.setInt(
                            1,
                            driverId);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                        accountId = rs.getInt(
                                "account_id");
                    }
                }

                if (accountId == -1) {

                    con.rollback();

                    JOptionPane.showMessageDialog(
                            this,
                            "Driver not found.",
                            "Not Found",
                            JOptionPane.WARNING_MESSAGE);

                    return;
                }

                try (
                        PreparedStatement ps = con.prepareStatement(
                                """
                                        DELETE FROM driver_info
                                        WHERE id=?
                                        """)) {

                    ps.setInt(
                            1,
                            driverId);

                    ps.executeUpdate();
                }

                try (
                        PreparedStatement ps = con.prepareStatement(
                                """
                                        DELETE FROM accounts
                                        WHERE id=?
                                        """)) {

                    ps.setInt(
                            1,
                            accountId);

                    ps.executeUpdate();
                }

                con.commit();

                JOptionPane.showMessageDialog(
                        this,
                        "Driver deleted successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                loadDrivers();

            } catch (Exception e) {

                con.rollback();

                throw e;
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Failed to delete driver.\n\n"
                            + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================
    // BUTTON
    // =====================================================

    private JButton createButton(
            String text,
            Color color) {

        JButton button = new JButton(text);

        button.setPreferredSize(
                new Dimension(
                        90,
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
                        12,
                        8,
                        12));

        return button;
    }

    private JButton createSmallButton(
            String text,
            Color color) {

        JButton button = new JButton(text);

        button.setPreferredSize(
                new Dimension(
                        58,
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

    private String safe(String value) {

        return value == null
                ? ""
                : value;
    }

    // =====================================================
    // ONLINE RENDERER
    // =====================================================

    private class OnlineRenderer
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

            if ("online".equalsIgnoreCase(
                    String.valueOf(value))) {

                label.setForeground(GREEN);

            } else {

                label.setForeground(
                        new Color(
                                130,
                                130,
                                140));
            }

            return label;
        }
    }

    // =====================================================
    // ACTION RENDERER
    // =====================================================

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

        ActionRenderer() {

            setOpaque(true);

            setLayout(
                    new FlowLayout(
                            FlowLayout.CENTER,
                            3,
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

    // =====================================================
    // ACTION EDITOR
    // =====================================================

    private class ActionEditor
            extends DefaultCellEditor {

        private final JPanel panel = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        3,
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

        ActionEditor(JCheckBox checkBox) {

            super(checkBox);

            panel.setBackground(Color.WHITE);

            panel.add(view);
            panel.add(status);
            panel.add(delete);

            view.addActionListener(
                    e -> viewAction());

            status.addActionListener(
                    e -> statusAction());

            delete.addActionListener(
                    e -> deleteAction());
        }

        private void viewAction() {

            int row = driverTable.getEditingRow();

            if (row < 0)
                return;

            int id = (int) tableModel
                    .getValueAt(
                            row,
                            0);

            stopCellEditing();

            viewDriver(id);
        }

        private void statusAction() {

            int row = driverTable.getEditingRow();

            if (row < 0)
                return;

            int id = (int) tableModel
                    .getValueAt(
                            row,
                            0);

            String status = String.valueOf(
                    tableModel
                            .getValueAt(
                                    row,
                                    7));

            stopCellEditing();

            toggleOnlineStatus(
                    id,
                    status);
        }

        private void deleteAction() {

            int row = driverTable.getEditingRow();

            if (row < 0)
                return;

            int id = (int) tableModel
                    .getValueAt(
                            row,
                            0);

            stopCellEditing();

            deleteDriver(id);
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
}