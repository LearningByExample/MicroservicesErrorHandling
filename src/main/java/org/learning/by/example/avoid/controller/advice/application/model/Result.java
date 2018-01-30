package org.learning.by.example.avoid.controller.advice.application.model;

public class Result<type> {

  private final type value;
  private final boolean hasError;

  private Result(type type, boolean hasError) {
    this.value = type;
    this.hasError = hasError;
  }

  public type getValue() {
    return value;
  }

  public boolean isError() {
    return hasError;
  }

  public static <type> Result<type> create(type object) {
    return new Result<type>(object, false);
  }

  public static <type> Result<type> error(type object) {
    return new Result<type>(object, true);
  }
}
