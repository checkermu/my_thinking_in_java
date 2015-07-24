package com.chapter.concurrency21;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年7月24日下午8:15:01
 */
public class BasicThread {
	
	/**
	 * 程序解释，首先输出了 waiting for LiftOff？
	 * Thread构造器需要一个 Runable对象，Thread对象的start()方法为该线程执行必须的初始化方法，then调用Runnable的run()方法，以启动任务。
	 * 
	 * 首先输出"waiting……"发现start()方法迅速返回了，在倒计时之前就输出。
	 * 实际上产生的是对LiftOff.run()方法的调用并且这个方法还没有完成，但是但是！！
	 * 由于因为LiftOff().run()是由不同的线程执行的，因此依旧可以执行main()线程中的其他操作（这种能力不局限于main()线程），
	 * 任何线程都可以启动另一个线程。因此程序会同时运行两个方法，main()和LiftOff.run()
	 * 
	 */
	/**
	 * 输出结果
	waiting for LiftOff
	#0(9),
	#0(8),
	#0(7),
	#0(6),
	#0(5),
	#0(4),
	#0(3),
	#0(2),
	#0(1),
	#0(LiftOff!),
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("waiting for LiftOff");
	}
	

}
