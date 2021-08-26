package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/*
泛型的使用
1. jdk5.0新增的特性
2. 在集合中使用泛型：
总结：
    1。集合接口或集合类在jdk5.0时都修改为带泛型的结构
    2。在实例化集合类时，可以指明具体的泛型类型
    3。指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法，构造器，属性）使用到类的泛型的位置，都指定为实例化的泛型类型
    比如：add(E e) ---> 实例化以后：add(Integer e)
    4。注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类来替换
    5。如果实例化时，没有指明范型的类型，默认类型为java.lang.Object类型

3. 如何自定义泛型结构：泛型类，泛型接口；泛型方法

泛型类，泛型接口

泛型方法

 */
public class GenericTest {

    // 在集合中使用泛型
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        // 问题1： 类型不安全
//        list.add("Tom");
        for (Object score: list) {
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    // 在集合中使用泛型的情况：
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        // 编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");
        for (Integer score : list) {
            // 避免了强转操作
            System.out.println(score);
        }
        // 方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 87);
        map.put("Jerry", 87);

        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        // option + enter 自动补全
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
    }

    @Test
    public void test4() {
        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        // 要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        // 建议：实例化时指明类的泛型
        Order<String> orderAA = new Order<>("orderAA", 1001, "order:AA");
        orderAA.setOrderT("AA:hello");
    }

    @Test
    public void test5() {
        SubOrder sub1 = new SubOrder();
        // 由于子类在继承带泛型的父类，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderId(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
    }

    @Test
    public void test6() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        // 泛型不同的引用不能相互赋值
//        list1 = list2
    }

    // 测试泛型方法
    @Test
    public void test7() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        // 泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
