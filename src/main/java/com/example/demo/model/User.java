package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import java.io.Serializable;
import java.util.function.Supplier;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable, Supplier<User> {
  @Id @GeneratedValue private Integer userId;
  private String name;
  private Integer age;

  public User(Integer userId, String name, Integer age) {
    this.userId = userId;
    this.name = name;
    this.age = age;
  }

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public User get() {
    return this;
  }
}
