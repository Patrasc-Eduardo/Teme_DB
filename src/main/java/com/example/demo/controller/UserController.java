package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
public class UserController {
  @Autowired UserService userService;

  @PutMapping("/create-rand-user")
  public User createRandomUser() {
    return userService.createRandomUser();
  }

  @PutMapping("/create-cost-user")
  public User createCustomUser(@RequestBody User user) {
    return userService.createCustomUser(user);
  }

  @GetMapping("/create-stream")
  public Stream<User> generateUserStream() {
    return userService.generateUserStream();
  }

  @GetMapping("/filter-age")
  public ArrayList<User> filtrateUserByAge(@RequestBody ArrayList<User> users) {
    return userService.filterByAgeStream(users);
  }

  @GetMapping("/double-age")
  public ArrayList<User> doubleUserAge(@RequestBody ArrayList<User> users) {
    return userService.mapAge(users);
  }

  @GetMapping("/print-last")
  public Optional<User> printLast(@RequestBody ArrayList<User> users) {
    return userService.printLast(users);
  }

  @GetMapping("/find-min-age")
  public User findMinAge(@RequestBody ArrayList<User> users) {
    return userService.findMinAge(users);
  }

  @GetMapping("/find-max-age")
  public User findMaxAge(@RequestBody ArrayList<User> users) {
    return userService.findMaxAge(users);
  }

  @GetMapping("/elim-dupl")
  public ArrayList<User> elimDupl(@RequestBody ArrayList<User> users) {
    return userService.eliminateDuplicates(users);
  }

  @GetMapping("/filt-map-sort")
  public ArrayList<User> filterMapSort(@RequestBody ArrayList<User> users) {
    return userService.filterMapSort(users);
  }
}
