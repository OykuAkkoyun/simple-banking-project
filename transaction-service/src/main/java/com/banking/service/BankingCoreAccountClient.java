package com.banking.service;

import com.banking.configuration.CustomFeignClientConfiguration;
import com.banking.model.request.UpdateBalanceRequest;
import com.banking.model.response.AccountResponse;
import com.banking.model.response.UpdateBalanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "simple-banking-account-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreAccountClient
{
    @RequestMapping(path = "/api/account/updateBalance", method = RequestMethod.POST)
    UpdateBalanceResponse updateBalance(@RequestBody UpdateBalanceRequest updateBalanceRequest);

    @RequestMapping(path = "/api/account/{accountNumber}", method = RequestMethod.GET)
    AccountResponse getAccount(@PathVariable("accountNumber") String accountNumber);
}