package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/*
    LocalDate, LocalTime, LocalDateTime的使用
    说明：
        1. LocalDateTime相较于LocalDate和LocalTime使用频率要高
        2. 类似于Calendar

    Instant的使用
    类似于java.util.Date类

    DateTimeFormatter:格式化或解析日期，时间
    类似于SimpleDateFormat
     */

public class JDK8DateTimeTest {

    @Test
    public void test1() {
        // now(): 获取当前的日期，时间，日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of():设置指定的年月日时分秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,6,13,23,43);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());//25
        System.out.println(localDateTime.getDayOfWeek());//SUNDAY

        // 体现不可变性
        // withXxx():设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2021-04-25
        System.out.println(localDate1);//2021-04-22

        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime2);
    }

    @Test
    public void test2() {
        // now(): 获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        // ofEpochMilli():通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1619394493520L);
        System.out.println(instant1);
    }

    @Test
    public void test3() {
        // 方式一：预定义的标准格式：
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        // 解析：字符串->日期
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);

        // 方式二：本地化相关的格式。如ofLocalizedDateTime()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        // 方式三：自定义的格式。如 ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = formatter2.format(LocalDateTime.now());
        System.out.println(str4);

        // 解析
        TemporalAccessor accessor = formatter2.parse("2019-02-18 03:52:09");
        System.out.println(accessor);
    }

}
