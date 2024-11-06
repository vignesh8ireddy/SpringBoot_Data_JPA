package com.vignesh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.vignesh.Dao.IBankAccountRepository;
import com.vignesh.Entity.BankAccount;

import jakarta.transaction.Transactional;

@Service
public class IAccountManagementServiceImpl implements IAccountManagementService {

	@Autowired
	IBankAccountRepository bankAccountRepository;
	
	@Override
	public String registerBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		return bankAccountRepository.saveAndFlush(bankAccount).toString();
	}

	@Override
	@Transactional
	@Modifying
	public String updateBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		if(!bankAccountRepository.existsById(bankAccount.getAccountNumber())) {
			return "No such account to update";
		}
		BankAccount bAccount=bankAccountRepository.getReferenceById(bankAccount.getAccountNumber());
		bAccount.setAccountBalance(bankAccount.getAccountBalance());
		bAccount.setAccountHolderName(bankAccount.getAccountHolderName());
		//return bankAccountRepository.saveAndFlush(bankAccount).toString();
		return bAccount.toString();
	}

}
