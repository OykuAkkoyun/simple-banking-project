package com.banking.exception;

public class TransactionNotPerformedException extends SimpleBankingGlobalException
{
    public TransactionNotPerformedException()
    {
        super("Unexpected error occurred while transaction performed.", GlobalErrorCode.ERROR_TRANSACTION_NOT_PERFORMED);
    }
}
