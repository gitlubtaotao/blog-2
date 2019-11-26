package com.hvkcoder.ioc;

import com.hvkcoder.ioc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author h-vk
 * @date 2019-11-25
 * @since V1.0
 */
public class Main {

  // TODO: 初始化 Spring 容器，并获取 Bean 配置
  private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

  /** TODO: 使用构造函数的方式获取 Bean */
  @Test
  public void testConstructor() {
    User user = context.getBean("user", User.class);
    user.sayHi();
    System.out.println(user.getAddress());
    System.out.println(user.getFavoriteSinger());
  }

  /** TODO: 使用工厂实例化获取 Bean */
  @Test
  public void testInstanceFactory() {
    User user = context.getBean("instanceFactory-user", User.class);
    user.sayHi();
  }

  /** TODO: 使用静态工厂实例获取 Bean */
  @Test
  public void testStaticFactory() {
    User user = context.getBean("staticFactory", User.class);
    user.sayHi();
  }

  /** TODO: Bean singleton 作用域 */
  @Test
  public void testScopeSingleton() {
    System.out.println(context.getBean("user") == context.getBean("user"));
  }

  /** TODO: Bean prototype 作用域 */
  @Test
  public void testScopePrototype() {
    System.out.println(context.getBean("user-prototype") == context.getBean("user-prototype"));
  }
}
