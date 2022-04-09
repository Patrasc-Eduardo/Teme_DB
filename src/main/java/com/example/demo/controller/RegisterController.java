package com.example.demo.controller;

import com.example.demo.dto.CustomerAuthDTO;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {
  @Autowired
  CustomerService customerService;

  @PutMapping("/register")
  public ModelAndView registerCustomer(@RequestBody Customer customerInfo) {
    if (!customerService.exists(customerInfo.getUsername())) {
      customerService.createCustomer(customerInfo);
      // aici se putea folosi customerAuthDTO in functie de context.
      // Totusi, m-am gandit ca in acest caz este util sa nu stocam doar
      // username,email,parola pt un user, dar si country, city .....
      ModelAndView modelAndView = new ModelAndView("registration");
      modelAndView.addObject("customerName", customerInfo.getUsername());
      modelAndView.addObject("successMessage", " was registered successfully !");
      modelAndView.setViewName("registration");
      return modelAndView;
    } else {
      ModelAndView modelAndView = new ModelAndView("errorRegistration");
      modelAndView.addObject("errorMessage", "username already exists !");
      modelAndView.setViewName("errorRegistration");
      return modelAndView;
    }
  }
}
