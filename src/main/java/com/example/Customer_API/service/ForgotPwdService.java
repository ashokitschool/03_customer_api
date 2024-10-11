package com.example.Customer_API.service;

public interface ForgotPwdService {

    Boolean sendMail(String email);

    Boolean checkEmailValid(String email);
}
