package com.gt.threads;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author checkermu
 * ��ͬ�̳߳ص�����
 */
public class CreateTPoolsMore extends Thread {

    @Override
    public void run() {
        System.out.println("ϵͳʱ�� �� " + System.currentTimeMillis() + " �̣߳� "
                + Thread.currentThread().getName() + "����ִ�У���");

    }

    /**
     * ����һ�����̵߳��̳߳�
     * 
     * @return
     */
    public ExecutorService SingleThreadPool() {
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        return singlePool;
    }

    /**
     * ����һ����С�̶����̳߳�
     * 
     * @return
     */
    public ExecutorService FixedThreadPool() {
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        return fixedPool;
    }

    /**
     * ����һ���ɻ����̳߳�
     * 
     * @return
     */
    public ExecutorService CachedThreadPool() {
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        return cachedPool;
    }

    /**
     * �������õ��̷߳����̳߳أ���ִ��
     * 
     * @param pool
     */
    public void service(ExecutorService pool) {
        // �����߳�
        Thread thread1 = new CreateTPoolsMore();
        Thread thread2 = new CreateTPoolsMore();
        Thread thread3 = new CreateTPoolsMore();
        Thread thread4 = new CreateTPoolsMore();
        Thread thread5 = new CreateTPoolsMore();
        // �߳����̳߳أ���ִ��
        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);
        pool.execute(thread5);
        // �ر��̳߳�
        pool.shutdown();
    }

    /**
     * ����һ����С�����Ƶ��̳߳أ������붨ʱ�������Է���
     */
    public void scheduledThreadPool() {
        ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(1);

        scheduledPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("=======" + System.currentTimeMillis()
                        + "=========");
            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        scheduledPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println(System.nanoTime());

            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);

    }

    public static void main(String[] args) {
        CreateTPoolsMore creatThreadPool = new CreateTPoolsMore();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("��ѡ�񴴽��̳߳أ�1.���߳��̳߳أ�2.�ɻ����̳߳أ�3.�̶���С�̳߳أ�4�ɶ�ʱ������ִ���̳߳�");
            int i = sc.nextInt();

            switch (i) {
            case 1:
                System.out.println("-----���õ��̵߳��̳߳�-----");
                // ���õ��̵߳��̳߳�
                creatThreadPool.service(creatThreadPool.SingleThreadPool());
                break;
            case 2:
                System.out.println("-----���ÿɻ����̵߳��̳߳�-----");
                // ���ÿɻ����̵߳��̳߳�
                creatThreadPool.service(creatThreadPool.CachedThreadPool());
                break;
            case 3:
                System.out.println("-----���ù̶���С�̵߳��̳߳�-----");
                // ���ù̶���С�̵߳��̳߳�
                creatThreadPool.service(creatThreadPool.FixedThreadPool());
                break;
            case 4:
                System.out.println("-----���ô�С�����ƿɶ�ʱ��������ִ�е��̳߳�-----");
                // ���ù̶���С�̵߳��̳߳�
                creatThreadPool.scheduledThreadPool();
                break;
            }
        }
    }

}
