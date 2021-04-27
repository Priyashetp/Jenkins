package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;

import com.example.demo.entity.BankAccountDetailsEntity;
import com.example.demo.entity.FinalTransaction;
import com.example.demo.exception.UserServiceException;

public interface UserDashboardService {
	
	
	/// user functionlities
	
	
	public String addBankAccount(BankAccountDetailsEntity accountDetails) throws UserServiceException;
	
	public List<BankAccountDetailsEntity> fetchUserAccount();
	

	public List<BankAccountDetailsEntity> fetchUserAccountAsPerCurrency();
	
	public void deleteBankAccount(long id);
	
	public FinalTransaction postTransaction(FinalTransaction finalTransaction) throws UserServiceException, MessagingException;
	
    
	
	/// transaction management ///
	
	public List<FinalTransaction> getUserTransaction();
    

    List<FinalTransaction> getUserTransactionByDate(LocalDate date);
    
	public Double getProfit() ;
	public List<FinalTransaction> getUserTransactionByName(String accountHolderName) ;

    
    
}
