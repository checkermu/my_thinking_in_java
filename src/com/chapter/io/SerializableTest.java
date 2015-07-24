package com.chapter.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年5月12日下午2:58:54
 */
public class SerializableTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("D:\\x.file"));
		Alien ali = new Alien();
		out.writeObject(ali);
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("D:\\x.file")));
		Object obj = in.readObject();
		System.out.println(obj.getClass());
	}
}
