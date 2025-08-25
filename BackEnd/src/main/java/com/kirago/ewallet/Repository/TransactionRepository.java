package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, String> {
    
}