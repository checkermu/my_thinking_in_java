package com.gt.threads;

import java.util.Date;

/**
 * 多线程学习的小例子;
 * 再次印证Thread.sleep()和 Thread.yield()；
 * sleep会给所有线程机会，且是阻塞的
 * yield只是转到就绪状态，且还是竞争关系；
 * 
 * 所以运行结果区别：
 * 1、sleep的话  会一个慢，三个块，交替运行
 * 2、yield的话会没有规律可言，交替执行；当然这里也没有快慢之分了！
 * 
 * @author checkermu
 *
 */
public class TimePrinter implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//写两个线程
		Thread t1 = new Thread(new TimePrinter(1000, "Fast one"));
		t1.start();
		
		Thread t2 = new Thread(new TimePrinter(3000, "Slow one"));
		t2.start();
	}
	
	int pauseTime;
	String name;

	//构造函数
	public TimePrinter(int t, String s){
		this.pauseTime = t;
		this.name = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				System.out.println(name+":"+new Date(System.currentTimeMillis()));
				Thread.sleep(pauseTime);
//				Thread.yield();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}

}
