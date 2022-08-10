package com.banking.controller;

import com.banking.model.request.OpenAccountRequest;
import com.banking.model.request.UpdateBalanceRequest;
import com.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController
{
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity openAccount(@RequestBody OpenAccountRequest openAccountRequest)
    {
        log.info("Create account request from API {}", openAccountRequest.toString());
        return ResponseEntity.ok(accountService.openAccount(openAccountRequest));
    }

    @GetMapping(value = "/{accountNumber}")
    public ResponseEntity getAccount(@PathVariable("accountNumber") String accountNumber)
    {
        log.info("Getting account by account number {}", accountNumber);
        return ResponseEntity.ok(accountService.getAccount(accountNumber));
    }

    @GetMapping(value = "/detail/{accountNumber}")
    public ResponseEntity getAccountDetails(@PathVariable("accountNumber") String accountNumber)
    {
        log.info("Getting account details by account number {}", accountNumber);
        return ResponseEntity.ok(accountService.getAccountDetails(accountNumber));
    }

    @PostMapping("/updateBalance")
    public ResponseEntity updateBalance(@RequestBody UpdateBalanceRequest updateBalanceRequest)
    {
        log.info("Create account request from API {}", updateBalanceRequest.toString());
        return ResponseEntity.ok(accountService.updateBalance(updateBalanceRequest));
    }

    @GetMapping
    public ResponseEntity getAccounts (Pageable pageable) {
        log.info("Getting all accounts from core");
        return ResponseEntity.ok(accountService.getAccounts(pageable));
    }

}
