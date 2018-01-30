package org.learning.by.example.avoid.controller.advice.application;

import org.learning.by.example.avoid.controller.advice.customer.controller.CustomerController;
import org.learning.by.example.avoid.controller.advice.customer.service.CustomerService;
import org.learning.by.example.avoid.controller.advice.customer.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
  @Bean
  CustomerService customerService(){
    return new CustomerServiceImpl();
  }

  @Bean
  CustomerController customerController(final CustomerService customerService){
    return new CustomerController(customerService);
  }
}
