package com.banking.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse
{
    private String accountNumber;
    private BigDecimal currentBalance;
    private Long id;
    private String status;
}
