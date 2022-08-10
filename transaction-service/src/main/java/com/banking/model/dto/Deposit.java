package com.banking.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Deposit
{
    private Long id;
    private String transactionReference;
    private String toAccount;
    private BigDecimal amount;
}
