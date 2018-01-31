## Avoid Controller Advice
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](/LICENSE)
[![Build Status](https://travis-ci.org/LearningByExample/AvoidControllerAdvice.svg?branch=master)](https://travis-ci.org/LearningByExample/AvoidControllerAdvice)
[![codecov](https://codecov.io/gh/LearningByExample/AvoidControllerAdvice/branch/master/graph/badge.svg)](https://codecov.io/gh/LearningByExample/AvoidControllerAdvice)

## info

The idea behind that project is to check how we could avoid to use ControllerAdvice, and even checked exceptions when handling errors in our Microservices.

Checked exception some times could leek ke the implementation details of our components, and as well used to break the control flow.

In order hand ControllerAdvice is the ultimate GOTO that we should use only to handle really unchecked exceptions, something really wrong.

The approach is to handle errors as part of our business logic.

## usage

We have created one wrapper class to support this concept named `Result<type>`, this class has two creation methods.

- `Result.create(object);` : That will create a wrapper containing the data to be returned.
- `Result.error(object)` : That will create a wrapper containing an error.



How to use this class is simple, for example in this example:

```java
public Result get(int id) {
  if (id == 1) return Result.create(new Customer(1, "super customer"));
  else if (id == -1)
    return Result.error(new BadParameters("bad parameters"));
  else
    return Result.error(new NotFound("customer not found"));
}
```

For handling the result we could just use the methods `isError()` and `getData()`.

```java
Result result = operation();

if(result.isError()){
  //do something with the error
}else{
  Customer customer = result.getValue();
}

```

Finally we use in our Controller a generic ResponseEntity we could return the wrapper value without needing to understand what contains.

For example:

```java

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

```

## runing

To just run the example microservice you could just do from the command line:
```bash
$ mvnw spring-boot run
```

To test the output when sending a correct customer id:

```bash
$ curl
```

To test the output when sending a invalidad customer id

```bash
$ curl
```

To test the output when sending a not found customer id

```bash
$ curl
```

## references

--