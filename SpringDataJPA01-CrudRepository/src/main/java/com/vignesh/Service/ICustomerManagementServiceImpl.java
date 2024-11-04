package com.vignesh.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.Dao.ICustomerRepository;
import com.vignesh.Entity.Customer;

@Service
public class ICustomerManagementServiceImpl implements ICustomerManagementService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public String registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Repo's InMemory Proxy class name::"+customerRepository.getClass());
		System.out.println("Repo's InMemory Proxy class implemented interfaces::"+Arrays.toString(customerRepository.getClass().getInterfaces()));
		System.out.println("Repo's InMemory Proxy class implemented Methods::"+Arrays.toString(customerRepository.getClass().getMethods()));
		Customer registeredcustomer = customerRepository.save(customer);
		return registeredcustomer+" is registered.";
	}
	
	@Override
	public String registerCustomerGroup(Iterable<Customer> customerList) {
		Iterable<Customer> registeredCustomerList = customerRepository.saveAll(customerList);
		return ((Collection)registeredCustomerList).size() + " no. of customers are registered: " + registeredCustomerList.toString();
	}
	
	@Override
	public long countCustomers() {
		return customerRepository.count();
	}
	
	@Override
	public boolean isThereAnyCustomerWithId(Integer cid) {
		return customerRepository.existsById(cid);
	}
	
	@Override
	public String getCustomerById(Integer cid) {
		Optional optionalObj = customerRepository.findById(cid);
		if(optionalObj.isPresent()) return ((Customer)optionalObj.get()).toString();
		return "No customer with id: "+cid;
	}
	
	
	@Override
	public String getAllCustomersByIds(Iterable<Integer> cidList) {
		
		Iterable<Customer> customerList = customerRepository.findAllById(cidList);
		return ((Collection)customerList).toString();
	}
	
	
	@Override
	public String getAllCustomers() {
		Iterable<Customer> customerList = customerRepository.findAll();
		return customerList.toString();
	}

}
