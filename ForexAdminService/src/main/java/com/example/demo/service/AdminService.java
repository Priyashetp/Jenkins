package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CurrencyEntity;
import com.example.demo.exception.AdminServiceException;

public interface AdminService {

	
	   public String addCurrency(CurrencyEntity entity) throws AdminServiceException;
	   
	   public String updateCurrency(CurrencyEntity entity) throws AdminServiceException;
	   
	   public void deleteCurrency(long id);
	   
	   public List<CurrencyEntity> ViewCurrency();
	    
		public CurrencyEntity ViewCurrencyByName(String name) ;

	   
}
