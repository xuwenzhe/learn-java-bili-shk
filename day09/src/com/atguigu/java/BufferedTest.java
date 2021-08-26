package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/*
处理流之一： 缓冲流的使用

1。缓冲流
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter

2. 作用：提高流的读取，写入的速度
提高读写速度的原因：内部提供了一个缓冲区

3. 处理流，就是"套接"在已有的流的基础上。
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File("sf_skyline.jpeg");
            File destFile = new File("sf_skyline_test.jpeg");
            // 2. 造流
            // 2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
//                bos.flush(); // 刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源关闭
            // 要求1：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
        }
    }

    // 实现文件复制的方法
    public void copyFileWithBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            // 2. 造流
            // 2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源关闭
            // 要求1：先关闭外层的流，再关闭内层的流
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "sf_skyline.jpeg";
        String destPath = "sf_skyline_test.jpeg";
        copyFileWithBuffered(srcPath, destPath);
        long end = System.currentTimeMillis();
        System.out.println("Copy took: " + (end - start) + " millis");
    }
}
