package com.example.demo.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MoneyTranferDetails;

@Service
public class CurrencyConversionServiceImpl {
	
    
	   @Autowired
	   ForexUserServiceProxy serviceProxy;
	
	   
	            /// currency conversion based on rates set by admin
	     
	    
	    public MoneyTranferDetails currencyConversion(MoneyTranferDetails transferDetails) {
			
	    	 
	    	HashMap<String, Double> hashMap = serviceProxy.getRates(transferDetails.getSenderCurrency(),
	    			                                                   transferDetails.getReceiverCurrency());
	    	    
	    	   
	    	       double  rate1 = hashMap.get(transferDetails.getSenderCurrency());
	    	       double  rate2 = hashMap.get(transferDetails.getReceiverCurrency());
	    	       
	    	       double exchangeRate =  rate1/rate2;
 	    	      
	    	        double receivedAmount =  transferDetails.getConvertedAmount() * exchangeRate;

	    	       
	    	             transferDetails.setReceivedAmount(receivedAmount);
	    	              
	    	              
	    	              	    return transferDetails;
	    	    	   
	    	       }
	
	  	  
}
