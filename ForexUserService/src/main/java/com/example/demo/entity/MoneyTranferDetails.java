package com.example.demo.entity;

public class MoneyTranferDetails {
	
	private long amount ;
	private double convertedAmount;
	private double receivedAmount;
	private double serviceFee;
	private String senderCurrency;
	private String receiverCurrency;
	

	public double getReceivedAmount() {
		return receivedAmount;
	}
	public void setReceivedAmount(double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	public double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
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
	
	
	
	

}
