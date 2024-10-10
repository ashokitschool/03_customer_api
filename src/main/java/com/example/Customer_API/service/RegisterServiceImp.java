package com.example.Customer_API.service;

import com.example.Customer_API.dto.Register;
import com.example.Customer_API.entity.Customer;
import com.example.Customer_API.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements  RegisterService{

    private CustomerRepo customerRepo;

    Customer customer=new Customer();

    public RegisterServiceImp(CustomerRepo customerRepo){
        this.customerRepo=customerRepo;
    }

    public Boolean register(Register register) {
        customer.setEmail(register.getEmail());
        customer.setPassword(register.getPassword());
        customer.setName(register.getName());
        customer.setPhoneNo(register.getPhoneNo());
        customerRepo.save(customer);
        return true;
    }
}
