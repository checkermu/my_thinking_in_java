package com.gt.memory;

/**
 * Volatile变量使用例子2
 * @author checkermu
 *
 */
public class VolatileUseTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VolatileUseTwo.getInstance();
	}

	private volatile static VolatileUseTwo instance;
	
	public static VolatileUseTwo getInstance(){
		if(instance == null){
			synchronized (VolatileUseTwo.class){
				if(instance==null){
					instance = new VolatileUseTwo();
				}
			}
		}
		return instance;
	}
	
}
