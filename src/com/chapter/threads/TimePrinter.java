package com.gt.threads;

import java.util.Date;

/**
 * ���߳�ѧϰ��С����;
 * �ٴ�ӡ֤Thread.sleep()�� Thread.yield()��
 * sleep��������̻߳��ᣬ����������
 * yieldֻ��ת������״̬���һ��Ǿ�����ϵ��
 * 
 * �������н������
 * 1��sleep�Ļ�  ��һ�����������飬��������
 * 2��yield�Ļ���û�й��ɿ��ԣ�����ִ�У���Ȼ����Ҳû�п���֮���ˣ�
 * 
 * @author checkermu
 *
 */
public class TimePrinter implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//д�����߳�
		Thread t1 = new Thread(new TimePrinter(1000, "Fast one"));
		t1.start();
		
		Thread t2 = new Thread(new TimePrinter(3000, "Slow one"));
		t2.start();
	}
	
	int pauseTime;
	String name;

	//���캯��
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
