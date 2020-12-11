package com.abel3t.learn.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class statusController {

  private final static Logger LOGGER = LoggerFactory.getLogger(statusController.class);

  @GetMapping("/status")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public final Exception handleAllExceptions(RuntimeException e) {
    LOGGER.error("Internal server error.", e);
    return e;
  }
}
