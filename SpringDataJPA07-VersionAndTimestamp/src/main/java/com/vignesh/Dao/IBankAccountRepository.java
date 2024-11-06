package com.vignesh.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vignesh.Entity.BankAccount;

public interface IBankAccountRepository extends JpaRepository<BankAccount, Long> {

	@Query("from BankAccount where accountNumber=:number")
	public Iterable<BankAccount> getBankAccountByNumber(Long number);
	
}
