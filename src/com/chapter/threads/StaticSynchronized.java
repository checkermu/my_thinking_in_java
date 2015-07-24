package com.chapter.threads;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午5:05:14
 * 
 * 用synchronized关键字修饰静态方法
 */
public class StaticSynchronized implements Runnable{

	//这时如果某个线程调用该方法，
    //将锁定synchronized方法所在对象对应的class对象，就是直接把class锁定了，而非某一个具体的对象
	//而不是锁定synchronized方法所在对象
	
	public synchronized static void execute(){
		for(int i = 0; i<30; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("compute1:execute1 " + i++);
        }
	}
	
	public synchronized static void execute2(){
		for(int i = 0; i<30; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("compute1:execute2 " + i++);
        }
	}
	
	public synchronized static void execute3(){
		for(int i = 0; i<30; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("compute1:execute3 " + i++);
        }
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		StaticSynchronized.execute();
		StaticSynchronized.execute2();
		StaticSynchronized.execute3();
	}
	
	public static void main(String[] args) {
		//main方法中两个线程分别调用同一个对象的两个static synchronized方法：
		StaticSynchronized com = new StaticSynchronized();
		StaticSynchronized com2 = new StaticSynchronized();
		Thread thread1 = new Thread(com);
	    Thread thread2 = new Thread(com2);
	    thread1.start();
	    thread2.start();

	}

	

}
