package com.hvkcoder.ioc.circular_dependency;

/**
 * @author h-vk
 * @date 2019-11-27
 * @since V1.0
 */
public class C {
  private A a;

  public A getA() {
    return a;
  }

  public void setA(A a) {
    this.a = a;
  }
}
