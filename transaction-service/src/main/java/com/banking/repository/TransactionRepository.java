package com.banking.repository;

import com.banking.model.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>
{
    Optional<List<TransactionEntity>> findByAccountNumber(String accountNumber);
}
