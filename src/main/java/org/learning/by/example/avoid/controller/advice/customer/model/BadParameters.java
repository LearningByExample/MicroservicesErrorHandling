package org.learning.by.example.avoid.controller.advice.customer.model;

public class BadParameters {
  private String message;

  public BadParameters(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
