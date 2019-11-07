![Java](https://s2.ax1x.com/2019/10/29/KRNvw9.md.jpg)

> 线程是程序中执行的线程，在 Java 虚拟机 中允许一个程序有多个线程并发执行，并且每个线程都有优先级，优先级高的线程要优先于优先级低的线程执行。每个线程可能被标记为守护线程，也可能不被标记。当 Java 虚拟机 运行时，通常就会有一个非守护线程。

## 进程与线程

<font color="red">进程：就是受操作系统管理的基本运行单元。</font><br/>
<font color="red">线程：可以理解成是在进程中独立运行的子任务；而多线程则可以理解为是多个线程在同一时间内运行不同种类的任务。</font>

### 多线程优点

在单任务的环境下，必须等待上一个任务完成后，才会执行下一个任务，这样使  CPU  利用率大幅降低；而在多任务环境下，CPU  可以在任务之间来回切换，系统的运行效率大大提升。**多线程是异步的。**  如下图所示

![单任务环境与多任务环境](https://s2.ax1x.com/2019/10/29/KRf1PK.png)

## 创建并启动线程

- Thread：通过继承  `Thread`，重写  `run`  方法创建线程，调用  `start`  方法启动线程。

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

- Runnable：通过实现  Runnable  接口，实现  `run`  方法创建线程，调用  `start`  方法启动线程。

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

- Executors.newCachedThreadPool：通过线程池创建线程

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

-  通过  Java8 Lambda  表达式创建

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

## Thread 与 Runnable 的联系与区别

上面通过 4 种方式实现了线程，归根结底也就只是采用了，继承或实例化 `Thread` 类 和 实现 `Runnable` 接口。

`Thread` 类定义在 `java.lang` 包中，

## 线程常用的方法

## 线程的生命周期

> 线程的生命周期分为 new，runnable，running，block，terminated

## 总结

1. Java 应用程序的 main 函数是一个线程，是被 JVM 启动时调用，线程名称为 main；
2. 实现一个线程，必须创建 `Thread` 实例，重写 `run` 方法，并调用 `start` 方法；
