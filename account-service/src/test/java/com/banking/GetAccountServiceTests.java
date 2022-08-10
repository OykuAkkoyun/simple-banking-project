package com.banking;

import com.banking.model.request.OpenAccountRequest;
import com.banking.model.response.Account;
import com.banking.model.response.OpenAccountResponse;
import com.banking.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

@SpringBootTest
class GetAccountServiceTests
{
	@MockBean
	AccountService accountService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void get_account_when_input_is_valid()
	{
		Account account = new Account();
		account.setAccountNumber("123");
		account.setCustomerId("11");
		account.setId(Long.valueOf(1));
		account.setCurrentBalance(BigDecimal.valueOf(100.0));

		Mockito.when(accountService.getAccount("123")).thenReturn(account);

		Assertions.assertEquals("123", account.getAccountNumber());
	}

	@Test
	public void get_account_when_input_is_not_valid()
	{
		Account account = null;
		account = accountService.getAccount("0");

		Assertions.assertEquals(null, account);
	}

}
