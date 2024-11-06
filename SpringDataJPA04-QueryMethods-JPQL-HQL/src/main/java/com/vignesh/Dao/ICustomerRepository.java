package com.vignesh.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vignesh.Entity.Customer;

import jakarta.transaction.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	//@Query(" from Customer")
	//@Query(" from Customer customer")
	@Query("select  customer from Customer as customer ")
	public  List<Customer>  getAllCustomers();
	
	
	/*
	@Query(" from Customer where billamt between :start and :end ")
	public Iterable<Customer>  getCustomersByBillAmountRange(@Param("start") float startAmount,@Param("end") float endAmount);
	*/
	
	//@Query(" from Customer where billamt between :start and :end ")
	//@Query(" from Customer as customer where customer.billamt between :start and :end ")
	@Query("from Customer where billamt between ?1 and ?2")
	public Iterable<Customer>  getCustomersByBillAmountRange(float start, float end);
	
	@Query("select cid,cname,billamt from Customer where cname in(:name1,:name2) ")  // scalar -projection (selecting specific multiple col values)
	public List<Object[]> getCustomerData(String name1,String name2);
	
	@Query("select caddress from Customer where cname like :initChars ")  // scalar -projection (selecting specific single col values)
	public List<String> findCustomerAddrsByNameChars(String initChars);
	
	@Query(" from Customer where caddress=:address ")
	public Customer findCustomerDataByAddrs(String address);
	
	@Query("select cid,cname,billamt from Customer where caddress=:address")
	public Object fetchCustomerDetailsByAddrs(String address);
	
	@Query("select cname from Customer where caddress=:address")
	public String fetchCustomerNameByAddrs(String address);
	
	@Query("select count(distinct caddress) from Customer")
	public int fetchAllCustmerCountByAddrs();
	
	@Query("select count(*), max(billamt), min(billamt),avg(billamt), sum(billamt) from Customer")
	public Object fetchCustomerAggregateData();
	
	@Query("update Customer set billamt=billamt+(billamt*:percentage/100.0f) where  caddress in(:city1,:city2) ")
	@Transactional
	@Modifying
	public int updateCustomerBillAmountByAddresses(double percentage, String city1, String city2);
	
	
	@Query("delete from Customer where billamt between :start and :end")
	@Transactional
	@Modifying
	public int deleteCustomersByBillAmtRange(double start,double end);

}
