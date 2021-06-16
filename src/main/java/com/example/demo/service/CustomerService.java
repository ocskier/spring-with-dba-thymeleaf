package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Iterable<Customer> getAllCustomers() {
        Iterable<Customer> customers = customerRepo.findAll();
        return customers;
    }
    public Customer getCustomerById(int id) {
        Customer customer = customerRepo.findById(id).get();
        return customer;
    }
    public Customer addUser(Customer customer) {
        Customer createdCustomer = customerRepo.save(customer);
        return createdCustomer;
    }
    public Boolean deleteUserById(int id) {
//        if (customerRepo.existsById(id)) {
//            customerRepo.deleteById(id);
//        }
        customerRepo.deleteById(id);
        return true;
    }
}
