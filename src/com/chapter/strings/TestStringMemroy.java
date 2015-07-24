package com.chapter.strings;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月24日下午8:32:37
 */
public class TestStringMemroy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStringMemroy tsm = new TestStringMemroy();
		tsm.testFinal();
	}

	public void testconstant(){
		String s1 = "hello world";
		String s2 = "hello world";
		String s3 = "hello"+" world";
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s3);
	}
	
	public void testNew(){
		String s1 = "hello world";
		String s2 = new String("hello world");
		String s3 = "hello"+new String(" world");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s3);
	}
	
	public void testThree(){
		String s1 = "a1";
		String s2 = "a"+1;
		System.out.println(s1==s2);
		
		String s3 = "aone";
		String s4 = "a"+"one";
		System.out.println(s3==s4);
		
		String s5 = "a3.4";
		String s6 = "a"+"3.4";
		System.out.println(s5==s6);
	}
	
	public void testFour(){
		String s1 = "aabb";
		String s2 = "bb";
		String s3 = "aa"+s2;
		
		System.out.println(s1==s3);
	}
	
	public void testFive(){
		String s1="aabb";
		final String s2 = new String("bb");
		String s3="aa"+s2;
		
		System.out.println(s1==s3);
	}
	
	public void testSix(){
		String a = "ab";
		final String bb = getBB();
		String b = "a" + bb;
		System.out.println((a == b)); //result = false
	}
	private String getBB() {  return "b";   }
	
	
	public void testSeven(){
		String  a  =  "a";
		String  b  =  "b";
		String  c  =  "c";
		String  s1  =   a  +  b  +  c;	
		
		StringBuffer temp = new StringBuffer();
		temp.append(a).append(b).append(c);
		String s2 = temp.toString();
		
		System.out.println(s1==s2);
	}
	
	public void testFinal(){
		final StringBuffer s1 = new StringBuffer("hello");
		
		s1.append("world");
		
		System.out.println(s1.toString());
	}
	
}
