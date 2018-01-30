package org.learning.by.example.avoid.controller.advice.customer.service;

import org.junit.Test;
import org.learning.by.example.avoid.controller.advice.application.model.Result;
import org.learning.by.example.avoid.controller.advice.customer.model.BadParameters;
import org.learning.by.example.avoid.controller.advice.customer.model.Customer;
import org.learning.by.example.avoid.controller.advice.customer.model.NotFound;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerServiceImplTest {

  private final CustomerServiceImpl customerService = new CustomerServiceImpl();

  @Test
  public void getValidCustomerShouldWork() {
    Result result = customerService.get(1);

    assertThat(result.isError(), equalTo(false));
    assertThat(result.getValue(), instanceOf(Customer.class));
  }

  @Test
  public void getNotValidIdShouldReturnBadParameters() {
    Result result = customerService.get(-1);

    assertThat(result.isError(), equalTo(true));
    assertThat(result.getValue(), instanceOf(BadParameters.class));
  }

  @Test
  public void getNotFoundIdShouldReturnNotFound() {
    Result result = customerService.get(2);

    assertThat(result.isError(), equalTo(true));
    assertThat(result.getValue(), instanceOf(NotFound.class));
  }

}
