package com.chapter.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午7:52:02
 */
public class StringAddress {
	public String toString(){
		return " StringAddress class Address:"+this.hashCode()+"\n";
	}
	
	public void addre(){
		List<StringAddress> v = new ArrayList<StringAddress>();
		for (int i=0; i<10; i++){
			v.add(new StringAddress());
		}
		
		System.out.println(v);
	}

	public void methodCase(){
		String s1 = "abc";
		String s2 = "Abc";
		System.out.println(s1.concat(s2));
	}
	
	public static void main(String[] args) {
		StringAddress sa = new StringAddress();
		sa.methodCase();
	}
}
