package com.example.Customer_API.service;

import com.example.Customer_API.dto.Login;
import com.example.Customer_API.entity.Customer;
import com.example.Customer_API.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private CustomerRepo customerRepo;

    public LoginServiceImpl(CustomerRepo customerRepo){
        this.customerRepo=customerRepo;
    }

    @Override
    public Login loginHandle(Login login) {
        Customer customer=customerRepo.findByEmailAndPassword(login.getEmail(),login.getPassword());
        Login login1=new Login();
        if(customer!=null){
            login1.setEmail(customer.getEmail());
            login1.setPassword(customer.getPassword());
            return login1;
        }
        System.out.println(login1.getEmail()+" "+login1.getPassword());
        return login1;
    }
}
