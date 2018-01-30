package org.learning.by.example.avoid.controller.advice.customer.controller;

import org.learning.by.example.avoid.controller.advice.customer.model.NotFound;
import org.learning.by.example.avoid.controller.advice.customer.service.CustomerService;
import org.learning.by.example.avoid.controller.advice.application.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(final CustomerService customerService) {
    this.customerService = customerService;
  }

  private HttpStatus getStatus(final Result result){
    if (result.isError()) {
      if (result.getValue() instanceof NotFound)
        return HttpStatus.NOT_FOUND;
      else
        return HttpStatus.BAD_REQUEST;
    } else return HttpStatus.OK;
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<?> get(@PathVariable() int id) {
    final Result result = customerService.get(id);
    final HttpStatus status = getStatus(result);

    return new ResponseEntity<>(result.getValue(), status);
  }
}
