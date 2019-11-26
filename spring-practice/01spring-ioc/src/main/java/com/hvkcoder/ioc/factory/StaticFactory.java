package com.hvkcoder.ioc.factory;

import com.hvkcoder.ioc.entity.User;

/**
 * @author h-vk
 * @date 2019-11-25
 * @since V1.0
 */
public class StaticFactory {

  public static User getUser() {
    return new User("王五", 18, null);
  }
}
