package com.fintracker.repository;

import com.fintracker.entity.Transaction;
import com.fintracker.entity.TransactionType;
import com.fintracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByUserIdAndType(Long userId, TransactionType type);
}
