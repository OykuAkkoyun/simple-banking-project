package com.banking;

import com.banking.model.response.CustomerResponse;
import com.banking.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
class CustomerServiceApplicationTests
{
	@MockBean
	CustomerService customerService;

	@Test
	void contextLoads()
	{
	}

	@Test
	public void get_customer_by_customer_id()
	{
		CustomerResponse response = new CustomerResponse();
		response.setFirstName("Oyku");
		response.setLastName("Akkoyun");

		Mockito.when(customerService.getCustomer("123")).thenReturn(response);

		Assertions.assertEquals("Oyku", response.getFirstName());
	}

}
