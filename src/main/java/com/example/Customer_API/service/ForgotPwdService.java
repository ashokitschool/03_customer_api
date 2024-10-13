package com.example.Customer_API.service;

import jakarta.mail.MessagingException;

import java.io.IOException;

public interface ForgotPwdService {

    Boolean sendMail(String email) throws MessagingException, IOException;

    Boolean checkEmailValid(String email);
}
