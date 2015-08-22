package com.chapter.concurrency21.producer;

import java.util.Stack;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年8月22日下午8:06:03
 */
public class MyProduceConsume {
	public Stack<Integer> stack = new Stack<Integer>();//定义一个仓库
	static final int SIZE =10;//仓库最大容量10
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyProduceConsume pc = new MyProduceConsume();
		Produce pro = pc.new Produce();
		Consume con = pc.new Consume();
		pro.start();
		con.start();
		
	}

	class Produce extends Thread{
		
		public void run(){
			try {
				produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//私有方法生产
		private void produce() throws InterruptedException{
			while(true){//满足条件的话会一直生产
				synchronized (stack) {//给stack对象加锁
					while(stack.size()==SIZE){
						//这个时候我们的仓库stack满了
						try {
							System.out.println("栈已经满了，等待空出的空间，通知去消费");
							stack.wait();
							//用这个对象在此线程下调用wait,表明此线程进入等待池，等待stack这个对象锁的那些线程可以获得锁了
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							stack.notify();
						}
					}
					stack.push(1);//每次栈中压入一个
					stack.notify();//调用notify会通知其他等待stack对象锁的线程，进入锁池，挑一个
					System.out.println("向栈中插入了一个元素：栈剩余空间为"+(SIZE-stack.size()));
					Thread.sleep(1000);
				}
				
			}
		}
	}
	
	
	class Consume extends Thread{
		public void run(){
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//私有方法消费
		private void consume() throws InterruptedException{
			while(true){
				synchronized (stack) {//只要条件允许就一直消费，对谁进行同步，stack
					while(stack.size()==0){
						try {
							System.out.println("现在栈为空，等待生产者生产");
							stack.wait();//调用wait,立即(释放线程占有资源，释放锁，退出同步代码块)
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
							stack.notify();
						}
					}
					stack.pop();
					//会通知那些wait的线程(在线程等待池的)，挑选一个进入锁池，等当前线程执行完，一起竞争锁资源
					stack.notify();
					System.out.println("消费了一个元素，剩余"+stack.size()+"个元素");
					Thread.sleep(1000);
				}
			}
		}
	}
	
	
	
}
