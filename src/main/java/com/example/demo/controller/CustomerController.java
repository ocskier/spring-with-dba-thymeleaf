package com.example.demo.controller;

import com.example.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    private Iterable<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
    @GetMapping("/customers/{id}")
    private Customer getStudent(@PathVariable("id") int id)
    {
        return customerService.getCustomerById(id);
    }
}
