package com.banking.service;

import com.banking.exception.EntityNotFoundException;
import com.banking.exception.TransactionNotPerformedException;
import com.banking.model.TransactionType;
import com.banking.model.entity.TransactionEntity;
import com.banking.model.request.DepositRequest;
import com.banking.model.request.UpdateBalanceRequest;
import com.banking.model.response.AccountResponse;
import com.banking.model.response.DepositResponse;
import com.banking.model.response.TransactionInfoResponse;
import com.banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionService
{
    private final TransactionRepository transactionRepository;
    private final BankingCoreAccountClient bankingCoreAccountClient;

    public DepositResponse deposit(DepositRequest request)
    {
        log.info("Sending deposit request {}" + request.toString());

        if (request.getAccountStatus().equals("ACTIVE"))
        {
            UpdateBalanceRequest updateAccountBalance = new UpdateBalanceRequest();
            updateAccountBalance.setAccountNumber(request.getToAccount());
            updateAccountBalance.setAmount(request.getAmount());
            bankingCoreAccountClient.updateBalance(updateAccountBalance);
        }

        TransactionEntity entity = new TransactionEntity();
        entity.setAccountNumber(request.getToAccount());
        entity.setAmount(request.getAmount());
        entity.setTransactionType(TransactionType.DEPOSIT);
        TransactionEntity depositResult = transactionRepository.save(entity);

        DepositResponse depositResponse = new DepositResponse();
        if(depositResult != null)
        {
            depositResponse.setTransactionId(depositResult.getId().toString());
            depositResponse.setMessage("Deposit to Account Successfully Completed : " + entity.getAccountNumber());
        }
        else throw new TransactionNotPerformedException();

        return depositResponse;
    }

    public List<TransactionInfoResponse> getTransactionByAccountNumber(String accountNumber)
    {
        List<TransactionInfoResponse> response = new ArrayList<>();
        List<TransactionEntity> depositEntityList = transactionRepository.findByAccountNumber(accountNumber).orElseThrow(EntityNotFoundException::new);

        for (TransactionEntity depositEntity : depositEntityList)
        {
            TransactionInfoResponse item = new TransactionInfoResponse();
            item.setAmount(depositEntity.getAmount());
            item.setTransactionType(TransactionType.DEPOSIT);
            response.add(item);
        }

        return response;
    }

}
