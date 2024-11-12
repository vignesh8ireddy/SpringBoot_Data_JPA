package com.vignesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

/*CREATE OR REPLACE PROCEDURE P_CUSTOMERS_BY_BILLAMT_RANGE 
(
  STARTAMOUNT IN FLOAT 
, ENDAMOUNT IN FLOAT 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
   OPEN DETAILS FOR
        SELECT * FROM JPA_CUSTOMER_TAB WHERE BILLAMT>=STARTAMOUNT AND BILLAMT<=ENDAMOUNT;
END P_CUSTOMERS_BY_BILLAMT_RANGE;*/


@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private  EntityManager  manager;

	@Override
	public List<Customer> getCustomersByBillAmountRange(double start, double end) {
		//create   StoredProcedure Query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_CUSTOMERS_BY_BILLAMT_RANGE",Customer.class);
		//register the PL/SQL procedure parameter with java data types
		query.registerStoredProcedureParameter(1,Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2,Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3,Object.class, ParameterMode.REF_CURSOR);  //indirectly registrering as OUT param
		
		//set values to IN params
		query.setParameter(1, start);
		query.setParameter(2, end);
	
		
		//call PL/SQL procedure
		List<Customer> list=query.getResultList();
		return list;
	}

}
