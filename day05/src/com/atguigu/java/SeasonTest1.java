package com.atguigu.java;

import java.util.Arrays;

/*
使用enum关键字定义枚举类
说明：定义的枚举类默认继承于java.lang.Enum类
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);
//        Season1{seasonName='夏天', seasonDesc='夏日炎炎'}
        System.out.println(Season1.class.getSuperclass());
//        class java.lang.Enum

        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(Thread.State.values()));
//        [NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]

        // valueOf(String objName): 返回枚举类中对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
        // 如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
//        Season1{seasonName='冬天', seasonDesc='冰天雪地'}
        winter.show();
//        大约在冬季
    }
}

interface info {
    void show();
}

enum Season1 implements info {

    // 1. 提供当前枚举类的多个对象 多个对象之间用","隔开，末尾对象用";"结束
    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2. 声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化类的构造器, 并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 5. 其他诉求：提供toString方法
    @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
