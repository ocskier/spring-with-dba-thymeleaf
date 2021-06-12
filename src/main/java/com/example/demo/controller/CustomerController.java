package com.example.demo.controller;

import com.example.demo.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CustomerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    @PostMapping("/customers")
    private void addStudent(HttpServletResponse response, Customer customer) throws IOException {
        System.out.println(customer.toString());
        customerService.addUser(customer);
        response.sendRedirect("/hello");
    }
}
