package com.vignesh.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public String registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Repo's InMemory Proxy class name::"+customerRepository.getClass());
		System.out.println("Repo's InMemory Proxy class implemented interfaces::"+Arrays.toString(customerRepository.getClass().getInterfaces()));
		System.out.println("Repo's InMemory Proxy class implemented Methods::"+Arrays.toString(customerRepository.getClass().getMethods()));
		Customer registeredcustomer = customerRepository.save(customer);
		return registeredcustomer+" is registered.";
	}
	
	/*
	 	@Override
		public String registerCustomerGroup(Iterable<Customer> list) {
		if(list!=null) {
			
			Iterable<Customer> it=custRepo.saveAll(list);
			// get the size of the collection
			int size=((Collection) it).size();
			//get id values of the saved customers
			List<Integer> custIds=(List<Integer>) ((Collection)it).stream().map(cust->((Customer) cust).getCno()).collect(Collectors.toList());
		
			return  size+" no.of customers are registered having the id values::"+custIds.toString();
			
		}
		else {
			throw new IllegalArgumentException(" invalid inputs");
		}
		
	}
	 */
	
	@Override
	public String registerCustomerGroup(Iterable<Customer> customerList) {
		Iterable<Customer> registeredCustomerList = customerRepository.saveAll(customerList);
		return ((Collection)registeredCustomerList).size() + " no. of customers are registered: " + registeredCustomerList.toString();
	}
	
	@Override
	public long countCustomers() {
		return customerRepository.count();
	}
	
	@Override
	public boolean isThereAnyCustomerWithId(Integer cid) {
		return customerRepository.existsById(cid);
	}
	
	@Override
	public String getCustomerById(Integer cid) {
		Optional optionalObj = customerRepository.findById(cid);
		if(optionalObj.isPresent()) return ((Customer)optionalObj.get()).toString();
		return "No customer with id: "+cid;
	}
	
	@Override
	public Customer findCustomerById(Integer cid) {
		return customerRepository.findById(cid).orElseThrow(() -> new IllegalArgumentException("Customer Not Found"));
	}
	
	
	@Override
	public String getAllCustomersByIds(Iterable<Integer> cidList) {
		
		Iterable<Customer> customerList = customerRepository.findAllById(cidList);
		return ((Collection)customerList).toString();
	}
	
	
	@Override
	public String getAllCustomers() {
		Iterable<Customer> customerList = customerRepository.findAll();
		return customerList.toString();
	}
	
	@Override
	public String updateCustomerBillAmt(Integer cid, Float discountPercent) {
		try {
			Customer customer = findCustomerById(cid);//select query is executed
			Double currentBillAmt = customer.getBillamt();
			customer.setBillamt(currentBillAmt - 0.01 * discountPercent * currentBillAmt);
			customer = customerRepository.save(customer);//once again select query is executed
			
			/*
			  spring data jpa checks if the entity already exists in the database.
			  This behavior happens if the Customer entity is not managed by the persistence context 
			  (i.e., it is detached). When you retrieve the entity using findById and modify it outside of a 
			  transactional context, it may become detached, causing JPA to perform a check with another 
			  select query before updating it.
			  
			  To avoid the second select query, ensure that this method runs in a transactional context. 
			  Adding @Transactional to this method will keep the entity managed, so save will not issue a 
			  second select query
			 */
			
			return "Customer bill amount is updated to " + customer.getBillamt() + "from " + currentBillAmt;			
		}
		catch(Exception e) {
			throw e;
		}

	}
	
	@Override
	public String registerOrUpdateCustomer(Customer customer) {
		Optional<Customer> optionalObj = customerRepository.findById(customer.getCid());
		if(optionalObj.isPresent()) {
			//customer already present so just update it
			customer = customerRepository.save(customer);
			return "customer with id " + customer.getCid() + " is updated";
		}		
		//customer is not already present, register
		customer = customerRepository.save(customer);
		return "customer with id " + customer.getCid() + " is registered";
	
	}
	
	@Override
	public String removeCustomerById(Integer id) {
		Optional<Customer> optionalObj = customerRepository.findById(id);
		if(optionalObj.isPresent()) {
			customerRepository.deleteById(id);
			return "Customer with id: " + id + " removed.";
		}
		else
			return "No Customer with id: " + id;
	}
	
	@Override
	public String removeCustomer(Customer customer) {
		Integer id = customer.getCid();
		Optional<Customer> optionalObj = customerRepository.findById(id);
		if(optionalObj.isPresent()) {
			customerRepository.delete(customer);
			/*
			 The above line is deleting the record even though the entire record
			 is not matching with the one in db.
			 It is just deleting if the id is same
			 
			 Then how it is different from deleteById()?
			 */
			return "Customer with id: " + id + " removed.";
		}
		else
			return "No Customer with id: " + id;
	}
	
	@Override
	public String removeAllCustomersByIds(Iterable<Integer> idList) {
		customerRepository.deleteAllById(idList);
		return "Customers with ids: " + idList.toString() + "are removed";
	}
	
	@Override
	public String removeAllCustomers() {
		customerRepository.deleteAll();
		return "All Customers are removed";
	}
	
	
	
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
	
	@Override
	public String removeCustomerBatchByIds(List<Integer> ids) {
		List<Customer> list=customerRepository.findAllById(ids);
		      if(list.size()!=0) {
		    	  customerRepository.deleteAllByIdInBatch(ids);
		    	  /*
		    	   Unlike deleteAllById() in CrudRepository, deleteAllByIdInBatch() method
		    	   generates only SQL query to delete multiple records efficiently using batch
		    	   
		    	   similarly deleteInBatch(Iterable<Customer> customerList), deleteAllInBatch() methods
		    	   generates only one SQL query
		    	   */
		    	  return  list.size()+" no.of records are deleted";
		      }
		     return "no records found for deletion";	
	}
	
	@Override
	public Customer getCustomerByIdReference(int id) {
		Customer customer=customerRepository.getReferenceById(id);
		/*
		 To use getReferenceById() method you have to enable lazy loading if not
		 managing the transactions(using @Transactional)
		 This can be done with the following property in application.properties
		 spring.jpa.properties.hibernate.enable_lazy_load_no_trans = true
		 
		 This is asking hibernate to load the record from db table lazily from db s/w
		 without transaction support
		 */
		return customer;
	}
	
	@Override
	public List<Customer> getCustomersByExampleData(Customer customer, boolean ascOrder, String...properties) {
		   Example<Customer> exampleObj=Example.of(customer);
		   Sort sortObj=Sort.by(ascOrder?Direction.ASC:Direction.DESC, properties);
		   List<Customer> list=customerRepository.findAll(exampleObj, sortObj);
		return list;
	}
	
	@Override
	public String registerCustomerGroup(List<Customer> customerList) {
		customerRepository.saveAllAndFlush(customerList);
		//saveAndFlush(Customer customer);
		//flush is saving/commiting the changes present in cache(Repository Object) to database
		return customerList.size()+" no. of records are saved";
	}

}
