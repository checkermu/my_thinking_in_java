package com.gt.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author checkermu�� ����ʹ���̳߳ش����ĺô�
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
         * ��������1000���߳�
         */
        {
            // ��ȡ��ǰ��������ʱ����
            Runtime run = Runtime.getRuntime();
            // �����������ջ��ƣ��Լ����ڴ����
            run.gc();
            // ��ȡ��ǰJVM�Ŀ����ڴ�
            long freeMemory = run.freeMemory();
            // ϵͳ��ǰʱ��
            long timePro = System.currentTimeMillis();
            // ����������ִ��1000���߳�
            for (int i = 0; i < 1000; i++) {
                new Thread(new CompareThreadPool()).start();
            }
            System.out.println("����������ִ��1000���߳�����Ҫռ�õ��ڴ��С: "
                    + (freeMemory - run.freeMemory()));
            System.out.println("��������������1000���߳���Ҫ��ʱ��Ϊ: "
                    + (System.currentTimeMillis() - timePro));
        }
        /**
         * �����̳߳ش���1000���߳�
         */
        {
            // ��ȡ��ǰ��������ʱ����
            Runtime run = Runtime.getRuntime();
            // �����������ջ��ƣ��Լ����ڴ����
            run.gc();
            // ��ȡ��ǰJVM�Ŀ����ڴ�
            long freeMemory = run.freeMemory();
            // ϵͳ��ǰʱ��
            long timePro = System.currentTimeMillis();
            ExecutorService service = Executors.newFixedThreadPool(2);
            // �̳߳ش�����ִ��1000���߳�
            for (int i = 0; i < 1000; i++) {
                service.submit(new CompareThreadPool());
            }

            System.out.println("ʹ���̳߳ش���1000���߳�����Ҫռ�õ��ڴ��С: "
                    + (freeMemory - run.freeMemory()));
            // �̳߳�ʹ����ɣ��ر��̳߳�
            service.shutdown();
            System.out.println("ʹ���̳߳ش���������1000���߳���Ҫ��ʱ��Ϊ: "
                    + (System.currentTimeMillis() - timePro));

        }

    }


}
