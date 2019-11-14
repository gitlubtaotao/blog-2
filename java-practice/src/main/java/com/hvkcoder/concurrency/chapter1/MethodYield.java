package com.hvkcoder.concurrency.chapter1;

/**
 * TODO: Yield 方法 当前线程让出 CPU 资源，进入就绪队列等待调度，等待时间不确定
 *
 * @author h-vk
 * @date 2019-11-13
 * @since V1.0
 */
public class MethodYield {
  public static void main(String[] args) {
    TheThread thread1 = new TheThread("Thread1");
    TheThread thread2 = new TheThread("Thread2");

    thread1.start();
    thread2.start();
  }

  static class TheThread extends Thread {
    public TheThread(String name) {
      super(name);
    }

    @Override
    public void run() {
      String name = Thread.currentThread().getName();
      while (true) {
        Thread.yield();
        System.out.println("【" + name + "】：Hello World");
      }
    }
  }
}
