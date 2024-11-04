package com.vignesh.Service;

import com.vignesh.Entity.Customer;

public interface ICustomerManagementService {

	public String registerCustomer(Customer customer);
	public String registerCustomerGroup(Iterable<Customer> customerList);
	
	public long countCustomers();
	public boolean isThereAnyCustomerWithId(Integer cid);
	public String getCustomerById(Integer cid);
	public String getAllCustomersByIds(Iterable<Integer> cidList);
	public String getAllCustomers();
	
}
