package com.hvkcoder.concurrency.chapter1;

/**
 * TODO: 输出线程生命周期状态
 *
 * @author h-vk
 * @date 2019-11-13
 * @since V1.0
 */
public class GetThreadState {
  public static void main(String[] args) {
    ThreadState threadState = new ThreadState();
    Thread thread = new Thread(threadState);
    System.out.println("新建线程 =>" + thread.getState());
  }

  static class ThreadState implements Runnable {
    @Override
    public void run() {}
  }
}
