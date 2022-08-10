package com.banking.service;

import com.banking.configuration.CustomFeignClientConfiguration;
import com.banking.model.request.TransactionRequest;
import com.banking.model.response.TransactionInfo;
import com.banking.model.response.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "simple-banking-transaction-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingTransactionFeignClient
{
    @RequestMapping(method = RequestMethod.POST, value = "/api/transaction/deposit")
    TransactionResponse deposit(@RequestBody TransactionRequest depositRequest);

    @RequestMapping(method = RequestMethod.GET, value = "api/transaction/{accountNumber}")
    List<TransactionInfo> getAccountTransactions(@PathVariable("accountNumber") String accountNumber);
}