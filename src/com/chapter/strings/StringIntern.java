package com.chapter.strings;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年7月21日下午9:01:00
 * 
 * String 的intern方法，
 * java方法去中的运行时常量池，对于class文件常量池的另外一个重要特性是具备动态性，
 * java语言不要求常量一定编译期才能产生，运行期间也可能将新的常量放入池中。这个特性
 * 用这个特性最多的就是String类的 intern()方法
 */
public class StringIntern {
	public static void main(String[] args) {
		String s1 = "ab123" ;  
        String s2 = new String( "ab123" ) ;  
        System.out.println( s1 == s2 );   
        String s3 = s2.intern() ;   
        System.out.println( s1 == s3 ) ;
	}
}
