package com.banking.model.request;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class OpenAccountRequest
{
    @NonNull
    private String customerId;
    @NonNull
    private BigDecimal initialCredit;
}
