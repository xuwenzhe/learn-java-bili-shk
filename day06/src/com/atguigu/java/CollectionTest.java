package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
Collection接口中声明的方法的测试
向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("Jerry", 20);
//        coll.add(p);
        coll.add(new Person("Jerry", 20));
        // contains(Object obj):判断当前集合中是否包含obj
        System.out.println(coll.contains(123));// true
        System.out.println(coll.contains(new String("Tom")));// true,判断内容

        // 本来为false, 调用equals(),实现为==。重写equals()后,返回true
        // 我们在判断时会调用obj对象所在类的equals()方法
        System.out.println(coll.contains(new Person("Jerry", 20)));

        // 2. containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));// true
    }

    @Test
    public void test2() {
        // 3. remove(Object obj): 从当前集合中移除obj元素
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);// [456, Tom, false]

        // 4. removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(456,"Tom");
        coll.removeAll(coll1);
        System.out.println(coll);//[false]
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 5. retainAll(Collection coll1): 交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);// [123, 456]

        // 6. equals(Object obj):判断当前Collection和形参Collection中元素是否都相同。List考虑顺序，Set不考虑顺序。
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));// true
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);
        //7. hashCode(): 返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // 8. 集合->数组: toArray()
        Object[] arr = coll.toArray();
        System.out.println(Arrays.toString(arr));
        // 拓展：数组->集合: 调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);//[AA, BB, CC]

        //注意
        System.out.println("===================");
        List<Integer> arr1 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr1);//[123, 456]
        List arr2 = Arrays.asList(new int[]{123,456});
        System.out.println(arr2);//[[I@6b57696f],有且仅有一个元素，为数组
        List arr3 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr3);//[123, 456]
        List arr4 = Arrays.asList(123,456);
        System.out.println(arr4);//[123, 456]

        // 9. iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
