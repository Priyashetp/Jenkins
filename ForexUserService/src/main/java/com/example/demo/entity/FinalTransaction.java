package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactiondetails")
public class FinalTransaction {
	
	    @Id
	    private long transactionId;
	    private long amount ;
	    private double serviceFee;
	    private long convertedAmount;
		private double receivedAmount;
		private String senderCurrency;
		private String receiverCurrency;
		private String accountHolderName;
		private long accountNumber;
		private String accountHolderEmail;
		private long senderAccountNumber;
		private String senderName;
		public String getSenderName() {
			return senderName;
		}
		public void setSenderName(String senderName) {
			this.senderName = senderName;
		}
		private LocalDate transactionDate;
	    private LocalTime transactionTime;
		
		
		
	    
		public String getAccountHolderEmail() {
			return accountHolderEmail;
		}
		public void setAccountHolderEmail(String accountHolderEmail) {
			this.accountHolderEmail = accountHolderEmail;
		}
		
		
		public LocalDate getTransactionDate() {
			return transactionDate;
		}
		public void setTransactionDate(LocalDate transactionDate) {
			this.transactionDate = transactionDate;
		}
		public LocalTime getTransactionTime() {
			return transactionTime;
		}
		public void setTransactionTime(LocalTime transactionTime) {
			this.transactionTime = transactionTime;
		}
		
		public long getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(long transactionId) {
			this.transactionId = transactionId;
		}
		public long getAmount() {
			return amount;
		}
		public void setAmount(long amount) {
			this.amount = amount;
		}
		public double getServiceFee() {
			return serviceFee;
		}
		public void setServiceFee(double serviceFee) {
			this.serviceFee = serviceFee;
		}
		public long getConvertedAmount() {
			return convertedAmount;
		}
		public void setConvertedAmount(long convertedAmount) {
			this.convertedAmount = convertedAmount;
		}
		public double getReceivedAmount() {
			return receivedAmount;
		}
		public void setReceivedAmount(double receivedAmount) {
			this.receivedAmount = receivedAmount;
		}
		public String getSenderCurrency() {
			return senderCurrency;
		}
		public void setSenderCurrency(String senderCurrency) {
			this.senderCurrency = senderCurrency;
		}
		public String getReceiverCurrency() {
			return receiverCurrency;
		}
		public void setReceiverCurrency(String receiverCurrency) {
			this.receiverCurrency = receiverCurrency;
		}
		public String getAccountHolderName() {
			return accountHolderName;
		}
		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public long getSenderAccountNumber() {
			return senderAccountNumber;
		}
		public void setSenderAccountNumber(long senderAccountNumber) {
			this.senderAccountNumber = senderAccountNumber;
		}
		
		
		
		
		
	
	

}
