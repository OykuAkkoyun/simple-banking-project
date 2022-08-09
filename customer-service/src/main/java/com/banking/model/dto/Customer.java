package com.banking.model.dto;

import lombok.Data;

@Data
public class Customer
{
    private Long id;

    private String customerId;

    private String firstName;

    private String lastName;
}
