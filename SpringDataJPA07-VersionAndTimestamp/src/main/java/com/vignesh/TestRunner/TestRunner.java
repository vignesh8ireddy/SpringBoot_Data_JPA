package com.vignesh.TestRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vignesh.Dao.IBankAccountRepository;
import com.vignesh.Entity.BankAccount;
import com.vignesh.Service.IAccountManagementService;

@Component
public class TestRunner implements CommandLineRunner {
	
	@Autowired
	IBankAccountRepository bankAccountRepository;
	@Autowired
	IAccountManagementService bankAccountService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		BankAccount bankAccount = new BankAccount("Leonard", 9132339307L, 600.00);
		System.out.println(bankAccountService.registerBankAccount(bankAccount));
		*/
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountNumber(4000000L);
		bankAccount.setAccountHolderName("Jordan");
		bankAccount.setAccountBalance(6200.00);
		bankAccount.setAccountHolderMobile(9132339307L);
		System.out.println("After Modifying: "+bankAccountService.updateBankAccount(bankAccount));
		System.out.println(bankAccountRepository.getBankAccountByNumber(4000000L));

	}

}
