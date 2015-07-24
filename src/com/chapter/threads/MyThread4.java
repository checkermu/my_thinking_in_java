package com.chapter.threads;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午4:54:39
 */
public class MyThread4 extends Thread{
	//两个线程操作一个对象，共享成员变量
	Number number;
	
	public MyThread4(Number number){
		this.number = number;
	}
	
	@Override
	public void run(){
		System.out.println(number.getNumber(8));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number number = new Number();
		//两个线程操作同一个对象，共享对象number的成员变量number
		MyThread4 myThread = new MyThread4(number);
		MyThread4 myThread2 = new MyThread4(number);
		myThread.start();
		myThread2.start();
		
	}

}
