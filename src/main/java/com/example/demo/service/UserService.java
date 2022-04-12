package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
  @Autowired private UserRepository userRepository;

  public User createRandomUser() {
    Faker faker = new Faker(); // random name generator
    String randName = faker.name().fullName();

    Random r = new Random();
    Integer randAge = r.nextInt(101);

    User newUser = new User(randName, randAge);

    userRepository.save(newUser);
    return newUser;
  }

  public User createCustomUser(User user) {
    userRepository.save(user);
    return user;
  }

  public Stream<User> generateUserStream() {
    Faker faker = new Faker(); // random name generator
    Random r = new Random();
    return Stream.of(
        new User(faker.name().fullName(), r.nextInt(101)),
        new User(faker.name().fullName(), r.nextInt(101)),
        new User(faker.name().fullName(), r.nextInt(101)));
  }

  public ArrayList<User> filterByAgeStream(ArrayList<User> users) {
    return (ArrayList<User>)
        users.stream().filter(user -> user.getAge() >= 18).collect(Collectors.toList());
  }

  public ArrayList<User> mapAge(ArrayList<User> users) {
    users.stream().forEach(user -> user.setAge(user.getAge() * 2));
    return users;
  }

  public Optional<User> printLast(ArrayList<User> users) {
    return users.stream().reduce((first, second) -> second);
  }

  public User findMinAge(ArrayList<User> users) {
    return users.stream()
        .min(Comparator.comparing(User::getAge))
        .orElseThrow(NoSuchElementException::new);
  }

  public User findMaxAge(ArrayList<User> users) {
    return users.stream()
        .max(Comparator.comparing(User::getAge))
        .orElseThrow(NoSuchElementException::new);
  }

  public ArrayList<User> eliminateDuplicates(ArrayList<User> users) {
    return (ArrayList<User>) users.stream().distinct().collect(Collectors.toList());
  }

  public ArrayList<User> filterMapSort(ArrayList<User> users) {
    users.stream()
        .filter(user -> user.getAge() >= 30)
        .sorted((u1, u2) -> u1.getAge() - u2.getAge())
        .forEach(user -> user.setName(user.getName().toUpperCase()));
    return users;
  }
}
