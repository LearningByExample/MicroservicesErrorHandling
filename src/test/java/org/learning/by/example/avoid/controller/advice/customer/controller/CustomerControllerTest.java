package org.learning.by.example.avoid.controller.advice.customer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.by.example.avoid.controller.advice.application.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest(classes = ApplicationConfig.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void mockMvcShouldBeReady() {
    assertThat(mockMvc, is(notNullValue()));
  }
}