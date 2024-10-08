package com.vignesh.repository;

import org.springframework.data.repository.CrudRepository;

import com.vignesh.entity.Customer;

public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
