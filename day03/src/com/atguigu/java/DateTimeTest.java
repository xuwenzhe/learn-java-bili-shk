package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/*
JDK 8之前日期和时间的API测试

java.util.Date类
      ｜ --- java.sql.Date类

1. 两个构造器的使用
   > 构造器一：Date():创建一个对应当前时间的Date对象
   > 构造器二：创建指定毫秒数的Date对象
2. 两个方法的使用
   > toString(): 显示当前的年月日时分秒
   > getTime(): 获取当前Date对象对应的毫秒数(时间戳)

3. java.sql.Date对应着数据库中的日期类型的变量
   > 如何实例化
   > 如何将java.util.Date对象转换为java.sql.Date对象

 */
public class DateTimeTest {
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        // 称为时间戳
        System.out.println(time);
    }
    @Test
    public void test2() {
        // 构造器一：Date(): 创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sat Apr 24 11:34:27 PDT 2021
        System.out.println(date1.getTime());//1619289267341
        // 构造器二：Date
        Date date2 = new Date(1619289267341L);
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(1619289267341L);
        System.out.println(date3);//2021-04-24

        // 如何将java.util.Date对象转换为java.sql.Date对象
        // 情况一：向下转型
        Date date4 = new java.sql.Date(1619289267341L);
        java.sql.Date date5 = (java.sql.Date) date4;
        // 情况二：
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date) date6;// 报错ClassCastException
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
}
