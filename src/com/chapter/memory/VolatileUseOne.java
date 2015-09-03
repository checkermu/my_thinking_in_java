package com.gt.memory;

/**
 * Volatileʹ�ó���֮һ
 * @author checkermu
 *
 */
public class VolatileUseOne {
	private static final int COUNT=20; //�����̵߳���Ŀ
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
		//�ȴ������ۼ��̶߳�����
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
