package com.gt.memory;

/**
 * 
 * @author checkermu
 *
 *volatile������������
 */
public class VolatileTest {
	public static volatile int race = 0;
	public static void increase(){
		race++;
	}
	
	private static final int COUNT=20; //�����̵߳���Ŀ
	
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
		
		//�ȴ������ۼ��̶߳�����
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(race);
	}

	/**
	 * �����ÿ�����н������ͬ�����Ƕ�������20000����Ϊ
	 * race++����������ԭ���Եģ�increase()��class�ļ�����4��ָ����ܻ�������࣬
	 * ���õ�raceֵ��ʱ��volatile��֤�˴�ʱ��ֵ����ȷ�ģ�
	 * ������ִ������ָ���ʱ�򣬱���߳̿����Ѿ���race��ֵ�����ˣ�
	 * ��������̵߳�race++����һ����ʱ�Ĳ�������û��ʵ�ʵ���race���
	 */
	
}
