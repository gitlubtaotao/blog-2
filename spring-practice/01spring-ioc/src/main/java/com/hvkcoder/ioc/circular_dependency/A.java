package com.hvkcoder.ioc.circular_dependency;

/**
 * @author h-vk
 * @date 2019-11-27
 * @since V1.0
 */
public class A {
  private B b;

  public B getB() {
    return b;
  }

  public void setB(B b) {
    this.b = b;
  }
}
