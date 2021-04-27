package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.service.AdminService;
@EnableDiscoveryClient
@SpringBootApplication


class ForexAdminControllerTest {

	@Autowired
	AdminService service;

	@Test
	void testGetCurrencyList() {
	}

	@Test
	void testGetCurrencyByName() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCurrency() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatecurrency() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCurrency() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRates() {
		fail("Not yet implemented");
	}

}
