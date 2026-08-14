package com.gomon.service;

import com.gomon.dao.AccountDAO;
import com.gomon.utils.PasswordHasher;
import com.gomon.utils.OTPGenerator;
import com.gomon.utils.EmailSender;
import com.gomon.model.User;
import com.gomon.model.Driver;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {

    private final AccountDAO accountDAO = new AccountDAO();
    private static final Map<String, String> otpStorage = new HashMap<>();

    public boolean resetPassword(String email, String newPassword) {

        String hashedPassword = PasswordHasher.hash(newPassword);

        return accountDAO.updatePassword(email, hashedPassword);

    }

    public boolean accountExists(String identifier) {

        return accountDAO.accountExists(identifier);

    }

    public boolean sendOTP(String identifier) {

        String otp = OTPGenerator.generateOTP();

        otpStorage.put(identifier, otp);

        return EmailSender.sendOTP(identifier, otp);

    }

    public boolean verifyOTP(String identifier, String otp) {

        String savedOTP = otpStorage.get(identifier);

        if (savedOTP == null) {

            return false;

        }

        return savedOTP.equals(otp);

    }

    public User login(String usernameOrEmail, String password) {

        User user = accountDAO.getUserByUsernameOrEmail(usernameOrEmail);

        if (user == null) {
            return null;
        }

        if (!PasswordHasher.verify(password, user.getPassword())) {
            return null;
        }

        return user;
    }

    public void registerUser(User user) {

        if (accountDAO.usernameExists(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        if (accountDAO.emailExists(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        if (accountDAO.phoneExists(user.getPhone())) {
            throw new IllegalArgumentException("Phone number already exists.");
        }

        user.setPassword(PasswordHasher.hash(user.getPassword()));
        user.setRole("USER");

        if (!accountDAO.insertUser(user)) {
            throw new RuntimeException("Unable to register user.");
        }
    }

    public void registerDriver(Driver driver) {

        if (accountDAO.usernameExists(driver.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        if (accountDAO.emailExists(driver.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        if (accountDAO.phoneExists(driver.getPhone())) {
            throw new IllegalArgumentException("Phone number already exists.");
        }

        driver.setPassword(PasswordHasher.hash(driver.getPassword()));
        driver.setRole("DRIVER");

        if (!accountDAO.insertDriver(driver)) {
            throw new RuntimeException("Unable to register driver.");
        }
    }

}