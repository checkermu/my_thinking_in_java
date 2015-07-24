package com.chapter.strings;

import java.util.Formatter;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午8:18:47
 * 
 * formmater 控制输出
 */
public class StringFormmter {
	private Formatter f = new Formatter(System.out);
	
	public void printTitle(){
		f.format("%-15s %5s %10s\n", "Item", "Qty", "Prive");
		f.format("%-15s %5s %10s\n", "----", "----", "----");
	}
	
	public void printTitleControl(int i, int j, int k){
		
		f.format("%-"+i+"s %"+j+"s %"+k+"s\n", "Item", "Qty", "Prive");
		f.format("%-15s %5s %10s\n", "----", "----", "----");
	}
	
	public static void main(String[] args) {
		StringFormmter sf = new StringFormmter();
		sf.printTitle();
		
		sf.printTitleControl(20, 10, 10);
	}
}
