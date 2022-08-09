package com.banking.model.mapper;

import com.banking.model.dto.Customer;
import com.banking.model.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;

public class CustomerMapper extends BaseMapper<CustomerEntity, Customer>
{
    @Override
    public CustomerEntity convertToEntity(Customer dto, Object... args)
    {
        CustomerEntity customerEntity = new CustomerEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, customerEntity);
        }
        return customerEntity;
    }

    @Override
    public Customer convertToDto(CustomerEntity entity, Object... args)
    {
        Customer customer = new Customer();
        if (entity != null) {
            BeanUtils.copyProperties(entity, customer);
        }
        return customer;
    }
}
