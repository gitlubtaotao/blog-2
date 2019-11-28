package com.hvkcoder.ioc.circular_dependency;

/**
 * @author h-vk
 * @date 2019-11-27
 * @since V1.0
 */
public class B {
  private C c;

  public C getC() {
    return c;
  }

  public void setC(C c) {
    this.c = c;
  }
}
