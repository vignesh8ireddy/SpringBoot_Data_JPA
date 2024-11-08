package com.vignesh.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.Dao.IBankAccountRepository;
import com.vignesh.Entity.BankAccount;

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
	public String updateBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		Optional<BankAccount> optionalObj=bankAccountRepository.findById(bankAccount.getAccountNumber());
		if(optionalObj.isPresent()) {
			BankAccount bAccount = optionalObj.get();
			System.out.println("Before Modifying: "+bAccount.toString());
			bAccount.setAccountBalance(bankAccount.getAccountBalance());
			bAccount.setAccountHolderName(bankAccount.getAccountHolderName());
			return bankAccountRepository.saveAndFlush(bAccount).toString();
		}
		return "No such account to update";
	}

}
