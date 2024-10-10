package com.example.Customer_API.service;

import com.example.Customer_API.entity.Customer;
import com.example.Customer_API.repo.CustomerRepo;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ForgotPwdServiceImp implements  ForgotPwdService{

    private EmailService emailService;
    public ForgotPwdServiceImp(EmailService emailService){
        this.emailService=emailService;
    }




    public Boolean sendMail(String email){

        String subject="Forgot password Mail from E-Commerce App";
        String body="Link to reset the password is http://localhost:4200/resetpwd";

        emailService.sendEmail(email,subject,body);

        return true;
    }
}
