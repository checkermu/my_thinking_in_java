package com.blogs.object;
/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年8月16日下午7:18:57
 * 
 * 类的一些变量的初始化，实例变量，静态变量，静态块，实例块。
 * 静态块只会初始化一次，静态变量在第一次调用对象初始化后，再次调用对象不会初始化了。
 */
public class Alibaba {
	public static int k = 0;
    public static Alibaba t1 = new Alibaba("t1");
    public static Alibaba t2 = new Alibaba("t2");
    public static int i = print("i");
    public static int n = 99;
    private int a = 0;
    public int j = print("j");
    {
        print("构造块");
    }
    static {
        print("静态块");
    }
    public Alibaba(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }
    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }
    public static void main(String args[]) {
//    	System.out.println("第一次");//如果加上这一句会出现在8:静态块   i=7    n=99 之间
													//9:j   i=8    n=100
        Alibaba t = new Alibaba("init");
        System.out.println("再来一次");
        Alibaba t2 = new Alibaba("init2");
        //执行结果如下:
        		/*1:j   i=0    n=0
        		2:构造块   i=1    n=1
        		3:t1   i=2    n=2
        		4:j   i=3    n=3
        		5:构造块   i=4    n=4
        		6:t2   i=5    n=5
        		7:i   i=6    n=6
        		8:静态块   i=7    n=99
        		9:j   i=8    n=100
        		10:构造块   i=9    n=101
        		11:init   i=10    n=102*/
        		/*再来一次
        		12:j   i=11    n=103
        		13:构造块   i=12    n=104
        		14:init2   i=13    n=105*/
        //再来一次这样的原因是，静态的变量都已经初始化过了，不会第二次创建对象的时候还初始化。
        
        
    }
}
