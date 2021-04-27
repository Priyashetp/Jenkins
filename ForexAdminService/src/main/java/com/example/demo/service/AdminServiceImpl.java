package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CurrencyEntity;
import com.example.demo.exception.AdminServiceException;
import com.example.demo.repo.CurrencyInfoRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CurrencyInfoRepo repo;
	
	
	// add new currency logic
	
	
	@Override
	public String addCurrency(CurrencyEntity entity) throws AdminServiceException {
		// TODO Auto-generated method stub
	
//		   if(entity != null) {
//			   
//			   Optional<CurrencyEntity> newEntity = repo.findById(entity.getId());
//			   
//			   if(newEntity==null) {
//				   
//				   repo.save(entity);
//	               return "Currency Added Successfully";
//			   }
//			   else {
//				   throw new AdminServiceException("Currency Already Exist!!");
//			   }
//			   
//		   }
//		   else {
//			   throw new AdminServiceException("Data model unavailable");
//		   }
		
		repo.save(entity);
		return "currency added successfully";
	}		
	

	// update currency logic
	
	@Override
	public String updateCurrency(CurrencyEntity entity) throws AdminServiceException {
		// TODO Auto-generated method stub
		
		if(entity!= null) {
			
			   entity.setId(entity.getId());
			   entity.setCurrencyName(entity.getCurrencyName());
			   entity.setCurrencyValue(entity.getCurrencyValue());
	           repo.save(entity);
			   return "Currency Updated Succesfully";		
		}
		
		else {
			
			throw new AdminServiceException("Data model unavailable");
		}
	}

	
	// delete currency logic
	
	@Override
	public void deleteCurrency(long id) {
		// TODO Auto-generated method stub
	
		  repo.deleteById(id);
		  
	}
	
	// view all currency 

	@Override
	public List<CurrencyEntity> ViewCurrency() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
		
		
		
	}

	
	// view currency as per name

	public CurrencyEntity ViewCurrencyByName(String name) {
		
		return repo.findByName(name);
		
		
	}
	
	// get currency rates
	
	public HashMap<String, Double> getRates(String senderCurrency , String receiverCurrency) throws AdminServiceException {
		
		     
		HashMap<String, Double> hashMap = new HashMap<>();
		
		
		     CurrencyEntity entity = repo.findByName(senderCurrency);
		     
		     CurrencyEntity newEntity = repo.findByName(receiverCurrency);
		     
		     if((newEntity != null  && entity != null) ) {
		    	 
		    	     
		    	     hashMap.put(entity.getCurrencyName(), entity.getCurrencyValue());
		    	     
		    	     hashMap.put(newEntity.getCurrencyName() , newEntity.getCurrencyValue());
		    	    
		    	     return hashMap;
		    	     
		 	 
	         }
		     else {
		    	 throw new AdminServiceException("Conversion not possible!!");
		     }
		 }

}
