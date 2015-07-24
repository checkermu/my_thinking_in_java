package com.chapter.base;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年7月2日上午9:07:26
 */
public class VariableI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testJ();
	}
	
	public static void testJ(){
		int j=0;
		for(int i=0; i<100; i++){
			j = ++j;
		}
		
		System.out.println(j);
	}
	
	
	
	/**
	 * 测试变量i++  与 ++i的区别， 
	 * 发现 最后一个 i++的话是不会算到进去的 ，如果是 ++i就会补上。
	 */
	public static void testI(){
		int i=0;
		i=i++ + ++i;
		int j=0;
		j=++j + j++ + j++ + j++ + ++j;
		int k=0;
		k=k++ + k++ + k++ + ++k + k++;
		int h=0;
		h=++h + ++h;
		System.out.println("i "+i);
		System.out.println("j "+j);
		System.out.println("k "+k);
		System.out.println("h "+h);
	}

}
