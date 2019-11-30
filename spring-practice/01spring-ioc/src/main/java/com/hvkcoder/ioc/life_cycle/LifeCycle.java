package com.hvkcoder.ioc.life_cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * TODO: Spring 容器中 Bean 的生命周期
 *
 * @author h-vk
 * @date 2019-11-30
 * @since V1.0
 */
public class LifeCycle
    implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        BeanPostProcessor,
        InitializingBean {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("2.=======> 通过 依赖注入 设置 Bean 的属性值.");
    this.name = name;
  }

  public LifeCycle() {
    System.out.println("1.=======> 根据配置文件实例化Bean.");
  }

  @Override
  public void setBeanName(String name) {
    System.out.println(
        "3.=======> 如果 Bean 实现了 BeanNameAware 接口，则 Spring 调用 setBeanName，并传入当前 Bean 的 id 或 name 值."
            + name);
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    System.out.println(
        "4.=======> 如果 Bean 实现了 BeanFactoryAware 接口，则 Spring 调用 setBeanFactory，并传入当前工厂实例引用."
            + beanFactory);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println(
        "5.=======> 如果 Bean 实现了 ApplicationContextAware 接口，则 Spring 调用 setApplicationContext，并传入当前 ApplicationContext 实例引用."
            + applicationContext);
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println(
        "6.=======> 如果 Bean 实现了 BeanPostProcessor 接口，则 Spring 调用 postProcessBeforeInitialization, 对 Bean 进行加工，AOP 就是通过这个接口类实现的.");
    return null;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println(
        "5.=======> 如果 Bean 实现了 InitializingBean 接口，则 Spring 调用 afterPropertiesSet.");
  }
}
