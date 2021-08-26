package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
测试FileInputStream和FileOutputStream的使用

结论：
1. 对于文本文件(.txt, .java, .c, .cpp)，使用字符流处理
2. 对于非文本文件(.jpg, .mp3, .mp4, .avi, .doc, .ppt, ...)，使用字节流处理


 */
public class FileInputOutputStreamTest {

    // 使用字节流FileInputStream处理文本文件，可能出现乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            // 1. 造文件
            File file = new File("hello.txt");
            // 2. 造流
            fis = new FileInputStream(file);

            // 3. 读数据
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer,0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
