package com.example.demo.service;

import com.example.demo.models.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public int updateCustomer(int id , FormData data, LocalDate joinedDate){
        if (customerRepo.existsById(id)) {
            Customer oldCustomer = this.getCustomerById(id);
            oldCustomer.setName(data.getName());
            oldCustomer.setAge(data.getAge());
            oldCustomer.setAddress(data.getAddress());
            oldCustomer.setDateJoined(joinedDate);
            customerRepo.save(oldCustomer);
            return 1;
        } else {
            return 0;
        }
    }
    public Boolean deleteUserById(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
