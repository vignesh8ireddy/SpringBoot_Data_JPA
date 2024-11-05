package com.vignesh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.vignesh.Dao.ICustomerRepository;
import com.vignesh.Entity.Customer;

@Service
public class ICustomerManagementServiceImpl implements ICustomerManagementService {

	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public Iterable<Customer> getAllSortedCustomers(boolean ascOrder, String...properties) {
		Sort sortObj = Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		return customerRepository.findAll(sortObj);
	}
	
	@Override
	public Page<Customer> getCustomersByPageNumber(int pageNumber, int pageSize) {
		Pageable pageableObj = PageRequest.of(pageNumber, pageSize);
		return customerRepository.findAll(pageableObj);
	}
	
	@Override
	public Page<Customer> getSortedCustomersByPageNumber(int pageNumber, int pageSize, boolean ascOrder, String...properties) {
		Sort sortObj = Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		Pageable pageableObj = PageRequest.of(pageNumber, pageSize, sortObj);
		return customerRepository.findAll(pageableObj);
	}
	
	@Override
	public void getAllCustomersPagebyPage(int pageSize) {
		   //get total no.of record count using CrudRepository
			long count=customerRepository.count();
			// get pages count
			long pagesCount=count/pageSize;
			 pagesCount=(count%pageSize==0)?pagesCount:++pagesCount;
			 
			 for(int i=0;i<pagesCount;++i) {
				 //prepare the Pageable object
				 Pageable pageableObj=PageRequest.of(i,pageSize);
				 Page<Customer> pageObj=customerRepository.findAll(pageableObj);
				 pageObj.forEach(System.out::println);
				 System.out.println("--------------  "+(pageObj.getNumber()+1)+"/"+pageObj.getTotalPages()+"------------------");
			 }
	}

}