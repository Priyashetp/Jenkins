package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.UserDashboardService;

@SpringBootTest
class ForexUserServiceApplicationTests {

	@Autowired
	UserDashboardService service;
	@Test
	void fetchUserAccountTest() {
		assertNotNull(service.fetchUserAccount());
	}
	
	@Test
	void getUserTransactionTest() {
		assertNotNull(service.getUserTransaction());
	}
	@Test
	void getUserTransactionByDate() {
		LocalDate date1 = LocalDate.parse("2021-01-01");

		assertNotNull(service.getUserTransactionByDate(date1));
	}
	@Test
	void getUserTransactionByNameTest() {
		assertNotNull(service.getUserTransactionByName("vijay"));
	}


}
