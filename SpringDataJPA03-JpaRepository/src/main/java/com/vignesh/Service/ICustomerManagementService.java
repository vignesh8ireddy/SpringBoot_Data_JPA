package com.vignesh.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vignesh.Entity.Customer;

public interface ICustomerManagementService {

	
	//CrudRepository Methods
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
	
	//PagingAndSortingRepository Methods
	public Iterable<Customer> getAllSortedCustomers(boolean ascOrder, String...propertires);
	public Page<Customer> getCustomersByPageNumber(int pageNumber, int pageSize);
	public Page<Customer> getSortedCustomersByPageNumber(int pageNumber, int pageSize, boolean ascOrder, String...properties);
	public void getAllCustomersPagebyPage(int pageSize);
	
	//JpaRepository specific methods
    public String removeCustomerBatchByIds(List<Integer> ids);
    public Customer getCustomerByIdReference(int id);
    public List<Customer> getCustomersByExampleData(Customer cust, boolean ascOrder,String...properties);
    public String registerCustomerGroup(List<Customer> list);
	
}
