package com.gt.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author checkermu； 看看使用线程池带来的好处
 *
 */
public class CompareThreadPool implements Runnable{

	private int id = 0;

    @Override
    public void run() {
        id++;

    }

    public static void main(String[] args) {
        /**
         * 独立创建1000个线程
         */
        {
            // 获取当前程序运行时对象
            Runtime run = Runtime.getRuntime();
            // 调用垃圾回收机制，以减少内存误差
            run.gc();
            // 获取当前JVM的空闲内存
            long freeMemory = run.freeMemory();
            // 系统当前时间
            long timePro = System.currentTimeMillis();
            // 独立创建并执行1000个线程
            for (int i = 0; i < 1000; i++) {
                new Thread(new CompareThreadPool()).start();
            }
            System.out.println("独立创建并执行1000个线程所需要占用的内存大小: "
                    + (freeMemory - run.freeMemory()));
            System.out.println("独立创建并运行1000个线程需要的时间为: "
                    + (System.currentTimeMillis() - timePro));
        }
        /**
         * 利用线程池创建1000个线程
         */
        {
            // 获取当前程序运行时对象
            Runtime run = Runtime.getRuntime();
            // 调用垃圾回收机制，以减少内存误差
            run.gc();
            // 获取当前JVM的空闲内存
            long freeMemory = run.freeMemory();
            // 系统当前时间
            long timePro = System.currentTimeMillis();
            ExecutorService service = Executors.newFixedThreadPool(2);
            // 线程池创建并执行1000个线程
            for (int i = 0; i < 1000; i++) {
                service.submit(new CompareThreadPool());
            }

            System.out.println("使用线程池创建1000个线程所需要占用的内存大小: "
                    + (freeMemory - run.freeMemory()));
            // 线程池使用完成，关闭线程池
            service.shutdown();
            System.out.println("使用线程池创建并运行1000个线程需要的时间为: "
                    + (System.currentTimeMillis() - timePro));

        }

    }


}
