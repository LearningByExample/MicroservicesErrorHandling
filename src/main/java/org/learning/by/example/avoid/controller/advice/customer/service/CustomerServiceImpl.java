package org.learning.by.example.avoid.controller.advice.customer.service;

import org.learning.by.example.avoid.controller.advice.application.model.Result;
import org.learning.by.example.avoid.controller.advice.customer.model.BadParameters;
import org.learning.by.example.avoid.controller.advice.customer.model.Customer;
import org.learning.by.example.avoid.controller.advice.customer.model.NotFound;

public class CustomerServiceImpl implements CustomerService {

  @Override
  public Result get(int id) {
    if (id == 1) return Result.create(new Customer(1, "super customer"));
    else if (id == -1)
      return Result.error(new BadParameters("bad parameters"));
    else
      return Result.error(new NotFound("customer not found"));
  }
}

