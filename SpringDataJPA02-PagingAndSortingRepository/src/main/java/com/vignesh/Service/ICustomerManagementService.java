package com.vignesh.Service;

import org.springframework.data.domain.Page;

import com.vignesh.Entity.Customer;

public interface ICustomerManagementService {

	public Iterable<Customer> getAllSortedCustomers(boolean ascOrder, String...propertires);
	public Page<Customer> getCustomersByPageNumber(int pageNumber, int pageSize);
	public Page<Customer> getSortedCustomersByPageNumber(int pageNumber, int pageSize, boolean ascOrder, String...properties);
	public void getAllCustomersPagebyPage(int pageSize);
	
}
