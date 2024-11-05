package com.vignesh.TestRunner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.vignesh.Entity.Customer;
import com.vignesh.Service.ICustomerManagementService;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	ICustomerManagementService customerService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		
		/*
		Iterable<Customer> customerList = customerService.getAllSortedCustomers(true, "cname");
		customerList.forEach(customer -> System.out.println(customer));
		*/
		//customerList.forEach(System.out::println);
		/*
		for(Customer customer : customerList) {
			System.out.println(customer);
		}
		*/
		
		
		
		/*
		Page<Customer> pageObj = customerService.getCustomersByPageNumber(2,2);
		pageObj.getContent().forEach(System.out::println);
		System.out.println("Current Page Number: "+pageObj.getNumber());
		System.out.println("Total Number of Pages: "+pageObj.getTotalPages());
		System.out.println("Number of Records in the current Page: "+pageObj.getNumberOfElements());
		System.out.println("Number of Records in total: "+pageObj.getTotalElements());
		*/
		
		/*
		Page<Customer> pageObj = customerService.getSortedCustomersByPageNumber(1,3, true, "billamt", "cname");
		pageObj.getContent().forEach(System.out::println);
		*/
		
		
		customerService.getAllCustomersPagebyPage(2);
	}

}
