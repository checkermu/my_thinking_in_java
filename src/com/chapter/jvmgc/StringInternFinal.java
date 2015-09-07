package com.gt.jvmall;

/**
 * 用常量池的角度来理解String是否相等
 * @author checkermu
 *
 */
public class StringInternFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "a";
		String b = "b";
		
		String ab = "ab";
		System.out.println((a+b)==ab); //false
		System.out.println(("a"+"b")==ab); //true
		
		final String afinal = "a";
		String result = afinal+"b";
		System.out.println(result == ab); //true
		
		String plus = a+"b";
		System.out.println(plus==ab); //false
		System.out.println(plus.intern() == ab);//true
		
		/**
		 * 运行结果解析：
		 * (a+b)==ab	false；原因是：a+b是两个变量想加，需要运行的时候才能确定其值，运行时候
		 * JVM会为两者想加产生一个新的对象，因此是false
		 * 
		 * ("a"+"b")==ab	true：原因是：两个都是常量，在编译的时候JVM已经将其变为"ab"字符串了
		 * 	而ab = "ab"；	也是常量，都在常量池中，所以为true
		 * 
		 * result==ab	true的原因是：result=afinal +"b"； afinal是个final类型的变量
		 * 	其实就是个常量，result在编译时已经被转换为"ab"了，所以为true
		 * 
		 * plus跟第一个相同，两个想加有个是变量，所以其值要等到运行时候才能确定；所以产生新对象了！
		 * 
		 * String类的 intern()方法，当调用intern方法的时候，如果常量池中已经包含有一个等于此对象
		 * 的字符串（这里的等于用equals(Object)确定），则返回池中的字符串，如果没有，将此String
		 * 添加到池中，并返回此String对象的引用！
		 */
		
	}

}
