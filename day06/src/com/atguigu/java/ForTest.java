package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/*
jdk 5.0新增了foreach循环，用于遍历集合，数组


 */
public class ForTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 快捷键iter
        // for (集合元素的类型 局部变量: 集合对象)
        // 内部仍然调用了迭代器。
        for (Object obj : coll) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1,2,3,4,5};
        for (int i : arr) {
            System.out.println(i);
        }
    }

    // 练习题
    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

        // 方式一：普通for赋值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }

        // 方式二：增强for循环
        for (String s : arr) {
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // MM, MM, MM
        // 方式二并没有改变原数组值。s值传递，同指向MM，但是赋值后，s指向了GG，而arr[i]仍指向MM。
    }
}
