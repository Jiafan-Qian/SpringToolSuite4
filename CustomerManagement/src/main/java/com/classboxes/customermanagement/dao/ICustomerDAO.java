package com.classboxes.customermanagement.dao;

import java.util.List;

import com.classboxes.customermanagement.entity.Customer;

public interface ICustomerDAO 
{
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);
}
