package com.hvkcoder.ioc;

import com.hvkcoder.ioc.annotation.controller.UserController;
import com.hvkcoder.ioc.circular_dependency.A;
import com.hvkcoder.ioc.entity.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
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

  /**
   * TODO: Spring 中的循环依赖
   *
   * <p>单例中的引用对象也是单例的
   *
   * <p>Spring 单例模式的对象会直接实例化，prototype 作用域下会检查引用是否实例化，如果引用未实例化，则暂停该 Bean 的实例，去实例化引用对象
   */
  @Test
  public void testCircularDependency() {
    A a = context.getBean("a", A.class);
    System.out.println(ToStringBuilder.reflectionToString(a));
    System.out.println(ToStringBuilder.reflectionToString(a.getB()));
    System.out.println(ToStringBuilder.reflectionToString(a.getB().getC()));
  }

  /** TODO: 通过注解方式注入 */
  @Test
  public void testAnnotationDI() {
    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("annotationContext.xml");

    UserController userController =
        applicationContext.getBean("userController", UserController.class);

    userController.save();
  }
}
