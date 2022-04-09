package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
public class CookieController {
  @GetMapping("/set-cookie")
  public ResponseEntity<Object> setCookie(HttpServletResponse response) {
    ResponseCookie springCookie =
        ResponseCookie.from("customer-id", UUID.randomUUID().toString())
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(60)
            .domain("example.com")
            .build();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
  }

  @GetMapping("/read-cookie")
  public String readCookie(
      @CookieValue(name = "customer-id", defaultValue = "default") String userId) {
    return userId;
  }
}
