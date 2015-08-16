package com.blogs.object;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年8月16日下午6:27:44
 * 测试集成父类，构造函数如何调用
 * 
 * 这让我想起来 JVM中的类的初始化,类加载机制,想想看,类的加载机制：加载-验证-准备-解析-初始化-使用卸载
 * ①加载干了三件事(1全限定名获得二进制字节流,2字节流代表的静态存储结构转化为方法区运行时数据结构, 3生成一个标识的java.lang.Class对象)
 * ②验证,主要保证Class字节流信息符合JVM要求且不会危害JVM自身安全
 * ③准备,这里主要是给类变量分配了内存，并设置了默认的类变量初始值，int就是0之类的。
 * ……
 * 
 * 在这个例子中，重点是，变量的声明和初始化并不是一个原子操作，我们可以写一行语句来表示，但却不是一个原子操作
 * 
 * 	进入Derived 构造函数。
	Derived 成员变量的内存被分配。
	Base 构造函数被隐含调用。
	Base 构造函数调用preProcess()。
	Derived 的preProcess 设置whenAmISet 值为 “set in preProcess()”。
 ***Derived 的成员变量初始化被调用。//最后才调用成员变量初始化
	执行Derived 构造函数体。	//如果设置了一个非空构造函数，且修改了变量whenSet，则最后输出修改的值。
 * 
 * 
 *	^^^^^^^^^^^^^^^^华丽的分隔线，测试查看后又添加一点东西^^^^^^^^^^^^^^^^^^^^^^^^^^
 *	blog上有人总结的两大原则：
 *	原则一：有static先初始化static，然后是非static的
 *	原则二：显式初始化（如果有的话），构造块初始化（如果有的话），最后调用构造函数进行初始化
 *
 *自己再分开总结下：
 * 对于没有extends的类来说：
 * 	1、所有的静态变量都在类第一次加载（在类加载中的“准备阶段”）的时候就被系统初始化了一次，默认值，基本类型int--0, 对象类型--null；
 * 	2、所有的静态块 static{    }    也都是只有在第一次类加载的时候运行一次。
 * 	3、 特别注意static变量被显示赋值，比如Student 类内有 static的Student变量，
 * 			且显式的赋值是不会再执行静态块和静态变量的初始化的！只执行实例变量和实例块的初始化。
 * 	4、 注意main函数也是类的静态部分
 * 
 * 对于有extends的子类初始化来说：
 * 	1、原则1就是跟先要满足上面的要求
 * 	2、不过static部分与非static部分要把子类父类结合起来整体看！，顺序是父类——>再子类！
 * 	3、整体的静态区看完了后，注意如果main函数中也有syso的话也是这个后面输出,
 * 			然后再父类实例变量（不管顺序在不在父类构造函数前后），再看父类的构造函数，再是子类的实例变量！
 * 	4、如果构造函数中有其他普通函数调用，且在子类中重写（重写是父类子类多态的一种表现），
 * 			那么new子类的时候，父类构造函数去调用子类的这个普通函数！
 * 
 */
public class Drived extends Base1{
	private int k = printInt("this no static K");
	private int kk = retInt();
	public Drived(){
//		whenSet = "hello world"; 如果这一行不注释，则输出这个
		process();
		System.out.println("k="+k +" j="+j);
	}
	public String whenSet = "set when decleard";
	
//	@Override
	void process(){
		whenSet = "set in process()!";
		System.out.println("now I am in sub class!");
	}
	
	private static int x2 = printInt("sub x2.int");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("int main");
		Drived d = new Drived();
		System.out.println(d.whenSet);
		
				
	}


}

class Base1 {

	private int i=retInt();
	protected int j;
	
	Base1(){
		process();
		System.out.println("i="+i +" j="+j+ "m="+m);
		j++;
	}
	private int m=retInt();
	void process(){
		System.out.println("I am Base process");
	}
	
	int retInt(){
		System.out.println("I am in Base 实例变量");
		return 10;
	}
	
	private static int x1 = printInt("Base1 parent .x1");
	static int printInt(String str){
		System.out.println(str);
		return 28;
	}
}

