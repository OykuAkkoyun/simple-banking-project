package com.banking.helper.exception;

public class EntityNotFoundException extends SimpleBankingGlobalException
{
    public EntityNotFoundException()
    {
        super("Requested entity not present in the DB.", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }
}
