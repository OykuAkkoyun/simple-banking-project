package com.banking;

import com.banking.controller.TransactionController;
import com.banking.model.response.TransactionInfoResponse;
import com.banking.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TransactionServiceApplicationTests
{

	@MockBean
	private TransactionService transactionService;

	@Autowired
	private TransactionController transactionController;

	@Test
	void contextLoads()
	{
		Assertions.assertNotNull(transactionController);
	}

	@Test
	public void get_transaction_by_account_number()
	{
		List<TransactionInfoResponse> transactionInfoResponseList = new ArrayList<>();
		TransactionInfoResponse transactionInfo = new TransactionInfoResponse();
		transactionInfo.setAmount(BigDecimal.valueOf(1250));
		TransactionInfoResponse anotherTransactionInfo = new TransactionInfoResponse();
		transactionInfo.setAmount(BigDecimal.valueOf(550));

		transactionInfoResponseList.add(transactionInfo);
		transactionInfoResponseList.add(anotherTransactionInfo);

		Mockito.when(transactionService.getTransactionByAccountNumber("123")).thenReturn(transactionInfoResponseList);

		Assertions.assertNotNull(transactionInfoResponseList);
		Assertions.assertEquals(2, transactionInfoResponseList.size());
	}

}
