package com.banking.service;

import com.banking.configuration.CustomFeignClientConfiguration;
import com.banking.model.response.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "simple-banking-account-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreFeignClient
{
    @RequestMapping(method = RequestMethod.GET, value = "/api/account/customer/{customerId}")
    AccountResponse getCustomerAccounts(@PathVariable("customerId") String customerId);
}
