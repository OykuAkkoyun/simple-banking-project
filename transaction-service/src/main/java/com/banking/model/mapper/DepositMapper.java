package com.banking.model.mapper;

import com.banking.model.dto.Deposit;
import com.banking.model.entity.TransactionEntity;
import org.springframework.beans.BeanUtils;

public class DepositMapper extends BaseMapper<TransactionEntity, Deposit>
{
    @Override
    public TransactionEntity convertToEntity(Deposit dto, Object... args)
    {
        TransactionEntity entity = new TransactionEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public Deposit convertToDto(TransactionEntity entity, Object... args)
    {
        Deposit dto = new Deposit();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
}
