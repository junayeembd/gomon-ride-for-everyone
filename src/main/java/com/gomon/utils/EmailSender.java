package com.gomon.utils;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class EmailSender {

    private static final String EMAIL = "gomonbd@gmail.com";
    private static final String APP_PASSWORD = "YOUR_APP_PASSWORD";

    public static boolean sendOTP(String toEmail, String otp) {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(
                                EMAIL,
                                APP_PASSWORD);

                    }

                });

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(EMAIL));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));

            message.setSubject("GOMON Password Reset OTP");

            message.setText(
                    "Your OTP is : " + otp +
                            "\n\nThis OTP is valid for 2 minutes.");

            Transport.send(message);

            return true;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;

    }

}