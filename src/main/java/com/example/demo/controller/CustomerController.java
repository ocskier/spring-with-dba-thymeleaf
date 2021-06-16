package com.example.demo.controller;

import java.io.PrintWriter;
import java.time.LocalDate;

import com.example.demo.models.Customer;
import com.example.demo.models.FormData;
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
    private Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    private Customer getStudent(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customers")
    private void addStudent(HttpServletResponse response, @ModelAttribute("customer") FormData data) throws IOException {
        LocalDate joinDate;
        if (data.getDate().isEmpty()){
            joinDate = LocalDate.now();
        } else {
            joinDate = LocalDate.parse(data.getDate());
        }
        Customer customer = new Customer(data.getName(), data.getAge(), data.getAddress(), joinDate);
        customerService.addUser(customer);
        response.sendRedirect("/hello");
    }

    @DeleteMapping("/customers/{id}")
    private void deleteStudent(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
        Boolean isDeleted = customerService.deleteUserById(id);
        if (isDeleted) {
            response.setStatus(200);
        } else {
            response.setStatus(404);
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(isDeleted);
        out.flush();
    }
}
