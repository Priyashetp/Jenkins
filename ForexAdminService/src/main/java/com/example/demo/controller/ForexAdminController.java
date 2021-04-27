package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CurrencyEntity;
import com.example.demo.exception.AdminServiceException;
import com.example.demo.service.AdminServiceImpl;

@CrossOrigin("*")
@RestController
public class ForexAdminController {

	
	@Autowired
	AdminServiceImpl service;
	
	
	  // view all currency details 
	
	    @GetMapping("/viewcurrency")
	    public List<CurrencyEntity> getCurrencyList() {
	    	
	    	
	     return service.ViewCurrency();
	    		
	   }
	    
	    // view currency by name
	
	    @GetMapping("/viewcurrencybyname/{name}")
	    public CurrencyEntity getCurrencyByName(@PathVariable String name) {
	    	
	    	
	        return service.ViewCurrencyByName(name);
	    		
	   }
	
	    
	    
	    // add new currency
	    
	    @PostMapping("/addcurrency")
	    public String addCurrency(@RequestBody CurrencyEntity entity) throws AdminServiceException {
	    	
	    	
	    	 String response = service.addCurrency(entity);
	    	 
	    	 return response;
	    	
	   }
	    
	    
	    // update currency

	    @PutMapping("/updatecurrency")
	    public String updatecurrency(@RequestBody CurrencyEntity entity) throws AdminServiceException {
		
	    String response = service.updateCurrency(entity);
	    	
	    	return response;
	    }
	    
	    
	    // delete currency
	    
	    @DeleteMapping("/deletecurrency/{id}")
	    public void deleteCurrency(@PathVariable long id) {
	    	
	    	 service.deleteCurrency(id);
	    	
	  	    }
	    
	    
	    // getting currency rates 
	    
	    
	    @GetMapping("/getrates/{senderCurrency}/{receiverCurrency}")
	    public HashMap<String, Double> getRates(@PathVariable String senderCurrency , @PathVariable String receiverCurrency) throws AdminServiceException {
	    	
	    	
	       HashMap<String, Double> response = service.getRates(senderCurrency, receiverCurrency);
	    	
	         
	              return response;
	    	   
	   }
}


