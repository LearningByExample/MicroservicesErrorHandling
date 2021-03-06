package org.learning.by.example.avoid.controller.advice.customer.model;

public class Customer {
  private String data;
  private int id;

  public Customer(final int id, final String name) {
    this.id = id;
    this.data = name;
  }

  public String getData() {
    return data;
  }

  public int getId() {
    return id;
  }
}
