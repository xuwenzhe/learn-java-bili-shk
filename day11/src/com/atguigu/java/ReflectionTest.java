package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    // 反射之前
    @Test
    public void test1() {
        // 1. 创建Person类的对象
        Person p1 = new Person("Tom", 12);

        // 2. 通过对象，调用其内部的属性和方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类的外部，不可以通过Person类的对象调用其内部的私有结构
        // 比如：name, showNation(), 以及私有的构造器（封装性的限制）
    }

    // 反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        // 1. 通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(obj.toString());

        // 2. 通过反射，调用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());


        // 3. 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        // 4. 通过反射，可以调用Person类的私有结构的。比如：私有的构造器，属性，方法
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1.toString());

        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "HanMeimei");

        // 调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    // 疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
    // 建议：直接new的方式
    // 疑问：什么时候会用到反射的方式调用？
    // 反射的特征：动态性
    // 疑问：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    // 不矛盾。封装性可以理解为不建议调用private结构


    /*
    关于java.lang.Class类的理解
    1. 类的加载过程：
    程序经过java.exe命令后，会生成一个或多个字节码文件（.class结尾），接着我们使用
    java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程
    就称为类的加载。
    加载到内存中的类，我们就称为运行时类，此运行时类就作为Class的一个实例。

    2. 换句话说，Class的实例就对应着一个运行时类.
    3. 加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类
    注意这里是"获取"，不是"创建"， 因为运行时已经加载到内存中

    万事万物皆对象？对象，File，URL，类也是对象（反射），数据库操作
     */

    // 获取Class实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性: .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // 方式二：通过运行时类的对象, 调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式三(开发中常用)：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4 == clazz3);
    }
}
