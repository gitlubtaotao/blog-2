![Java](https://s2.ax1x.com/2019/10/29/KRNvw9.md.jpg)

> 在 JVM 中允许一个程序有多个线程并发执行，并且每个线程都有优先级，优先级高的线程要优先于优先级低的线程执行。每个线程可能被标记为守护线程，也可能不被标记。当 JVM 运行时，通常就会有一个非守护线程。

## 进程与线程

<font color="red">进程：就是受操作系统管理的基本运行单元。进程之间的内存是不共享的，进程之间使用 socket 通信。</font><br/>
<font color="red">线程：可以理解成是在进程中独立运行的子任务；而多线程则可以理解为是多个线程在同一时间内运行不同种类的任务。线程间的内存是共享，每个运行的线程都对应一个栈（stack）。</font>

### 多线程优点

> 在单任务的环境下，必须等待上一个任务完成后，才会执行下一个任务，这样使 CPU 利用率大幅度降低；而在多任务环境下，CPU 可以在任务之间来回切换，系统的运行效率大大提升。**多线程是异步的。** 如下图所示

![单任务环境与多任务环境](https://s2.ax1x.com/2019/10/29/KRf1PK.png)

## 创建并启动线程

- Thread：通过继承  `Thread`，重写  `run`  方法创建线程，调用  `start`  方法启动线程。

<br/>

```java
public class ExtendsThread extends Thread {
  @Override
  public void run() {
    System.out.println("ExtendsThread");
  }

  public static void main(String[] args) {
    new ExtendsThread().start(); // ExtendsThread
  }
}
```

- Runnable：通过实现  Runnable  接口，实现  `run`  方法创建线程，调用  `start`  方法启动线程。

<br/>

```java
public class ImplementRunnable implements Runnable {
  public void run() {
    System.out.println("ImplementRunnable");
  }

  public static void main(String[] args) {
    new Thread(new ImplementRunnable).start(); // ImplementRunnable
  }
}
```

- Executors.newCachedThreadPool：通过线程池创建线程

<br/>

```java
public class ExecutorsThreadPool {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();

    executorService.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("ExecutorService"); // ExecutorService
      }
    });

    executorService.shutdown();
  }
}
```

- 通过  Java8 Lambda  表达式创建

<br/>

```java
public class LambdaThread {
  public static void main(String[] args) {
    new Thread(() -> {
      System.out.println("LambdaThread"); // LambdaThread
    }).start();
  }
}
```

## 线程中常用的方法

- isAlive()：表示线程是否还未终止；
- Thread.sleep()：设置当前线程睡眠指定毫秒数；
- Thread.yield()：当前线程让出 CPU 资源，进入就绪队列等待调度，但是等待时间不确定；
- Thread.join()：当前线程等待指定线程结束后才能继续执行；

<br/>

```java
public static void main(String[] args) {
	String name = Thread.currentThread().getName();
	System.out.println(name + " start.");

	Runnable runnable = () -> {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");

		for(int i = 0; i < 5; i++) {
			System.out.println(threadName + " loop at "+ i);
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
```

output

```
main start.
aThread start.
aThread loop at 0
aThread loop at 1
aThread loop at 2
aThread loop at 3
aThread loop at 4
aThread end.
main end.
```

## 线程的状态

> 当线程被创建并启动后，它要经过 新建（New）、运行（Runnable）、阻塞（Blocked）、等待（Waiting）、超时等待（Timed_Waiting）、终止（Terminate）6 种状态，这 6 中状态定义在 Thread.State 中。
