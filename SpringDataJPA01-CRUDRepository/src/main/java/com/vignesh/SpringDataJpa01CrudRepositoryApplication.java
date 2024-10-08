package com.vignesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vignesh.entity.Customer;
import com.vignesh.service.ICustomerService;

@SpringBootApplication
public class SpringDataJpa01CrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpa01CrudRepositoryApplication.class, args);
		ICustomerService service = context.getBean("cservice",ICustomerService.class);
		String res = service.registerCustomer(new Customer(66,"Tony","Newyork",88.0));
		System.out.println(res);
	}

}
