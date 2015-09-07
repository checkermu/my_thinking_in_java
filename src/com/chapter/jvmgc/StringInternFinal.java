package com.gt.jvmall;

/**
 * �ó����صĽǶ������String�Ƿ����
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
		 * ���н��������
		 * (a+b)==ab	false��ԭ���ǣ�a+b������������ӣ���Ҫ���е�ʱ�����ȷ����ֵ������ʱ��
		 * JVM��Ϊ������Ӳ���һ���µĶ��������false
		 * 
		 * ("a"+"b")==ab	true��ԭ���ǣ��������ǳ������ڱ����ʱ��JVM�Ѿ������Ϊ"ab"�ַ�����
		 * 	��ab = "ab"��	Ҳ�ǳ��������ڳ������У�����Ϊtrue
		 * 
		 * result==ab	true��ԭ���ǣ�result=afinal +"b"�� afinal�Ǹ�final���͵ı���
		 * 	��ʵ���Ǹ�������result�ڱ���ʱ�Ѿ���ת��Ϊ"ab"�ˣ�����Ϊtrue
		 * 
		 * plus����һ����ͬ����������и��Ǳ�����������ֵҪ�ȵ�����ʱ�����ȷ�������Բ����¶����ˣ�
		 * 
		 * String��� intern()������������intern������ʱ��������������Ѿ�������һ�����ڴ˶���
		 * ���ַ���������ĵ�����equals(Object)ȷ�������򷵻س��е��ַ��������û�У�����String
		 * ��ӵ����У������ش�String��������ã�
		 */
		
	}

}
