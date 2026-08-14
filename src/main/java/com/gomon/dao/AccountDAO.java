package com.gomon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.gomon.database.DatabaseConnection;
import com.gomon.model.User;
import com.gomon.model.Driver;
import java.sql.Statement;

public class AccountDAO {
    public boolean updatePassword(String email, String password) {

        String sql = "UPDATE account SET password=? WHERE email=?";

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, password);

            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

    public boolean accountExists(String identifier) {

        String sql = """
                SELECT id
                FROM account
                WHERE email = ? OR phone = ?
                """;

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, identifier);
            ps.setString(2, identifier);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public User getUserByUsernameOrEmail(String usernameOrEmail) {

        String sql = """
                SELECT *
                FROM account
                WHERE username = ?
                   OR email = ?
                """;

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usernameOrEmail);
            ps.setString(2, usernameOrEmail);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("full_name"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean usernameExists(String username) {

        String sql = "SELECT id FROM account WHERE username = ?";

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean emailExists(String email) {

        String sql = "SELECT id FROM account WHERE email = ?";

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean phoneExists(String phone) {

        String sql = "SELECT id FROM account WHERE phone = ?";

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phone);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insertUser(User user) {

        String sql = """
                INSERT INTO account
                (full_name, username, email, phone,
                 address, password, role, status)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getPassword()); // BCrypt Hash
            ps.setString(7, user.getRole());
            ps.setString(8, "ACTIVE");

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean insertDriver(Driver driver) {

        String accountSql = """
                INSERT INTO account
                (full_name, username, email, phone,
                 address, password, role, status)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        String driverSql = """
                INSERT INTO driver_info
                (account_id, nid, driving_license,
                 vehicle_type, vehicle_number, work_time)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        Connection con = null;

        try {

            con = DatabaseConnection.getConnection();
            con.setAutoCommit(false);

            // Insert into account
            PreparedStatement ps1 = con.prepareStatement(
                    accountSql,
                    Statement.RETURN_GENERATED_KEYS);

            ps1.setString(1, driver.getFullName());
            ps1.setString(2, driver.getUsername());
            ps1.setString(3, driver.getEmail());
            ps1.setString(4, driver.getPhone());
            ps1.setString(5, driver.getAddress());
            ps1.setString(6, driver.getPassword());
            ps1.setString(7, "DRIVER");
            ps1.setString(8, "ACTIVE");

            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();

            if (!rs.next()) {
                con.rollback();
                return false;
            }

            int accountId = rs.getInt(1);

            // Insert into driver_info
            PreparedStatement ps2 = con.prepareStatement(driverSql);

            ps2.setInt(1, accountId);
            ps2.setString(2, driver.getNid());
            ps2.setString(3, driver.getDrivingLicense());
            ps2.setString(4, driver.getVehicleType());
            ps2.setString(5, driver.getVehicleNumber());
            ps2.setString(6, driver.getWorkTime());

            ps2.executeUpdate();

            con.commit();

            return true;

        } catch (Exception e) {

            try {
                if (con != null)
                    con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {
                if (con != null) {
                    con.setAutoCommit(true);
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return false;
    }
}
