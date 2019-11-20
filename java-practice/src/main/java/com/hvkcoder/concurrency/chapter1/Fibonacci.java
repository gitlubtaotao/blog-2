package com.hvkcoder.concurrency.chapter1;

/**
 * TODO: Thinking in java 并发实现 Fibonacci 数列
 *
 * <p>0 1 1 2 3 5 8 13
 *
 * <p>Fibonacci 公式 F(0) = 0 F(1) = 1 F(2) = 1 F(n) = F(n-1) + F(n-2)
 *
 * @author h-vk
 * @date 2019-11-20
 * @since V1.0
 */
public class Fibonacci implements Runnable {
  private int index;

  private static int num1 = 0;
  private static int num2 = 1;
  private int result = 0;

  private Fibonacci(int n) {
    index = n;
  }

  @Override
  public void run() {
    if (index < 2) result = index;
    else {
      result = num1 + num2;
      num1 = num2;
      num2 = result;
    }
    System.out.println("F(" + index + ") = " + result);
  }

  public static void main(String[] args) {
    for (int i = 0; i < 8; i++) {
      new Thread(new Fibonacci(i)).start();
    }
  }
}
