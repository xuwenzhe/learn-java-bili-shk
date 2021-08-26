package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
创建线程的方式四：
开发中，一般都使用线程池的方式创建和管理线程

面试题：创建多线程有几种方式？四种！
 */

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+ " : " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        // 2. 执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 设置线程池的属性
        System.out.println(service.getClass()); // ThreadPoolExecutor
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;// 向下转型
//        service1.setCorePoolSize(15);// 线程池的管理

        service.execute(new NumberThread());//适用于Runnable
        service.execute(new NumberThread1());
//        service.submit(Callable callable);//适用于Callable
        // 3. 关闭线程池
        service.shutdown();
    }
}
