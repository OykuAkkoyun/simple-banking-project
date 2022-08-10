package com.banking.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Data
public class AccountDetailResponse
{
    private String accountNumber;
    private BigDecimal currentBalance;
    private CustomerInfo customerInfo;
    private List<TransactionInfo> transactionInfo;

    public static AccountDetailResponse convertAccountDetailResponse(String accountNumber, BigDecimal currentBalance,
                                                     CustomerInfo customerInfo, List<TransactionInfo> transactionInfo)
    {
        AccountDetailResponse response = new AccountDetailResponse();
        response.setAccountNumber(accountNumber);
        response.setCurrentBalance(currentBalance);
        response.setCustomerInfo(customerInfo);
        response.setTransactionInfo(transactionInfo);

        return response;
    }
}
