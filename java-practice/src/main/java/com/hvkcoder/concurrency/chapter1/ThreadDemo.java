package com.hvkcoder.concurrency.chapter1;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO: 创建并运行线程
 *
 * @author h-vk
 * @date 2019-11-13
 * @since V1.0
 */
public class ThreadDemo {

  public static void main(String[] args) {
    new ExtendThread().run();

    new Thread(new ImplementRunnable()).run();

    /** TODO: 通过 创建线程池 创建并运行线程 */
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(
        new Runnable() {
          @Override
          public void run() {
            System.out.println("ExecutorService");
          }
        });
    executorService.shutdown();

    /** TODO: 通过 Lambda 表达式创建并运行线程 */
    new Thread(
            () -> {
              System.out.println("Lambda 表达式创建并运行线程");
            })
        .run();
  }

  /** TODO: 通过继承 Thread 类，并重写 run 方法创建线程 */
  static class ExtendThread extends Thread {
    @Override
    public void run() {
      System.out.println("ExtendsThread");
    }
  }

  /** TODO: 通过实现 Runnable 接口，并重写 run 方法创建线程 */
  static class ImplementRunnable implements Runnable {
    @Override
    public void run() {
      System.out.println("ImplementRunnable");
    }
  }

  @Test
  public void testSay() {
    System.out.println("fdsa");
  }
}
