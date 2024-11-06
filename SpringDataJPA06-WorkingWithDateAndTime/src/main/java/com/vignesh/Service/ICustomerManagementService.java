package com.vignesh.Service;

import com.vignesh.Entity.Customer;

public interface ICustomerManagementService {

	public String registerCustomer(Customer customer);
	public Iterable<Customer> getAllCustomers();
	
}
