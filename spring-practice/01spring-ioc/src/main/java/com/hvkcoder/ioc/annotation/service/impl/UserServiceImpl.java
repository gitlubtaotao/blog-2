package com.hvkcoder.ioc.annotation.service.impl;

import com.hvkcoder.ioc.annotation.dao.UserDao;
import com.hvkcoder.ioc.annotation.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author h-vk
 * @date 2019-11-29
 * @since V1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

  /**
   * @Resource 通过 name 指定 Bean 实例名装配
   *
   * <p>相当于配置文件中 <property name="userDao" ref="userDao" />
   */
  @Resource(name = "userDao")
  private UserDao userDao;

  @Override
  public void save() {
    userDao.save();
    System.out.println("userService......save");
  }
}
