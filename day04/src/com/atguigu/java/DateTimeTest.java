package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
jdk 8之前的日期时间API测试
1. System类中currentTimeMillis();
2. java.util.Date和子类java.sql.Date
3. SimpleDateFormat
4. Calendar
注意：
* 获取月份时：一月是0，二月是1，以此类推，12月是11
* 获取星期时：周日是1，周二是2，以此类推，周六是7
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    1. 两个操作：
    1.1 格式化：日期 ---> 字符串
    1.2 解析：格式化的逆过程，字符串 ---> 日期

    2. SimpleDateFormat的实例化
     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "4/24/21, 11:54 PM";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        System.out.println("=========按照指定的方式格式化和解析：调用带参的构造器=========");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf1.format(date));
        // 解析：要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        // 否则抛异常
        System.out.println(sdf1.parse("2021-04-24 11:57:20"));
    }
    @Test
    public void testExer() throws ParseException {
        // 练习一：字符串转换为java.sql.Date
        String birth = "2020-09-28";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    Calendar日历类的使用
     */
    @Test
    public void testCalendar() {
        // 1. 实例化
        // 方式一：创建其子类（GregorianCalendar）的对象
        // 方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        // 2. 常用方法
        // get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//25
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//115
        // set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//22
        // add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//19
        // getTime(): 日历类--->Date
        Date date = calendar.getTime();
        System.out.println(date);//Mon Apr 19 16:16:17 PDT 2021
        // setTime(): Date--->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        System.out.println(calendar.getTime());//Sun Apr 25 16:16:17 PDT 2021
    }
}
