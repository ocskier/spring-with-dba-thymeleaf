package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CustomerService;
import com.example.demo.models.Customer;

@SpringBootApplication
@Controller
public class DemoApplication {
	@Autowired
	CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/")
	public String home(String name) {
		return "index";
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Bob's Burgers") String name, Model model) {
		Iterable<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("name", name);
		model.addAttribute("customers", customers);
		return "hello";
	}
	@GetMapping("/customer/{id}")
	public String hello(@PathVariable("id") int id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "update";
	}
}
