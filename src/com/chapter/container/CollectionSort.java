package com.chapter.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年8月19日下午2:22:53
 */
public class CollectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSort();
		
	}

	
	public static void testSort(){
		String[] arrS = {"my", "ma", "m1","1a", "11"};
		List<String> lists = Arrays.asList(arrS);
		Collections.sort(lists, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				return o2.compareTo(o1);
			}
			
		});
		
		print(lists);
		
	}
	
	public static void print(List lists){
		for(Object l:lists){
			System.out.println(l);
		}
	}
}
