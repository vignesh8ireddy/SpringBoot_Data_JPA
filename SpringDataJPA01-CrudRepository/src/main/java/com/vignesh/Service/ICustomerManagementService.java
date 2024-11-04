package com.vignesh.Service;

import com.vignesh.Entity.Customer;

public interface ICustomerManagementService {

	public String registerCustomer(Customer customer);
	public String registerCustomerGroup(Iterable<Customer> customerList);
	
	public long countCustomers();
	public boolean isThereAnyCustomerWithId(Integer cid);
	public String getCustomerById(Integer cid);
	public Customer findCustomerById(Integer cid);
	public String getAllCustomersByIds(Iterable<Integer> cidList);
	public String getAllCustomers();
	
	public String updateCustomerBillAmt(Integer cid, Float discountPercent);
	public String registerOrUpdateCustomer(Customer customer);
	
	public String removeCustomerById(Integer id);
	public String removeCustomer(Customer customer);
	public String removeAllCustomersByIds(Iterable<Integer> idList);
	public String removeAllCustomers();
	
}
