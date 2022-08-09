package com.banking.service;

import com.banking.helper.exception.EntityNotFoundException;
import com.banking.model.dto.Customer;
import com.banking.model.entity.CustomerEntity;
import com.banking.model.mapper.CustomerMapper;
import com.banking.model.response.CustomerResponse;
import com.banking.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService
{
    private final CustomerRepository customerRepository;

    private CustomerMapper customerMapper = new CustomerMapper();


    public List<Customer> getCustomers(Pageable pageable)
    {
        Page<CustomerEntity> allCustomersInDb = customerRepository.findAll(pageable);
        List<Customer> customers = customerMapper.convertToDtoList(allCustomersInDb.getContent());
        return customers;
    }

    public CustomerResponse getCustomer(String customerId)
    {
        CustomerResponse response = new CustomerResponse();
        CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId).orElseThrow(EntityNotFoundException::new);
        response.setFirstName(customerEntity.getFirstName());
        response.setLastName(customerEntity.getLastName());

        return response;
    }
}
