package com.banking;

import com.banking.controller.AccountController;
import com.banking.model.request.OpenAccountRequest;
import com.banking.model.response.OpenAccountResponse;
import com.banking.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
public class OpenNewAccountTests
{

    @Autowired
    AccountService accountService;

    @Autowired
    private AccountController accountController;

    @Test
    void contextLoads()
    {
        Assertions.assertNotNull(accountService);
        Assertions.assertNotNull(accountController);
    }

    @Test
    public void open_new_account_with_negative_amount()
    {
        OpenAccountRequest request = new OpenAccountRequest("1", BigDecimal.valueOf(-1));

        OpenAccountResponse response = accountService.openAccount(request);

        Assertions.assertEquals(BigDecimal.valueOf(0), response.getCurrentBalance());
    }

}
