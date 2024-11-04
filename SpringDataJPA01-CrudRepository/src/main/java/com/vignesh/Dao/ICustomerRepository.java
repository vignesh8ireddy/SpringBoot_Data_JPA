package com.vignesh.Dao;

import org.springframework.data.repository.CrudRepository;

import com.vignesh.Entity.Customer;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
