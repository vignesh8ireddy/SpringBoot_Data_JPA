package com.vignesh.TestRunner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vignesh.Dao.ICustomerRepository;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		
		/*
		customerRepository.getAllCustomers().forEach(System.out::println);
		*/
		
		/*
		customerRepository.getCustomersByBillAmountRange(100.0f, 1000.0f).forEach(System.out::println);
		*/
		
		/*
	 	List<Object[]> list=customerRepository.getCustomerData("Tony", "bruce");
	  	list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+"  ");
		  	}
		  	System.out.println();
	  	});
		*/
		
		/*
		List<String> list1=customerRepository.findCustomerAddrsByNameChars("B%");
		list1.forEach(address->{
			System.out.println(address);
		});
		*/
		
		/*
		Customer cust=customerRepository.findCustomerDataByAddrs("Ohio");
		System.out.println(cust);
		*/
	
		/*
		Object  object=customerRepository.fetchCustomerDetailsByAddrs("Ohio");
	    Object  data[]=(Object[])object;
   	    System.out.println("customer details ::"+Arrays.toString(data));
		*/
	
		//System.out.println(" custome name ::"+customerRepository.fetchCustomerNameByAddrs("Texas"));
	
		//System.out.println("Customers count::"+customerRepository.fetchAllCustmerCountByAddrs());
	
		/*
		Object aggregateData[]=(Object[])customerRepository.fetchCustomerAggregateData();
		System.out.println("count ::"+aggregateData[0]);
		System.out.println("max billAmt::"+aggregateData[1]);
		System.out.println("min billAmt::"+aggregateData[2]);
		System.out.println("avg billAmt::"+aggregateData[3]);
		System.out.println("sum of billAmt::"+aggregateData[4]);
		*/
	  
		/* 
	  	int count=customerRepository.updateCustomerBillAmountByAddresses(10.0, "Newyork", "Texas");
	  	System.out.println("no.of customers that are effected::"+count);
		*/
		
		/*
	  	int count=customerRepository.deleteCustomersByBillAmtRange(100000.0, 1000000.0);
	  	System.out.println("no.of records that are deleted are ::"+count);
		 */
	}
		
}

