package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Injecting CustomerDAO dependency
	@Autowired
	private CustomerDAO customerDAO;
	
	// The "GetMapping" annotation will contrain this method to handle only get requests unlike
	// the "RequestMapping" annotation which covers all HTTP methods. A similar "PostMapping"
	// annotation is also available for only handling post methods. This type of contrain can also
	// be applied in the "RequestMapping" method by the following code:
	// @RequestMapping(path = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerDAO.getCustomers();
		
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
