package com.example.Customer_API.repo;

import com.example.Customer_API.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    public Customer findByEmailAndPassword(String email,String pwd);

    public Customer findByEmail(String email);
}
