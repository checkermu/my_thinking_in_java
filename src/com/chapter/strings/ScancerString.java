package com.chapter.strings;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年6月25日下午8:57:57
 */
public class ScancerString {

	public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803"));
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner stdin = new Scanner(input);
		System.out.println("what is your name?");
		String name = stdin.nextLine();
		System.out.println(name);
		
		System.out.println("How old? what is your favoirte double?");
		System.out.println("input: <age> <double>");
		int age = stdin.nextInt();
		double fav = stdin.nextDouble();
		System.out.println(age);
		System.out.println(fav);
		System.out.format("Hi,  %s.\n", name);
		System.out.format("In five years you will be %d.\n", age+5);
		
	}

}
