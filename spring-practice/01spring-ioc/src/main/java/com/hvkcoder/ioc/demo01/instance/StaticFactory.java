package com.hvkcoder.ioc.demo01.instance;

import com.hvkcoder.ioc.demo01.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author h-vk
 * @date 2019-11-25
 * @since V1.0
 */
public class StaticFactoryInstance {
  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    User staticFactory = (User) applicationContext.getBean("staticFactory");
    staticFactory.sayHi();
  }
}
