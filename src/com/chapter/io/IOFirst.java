package com.chapter.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * author: checkermu email:guotaoleng@163.com
 * time: 2015年7月7日上午11:09:47
 */
public class IOFirst {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		testSystemIn();
//		testInputStream();
		/*Map<String, String> map1 = new HashMap<String, String>();
		map1.put("ZHAN", "hongying");
		map1.put("GUO", "tao");
		Vector v1 = new Vector();
		v1.add(map1);
		System.out.println(v1);*/
		
//		fileTest();
//		fileInputStreamTest();
//		fileOutputStreamTest();
//		fileInputOutStreamTest();
//		bufferedReaderTest();
//		differentTest();
		
//		fileInputStreamTest();中文打印到屏幕乱码
		
		readerFilePrint();
		
//		outStreamWriter();
				
	}
	
	/**
	 * 将字符输出流转换为字节输出到文件中，使用OutputStreamWriter类进行
	 * @throws IOException 
	 */
	public static void outStreamWriter() throws IOException{
		FileOutputStream fo = new FileOutputStream("D:\\root\\fileone.txt", true);
		Writer out = new OutputStreamWriter(fo, "UTF-8");
		out.write("换成UTF-8试试这次是不是乱码！");
		out.close();
		System.out.println("OK");
	}
	
	/**
	 * 用FileInputStream有汉字的读取并打印，会涉及乱码，这里用字符流
	 * @throws IOException 
	 * 
	 */
	public static void readerFilePrint() throws IOException{
		FileInputStream fr = new FileInputStream("D:\\root\\fileone.txt");
//		BufferedReader br = new BufferedReader(fr); 这个并不能转换 还是用 InputStreamReader
		InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s;
		while((s=br.readLine())!=null){
			System.out.println(s);
		}
		System.out.println("end");
	}
	
	/**
	 * Reader和Writer处理的是字符流，在处理字符流时涉及了字符编码的转换问题
	 * @throws IOException
	 */
	public static void differentTest() throws IOException{
		System.out.println("内存中采用Unicode编码");
		char c='好';
		int lowBit = c&0xFF;
		int highBit = (c&0xFF00)>>8;
		System.out.println(""+lowBit+"    "+highBit);
		String s = "好";
		System.out.println("本地操作系统默认编码");
		readBuff(s.getBytes());
		System.out.println("采用GBK编码");
		readBuff(s.getBytes("GBK"));
		System.out.println("采用UTF-8编码");
		readBuff(s.getBytes("UTF-8"));
	}
	
	/**
	 * 读取字节码  被上个函数调用
	 * @param buff
	 * @throws IOException
	 */
	public static void readBuff(byte[] buff) throws IOException{
		ByteArrayInputStream in = new ByteArrayInputStream(buff);
		int data;
		while((data=in.read())!=-1){
			System.out.print(data+" ");
		}
		System.out.println();
		in.close();
	}
	
	
	/**
	 * 利用缓冲区输入输出
	 * BufferedReader与标准数据流相接
	 * @throws IOException 
	 * 
	 * 设置输入流，输入缓冲区，  设置输出流，输出缓冲区
	 */
	public static void bufferedReaderTest() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		FileWriter out = new FileWriter("D:\\root\\filefour.txt");
		BufferedWriter bw = new BufferedWriter(out);
		System.out.println("please input:");
		String s ;
		while((s=br.readLine())!=null){
			bw.write(s, 0, s.length());
		}
		bw.close();
		System.out.println("OK");
	}
	
	
	/**
	 * 同时测试FileInputStream 和FileOutputStream  从一个文件读取，输入到另一个文件
	 * 注意：有中文的时候在输出文件中不会乱码，原因是：Stream以字节形式读取，再以同样字节的形式放到另一个文件中，
	 * @throws IOException 
	 */
	public static void fileInputOutStreamTest() throws IOException{
		File f1 = new File("D:\\root\\fileone.txt");
		File f2 = new File("D:\\root\\filetwo.txt");
		FileInputStream fin = new FileInputStream(f1);
		FileOutputStream fout = new FileOutputStream(f2);
		int c;
		while((c=fin.read())!=-1){
			fout.write(c);
		}
		fin.close();
		fout.close();
	}
	
	
	/**
	 * FileOutputStream输出到文件
	 * 从标准输入设备读取到内存，然后通过FileOutputStream输出到文件，
	 */
	public static void fileOutputStreamTest(){
		try {
			System.out.println("please input form your KeyBoard:");
			int count, n=512;
			byte buffer[] = new byte[n];
			count = System.in.read(buffer);
			FileOutputStream wf = new FileOutputStream("D:\\root\\filethree.txt", true);
			wf.write(buffer, 0, count); //如果不加这个count，表示写入的数目，那么会写入512个，后面都是空的，
			wf.close();
			System.out.println("save to txt!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File write error!");
		}
	}
	
	
	/**
	 * FileInputStream 输入流，从文件读取内容，经过标准输入到屏幕
	 * 在这里有问题：1个是乱码问题，2个是输出格式，.java文件的时候重复输出了一部分？？？
	 */
	public static void fileInputStreamTest(){
		try{      
            FileInputStream rf=new   FileInputStream("fileone.txt");  
            int n=512;   byte  buffer[]=new  byte[n];     
            while((rf.read(buffer,0,n)!=-1)&&(n>0)){  
                System.out.println(new String(buffer) ); //以字节行书读取文件输出会是乱码，汉字一个是俩个字节，但是这里没有组合，有汉字适合用字符流 
             }  
             System.out.println();  
             rf.close();  
	     } catch(IOException  IOe){        
	           System.out.println(IOe.toString());  
	     }  
	}
	
	/**
	 * File 的方法测试，用到了创建目录，创建文件，注意：new File对象和在物理磁盘上创建一个文件是不同时的。
	 * @throws IOException
	 */
	public static void fileTest() throws IOException{
//		File file = new File(filepath);
		File dir = new File("\\root");
		File f1 = new File("fileone.txt");
		File f2 = new File(dir, "filetwo.txt");
		//文件对象创建后，指定的对象不一定物理上存在
		if(!dir.exists()){
			dir.mkdir();
		}
		//如果注释掉，fileone.txt是不会创建出来的。
		if(!f1.exists()){
			f1.createNewFile();
		}
		if(!f2.exists()){
			f2.createNewFile();
		}
		
		System.out.println("f1 absolutePath = "+f1.getAbsolutePath());
		System.out.println("f1 canread="+f1.canRead());
		System.out.println("f1 length="+f1.length());
		
		String[] FL;
		int count =0;
		FL = dir.list();
		
		for (int i=0; i<FL.length; i++){
			count++;
			System.out.println(FL[i] +"is in \\root");
		}
		
		System.out.println("There are "+ count +" file in \\root");
	}
	
	
	public static void testInputStream(){
		String s;
		//创建缓冲区阅读器从键盘逐行读入数据
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		System.out.println("Unix系统: ctrl-d 或 ctrl-c 退出"  
                + "\nWindows系统: ctrl-z 退出"); 
		try{
			//读一行数据，并标准输出到显示器
			s=in.readLine();
			//readLine()方法运行时若发生I/O错误，将抛出IOException异常
			while(s!=null){
				System.out.println("Read: "+s);
				s=in.readLine();
			}
			//关闭缓冲区阅读器
			in.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void testSystemIn(){
		int b;
		try {
			System.out.println("please input:");
			while((b=System.in.read())!=-1){
				System.out.print((char)b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

}
