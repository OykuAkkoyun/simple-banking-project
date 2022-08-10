package com.banking.model.mapper;

import com.banking.model.entity.AccountEntity;
import com.banking.model.response.Account;
import org.springframework.beans.BeanUtils;

public class AccountMapper extends BaseMapper<AccountEntity, Account>
{
    @Override
    public AccountEntity convertToEntity(Account dto, Object... args)
    {
        AccountEntity entity = new AccountEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity, "customer");
        }
        return entity;
    }

    @Override
    public Account convertToDto(AccountEntity entity, Object... args)
    {
        Account dto = new Account();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "customer");
        }
        return dto;
    }
}
