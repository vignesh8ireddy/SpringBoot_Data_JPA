package com.vignesh.testRunner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vignesh.entity.Customer;
import com.vignesh.service.ICustomerMgmtService;

@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	private ICustomerMgmtService  custService;

	@Override
	public void run(String... args) throws Exception {
		List<Customer> list=custService.getCustomersByBillAmountRange(10000.0, 100000.0);
		list.forEach(cust->{
			System.out.println(cust);
		});

	}

}
