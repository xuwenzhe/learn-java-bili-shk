package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
涉及到String类与其他结构之间的转换
复习：
String与基本数据类型，包装类之间的转换
String -> 基本数据类型，包装类：调用包装类的静态方法：parseXxx(str)
基本数据类型 -> String：调用String重载的valueOf(xxx)

String与char[]之间的转换：
String -> char[]: 调用String的toCharArray()
char[] -> String: 调用String的构造器

String与byte[]之间的转换
编码：String -> byte[]:调用String的getBytes()
解码：bytes[] -> String: 调用String的构造器

编码：字符串 -> 字节 （看得懂 -> 看不懂的二进制数据）
解码：编码的逆过程，字节 -> 字符串（看不懂的二进制数据 -> 看得懂）

说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
 */
public class StringTest1 {
    @Test
    public void test4() {
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        System.out.println(s1 == s3);// false
        final String s4 = "javaEE";// 这里s4是一个常量
        String s5 = s4 + "hadoop";
        System.out.println(s1 == s5);// true
    }
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();// 使用默认的字符集，utf-8一个汉字对应3bytes，gbk字符集一个汉字对应2bytes
        System.out.println(Arrays.toString(bytes));
        // [97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]

        System.out.println(new String(bytes));// 使用默认的字符集，进行解码
        byte[] gbks = str1.getBytes("gbk");
        System.out.println(new String(gbks));// 出现乱码。原因：编码集和解码集不一致
        System.out.println(new String(gbks, "gbk"));
    }
    @Test
    public void test2() {
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        System.out.println(new String(arr));
    }
    @Test
    public void test1() {
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(String.valueOf(num));
        String str2 = num + "";
        System.out.println(str1 == str2);//str1在常量池中，str2在堆中
    }
}
