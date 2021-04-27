package com.example.demo.service;

import java.util.HashMap;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("forex-admin-service")
@RibbonClient("forex-admin-service")
public interface ForexUserServiceProxy {
	
	
	/// proxy service for microservices communication
	
	
    @GetMapping("/getrates/{senderCurrency}/{receiverCurrency}")
    public HashMap<String, Double> getRates(@PathVariable String senderCurrency , @PathVariable String receiverCurrency); 

	
	

}
