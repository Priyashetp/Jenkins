package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.CurrencyEntity;
import com.example.demo.exception.AdminServiceException;
import com.example.demo.service.AdminService;
import com.example.demo.service.AdminServiceImpl;

@SpringBootTest
class ForexAdminServiceApplicationTests {

	@Autowired
	AdminService service;

	@Test
	void testGetCurrencyList() {
		assertNotNull(service.ViewCurrency());
	}

	@Test
	void testGetCurrencyByName() {
		CurrencyEntity entity=new CurrencyEntity(2,"INR",1);
		assertEquals(entity, service.ViewCurrencyByName("INR"));
	}
	
//	@Test
//	void testGetRates()  {
//		
//		AdminServiceImpl service2=new AdminServiceImpl();
//		
//		HashMap<String, Double> rate= new HashMap<String, Double>();
//		rate.put("INR", 1.0);
//		rate.put("USD",75.14);
//		try {
//			assertEquals(rate, service2.getRates("inr","usd"));
//		} catch (AdminServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


}
