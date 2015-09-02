package com.gt.contianer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//copyOnWrite容器尝试，思想：写时拷贝，那么拷贝的是引用吗？
//发现所有的对象类型的数组，不惯怎么拷贝都是引用，除非new
public class CopyOnWriteTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
//		testWrite();
		test();
	}
	
	public static void test() throws CloneNotSupportedException{
		Node[] n1 = {new Node(1, "one"), new Node(2, "two"), new Node(3, "three")};
		/*Node[] n2 = n1;
		n2[0].s1="newOne";
		System.out.println(n1[0].hashCode()+"@"+n1[0]);
		System.out.println(n2[0].hashCode()+"@"+n2[0]);*/
		/*Node[] n3 = new Node[n1.length];
		System.arraycopy(n1, 0, n3, 0, n1.length);
		n3[0].s1="newOne";
		System.out.println(n1[0].hashCode()+"@"+n1[0]);
		System.out.println(n3[0].hashCode()+"@"+n3[0]);*/
		
		/*Node[] n4 = n1.clone();
		n4[0].s1="newOne";
		System.out.println(n1[0].hashCode()+"@"+n1[0]);
		System.out.println(n4[0].hashCode()+"@"+n4[0]);*/
		
		/*Node[] n5 = new Node[n1.length];
		
		n5 = Arrays.copyOf(n1, n1.length);
		n5[0].s1="newOne";
		System.out.println(n1[0].hashCode()+"@"+n1[0].s1);
		System.out.println(n5[0].hashCode()+"@"+n5[0].s1);*/
		
		Node[] n6 = new Node[n1.length];
		
		for(int i=0; i<n1.length; i++){
			n6[i]=(Node) n1[i].clone();
		}
		n6[0].s1="newOne";
		System.out.println(n1[0].hashCode()+"@"+n1[0].s1);
		System.out.println(n6[0].hashCode()+"@"+n6[0].s1);
		
		
	}
	
	
	public static void testWrite(){
		CopyOnWriteArrayList list = new CopyOnWriteArrayList();
		list.add("k1:v1");
		list.add("k2:v2");
		Object obj0 = list.get(0);
		
		list.add("k3:v3");
		list.set(0, "k1:vvvvvvv");
		
		System.out.println(list.get(0).hashCode()+"@"+list.get(0));
		System.out.println(obj0.hashCode()+"@"+obj0);
		
	}
	
}

class Node implements Cloneable{
	int v1;
	String s1;
	
	public Node(int v, String s){
		super();
		this.v1 = v;
		this.s1 = s;
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
