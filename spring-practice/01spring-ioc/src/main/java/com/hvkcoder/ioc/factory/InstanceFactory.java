package com.hvkcoder.ioc.factory;

import com.hvkcoder.ioc.entity.User;

/**
 * @author h-vk
 * @date 2019-11-25
 * @since V1.0
 */
public class InstanceFactory {
  public User getUser() {
    return new User("赵六", 18, null);
  }
}
