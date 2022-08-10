package com.banking.model.response;

import com.banking.model.TransactionType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class TransactionInfoResponse
{
    private BigDecimal amount;
    private TransactionType transactionType;
}
