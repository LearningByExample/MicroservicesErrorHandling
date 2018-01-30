package org.learning.by.example.avoid.controller.advice.customer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.by.example.avoid.controller.advice.application.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void mockMvcShouldBeReady() {
    assertThat(mockMvc, is(notNullValue()));
  }

  @Test
  public void weShouldGetACustomerWithValidId() throws Exception {
    mockMvc.perform(get("/customer/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data").value("super customer"));
  }

  @Test
  public void weShouldGetABadRequestWithInValidId() throws Exception {
    mockMvc.perform(get("/customer/-1"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("bad parameters"));
  }

  @Test
  public void weShouldGetANotFoundWithOtherId() throws Exception {
    mockMvc.perform(get("/customer/2"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("customer not found"));
  }

}