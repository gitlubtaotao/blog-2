<section class="layout" style="padding: 10px; line-height: 1.6; word-spacing: 0px; word-wrap: break-word; font-family: Optima-Regular, Optima, PingFangSC-light, PingFangTC-light, 'PingFang SC', Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-size: 15px; letter-spacing: 0.05em; color: #333;"><p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;"><img src="https://s2.ax1x.com/2019/10/29/KRNvw9.md.jpg" alt="Java" style="display: block; margin: 0 auto; width: 100%;"></p>
<blockquote style="display: block; font-size: 0.9em; overflow: auto; overflow-scrolling: touch; padding-top: 10px; padding-bottom: 10px; padding-left: 20px; padding-right: 10px; margin-bottom: 20px; margin-top: 20px; margin: 10px 5px; border-left: 3px solid #35b378; border-right: 0px solid #35b378; color: #616161; quotes: none; background: #FBF9FD;">
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; margin: 0px; color: #333; line-height: 26px;">在 JVM 中允许一个程序有多个线程并发执行，并且每个线程都有优先级，优先级高的线程要优先于优先级低的线程执行。每个线程可能被标记为守护线程，也可能不被标记。当 JVM 运行时，通常就会有一个非守护线程。</p>
</blockquote>
<h2 id="进程与线程" style="margin-top: 40px; margin-bottom: 20px; bmin-height: 32px; line-height: 32px; border-bottom: solid 1px #000000; color: #35b378; display: inline-block; border-bottom-width: 0px; border-bottom-style: solid; border-color: #35b378; padding-top: 5px; padding-right: 0.5em; padding-left: 0.5em; font-size: 23px; margin: 1em 0 0rem 0; padding: 0.5em 0; text-align: leftt; font-weight: bold;">进程与线程</h2>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;"><font color="red">进程：就是受操作系统管理的基本运行单元。进程之间的内存是不共享的，进程之间使用 socket 通信。</font><br>
<font color="red">线程：可以理解成是在进程中独立运行的子任务；而多线程则可以理解为是多个线程在同一时间内运行不同种类的任务。线程间的内存是共享，每个运行的线程都对应一个栈（stack）。</font></p>
<h3 id="多线程优点" style="margin-top: 40px; margin-bottom: 20px; font-size: 18px; margin: 1.2em 0 1em; padding: 0; font-weight: bold; color: #35b378;">多线程优点</h3>
<blockquote style="display: block; font-size: 0.9em; overflow: auto; overflow-scrolling: touch; padding-top: 10px; padding-bottom: 10px; padding-left: 20px; padding-right: 10px; margin-bottom: 20px; margin-top: 20px; margin: 10px 5px; border-left: 3px solid #35b378; border-right: 0px solid #35b378; color: #616161; quotes: none; background: #FBF9FD;">
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; margin: 0px; color: #333; line-height: 26px;">在单任务的环境下，必须等待上一个任务完成后，才会执行下一个任务，这样使 CPU 利用率大幅度降低；而在多任务环境下，CPU 可以在任务之间来回切换，系统的运行效率大大提升。<strong style="font-weight: bold; color: #35b378;">多线程是异步的。</strong> 如下图所示</p>
</blockquote>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;"><img src="https://s2.ax1x.com/2019/10/29/KRf1PK.png" alt="单任务环境与多任务环境" style="display: block; margin: 0 auto; width: 100%;"></p>
<h2 id="创建并启动线程" style="margin-top: 40px; margin-bottom: 20px; bmin-height: 32px; line-height: 32px; border-bottom: solid 1px #000000; color: #35b378; display: inline-block; border-bottom-width: 0px; border-bottom-style: solid; border-color: #35b378; padding-top: 5px; padding-right: 0.5em; padding-left: 0.5em; font-size: 23px; margin: 1em 0 0rem 0; padding: 0.5em 0; text-align: leftt; font-weight: bold;">创建并启动线程</h2>
<ul style="margin-top: 5px; margin-bottom: 5px; padding-left: 20px; color: #333; font-size: 14px; list-style-type: disc;">
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">Thread：通过继承  <code style="font-size: 14px; word-wrap: break-word; padding: 2px 4px; border-radius: 4px; margin: 0 2px; background-color: rgba(27,31,35,.05); font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; word-break: break-all; color: #35b378;">Thread</code>，重写  <code style="font-size: 14px; word-wrap: break-word; padding: 2px 4px; border-radius: 4px; margin: 0 2px; background-color: rgba(27,31,35,.05); font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; word-break: break-all; color: #35b378;">run</code>  方法创建线程，调用  <code style="font-size: 14px; word-wrap: break-word; padding: 2px 4px; border-radius: 4px; margin: 0 2px; background-color: rgba(27,31,35,.05); font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; word-break: break-all; color: #35b378;">start</code>  方法启动线程。</li>
</ul>
<br>

<pre style="overflow-x: scroll; border: 2px solid #eee;"><code class="language-java" style="font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; border-radius: 0px; font-size: 12px; padding: 2px; display: -webkit-box;">public <span class="hljs-class" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">class</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">ExtendsThread</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">extends</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">Thread</span> </span>{
  <span class="hljs-meta" style="line-height: 26px; color: #643820;">@Override</span>
  public void run() {
    <span class="hljs-type" style="line-height: 26px; color: #5c2699;">System</span>.out.println(<span class="hljs-string" style="line-height: 26px; color: #c41a16;">"ExtendsThread"</span>);
  }

  public static void main(<span class="hljs-type" style="line-height: 26px; color: #5c2699;">String</span>[] args) {
    <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">new</span> <span class="hljs-type" style="line-height: 26px; color: #5c2699;">ExtendsThread</span>().start(); <span class="hljs-comment" style="line-height: 26px; color: #007400;">// ExtendsThread</span>
  }
}</code></pre>
<ul style="margin-top: 5px; margin-bottom: 5px; padding-left: 20px; color: #333; font-size: 14px; list-style-type: disc;">
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">Runnable：通过实现  Runnable  接口，实现  <code style="font-size: 14px; word-wrap: break-word; padding: 2px 4px; border-radius: 4px; margin: 0 2px; background-color: rgba(27,31,35,.05); font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; word-break: break-all; color: #35b378;">run</code>  方法创建线程，调用  <code style="font-size: 14px; word-wrap: break-word; padding: 2px 4px; border-radius: 4px; margin: 0 2px; background-color: rgba(27,31,35,.05); font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; word-break: break-all; color: #35b378;">start</code>  方法启动线程。</li>
</ul>
<br>

<pre style="overflow-x: scroll; border: 2px solid #eee;"><code class="language-java" style="font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; border-radius: 0px; font-size: 12px; padding: 2px; display: -webkit-box;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-class" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">class</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">ImplementRunnable</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">implements</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">Runnable</span> {</span>
  <span class="hljs-function" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">void</span> <span class="hljs-title" style="line-height: 26px; color: #1c00cf;">run</span><span class="hljs-params" style="line-height: 26px; color: #5c2699;">()</span> </span>{
    System.out.<span class="hljs-built_in" style="line-height: 26px; color: #5c2699;">println</span>(<span class="hljs-string" style="line-height: 26px; color: #c41a16;">"ImplementRunnable"</span>);
  }

  <span class="hljs-function" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">static</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">void</span> <span class="hljs-title" style="line-height: 26px; color: #1c00cf;">main</span><span class="hljs-params" style="line-height: 26px; color: #5c2699;">(<span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">String</span>[] args)</span> </span>{
    <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">new</span> Thread(<span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">new</span> ImplementRunnable).start(); <span class="hljs-comment" style="line-height: 26px; color: #007400;">// ImplementRunnable</span>
  }
}</code></pre>
<ul style="margin-top: 5px; margin-bottom: 5px; padding-left: 20px; color: #333; font-size: 14px; list-style-type: disc;">
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">Executors.newCachedThreadPool：通过线程池创建线程</li>
</ul>
<br>

<pre style="overflow-x: scroll; border: 2px solid #eee;"><code class="language-java" style="font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; border-radius: 0px; font-size: 12px; padding: 2px; display: -webkit-box;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-class" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">class</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">ExecutorsThreadPool</span> {</span>
  <span class="hljs-function" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">static</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">void</span> <span class="hljs-title" style="line-height: 26px; color: #1c00cf;">main</span><span class="hljs-params" style="line-height: 26px; color: #5c2699;">(<span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">String</span>[] args)</span> </span>{
    ExecutorService executorService = Executors.newCachedThreadPool();

    executorService.execute(<span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">new</span> Runnable() {
      @Override
      <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">void</span> <span class="hljs-built_in" style="line-height: 26px; color: #5c2699;">run</span>() {
        System.out.<span class="hljs-built_in" style="line-height: 26px; color: #5c2699;">println</span>(<span class="hljs-string" style="line-height: 26px; color: #c41a16;">"ExecutorService"</span>); <span class="hljs-comment" style="line-height: 26px; color: #007400;">// ExecutorService</span>
      }
    });

    executorService.<span class="hljs-built_in" style="line-height: 26px; color: #5c2699;">shutdown</span>();
  }
}</code></pre>
<ul style="margin-top: 5px; margin-bottom: 5px; padding-left: 20px; color: #333; font-size: 14px; list-style-type: disc;">
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">通过  Java8 Lambda  表达式创建</li>
</ul>
<br>

<pre style="overflow-x: scroll; border: 2px solid #eee;"><code class="language-java" style="font-family: Operator Mono, Consolas, Monaco, Menlo, monospace; border-radius: 0px; font-size: 12px; padding: 2px; display: -webkit-box;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-class" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">class</span> <span class="hljs-title" style="line-height: 26px; color: #5c2699;">LambdaThread</span> {</span>
  <span class="hljs-function" style="line-height: 26px;"><span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">public</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">static</span> <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">void</span> <span class="hljs-title" style="line-height: 26px; color: #1c00cf;">main</span><span class="hljs-params" style="line-height: 26px; color: #5c2699;">(<span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">String</span>[] args)</span> </span>{
    <span class="hljs-keyword" style="line-height: 26px; color: #aa0d91;">new</span> Thread(() -&gt; {
      System.out.<span class="hljs-built_in" style="line-height: 26px; color: #5c2699;">println</span>(<span class="hljs-string" style="line-height: 26px; color: #c41a16;">"LambdaThread"</span>); <span class="hljs-comment" style="line-height: 26px; color: #007400;">// LambdaThread</span>
    }).start();
  }
}</code></pre>
<h2 id="线程的状态" style="margin-top: 40px; margin-bottom: 20px; bmin-height: 32px; line-height: 32px; border-bottom: solid 1px #000000; color: #35b378; display: inline-block; border-bottom-width: 0px; border-bottom-style: solid; border-color: #35b378; padding-top: 5px; padding-right: 0.5em; padding-left: 0.5em; font-size: 23px; margin: 1em 0 0rem 0; padding: 0.5em 0; text-align: leftt; font-weight: bold;">线程的状态</h2>
<blockquote style="display: block; font-size: 0.9em; overflow: auto; overflow-scrolling: touch; padding-top: 10px; padding-bottom: 10px; padding-left: 20px; padding-right: 10px; margin-bottom: 20px; margin-top: 20px; margin: 10px 5px; border-left: 3px solid #35b378; border-right: 0px solid #35b378; color: #616161; quotes: none; background: #FBF9FD;">
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; margin: 0px; color: #333; line-height: 26px;">当线程被创建并启动后，它要经过 新建（NEW）、运行（RUNNABLE）、阻塞（BLOCKED）、等待（WAITING）、超时等待（TIMED_WAITING）、终止（TERMINATED）6 种状态，这 6 中状态定义在 Thread.State 中。</p>
</blockquote>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;"><img src="https://s2.ax1x.com/2019/11/18/M6wADx.png" alt="线程状态图" style="display: block; margin: 0 auto; width: 100%;"></p>
<h4 id="新建状态new" style="margin-top: 40px; margin-bottom: 20px; font-weight: bold; color: #333; font-size: 16px;">新建状态(NEW)</h4>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">实现 Runnable 接口和继承 Thread 类可以得到一个线程类，通过 new 关键字实例化，但是没有调用 start()方法。</p>
<h4 id="运行状态runnable" style="margin-top: 40px; margin-bottom: 20px; font-weight: bold; color: #333; font-size: 16px;">运行状态(RUNNABLE)</h4>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">Java 中将 就绪状态(READY) 和 运行中状态(RUNNING) 统称为运行状态(RUNNABLE)。当线程对象被创建并调用 start() 方法，此时该线程进入就绪状态(READY)，等待线程调度器执行。</p>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">就绪状态(READY) 还可通过以下方式进入：</p>
<ul style="margin-top: 5px; margin-bottom: 5px; padding-left: 20px; color: #333; font-size: 14px; list-style-type: disc;">
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">调用当前线程的 yield() 方法，当前线程被挂起；</li>
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">当前线程 sleep() 方法结束、其他线程 join() 方法结束、等待用户输入完毕、某个线程拿到对象锁；</li>
<li style="margin-top: 5px; margin-bottom: 5px; line-height: 26px; text-align: left; color: #333; font-size: 14px; margin: 10px;">当线程时间片用完；</li>
</ul>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">当线程调度器从可运行池中选择一个线程作为当前执行线程时，该线程进入运行中状态(RUNNING)。这也是线程进入运行中状态(RUNNING)的唯一方式。</p>
<h4 id="阻塞状态blocked" style="margin-top: 40px; margin-bottom: 20px; font-weight: bold; color: #333; font-size: 16px;">阻塞状态(BLOCKED)</h4>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">当前线程在进入 synchronized 关键字修饰的方法或代码(获取锁)时的状态。</p>
<h4 id="等待状态waiting" style="margin-top: 40px; margin-bottom: 20px; font-weight: bold; color: #333; font-size: 16px;">等待状态(WAITING)</h4>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">处于这种状态的线程不会被分配 CPU 执行时间，它们要等待被显式地唤醒，否则会处于无限等待的状态。</p>
<h4 id="超时等待timed_waiting" style="margin-top: 40px; margin-bottom: 20px; font-weight: bold; color: #333; font-size: 16px;">超时等待(TIMED_WAITING)</h4>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">处于这种状态的线程会到达一定事件后被自动唤醒。</p>
<h4 id="终止terminate" style="margin-top: 40px; margin-bottom: 20px; font-weight: bold; color: #333; font-size: 16px;">终止(TERMINATE)</h4>
<p style="font-size: 14px; padding-top: 5px; padding-bottom: 5px; line-height: 26px; color: #333; margin: 1em 4px;">当线程程序执行完成，该线程将会终止，<strong style="font-weight: bold; color: #35b378;">在一个终止的线程上调用 start()方法，会抛出 java.lang.IllegalThreadStateException 异常</strong>。</p>
</section>