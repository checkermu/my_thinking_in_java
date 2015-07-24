package com.chapter.threads;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午4:36:08
 * 共享成员变量的例子，成员变量,和局部变量的尝试
 */
public class MyThread3 implements Runnable{
	//成员变量，两个线程操作同一个对象，将会共享成员变量
	int i;
	
	public void run(){
		//两个线程操作同一个对象，将各自保持局部变量的拷贝
//		int i=0; 
		i=0;
		while(i<100){
			System.out.println(i);
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException  e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		MyThread3 myThread = new MyThread3();
		//下面两个线程对同一个对象（Runnable的实现类对象）进行操作
		Thread thread = new Thread(myThread);
		Thread thread2 = new Thread(myThread);
		 //各自保存局部变量的拷贝，互不影响，输出200个数字
		thread.start();
		thread2.start();
		
	}
}
