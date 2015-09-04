package com.gt.threads;

/**
 * �����½�������
 * @author checkermu
 * 
 * ������ͬһ�� Runnable 
 * ��ͬ�̣߳����û��ͬ���飬��Ȼ�Ƕ��߳��������������ͬһ��Runnable��ֻҪ���˶������Ϳ���ͬ��
 * 
 * ����Ҫ�Ƕ���������������������Runnable����Ļ� ��Ȼ�����������
 *
 */
public class TestMultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " �߳����п�ʼ!"); 
		Multi m = new Multi();
		Multi m2 = new Multi();
		Thread t1 = new Thread(m, "A");
		Thread t2 = new Thread(m2, "B");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName() + " �߳����н���!"); 
	}

}
class Multi implements Runnable{

	@Override
	public  void run() { // synchronized 
		// TODO Auto-generated method stub
		synchronized(Multi.class){
		System.out.println(Thread.currentThread().getName() + " �߳����п�ʼ!");  
        for (int i = 0; i < 10; i++) {  
            System.out.println(i + " " + Thread.currentThread().getName());  
            try {  
                Thread.sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println(Thread.currentThread().getName() + " �߳����н���!"); 
	}
	}
}