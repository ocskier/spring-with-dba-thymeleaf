package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
