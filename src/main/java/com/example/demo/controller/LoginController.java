package com.example.demo.controller;

import com.example.demo.dto.CustomerAuthDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;

@RestController
public class LoginController {
  @Autowired CustomerService customerService;

  @GetMapping("/login")
  public ModelAndView loginCustomer(@RequestBody CustomerAuthDTO customerInfo, HttpServletResponse response) {
    if (customerService.validateLogin(customerInfo)) {
      ModelAndView modelAndView = new ModelAndView("login");

      Cookie cookie = new Cookie("customerUsername", customerInfo.getUsername());

      cookie.setPath("/");
      cookie.setMaxAge(60);
      cookie.setHttpOnly(true);
      cookie.setDomain("localhost");

      response.addCookie(cookie);

      modelAndView.addObject("successMessage", " Login successful !");
      modelAndView.setViewName("login");
      return modelAndView;
    } else {
      ModelAndView modelAndView = new ModelAndView("errorLogin");
      modelAndView.addObject("errorMessage", "Incorrect Data !");
      modelAndView.setViewName("errorLogin");
      return modelAndView;
    }
  }

  @GetMapping("/home")
  public ModelAndView homePage(@CookieValue(value = "customerUsername", defaultValue = "false") String loginStatus) {
    if (loginStatus.equals("false")) {
      return new ModelAndView("logged-out");
    } else {
      ModelAndView modelAndView = new ModelAndView("logged-in");
      modelAndView.addObject("customerUsername", loginStatus);
      return modelAndView;
    }
  }
}
