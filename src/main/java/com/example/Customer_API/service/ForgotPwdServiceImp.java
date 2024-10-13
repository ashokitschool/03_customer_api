package com.example.Customer_API.service;

import com.example.Customer_API.entity.Customer;
import com.example.Customer_API.repo.CustomerRepo;
import com.example.Customer_API.util.EmailUtil;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ForgotPwdServiceImp implements  ForgotPwdService{

    private CustomerRepo customerRepo;
    private EmailUtil emailUtil;

    Customer customer=new Customer();
    public ForgotPwdServiceImp(EmailService emailService,CustomerRepo customerRepo,EmailUtil emailUtil){
        //this.emailService=emailService;
        this.customerRepo=customerRepo;
        this.emailUtil=emailUtil;
    }

    public Boolean checkEmailValid(String email){
        customer=customerRepo.findByEmail(email);
        return customer != null;
    }

    public Boolean sendMail(String email) throws MessagingException, IOException {
        Boolean flag=false;
        String url="http://localhost:4200/resetpwd/"+email;
        customer=customerRepo.findByEmail(email);
        String name=customer.getName();
        System.out.println("Name is "+name+" Email is "+email+" URL is "+url);
        flag=emailUtil.sendResetPasswordEmail(email,name,url);
        return flag;
    }
}
