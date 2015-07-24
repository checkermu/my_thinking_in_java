package com.chapter.threads;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午7:18:32
 */
public class ThreadClass implements Runnable{

	public void test(){
		synchronized (Thread.class) {
			System.out.println("test开始..");  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            System.out.println("test结束..");  
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadClass tc = new ThreadClass();
		tc.test();
	}

	public static void main(String[] args) {
		for(int i=0; i<3; i++){
			ThreadClass tc = new ThreadClass();
			Thread thread = new Thread(tc);
			thread.start();
		}
	}
}
