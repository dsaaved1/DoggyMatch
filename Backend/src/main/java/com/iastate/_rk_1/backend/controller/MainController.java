package com.iastate._rk_1.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  
  /**
   * Returns "server running" if the server is running
   * @return String
   */
  @GetMapping("/")
  public String index() {
      return "server running";
  }
}
