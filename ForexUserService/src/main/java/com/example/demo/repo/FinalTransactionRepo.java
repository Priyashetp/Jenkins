package com.example.demo.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FinalTransaction;

@Repository
public interface FinalTransactionRepo extends JpaRepository<FinalTransaction, Long> {

	

    @Query("SELECT u FROM FinalTransaction u WHERE u.transactionDate = ?1")
	List<FinalTransaction> findByDate(LocalDate date);

    @Query("SELECT u FROM FinalTransaction u WHERE u.senderName = ?1")
	List<FinalTransaction> findByAccountNAme(String accountHolder);

    
    @Query("SELECT sum(v.serviceFee) as prof FROM FinalTransaction v ")
	Double getProfit();


}
