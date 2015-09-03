package com.gt.memory;

/**
 * 
 * @author checkermu
 *
 *volatile变量自增测试
 */
public class VolatileTest {
	public static volatile int race = 0;
	public static void increase(){
		race++;
	}
	
	private static final int COUNT=20; //生成线程的数目
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread[] ts = new Thread[COUNT];
		for(int i=0; i<COUNT; i++){
			ts[i] = new Thread(new Runnable(){
				public void run(){
					for(int i=0; i<1000; i++){
						increase();
					}
				}
			});
			ts[i].start();
		}
		
		//等待所有累加线程都结束
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(race);
	}

	/**
	 * 结果：每次运行结果都不同，但是都不会是20000；因为
	 * race++；操作不是原子性的；increase()在class文件中是4条指令，可能汇编代码更多，
	 * 当得到race值的时候，volatile保证了此时的值是正确的，
	 * 但是在执行其他指令的时候，别的线程可能已经把race的值增大了，
	 * 所以这个线程的race++就是一个过时的操作，并没有实际导致race变大；
	 */
	
}
