package com.hvkcoder.ioc.entity;

import lombok.Data;

import java.util.List;

/**
 * @author h-vk
 * @date 2019-11-22
 * @since V1.0
 */
@Data
public class User {
  private String username;
  private int age;
  private Address address;
  private List<String> favoriteSinger;

  public User() {}

  public User(String username, int age, Address address) {
    this.username = username;
    this.age = age;
    this.address = address;
  }

  public void sayHi() {
    System.out.println("Hi! My name's " + username + " . I'm " + age + " years old.");
  }
}
