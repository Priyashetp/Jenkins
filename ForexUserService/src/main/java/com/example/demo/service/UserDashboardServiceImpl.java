package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BankAccountDetailsEntity;
import com.example.demo.entity.FinalTransaction;
import com.example.demo.entity.MoneyTranferDetails;
import com.example.demo.exception.UserServiceException;
import com.example.demo.repo.BankAccountRepo;
import com.example.demo.repo.FinalTransactionRepo;

@Service
public class UserDashboardServiceImpl implements UserDashboardService {

	@Autowired
	private BankAccountRepo accountRepo;

	@Autowired
	private FinalTransactionRepo transactionRepo;

	// entity class object meant to hold latest transfer details

	MoneyTranferDetails transferDetails = new MoneyTranferDetails();

	// method to hold latest transferDetails object
	// called every time a new transaction is initiated

	public void holdTransferDetails(MoneyTranferDetails transferDetails) {

		this.transferDetails = transferDetails;

	}

	// method to add bank account

	public String addBankAccount(BankAccountDetailsEntity accountDetails) throws UserServiceException {

		long randomAmount = (long) (Math.random() * 1000000);
		accountDetails.setAccountBalance(randomAmount);
		accountRepo.save(accountDetails);
		return "Bank Account added successfully";

	}

	// method to fetch bank accounts for user

	@Override
	public List<BankAccountDetailsEntity> fetchUserAccount() {
		// TODO Auto-generated method stub

		List<BankAccountDetailsEntity> accountDetails = accountRepo.findAll();

		return accountDetails;
	}

	// method to fetch user bank accounts as per sender currency
	// meant for final transaction

	@Override
	public List<BankAccountDetailsEntity> fetchUserAccountAsPerCurrency() {

		List<BankAccountDetailsEntity> accountDetailEntity = accountRepo
				.findByCurrency(transferDetails.getSenderCurrency());

		return accountDetailEntity;

	}

	// method to delete bank account

	@Override
	public void deleteBankAccount(long id) {

		accountRepo.deleteById(id);

	}

	// method to post final transaction data

	@Override
	public FinalTransaction postTransaction(FinalTransaction finalTransaction)
			throws MessagingException, UserServiceException {

		if (finalTransaction != null) {

			Optional<BankAccountDetailsEntity> accountDetails = accountRepo
					.findById(finalTransaction.getSenderAccountNumber());

			// sufficient balance check
			if (accountDetails.get().getAccountBalance() >= finalTransaction.getAmount() + 5000) {

				// money deduction from sender account
				accountDetails.get()
						.setAccountBalance(accountDetails.get().getAccountBalance() - finalTransaction.getAmount());

				long transactionId = (long) (Math.random() * 100000000);

				finalTransaction.setTransactionId(transactionId);
				finalTransaction.setAmount(finalTransaction.getAmount());
				finalTransaction.setServiceFee(finalTransaction.getServiceFee());
				finalTransaction.setConvertedAmount(finalTransaction.getConvertedAmount());
				finalTransaction.setReceivedAmount(finalTransaction.getReceivedAmount());
				finalTransaction.setSenderCurrency(finalTransaction.getSenderCurrency());
				finalTransaction.setReceiverCurrency(finalTransaction.getReceiverCurrency());
				finalTransaction.setAccountHolderName(finalTransaction.getAccountHolderName());
				finalTransaction.setAccountNumber(finalTransaction.getAccountNumber());
				finalTransaction.setSenderAccountNumber(finalTransaction.getSenderAccountNumber());
				finalTransaction.setSenderName(accountDetails.get().getAccountHolderName());
				finalTransaction.setTransactionDate(LocalDate.now());
				finalTransaction.setTransactionTime(LocalTime.now());

				transactionRepo.save(finalTransaction);

				if (finalTransaction.getAccountHolderEmail() != null) {

					sendMailNotification(finalTransaction);
				}
				return finalTransaction;
			} else {
				throw new UserServiceException("Insufficient Account Balance");
			}
		}

		else {

			throw new UserServiceException("Data not available");
		}
	}

	// method to send notification mail to recipient after succesfull transaction
	// intiated

	private void sendMailNotification(FinalTransaction finalTransaction) throws MessagingException {

		// fetches system properties
		Properties properties = System.getProperties();

		// setting host

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// getting session object

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("servicesforex26@gmail.com", "Forex!123");

			}

		});

		session.setDebug(true);

		// composing message

		MimeMessage mailMessage = new MimeMessage(session);

		mailMessage.setFrom("servicesforex26@gmail.com");

		mailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(finalTransaction.getAccountHolderEmail()));

		mailMessage.setSubject("Forex Service Transaction!!");

		mailMessage.setText("Hi " + finalTransaction.getAccountHolderName() + " a payment of " +

				finalTransaction.getReceivedAmount() + " " + finalTransaction.getReceiverCurrency() +

				" has been initiated to your bank " + "account number " + finalTransaction.getAccountNumber()

		);

		// sending message using transport class

		Transport.send(mailMessage);

	}

	//// transaction management ////

	// method to get user transaction

	@Override
	public List<FinalTransaction> getUserTransaction() {

		List<FinalTransaction> userTransactionDetails = transactionRepo.findAll();

		return userTransactionDetails;
	}

	@Override

	// method to get transaction as per date

	public List<FinalTransaction> getUserTransactionByDate(LocalDate date) {
		// TODO Auto-generated method stub

		List<FinalTransaction> transaction = transactionRepo.findByDate(date);

		return transaction;

	}

	@Override

	public Double getProfit() {
		Double prof = transactionRepo.getProfit();
		return prof;
	}
	
	@Override
	public List<FinalTransaction> getUserTransactionByName(String accountHolderName) {
		List<FinalTransaction> transaction = transactionRepo.findByAccountNAme(accountHolderName);
		return transaction;
	}

}
