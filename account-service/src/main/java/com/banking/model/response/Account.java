package com.banking.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account
{
    private Long id;
    private String accountNumber;
    private BigDecimal currentBalance;
    private String customerId;
}