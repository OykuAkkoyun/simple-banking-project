package com.banking.controller;

import com.banking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/customer")
@RequiredArgsConstructor
public class CustomerController
{
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity getCustomers(Pageable pageable)
    {
        log.info("Getting all customers from API");
        return ResponseEntity.ok(customerService.getCustomers(pageable));
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity getCustomer(@PathVariable("customerId") String customerId)
    {
        log.info("Getting customer by customerId {}", customerId);
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

   /* @GetMapping(value = "/{customerId}/account")
    public ResponseEntity getCustomerAccounts(@PathVariable("customerId") String customerId)
    {
        log.info("Getting customer accounts by customerId {}", customerId);
        return ResponseEntity.ok(customerService.getCustomerAccounts(customerId));
    }*/

    @GetMapping(value = "/{customerId}/transaction")
    public ResponseEntity getAllInformation(@PathVariable("customerId") String customerId)
    {
        log.info("Reading customer by customerId {}", customerId);
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }
}
