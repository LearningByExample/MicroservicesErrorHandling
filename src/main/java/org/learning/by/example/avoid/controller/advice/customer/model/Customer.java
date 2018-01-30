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

  public void setData(final String data) {
    this.data = data;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
