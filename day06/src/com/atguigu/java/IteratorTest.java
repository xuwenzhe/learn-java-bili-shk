package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
集合元素的遍历操作，使用迭代器Iterator接口
* Iterator对象称为迭代器（设计模式的一种），主要用于遍历Collection集合中的元素。
* GOF给迭代器模式的定义为：提供一种方法访问一个容器（container）对象中各个元素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。类似于"公交车上的售票员"，"火车上的乘务员"，"空姐"。
* Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象。
* Iterator仅用于遍历集合，Iterator本身并不提供承装对象的能力。如果需要创建Iterator对象，则必须有一个被迭代的集合。
* 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。

内部的方法：hasNext()和next()
内部定义了remove(), 可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()。如果还未调用next()或在上一次调用next方法之后已经调用了remove方法，再调用remove都会报IllegalStateException
迭代器主要用来遍历Collection，不用于遍历Map

 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // 方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        // 报异常：NoSuchElementException
//        System.out.println(iterator.next());

        // 方式二：不推荐
        for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }

        // 方式三：推荐
        // hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            // next(): 1）指针下移 2）将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 错误方式一：
        Iterator iterator = coll.iterator();
        while ((iterator.next()) != null) {
            System.out.println(iterator.next());
        }
        // 错误方式二：
        while ((coll.iterator().hasNext())) {
            System.out.println(coll.iterator().next());
        }
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }

        // 遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            // next(): 1）指针下移 2）将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }
}
