package com.vignesh.TestRunner;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

		Customer customer=new Customer("Tom", "Alaska", 1600.00, LocalDateTime.now(), LocalDate.now(), LocalTime.now());
		System.out.println(customerService.registerCustomer(customer));
		Iterable<Customer> customerList=customerService.getAllCustomers();
		customerList.forEach(System.out::println);
	}

}
