package com.vignesh.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.vignesh.Entity.Customer;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer>, CrudRepository<Customer, Integer> {

}
