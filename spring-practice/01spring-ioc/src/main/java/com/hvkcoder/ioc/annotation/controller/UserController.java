package com.hvkcoder.ioc.annotation.controller;

import com.hvkcoder.ioc.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author h-vk
 * @date 2019-11-29
 * @since V1.0
 */
@Controller("userController")
public class UserController {
  @Autowired private UserService userService;

  public void save() {
    userService.save();
    System.out.println("userController....save");
  }
}
