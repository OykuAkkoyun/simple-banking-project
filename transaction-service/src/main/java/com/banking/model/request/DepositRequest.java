package com.banking.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositRequest
{
    private String toAccount;
    private String accountStatus;
    private BigDecimal amount;
}
