/*package com.banking.service;

import com.banking.configuration.CustomFeignClientConfiguration;
import com.banking.model.request.DepositRequest;
import com.banking.model.response.AccountResponse;
import com.banking.model.response.DepositResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "simple-banking-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreFeignClient
{
    @RequestMapping(path = "/api/account/{accountNumber}", method = RequestMethod.GET)
    AccountResponse getAccount(@PathVariable("accountNumber") String accountNumber);

    @RequestMapping(path = "/api/v1/transaction/fund-transfer", method = RequestMethod.POST)
    DepositResponse deposit(@RequestBody DepositRequest depositRequest);
}
*/