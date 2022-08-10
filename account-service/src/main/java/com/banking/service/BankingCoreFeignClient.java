package com.banking.service;

import com.banking.configuration.CustomFeignClientConfiguration;
import com.banking.model.response.CustomerInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "simple-banking-customer-service", configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreFeignClient
{
    @RequestMapping(method = RequestMethod.GET, value = "api/customer/{customerId}")
    CustomerInfo getCustomerInfo(@PathVariable("customerId") String customerId);
}
