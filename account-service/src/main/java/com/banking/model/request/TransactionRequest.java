package com.banking.model.request;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class TransactionRequest
{
    @NonNull
    private String toAccount;
    @NonNull
    private String accountStatus;
    @NonNull
    private BigDecimal amount;
}