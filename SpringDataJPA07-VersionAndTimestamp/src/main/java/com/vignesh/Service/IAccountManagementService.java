package com.vignesh.Service;


import com.vignesh.Entity.BankAccount;

public interface IAccountManagementService {
	
	public String registerBankAccount(BankAccount bankAccount);
	public String updateBankAccount(BankAccount bankAccount);

}
