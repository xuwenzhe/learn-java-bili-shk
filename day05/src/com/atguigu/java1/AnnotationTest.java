package com.atguigu.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/*
注解的使用
1·理解Annotation
2·Annotation的使用示例
示例一：生成文档相关的注解
示例二：在编译时进行格式检查（JDK内置的三个基本注解）
@Override: 限定重写父类方法，该注解只能用于方法
@Deprecated: 用于表示所修饰的元素（类，方法等）已过时。通常是因为所修饰的结构危险或存在更好的选择。
@SuppressWarnings: 抑制编译期警告

示例三：跟踪代码依赖性，实现替代配置文件功能。

3· 如何自定义注解：参照@suppressWarnings定义
- 注解声明为：@interface
- 内部定义成员，通常使用value表示
- 可以指定成员的默认值，使用default定义
- 如果自定义注解没有成员，表明是一个标识作用。

如果注解有成员，在使用注解时，需要指明成员的值。
自定义注解必须配上注解的信息处理流程（使用反射）才有意义。
自定义注解通常都会指明两个元注解：Retention，Target

4· jdk提供的4种元注解
元注解：对现有的注解进行解释说明的注解
@Retention:指定所修饰的Annotation的生命周期：SOURCE/CLASS（默认）/RUNTIME
      只有声明为RUNTIME生命周期的注解，才能通过反射获取。
@Target: 用于指定被修饰的Annotation能用于修饰哪些程序元素
===== 出现的频率较低 =====
@Documented：表示所修饰的注解在被javadoc解析时，保留下来。
@Inherited：被它修饰的Annotation将具有继承性。

5·通过反射获取注解信息 --- 到反射内容时系统讲解。
6·jdk8中注解的新特性：可重复注解，类型注解
 */
public class AnnotationTest {
    @Test
    public void testGetAnnotation() {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations));
    }
}

@MyAnnotation(value = "hi")
class Person {
    private String name;
    private int age;

    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void show() {
    }
}