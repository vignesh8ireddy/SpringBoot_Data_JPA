package com.vignesh.service;

import java.util.List;

import com.vignesh.entity.Customer;

public interface ICustomerMgmtService {
      public  List<Customer>  getCustomersByBillAmountRange(double start,double end);
}
