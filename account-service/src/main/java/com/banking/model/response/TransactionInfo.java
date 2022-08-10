package com.banking.model.response;

import com.banking.model.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionInfo
{
    private BigDecimal amount;
    private TransactionType transactionType;
}
