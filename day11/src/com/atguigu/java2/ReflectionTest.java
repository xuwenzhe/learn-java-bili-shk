package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
调用运行时类中指定的结构：属性，方法，构造器
 */
public class ReflectionTest {
    // 不需要掌握
    @Test
    public void test1() throws Exception {
        Class clazz = Person.class;
        // 创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        // 获取指定的属性:要求运行时类中属性声明为public
        // 通常不实用此方法，因为属性一般为private
        Field id = clazz.getField("id");
        /*
        设置当前属性的值
        set()： 参数1，指明设置哪个对象的属性， 参数2：将此属性设置为多少
         */
        id.set(p, 1001);
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /*
    如何操作运行时类中的指定的属性 - 需要掌握
     */
    @Test
    public void testField1() throws Exception {
        Class clazz = Person.class;
        // 创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        // getDeclaredField(String fieldName): 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        // 保证当前属性是可访问的
        name.setAccessible(true);
        // 获取，设定指定对象的属性值
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    /*
    如何操作运行时类中的指定的方法 - 需要掌握
     */
    @Test
    public void testMethod() throws Exception {
        Class clazz = Person.class;
        // 创建运行时类的对象
        Person p = (Person) clazz.newInstance();
        // 获取指定的某个方法
        // getDeclaredMethod(): 参数1：指明获取的方法的名称 参数2：指明获取方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        // 保证当前方法是可访问的
        show.setAccessible(true);
        // 调用方法的invoke(): 参数1： 方法的调用者 参数2：给方法形参赋值的实参
        // invoke()的返回值即为对应类中调用的方法的返回值
        Object returnValue = show.invoke(p, "CHN");// p.show("CHN");
        System.out.println(returnValue);

        // private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        showDesc.invoke(Person.class);
    }

    /*
    如何调用运行时类中指定的构造器
     */
    @Test
     public void testConstructor() throws Exception {
        Class clazz = Person.class;
        // private Person(String name)
        //1. 获取指定的构造器
        // getDeclaredConstructor(): 参数：指明构造器的参数列表
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        // 保证此构造器是可访问的
        constructor.setAccessible(true);
        // 调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);
    }
}
