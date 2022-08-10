package com.banking.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class UpdateBalanceRequest
{
    private String accountNumber;
    private BigDecimal amount;
}
