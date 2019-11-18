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

## 线程的状态

> 当线程被创建并启动后，它要经过 新建（NEW）、运行（RUNNABLE）、阻塞（BLOCKED）、等待（WAITING）、超时等待（TIMED_WAITING）、终止（TERMINATED）6 种状态，这 6 中状态定义在 Thread.State 中。

![线程状态图](https://s2.ax1x.com/2019/11/18/M6wADx.png)

#### 新建状态(NEW)

实现 Runnable 接口和继承 Thread 类可以得到一个线程类，通过 new 关键字实例化，但是没有调用 start()方法。

#### 运行状态(RUNNABLE)

Java 中将 就绪状态(READY) 和 运行中状态(RUNNING) 统称为运行状态(RUNNABLE)。当线程对象被创建并调用 start() 方法，此时该线程进入就绪状态(READY)，等待线程调度器执行。

就绪状态(READY) 还可通过以下方式进入：

- 调用当前线程的 yield() 方法，当前线程被挂起；
- 当前线程 sleep() 方法结束、其他线程 join() 方法结束、等待用户输入完毕、某个线程拿到对象锁；
- 当线程时间片用完；

当线程调度器从可运行池中选择一个线程作为当前执行线程时，该线程进入运行中状态(RUNNING)。这也是线程进入运行中状态(RUNNING)的唯一方式。

#### 阻塞状态(BLOCKED)

当前线程在进入 synchronized 关键字修饰的方法或代码(获取锁)时的状态。

#### 等待状态(WAITING)

处于这种状态的线程不会被分配 CPU 执行时间，它们要等待被显式地唤醒，否则会处于无限等待的状态。

#### 超时等待(TIMED_WAITING)

处于这种状态的线程会到达一定事件后被自动唤醒。

#### 终止(TERMINATE)

当线程程序执行完成，该线程将会终止，**在一个终止的线程上调用 start()方法，会抛出 java.lang.IllegalThreadStateException 异常**。
