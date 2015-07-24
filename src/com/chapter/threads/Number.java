package com.chapter.threads;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午4:51:04
 * 一个Number类，通过一个方法 getNumber获取数据，
 */
public class Number {
	private int number = 10;
	
	public String getNumber(int i){
		if(number>0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException  e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			number -= i;
			return "取出"+i+"成功，剩余数量："+number;
		}
		return "取出"+i+"失败，剩余数量："+number;
	}

}
