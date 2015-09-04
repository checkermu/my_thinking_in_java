package com.gt.threads;

/**
 * 测试下交替运行
 * @author checkermu
 * 
 * 测试下同一个 Runnable 
 * 不同线程，如果没有同步块，仍然是多线程乱序输出；但是同一个Runnable，只要加了对象锁就可以同步
 * 
 * 但是要是对象锁，不是类锁，两个Runnable对象的话 仍然是乱序输出！
 *
 */
public class TestMultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!"); 
		Multi m = new Multi();
		Multi m2 = new Multi();
		Thread t1 = new Thread(m, "A");
		Thread t2 = new Thread(m2, "B");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!"); 
	}

}
class Multi implements Runnable{

	@Override
	public  void run() { // synchronized 
		// TODO Auto-generated method stub
		synchronized(Multi.class){
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");  
        for (int i = 0; i < 10; i++) {  
            System.out.println(i + " " + Thread.currentThread().getName());  
            try {  
                Thread.sleep((int) Math.random() * 10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!"); 
	}
	}
}