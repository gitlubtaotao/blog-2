package com.hvkcoder.ioc.annotation.dao.impl;

import com.hvkcoder.ioc.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author h-vk
 * @date 2019-11-29
 * @since V1.0
 */
// 写法等等同于 <bean id="userDao" class="com.hvkcoder.ioc.annotation.dao.impl.UserDaoImpl" />
@Repository("userDao")
public class UserDaoImpl implements UserDao {
  @Override
  public void save() {
    System.out.println("userDao.......save");
  }
}
