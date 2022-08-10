package com.banking.service;

import com.banking.exception.EntityNotFoundException;
import com.banking.model.request.TransactionRequest;
import com.banking.model.request.UpdateBalanceRequest;
import com.banking.model.response.*;
import com.banking.model.entity.AccountEntity;
import com.banking.model.mapper.AccountMapper;
import com.banking.model.request.OpenAccountRequest;
import com.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService
{
    private final AccountRepository accountRepository;
    private final BankingCoreFeignClient bankingCoreFeignClient;
    private final BankingTransactionFeignClient bankingTransactionFeignClient;

    private AccountMapper accountMapper = new AccountMapper();

    public List<Account> getAccounts(Pageable pageable)
    {
        Page<AccountEntity> allAccountsInDb = accountRepository.findAll(pageable);
        List<Account> accounts = accountMapper.convertToDtoList(allAccountsInDb.getContent());

        return accounts;
    }

    public Account getAccount(String accountNumber)
    {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber).orElseThrow(EntityNotFoundException::new);
        return accountMapper.convertToDto(accountEntity);
    }

    public AccountDetailResponse getAccountDetails(String accountNumber)
    {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber).orElseThrow(EntityNotFoundException::new);

        CustomerInfo customerInfo = bankingCoreFeignClient.getCustomerInfo(accountEntity.getCustomerId());
        List<TransactionInfo> transactionInfo = bankingTransactionFeignClient.getAccountTransactions(accountNumber);
        AccountDetailResponse response = AccountDetailResponse.convertAccountDetailResponse(accountEntity.getAccountNumber(),
                accountEntity.getCurrentBalance(), customerInfo, transactionInfo);

        return response;
    }

    @Transactional
    public OpenAccountResponse openAccount(OpenAccountRequest request)
    {
        log.info("Sending create account request {}" + request.toString());

        AccountEntity entity = new AccountEntity();
        String generatedAccountNumber = UUID.randomUUID().toString();
        entity.setAccountNumber(generatedAccountNumber);
        entity.setCustomerId(request.getCustomerId());

        if (request.getInitialCredit().compareTo(BigDecimal.ZERO) < 0)
            entity.setCurrentBalance(BigDecimal.valueOf(0));
        else
            entity.setCurrentBalance(request.getInitialCredit());

        AccountEntity accountEntityResult = accountRepository.save(entity);

        if (accountEntityResult != null && request.getInitialCredit().compareTo(BigDecimal.ZERO) > 0)
        {
            makeDepositRecord(request, generatedAccountNumber);
        }

        OpenAccountResponse openAccountResponse = new OpenAccountResponse();
        openAccountResponse.setAccountNumber(generatedAccountNumber);
        openAccountResponse.setCurrentBalance(accountEntityResult.getCurrentBalance());
        openAccountResponse.setMessage("Account Successfully Opened");

        return openAccountResponse;
    }

    private void makeDepositRecord(OpenAccountRequest request, String generatedAccountNumber)
    {
        TransactionRequest depositRequest = new TransactionRequest(generatedAccountNumber, "NEW", request.getInitialCredit());
        bankingTransactionFeignClient.deposit(depositRequest);
    }

    public UpdateBalanceResponse updateBalance(UpdateBalanceRequest request)
    {
        UpdateBalanceResponse response = new UpdateBalanceResponse();
        AccountEntity accountEntity = accountRepository.findByAccountNumber(request.getAccountNumber()).orElseThrow(EntityNotFoundException::new);
        accountEntity.setCurrentBalance(accountEntity.getCurrentBalance().add(request.getAmount()));

        accountRepository.save(accountEntity);
        response.setMessage("Account's balance is updated");

        return response;
    }

}
