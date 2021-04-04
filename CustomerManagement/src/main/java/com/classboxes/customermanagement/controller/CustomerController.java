package com.classboxes.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.classboxes.customermanagement.entity.Customer;
import com.classboxes.customermanagement.service.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model)
	{
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers",customers);
		return "list-customers";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model model)
	{
		Customer customers = new Customer();
		model.addAttribute("customers", customers);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customers") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
}
