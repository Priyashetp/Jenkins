package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BankAccountDetailsEntity;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccountDetailsEntity, Long> {

    @Query("SELECT u FROM BankAccountDetailsEntity u WHERE u.currency = ?1")
   	List<BankAccountDetailsEntity> findByCurrency(String currency);


}
