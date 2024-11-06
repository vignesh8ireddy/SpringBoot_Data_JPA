package com.vignesh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vignesh.Dao.ICustomerRepository;
import com.vignesh.Entity.Customer;

@Service
public class ICustomerManagementServiceImpl implements ICustomerManagementService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public String registerCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer).toString();
	}
	
	@Override
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

}