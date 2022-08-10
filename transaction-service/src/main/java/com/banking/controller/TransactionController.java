package com.banking.controller;

import com.banking.model.request.DepositRequest;
import com.banking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transaction")
public class TransactionController
{
    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody DepositRequest depositRequest)
    {
        log.info("Got deposit request from API {}", depositRequest.toString());
        return ResponseEntity.ok(transactionService.deposit(depositRequest));
    }

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity getTransactionsByAccountNumber(@PathVariable("accountNumber") String accountNumber)
    {
        log.info("Getting transactions by account number {}", accountNumber);
        return ResponseEntity.ok(transactionService.getTransactionByAccountNumber(accountNumber));
    }

}
