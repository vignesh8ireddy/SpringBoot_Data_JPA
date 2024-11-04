package com.vignesh.TestRunner;

import java.util.List;

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
		/*
		Customer customer = new Customer();
		customer.setCname("Bruce");customer.setCaddress("Newyork");customer.setBillamt(39999.00);
		String result = customerService.registerCustomer(customer);
		System.out.println(result);
		*/
		
		/*
		Iterable<Customer> customerList = List.of(new Customer("Jack","Pandora",399.99d), new Customer("Taylor","Nashville",3366.00d));
		String result = customerService.registerCustomerGroup(customerList);
		System.out.println(result);
		*/
		
		/*
		System.out.println("The total no. of customers are: "+customerService.countCustomers());
		*/
		
		/*
		System.out.println("Is there any customer with id = 52?: "+customerService.isThereAnyCustomerWithId(52));
		System.out.println("Is there any customer with id = 2?: "+customerService.isThereAnyCustomerWithId(2));
		System.out.println("Is there any customer with id = 62?: "+customerService.isThereAnyCustomerWithId(62));
		*/
		
		/*
		System.out.println("Customer id = 52 : " + customerService.getCustomerById(52));
		System.out.println("Customer id = 6 : " + customerService.getCustomerById(6));
		*/

		/*
		System.out.println("Customer id = 52 : " + customerService.findCustomerById(52));
		System.out.println("Customer id = 6 : " + customerService.findCustomerById(6));
		*/
		
		/*
		Iterable<Integer> cidList = List.of(52,1,2);
		System.out.println("Customers with ids=(52,1,2): " + customerService.getAllCustomersByIds(cidList));
		*/
		
		/*
		System.out.println("List of all the customers: " + customerService.getAllCustomers());
		*/
		
		/*
		System.out.println("Update customer bill amount of id 1 with discount percent 10\n"+customerService.updateCustomerBillAmt(1, 10.0f));
		*/
		
		/*
		Customer customer = new Customer(1052, "Bruce", "Ohio", 4999.99);
		System.out.println(customerService.registerOrUpdateCustomer(customer));
		*/
		
		/*
		System.out.println(customerService.removeCustomerById(1052));
		*/
		
		/*
		Customer customer = new Customer(2, "Bruce", "Ohio", 4999.99);
		System.out.println(customerService.removeCustomer(customer));
		*/
		
	}

}
