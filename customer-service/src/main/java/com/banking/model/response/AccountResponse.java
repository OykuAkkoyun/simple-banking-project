package com.banking.model.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountResponse
{
    private String accountNumber;
    private BigDecimal currentBalance;
}