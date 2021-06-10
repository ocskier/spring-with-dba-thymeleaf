package com.example.demo.controller;

import com.example.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    private Iterable<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
}
