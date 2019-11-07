package com.hvkcoder.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author h-vk
 * @date 2019-10-29
 * @since V1.0
 */
public class ThreadDemo  {
	/**
	 * TODO: 通过继承 Thread 类，重写 run 方法，创建线程
	 */
	public class ExtendsThread extends Thread{
		@Override
		public void run() {
			System.out.println("ExtendsThread");
		}
	}

	/**
	 * TODO: 通过实现 Runnable 接口 并实现 run 方法，创建线程
	 */
	public class ImplementRunnable implements Runnable {
		public void run() {
			System.out.println("ImplementRunnable");
		}
	}

	/**
	 * 面试题： 说出启动线程的方式
	 * 1. Thread	2. Runnable		3. Executors.newCachedThreadPool
	 */
	@Test
	public void testRunThread() {
		// TODO: 实例 Thread 子类，调用 start 方法，启动线程
		new ExtendsThread().start();

		// TODO: 实例 Thread 对象，调用 start 方法，启动线程
		new Thread(new ImplementRunnable()).start();

		// TODO: 通过 Java8 Lambda 表达式创建并启动线程
		new Thread(() -> {
			System.out.println("Lambda 表达式创建与启动线程");
		}).start();

		// TODO: 通过 线程池创建
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("ExecutorService");
			}
		});
		executorService.shutdown();
	}
}
