package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CurrencyEntity;

@Repository
public interface CurrencyInfoRepo extends JpaRepository<CurrencyEntity, Long>{


    @Query("SELECT u FROM CurrencyEntity u WHERE u.currencyName = ?1")
	CurrencyEntity findByName(String currencyName);

	
}
