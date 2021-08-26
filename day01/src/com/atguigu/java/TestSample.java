package com.atguigu.java;

public class TestSample {
    public void method1(String str) {
        System.out.println(str);
    }
    public void method2(String str) {
        method1(str);
    }
    public static void main(String[] args) {
        TestSample s = new TestSample();
        s.method2("hello");
    }
}
