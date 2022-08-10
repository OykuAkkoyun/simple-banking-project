package com.banking.model.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OpenAccountResponse
{
    private String accountNumber;
    private BigDecimal currentBalance;
    private String message;
}
