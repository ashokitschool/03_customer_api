package com.example.Customer_API.util;

import com.example.Customer_API.email.EmailTemplateLoader;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class EmailUtil {
    private JavaMailSender mailSender;
    private EmailTemplateLoader templateLoader;

    public EmailUtil(JavaMailSender mailSender, EmailTemplateLoader templateLoader) {
        this.mailSender = mailSender;
        this.templateLoader = templateLoader;
    }

    public Boolean sendResetPasswordEmail(String to, String name, String resetLink) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        // Load HTML template
        String template = templateLoader.loadTemplate("classpath:templates/reset-password-template.html");

        // Replace placeholders in the template
        String htmlBody = templateLoader.replacePlaceholders(template, name, resetLink);

        helper.setTo(to);
        helper.setSubject("Password Reset Request");
        helper.setText(htmlBody, true);  // Set to true for HTML content

        mailSender.send(message);
        return true;
    }
}
