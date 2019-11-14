package com.hvkcoder.concurrency.chapter1;

/**
 * TODO: join 方法 当前线程等待指定线程结束后才能继续执行
 *
 * @author h-vk
 * @date 2019-11-13
 * @since V1.0
 */
public class MethodJoin {
  public static void main(String[] args) {
    String name = Thread.currentThread().getName();
    System.out.println(name + " start.");

    Runnable runnable =
        () -> {
          String threadName = Thread.currentThread().getName();
          System.out.println(threadName + " start.");

          for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " loop at " + i);
          }

          System.out.println(threadName + " end.");
        };

    Thread aThread = new Thread(runnable, "aThread");
    aThread.start();
    try {
      aThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(name + " end.");
  }
}
