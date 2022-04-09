package com.example.demo.controller;

import com.example.demo.dto.CustomerAuthDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
  @Autowired CustomerService customerService;

  @GetMapping("/login")
  public ModelAndView loginCustomer(@RequestBody CustomerAuthDTO customerInfo) {
    if (customerService.validateLogin(customerInfo)) {
      ModelAndView modelAndView = new ModelAndView("login");
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
}
