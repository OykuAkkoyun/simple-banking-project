package com.banking.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Data
public class UpdateBalanceRequest
{
    @NonNull
    private String accountNumber;
    @NonNull
    private BigDecimal amount;
}
