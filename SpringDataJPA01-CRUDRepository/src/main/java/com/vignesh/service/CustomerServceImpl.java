package com.vignesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.entity.Customer;
import com.vignesh.repository.ICustomerRepo;

@Service("cservice")
public class CustomerServceImpl implements ICustomerService {

	@Autowired
	ICustomerRepo proxyRepo;
	
	@Override
	public String registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer cust = proxyRepo.save(customer);
		return "Customer Registered with id: "+cust.toString();
	}

}
