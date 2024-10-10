package com.example.Customer_API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,String subject,String body){
        System.out.println(toEmail);
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("tejalkhule97@gmail.com");
        message.setTo(toEmail.trim());
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);

    }
}
