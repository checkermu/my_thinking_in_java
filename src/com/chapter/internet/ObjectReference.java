package com.chapter.internet;

import com.chapter.util.Paramaters;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月4日下午8:34:04
 * 对象的引用示例，参数的传递，
 */
public class ObjectReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectReference or = new ObjectReference();
		/*int pa=50;
		or.testBasicType(pa);
		System.out.println("main pa="+pa);	//在函数中如何改变不会影响函数调用之外
		
		StringBuffer sMain = new StringBuffer("init");
		or.add(sMain);	//add之后会发生变化
		System.out.println("after add sMain="+sMain.toString());
		
		or.testObjectType(sMain); //在函数中new一个外面并没有变化，按值传递？
		
		System.out.println("after new() sMain="+sMain.toString()); 
		
		Object obj;
		obj = new Object();*/
		
		/**
		 * another test  for why AddTwoNumbers l3=newHead is null
		 */
		or.testNew();

	}
	
	public void testNew(){
		Paramaters pa = new Paramaters(25);
		Paramaters next = pa;
		
		if(next!=null){
			System.out.println("next is not NULL!");
		}else{
			System.out.println("NULL!");
		}
		next.setAge(18);
		
		System.out.println("next.age="+next.age +" pa.age="+pa.age);
		
	}
	
	
	/**
	 * java传参数问题，java只有一种参数传递，那就是按值传递，java中传递任何东西都是传值，
	 * 基本类型，则得到一份拷贝，传递引用，就得到引用的拷贝, 引用的拷贝，指向的实质对象还是一样
	 */
	
	public void testBasicType(int pa){
		System.out.println("before pa= "+pa);
		pa=100;
		System.out.println("after pa= "+pa);
	}
	
	public void testObjectType(StringBuffer s){
		s = new StringBuffer("java");
	}
	
	public void add(StringBuffer s){
		s.append("_add");
	}

}
