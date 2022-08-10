package com.banking.repository;

import com.banking.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>
{
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
  //  List<AccountEntity> findByCustomerId(String customerId);
}
