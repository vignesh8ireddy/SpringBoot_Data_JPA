package com.vignesh.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vignesh.Entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
