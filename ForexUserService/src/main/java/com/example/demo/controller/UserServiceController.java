package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BankAccountDetailsEntity;
import com.example.demo.entity.FinalTransaction;
import com.example.demo.entity.MoneyTranferDetails;
import com.example.demo.exception.UserServiceException;
import com.example.demo.service.CurrencyConversionServiceImpl;
import com.example.demo.service.UserDashboardServiceImpl;

@CrossOrigin("*")
@RestController
public class UserServiceController {

	@Autowired
	private CurrencyConversionServiceImpl service;

	@Autowired
	private UserDashboardServiceImpl dashboardService;

	/// currency conversion ////

	// method for instant currency conversion

	@PostMapping("/currencyconversion")
	public MoneyTranferDetails getConversionDetails(@RequestBody MoneyTranferDetails transferDetails) {

		dashboardService.holdTransferDetails(transferDetails);

		MoneyTranferDetails response = service.currencyConversion(transferDetails);

		return response;

	}

	/// user functionalities ////

	// method used to add new bank account

	@PostMapping("/addbankaccount")
	public String addBankAccount(@RequestBody BankAccountDetailsEntity accountDetails) throws UserServiceException {

		String response = dashboardService.addBankAccount(accountDetails);

		return response;

	}

	// method to delete user bank account

	@DeleteMapping("/deleteuserbankaccount/{id}")
	public void deleteBAnkAccount(@PathVariable long id) {

		dashboardService.deleteBankAccount(id);

	}

	// method to fetch bank account as per user

	@GetMapping("/fetchaccount")
	public List<BankAccountDetailsEntity> fetchUserAccounts() {

		List<BankAccountDetailsEntity> accountDetails = dashboardService.fetchUserAccount();

		return accountDetails;

	}

	// method to fetch bank account as per sender currency

	@GetMapping("/fetchcurrencyaccount")
	public List<BankAccountDetailsEntity> fetchUserAccountAsPerSenderCurrency() {

		List<BankAccountDetailsEntity> accountDetailsEntity = dashboardService.fetchUserAccountAsPerCurrency();

		return accountDetailsEntity;

	}

	// method to post transaction details;

	@PostMapping("/finaltransaction")
	public FinalTransaction postTransaction(@RequestBody FinalTransaction finaltransaction)
			throws UserServiceException, MessagingException {

		FinalTransaction response = dashboardService.postTransaction(finaltransaction);

		return response;

	}

	/// transaction management ///

	// method to get transaction history

	@GetMapping("/getusertransaction")
	public List<FinalTransaction> getUserTransaction() {

		List<FinalTransaction> transactionHistory = dashboardService.getUserTransaction();

		return transactionHistory;

	}

	// method to get transaction as per date

	@GetMapping("/getusertransactionbydate/{date}")
	public List<FinalTransaction> getUserTransactionByDate(@PathVariable String date) {

		LocalDate date1 = LocalDate.parse(date);

		List<FinalTransaction> transaction = dashboardService.getUserTransactionByDate(date1);

		return transaction;
	}
	
	@GetMapping("/getusertransactionbyaccountName/{senderName}")
	public List<FinalTransaction> getUserTransactionByName(@PathVariable String senderName) {


		List<FinalTransaction> transaction = dashboardService.getUserTransactionByName(senderName);

		return transaction;
	}


	@GetMapping("/getprofit")
	public Double getProfit() {

		Double prof = dashboardService.getProfit();
		System.out.println(prof);

		return prof;

	}

}
