package org.learning.by.example.avoid.controller.advice.customer.model;

public class NotFound {
  private String message;

  public NotFound(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
