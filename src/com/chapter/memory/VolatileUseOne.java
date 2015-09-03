package com.gt.memory;

/**
 * Volatile使用场景之一
 * @author checkermu
 *
 */
public class VolatileUseOne {
	private static final int COUNT=20; //生成线程的数目
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final VolatileUseOne obj =  new VolatileUseOne();
		Thread[] ts = new Thread[COUNT];
		for(int i=0; i<COUNT; i++){
			if(i==10){
				obj.shutdown();
			}
			ts[i] = new Thread(new Runnable(){
				public void run(){
					for(int i=0; i<1000; i++){
						obj.doWork();
					}
				}
			});
			ts[i].start();
		}
		//等待所有累加线程都结束
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println("OVer");
	}

	volatile boolean shutDown;
	
	public void shutdown(){
		shutDown=true;
	}

	public void doWork(){
		while(!shutDown){
			System.out.println(Thread.currentThread().getName()+"Iam false now");
		}
	}
	
}
